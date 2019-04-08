package com.art.bbc_news.utils;

import android.app.Activity;

import com.art.bbc_news.R;

public class UIAnimateHelper {

    public static void animateFadeInOut(Activity activity){
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);    }
}
