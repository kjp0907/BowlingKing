package com.example.tacademy.bowlingkingproject.TabPager.Register;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.tacademy.bowlingkingproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng myPosition = new LatLng(U.getInstance().getMyLat(),
                U.getInstance().getMyLng());
        //마킹
        Marker marker =
                mMap.addMarker(new MarkerOptions().position(myPosition).title("내위치").snippet("자취방"));
        marker.setTag("자취방이다!!"); //서버로 부터 받은 샵 정보를 넣는다.

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,12));
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener(){
            @Override
            public void onMyLocationChange(Location location) {
                Log.i("GPS","구글 지도 상 내 위치 정보:" + location.getLatitude()
                        + "," + location.getLongitude());
            }
        });

        //지도 클릭
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng latLng) {
                Log.i("GPS",
                        "내가찍은 위치:" + latLng.latitude +
                                "," + latLng.longitude);

                gps.getInstance().gpsdata.setLongitude(latLng.longitude);
                gps.getInstance().gpsdata.setLatitude(latLng.latitude);

                mMap.addMarker(new MarkerOptions().position(latLng).title("신규위치"));
                CameraPosition MARKER_POS =new CameraPosition.Builder()
                        .target(latLng)
                        .zoom(16)
                        .bearing(60)
                        .tilt(30)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(MARKER_POS));
            }
        });
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener(){
            @Override
            public void onMapLongClick(LatLng latLng) {
                Log.i("GPS",
                        "내가 길게 찍은 위치:" + latLng.latitude
                                +"," + latLng.longitude);
                mMap.addMarker(new MarkerOptions().position(latLng).title("롱규위치"));
                CameraPosition MARKER_POS = new CameraPosition.Builder()
                        .target(latLng)
                        .zoom(16)
                        .bearing(60)
                        .tilt(30)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(MARKER_POS));



            }
        });

        //마커 클릭
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                Log.i("GPS","내가길게 찍은 위치:" + marker.getPosition().latitude +
                        "," + marker.getPosition().longitude+"/"+marker.getTag().toString());///////
                return false;
            }
        });
        //반경 표시
        //마커 변경
        //마커 이동
    }
}
