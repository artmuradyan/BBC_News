package com.art.bbc_news.bbcnews_screen;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.art.bbc_news.R;
import com.art.bbc_news.newsdetail_screan.NewsDetailActivity;
import com.art.bbc_news.utils.Constants;
import com.art.bbc_news.objects.BBCObject;
import com.art.bbc_news.utils.NetworkConnection;
import com.art.bbc_news.utils.UIAnimateHelper;

public class BBCNewsActivity extends AppCompatActivity {

    private RecyclerView mBBCNewsRv;
    private BBCNewsAdapter bbcNewsAdapter;
    private BBCObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbc_news);

        initViews();
        getList();
    }

    private void initViews() {
        mBBCNewsRv = findViewById(R.id.bbc_news_reciclerview);
        mBBCNewsRv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        bbcNewsAdapter = new BBCNewsAdapter();
        mBBCNewsRv.setAdapter(bbcNewsAdapter);

        bbcNewsAdapter.setOnItemClickListener(new BBCNewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (NetworkConnection.isNetworkConnected(getApplicationContext())) {
                    goToDetails(view, position);
                }else {
                    Snackbar snackbar = Snackbar
                            .make(findViewById(R.id.bbcnews_root_ly), R.string.no_internet, Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

            }
        });
    }

    private void goToDetails(View view, int position){
        Intent intent = new Intent(BBCNewsActivity.this, NewsDetailActivity.class);
        intent.putExtra(Constants.NEWS_DETAILS, object.getArticles().get(position).getUrl());
        startActivity(intent);
        UIAnimateHelper.animateToLeft(BBCNewsActivity.this);
    }

    private void getList() {
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            object = (BBCObject) b.getSerializable(Constants.NEWS_LIST);
            bbcNewsAdapter.setItems(object.getArticles());
        }

    }


}
