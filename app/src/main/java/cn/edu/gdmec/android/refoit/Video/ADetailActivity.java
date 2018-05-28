package cn.edu.gdmec.android.refoit.Video;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.edu.gdmec.android.refoit.R;

/**
 * Created by Administrator on 2018/5/28.
 */

public class ADetailActivity extends Activity{
    private WebView webNews;
    private String loadUrl,title;
    private WebViewClient webViewClient;
    private TextView tv_bar_title;
    private ImageView iv_back;
    private ProgressBar pb_load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_detail);
        loadUrl=getIntent().getStringExtra("url");
        title=getIntent().getStringExtra("title");
        initView();
        setWebViewClient();
    }

    private void setWebViewClient() {
        webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pb_load.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pb_load.setVisibility(View.GONE);
            }
        };
        webNews.setWebViewClient(webViewClient);
    }
    private void initView() {
        webNews=(WebView)findViewById(R.id.wb_news);
        webNews.getSettings().setJavaScriptEnabled(true);
        webNews.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webNews.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webNews.canGoBack();
        webNews.canGoForward();
        webNews.loadUrl(loadUrl);
        tv_bar_title=(TextView)findViewById(R.id.tv_bar_title);
        tv_bar_title.setText(title);
        iv_back=(ImageView)findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pb_load=(ProgressBar)findViewById(R.id.pb_load);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        webNews.destroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK&&webNews.canGoBack()){
            webNews.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
