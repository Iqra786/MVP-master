package com.prac.mvp.android.activity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.prac.mvp.R;


public abstract class ActivityDetail extends AppCompatActivity {

    protected ImageView artWork;
    protected TextView  webUrl;
    protected TextView seamable;
    protected  TextView listener;
    protected  TextView mBid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        artWork = findViewById(R.id.activity_detail_image);
        webUrl= findViewById(R.id.activity_detail_url);
        seamable = findViewById(R.id.activity_detail_streamable);
        listener = findViewById(R.id.activity_detail_listener);
        mBid = findViewById(R.id.activity_detail_mbid);
    }

    protected abstract int getContentView();
}
