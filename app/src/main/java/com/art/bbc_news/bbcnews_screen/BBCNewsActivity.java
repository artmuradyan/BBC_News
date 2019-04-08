package com.art.bbc_news.bbcnews_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.art.bbc_news.R;
import com.art.bbc_news.utils.Constants;
import com.art.bbc_news.objects.BBCObject;

public class BBCNewsActivity extends AppCompatActivity {

    private RecyclerView mBBCNewsRv;
    private BBCNewsAdapter bbcNewsAdapter;

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
                Toast.makeText(BBCNewsActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getList(){
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            BBCObject object = (BBCObject) b.getSerializable(Constants.NEWS_LIST);
            bbcNewsAdapter.setItems(object.getArticles());
        }

    }




}
