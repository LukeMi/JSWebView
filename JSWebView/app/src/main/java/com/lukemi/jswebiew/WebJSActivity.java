package com.lukemi.jswebiew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class WebJSActivity extends AppCompatActivity {

    private View webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_js);
        initView();
    }


    private void initView() {
        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/webviewtest.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JiaoHu(), "android");

        Button btn = (Button) findViewById(R.id.get_js);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.loadUrl("javascript:android#(true)");
                webView.loadUrl("javascript:self()");
            }
        });
    }

    public class JiaoHu {
        @JavascriptInterface
        public void startFunction(String obj) {
            Toast.makeText(WebJSActivity.this, "js调用了android的方法: " + obj, Toast.LENGTH_SHORT).show();
        }
    }

    private void set() {
        String s = "{" + "            'SectionTagID': ''," + " 'SectionID': zz.ID," +
                "                'Shape': \"radio\"," +
                "                'CoordsX': bx," +
                "                'CoordsY': by," +
                "                'Rate': mc," +
                "                'CreateUserID': aUserId" +
                "        }";


    }
}
