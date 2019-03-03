package com.foray.foraypopupwindow.Anim;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.foray.foraypopupwindow.R;

public class ForayAnimationManager {

    public static LayoutAnimationController getTranslateAnimation(Context context){
        return AnimationUtils.loadLayoutAnimation(context, R.anim.layout_trans_anim);
    }

    public static LayoutAnimationController getAlphaAnimation(Context context){
        return AnimationUtils.loadLayoutAnimation(context, R.anim.layout_alpha_anim);
    }
    public static LayoutAnimationController getRotateAnimation(Context context){
        return AnimationUtils.loadLayoutAnimation(context, R.anim.layout_rotate_anim);
    }


}
