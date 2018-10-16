package com.sun.utils.util;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.sun.library.SpannableUtil;
import com.sun.library.ToastUtil;
import com.sun.utils.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 18/10/16.
 */

public class SpannableUtilActivity extends AppCompatActivity {
    @BindView(R.id.tv_1)
    TextView mTextView1;
    @BindView(R.id.tv_2)
    TextView mTextView2;
    @BindView(R.id.tv_3)
    TextView mTextView3;
    @BindView(R.id.tv_4)
    TextView mTextView4;
    @BindView(R.id.tv_5)
    TextView mTextView5;
    @BindView(R.id.tv_6)
    TextView mTextView6;
    @BindView(R.id.tv_7)
    TextView mTextView7;
    @BindView(R.id.tv_8)
    TextView mTextView8;
    @BindView(R.id.tv_9)
    TextView mTextView9;
    @BindView(R.id.tv_10)
    TextView mTextView10;
    @BindView(R.id.tv_11)
    TextView mTextView11;
    @BindView(R.id.tv_12)
    TextView mTextView12;

    String str = "一生戎马为长安";

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_util);
        ButterKnife.bind(this);
        mContext = this;
        SpannableUtil.setForegroundColor(mContext, mTextView1, str, 2, 4, R.color.colorAccent);
        SpannableUtil.setBackgroundColor(mContext, mTextView2, str, 2, 4, R.color.colorAccent);
        SpannableUtil.setClickableSpan(mTextView3, str, 2, 4, new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                ToastUtil.showToast(mContext, "setClickableSpan");
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                //去掉可点击文字的下划线
                ds.setUnderlineText(false);
            }
        });
        //SpannableUtil.setBlurMaskFilter(mTextView4, str, 0, 4, 4.0f);这样写不生效，下面的生效好神奇
        SpannableUtil.setBlurMaskFilter(mTextView4, "一生戎马为长安", 2, 4);
        SpannableUtil.setStrikethroughSpan(mTextView5, str, 2, 4);
        SpannableUtil.setUnderlineSpan(mTextView6, str, 2, 4);
        SpannableUtil.setAbsoluteSizeSpan(mTextView7, str, 2, 4, 10);
        SpannableUtil.setRelativeSizeSpan(mTextView8, str, 2, 4, 2.0f);
        SpannableUtil.setStyleSpan(mTextView9, str, 2, 4, Typeface.BOLD_ITALIC);
        SpannableUtil.setURLSpan(mTextView10, str, 2, 4, "https://www.baidu.com/");
        SpannableUtil.setSuperscriptSpan(mTextView11, str, 2, 4);
        SpannableUtil.setSubscriptSpan(mTextView12, str, 2, 4);
    }
}
