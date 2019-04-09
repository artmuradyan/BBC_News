package com.art.bbc_news.splash_screen;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

import com.art.bbc_news.R;
import com.art.bbc_news.bbcnews_screen.BBCNewsActivity;
import com.art.bbc_news.utils.Constants;
import com.art.bbc_news.objects.BBCObject;
import com.art.bbc_news.retro.ApiUtil;
import com.art.bbc_news.utils.NetworkConnection;
import com.art.bbc_news.utils.UIAnimateHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashActivity extends AppCompatActivity {

    private final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);

        if (NetworkConnection.isNetworkConnected(getApplicationContext())) {
            getNews();
        }else {
            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.splash_root_ly), R.string.no_internet, Snackbar.LENGTH_LONG);
            snackbar.show();
        }

    }

    private void getNews(){
        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<BBCObject>() {
            @Override
            public void onResponse(Call<BBCObject> call, Response<BBCObject> response) {
                if (response.isSuccessful()) {
                    BBCObject object = response.body();

                    Intent i = new Intent();
                    Bundle b = new Bundle();
                    b.putSerializable(Constants.NEWS_LIST, object);
                    i.putExtras(b);
                    i.setClass(SplashActivity.this, BBCNewsActivity.class);
                    startActivity(i);
                    UIAnimateHelper.animateFadeInOut(SplashActivity.this);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BBCObject> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "Error loading from API");
            }
        });
    }

}
