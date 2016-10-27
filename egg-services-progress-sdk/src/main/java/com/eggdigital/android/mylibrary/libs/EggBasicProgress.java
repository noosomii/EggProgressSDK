package com.eggdigital.android.mylibrary.libs;

import android.app.ProgressDialog;
import android.content.Context;

public class EggBasicProgress {

    private Context mContext;
    private ProgressDialog mProgress;

    public EggBasicProgress(Context mContext) {
        this.mContext = mContext;
    }

    public void onShowEggBasicProgress(boolean cancelable) {
        mProgress = ProgressDialog.show(mContext, "", "", true, cancelable);
    }

    public void onShowEggBasicProgress(String title, String message, boolean cancelable) {
        mProgress = ProgressDialog.show(mContext, title, message, true, cancelable);
    }

    public void onShowEggBasicProgressBar(boolean cancelable, int max) {
        mProgress = new ProgressDialog(mContext);
        mProgress.setCancelable(cancelable);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgress.setProgress(0);
        mProgress.setMax(max);
        mProgress.show();
    }

    public void onShowEggBasicProgressBar(String title, String message, boolean cancelable, int max) {
        mProgress = new ProgressDialog(mContext);
        if(!title.equals("")) mProgress.setTitle(title);
        if(!message.equals("")) mProgress.setMessage(message);
        mProgress.setCancelable(cancelable);
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgress.setProgress(0);
        mProgress.setMax(max);
        mProgress.show();
    }

    public void onUpdateEggBasicProgressBar(int number) {
        if (mProgress != null && mProgress.isShowing()) {
            int timeProgress = mProgress.getProgress() + number;
            mProgress.setProgress(timeProgress);
        }
    }

    public void onHideEggBasicProgress() {
        if(mProgress != null && mProgress.isShowing())
            mProgress.hide();
    }

}
