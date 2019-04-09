package com.art.bbc_news.utils;

import android.app.Activity;

import com.art.bbc_news.R;

public class UIAnimateHelper {

    public static void animateFadeInOut(Activity activity){
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public static void animateToRight(Activity activity){
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    public static void animateToLeft(Activity activity){
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
