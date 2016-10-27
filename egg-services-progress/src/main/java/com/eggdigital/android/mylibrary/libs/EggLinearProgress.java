package com.eggdigital.android.mylibrary.libs;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.eggdigital.android.mylibrary.R;

/**
 * Created by noosomii on 10/20/2016 AD.
 */

public class EggLinearProgress extends LinearLayout {

    private int colorProgress;

    public EggLinearProgress(Context context) {
        super(context);
        initialize(context);
    }

    public EggLinearProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Linear_Progress);
        int colorProgressDefault = ContextCompat.getColor(context, R.color.color_egg_progress_default);
        colorProgress = typedArray.getColor(R.styleable.Linear_Progress_egg_progress_color, colorProgressDefault);
        initialize(context);
    }

    private void initialize(Context context){
        View mView = inflate(context, R.layout.linear_progress, this);
        ProgressBar mProgressBar = (ProgressBar) mView.findViewById(R.id.linear_progress_tmp);
        mProgressBar.setIndeterminate(true);
        mProgressBar.getIndeterminateDrawable().setColorFilter(colorProgress, android.graphics.PorterDuff.Mode.SRC_IN);
    }


}
