package com.eggdigital.egglibs.egglibs;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.eggdigital.android.mylibrary.libs.EggLinearProgress;
import com.eggdigital.android.mylibrary.libs.EggLoadingProgress;
import com.eggdigital.android.mylibrary.libs.EggCircularProgress;
import com.eggdigital.android.mylibrary.libs.EggBasicProgress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EggBasicProgress mEggBasicProgress;
    private EggLoadingProgress mEggLoadingProgress;
    private EggCircularProgress mEggCircularProgress;
    private static int MAX = 100;
    private static long DELAY = 300;
    private int colorPosition = 0;
    private EditText mTitle, mMessage;
    private EggLinearProgress mEggLinearProgress;
    LinearLayout colorView;
    private int[] color = {Color.parseColor("#ff9933cc"), Color.parseColor("#ff0099cc"),
            Color.parseColor("#ffff8800"), Color.parseColor("#ff669900")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context mContext = this;
        mTitle = (EditText) findViewById(R.id.txt_title);
        mMessage = (EditText) findViewById(R.id.txt_message);
        mEggLinearProgress = (EggLinearProgress) findViewById(R.id.linear_progress);

        colorView = (LinearLayout) findViewById(R.id.color_view);
        for (int i = 0; i < color.length; i++) {
            CheckBox mCheck = new CheckBox(mContext);
            if(i == 0) mCheck.setChecked(true);
            mCheck.setBackgroundColor(color[i]);
            mCheck.setId(i);
            mCheck.setOnClickListener(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 4, 4, 4);
            mCheck.setLayoutParams(params);
            colorView.addView(mCheck);
        }

        mEggBasicProgress = new EggBasicProgress(mContext);
        mEggLoadingProgress = new EggLoadingProgress(mContext);
        mEggCircularProgress = new EggCircularProgress(mContext);
    }

    public void openEggBasicProgress(View view) {
        mEggBasicProgress.onShowEggBasicProgress(mTitle.getText().toString(), mMessage.getText().toString(), false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEggBasicProgress.onHideEggBasicProgress();
            }
        }, 3000);
    }

    public void openEggBasicProgressBar(View view) {
        mEggBasicProgress.onShowEggBasicProgressBar(mTitle.getText().toString(),
                mMessage.getText().toString(), false, MAX);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int jumpTime = 0;
                while (jumpTime < MAX) {
                    try {
                        Thread.sleep(DELAY);
                        jumpTime += 5;
                        mEggBasicProgress.onUpdateEggBasicProgressBar(jumpTime);
                        if(jumpTime >= MAX) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mEggBasicProgress.onHideEggBasicProgress();
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void openEggLoadingProgress(View view) {
        mEggLoadingProgress.onShowEggLoadingProgressBar(false, MAX, color[colorPosition],
                mTitle.getText().toString(), mMessage.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                int jumpTime = 0;
                while (jumpTime < MAX) {
                    try {
                        Thread.sleep(DELAY);
                        jumpTime += 5;
                        mEggLoadingProgress.onUpdateProgressBar(jumpTime);
                        if(jumpTime >= MAX) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mEggLoadingProgress.onHideEggProgressBar();
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void openEggCircularProgress(View view) {
        mEggCircularProgress.onShowEggProgressCircle(false, color[colorPosition]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEggCircularProgress.onHideEggProgressCircle();
            }
        }, 3000);
    }

    public void openEggLinearProgress(View view) {
        mEggLinearProgress.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEggLinearProgress.setVisibility(View.INVISIBLE);
            }
        }, 3000);
    }

    @Override
    public void onClick(View view) {
        colorPosition = view.getId();
        for(int i = 0; i < colorView.getChildCount(); i++) {
            CheckBox mCheckBox = (CheckBox) colorView.findViewById(i);
            if(i == colorPosition) mCheckBox.setChecked(true);
            else mCheckBox.setChecked(false);
        }
    }

}
