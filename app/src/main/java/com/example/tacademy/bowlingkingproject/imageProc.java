package com.example.tacademy.bowlingkingproject;


import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 이미지 프로세싱
 */
public class imageProc {
    private static imageProc ourInstance = new imageProc();

    public static imageProc getInstance() {
        return ourInstance;
    }

    private imageProc() {
    }
    //UIL : Universal Image Loader
    ImageLoader imageLoader; //유니버셜 이미지 로더 아까 디펜던시에 추가한것
    ImageLoaderConfiguration configuration;
    DisplayImageOptions displayImageOptions;
    //초기화는 1회만 하면 됨 (이미지 쓰기 전에)
    public ImageLoader getImageLoader(Context context) {
        if(imageLoader == null) {
            //이미 싱글톤이므로 굳이 변수로 받지 않아도 된다(싱글톤 자체가 스태틱)
            imageLoader = ImageLoader.getInstance();
            configuration = new ImageLoaderConfiguration.Builder(context).build();
            imageLoader.init(configuration);
            displayImageOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
        }
        return imageLoader;
    }
    //이미지 드로잉
    public void drawImage(String url, ImageView imageView) //이미지 주소랑 이미지 뷰만 오면 됨
    {
        imageLoader.displayImage(url, imageView, displayImageOptions);
    }
}
