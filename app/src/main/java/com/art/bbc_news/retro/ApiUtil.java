package com.art.bbc_news.retro;

public class ApiUtil {

    private static final String BASE_URL = "https://newsapi.org/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}
