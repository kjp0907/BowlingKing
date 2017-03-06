package com.example.tacademy.bowlingkingproject.join;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.Message.BaseActivity;

public class TermsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        WebView webView = (WebView) this.findViewById(R.id.joinWebView); //뷰는 뷴데 무슨뷰나 왭뷰다 더 높아서 타이밍해줘야됨 (Webview)
        // 1. 자바스크립트 허용 처리
        // webView.getSettings().setJavaScriptEnabled(true);
        // 2. 크롬 클라이언트등 구현 처리
        // webView.setWebChromeClient(new WebChromeClient(){
        // });
        //3.로딩
        webView.loadUrl("https://nid.naver.com/user2/common/terms/terms.nhn?m=viewTermOfUseNaver&mobile=Y"); //load.URL html을 내부에다 끌어다 올때 (데이터를 쥐고있을때 하는, 방식 하이브리드 앱할떄)

    }
}