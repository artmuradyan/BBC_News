package com.art.bbc_news.retro;


import com.art.bbc_news.objects.BBCObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("v2/top-headlines?sources=techcrunch&apiKey=97ba815035ae4381b223377b2df975ab")
    public Call<BBCObject> getAllPost();
}
