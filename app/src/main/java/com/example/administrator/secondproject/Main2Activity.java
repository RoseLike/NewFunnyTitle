package com.example.administrator.secondproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class Main2Activity extends AppCompatActivity {
    ProgressBar mProgressBar;
    WebView mWebView;
    String urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back_gray);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mProgressBar = (ProgressBar) findViewById(R.id.progressId);
        mWebView = (WebView) findViewById(R.id.webviewId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//隐藏title
        Intent intent = getIntent();
        urls= intent.getStringExtra("ma");
        Log.d("majunjun", "======-----=========" + urls);
        mWebView.loadUrl(urls);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
                getSupportActionBar().
                        setHomeAsUpIndicator(new BitmapDrawable(favicon));
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //网页加载完成
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    //如果网页加载完毕，将进度条隐藏
                    mProgressBar.setVisibility(View.INVISIBLE);
                }
                mProgressBar.setProgress(newProgress);

            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//开启javaScript的脚本
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setDisplayZoomControls(true);
        webSettings.supportMultipleWindows();//支持多窗体
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_Share);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Share) {
            OnekeyShare oks = new OnekeyShare();
            oks.disableSSOWhenAuthorize();
            oks.setTitle("分享");
            oks.setText("快看看有惊喜");
            oks.setExecuteUrl(urls);
            oks.show(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}