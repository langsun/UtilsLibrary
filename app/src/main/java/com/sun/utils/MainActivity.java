package com.sun.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sun.utils.util.SpannableUtilActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_spannable_util)
    public void spannableUtil(){
        Intent intent = new Intent(MainActivity.this, SpannableUtilActivity.class);
        startActivity(intent);

    }
}
