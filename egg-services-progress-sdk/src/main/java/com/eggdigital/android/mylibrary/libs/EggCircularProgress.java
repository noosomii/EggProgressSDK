package com.eggdigital.android.mylibrary.libs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.eggdigital.android.mylibrary.R;

/**
 * Created by noosomii on 10/19/2016 AD.
 */

public class EggCircularProgress {

    private Context mContext;
    private Dialog mDialogView;

    public EggCircularProgress(Context mContext) {
        this.mContext = mContext;
    }

    public void onShowEggProgressCircle(boolean cancelable) {
        mDialogView = new Dialog(mContext);
        mDialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialogView.setContentView(R.layout.circular_progress);
        mDialogView.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialogView.setCancelable(cancelable);
        mDialogView.setCanceledOnTouchOutside(cancelable);
        mDialogView.show();
    }

    public void onShowEggProgressCircle(boolean cancelable, int color) {
        mDialogView = new Dialog(mContext);
        mDialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialogView.setContentView(R.layout.circular_progress);
        ProgressBar progressBar = (ProgressBar) mDialogView.findViewById(R.id.circular_progress);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        mDialogView.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialogView.setCancelable(cancelable);
        mDialogView.setCanceledOnTouchOutside(cancelable);
        mDialogView.show();
    }

    public void onHideEggProgressCircle() {
        if(mDialogView != null && mDialogView.isShowing()) {
            mDialogView.hide();
        }
    }

}
