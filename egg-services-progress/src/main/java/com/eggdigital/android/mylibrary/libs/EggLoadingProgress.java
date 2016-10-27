package com.eggdigital.android.mylibrary.libs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;

import com.eggdigital.android.mylibrary.R;

/**
 * Created by noosomii on 10/17/2016 AD.
 */

public class EggLoadingProgress {

    private Context mContext;
    private ProgressDialog mProgress;

    public EggLoadingProgress(Context mContext) {
        this.mContext = mContext;
    }

    public void onShowEggLoadingProgressBar(boolean cancelable, int max) {
        mProgress = new ProgressDialog(mContext);
        mProgress.setCancelable(cancelable);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgress.setProgressDrawable(ContextCompat.getDrawable(mContext, R.drawable.custom_linear_progress));
        mProgress.setProgress(0);
        mProgress.setMax(max);
        mProgress.show();
    }

    public void onShowEggLoadingProgressBar(boolean cancelable, int max, int color) {
        mProgress = new ProgressDialog(mContext);
        mProgress.setCancelable(cancelable);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        LayerDrawable layer = (LayerDrawable) ContextCompat.getDrawable(mContext, R.drawable.custom_linear_progress);
        ClipDrawable progress = (ClipDrawable) (layer.findDrawableByLayerId(R.id.progress));
        progress.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        mProgress.setProgressDrawable(layer);
        mProgress.setProgress(0);
        mProgress.setMax(max);
        mProgress.show();
    }

    public void onShowEggLoadingProgressBar(boolean cancelable, int max, int color, String title, String message) {
        mProgress = new ProgressDialog(mContext);
        if(!title.equals("")) mProgress.setTitle(title);
        if(!message.equals("")) mProgress.setMessage(message);
        mProgress.setCancelable(cancelable);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        LayerDrawable layer = (LayerDrawable) ContextCompat.getDrawable(mContext, R.drawable.custom_linear_progress);
        ClipDrawable progress = (ClipDrawable) (layer.findDrawableByLayerId(R.id.progress));
        progress.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        mProgress.setProgressDrawable(layer);
        mProgress.setProgress(0);
        mProgress.setMax(max);
        mProgress.show();
    }

    public void onUpdateProgressBar(int number) {
        if (mProgress != null && mProgress.isShowing()) {
            int timeProgress = mProgress.getProgress() + number;
            mProgress.setProgress(timeProgress);
        }
    }

    public void onHideEggProgressBar() {
        if(mProgress != null && mProgress.isShowing()) {
            mProgress.hide();
        }
    }

}
