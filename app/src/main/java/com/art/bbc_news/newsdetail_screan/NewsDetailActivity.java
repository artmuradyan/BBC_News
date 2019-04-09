package com.art.bbc_news.newsdetail_screan;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.art.bbc_news.R;
import com.art.bbc_news.utils.Constants;
import com.art.bbc_news.utils.UIAnimateHelper;

public class NewsDetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getURL();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                UIAnimateHelper.animateToRight(NewsDetailActivity.this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        UIAnimateHelper.animateToRight(NewsDetailActivity.this);
    }

    private void getURL() {
        String url = getIntent().getExtras().getString(Constants.NEWS_DETAILS);

        WebView webView = findViewById(R.id.news_detail_webview);
        webView.loadUrl(url);
    }
}
