package com.art.bbc_news.bbcnews_page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.art.bbc_news.R;
import com.art.bbc_news.objects.BBCObject;
import com.art.bbc_news.retro.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BBCNewsActivity extends AppCompatActivity {

    private final String TAG = BBCNewsActivity.class.getSimpleName();
    private RecyclerView mBBCNewsRv;
    private BBCNewsAdapter bbcNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbc_news);

        initViews();
        getNews();
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

    private void getNews(){
        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<BBCObject>() {
            @Override
            public void onResponse(Call<BBCObject> call, Response<BBCObject> response) {
                if (response.isSuccessful()) {
                    BBCObject object = response.body();

                    bbcNewsAdapter.setItems(object.getArticles());
                }
            }

            @Override
            public void onFailure(Call<BBCObject> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API");
            }
        });
    }


}
