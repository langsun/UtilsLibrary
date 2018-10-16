package com.sun.library;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

/**
 * Created by sun on 18/10/16.
 */

public class SpannableUtil {

    /**
     *
     void setSpan (Object what, int start, int end, int flags)

     object what ：对应的各种Span，后面会提到；

     int start：开始应用指定Span的位置，索引从0开始

     int end：结束应用指定Span的位置，不包含

     int flags

     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括（在标志位【start，end）前后添加文字，新添加的文字不会有任何设置的属性）

     Spannable.SPAN_EXCLUSIVE_INCLUSIVE ：前面不包括，后面包括。（在标志位【start，end）前添加文字，新添加的文字不会有任何设置的属性，后边的添加的文字会带有设置的what属性）

     Spannable.SPAN_INCLUSIVE_EXCLUSIVE ：前面包括，后面不包括。（在标志位【start，end）后添加文字，新添加的文字不会有任何设置的属性，前边边的添加的文字会带有设置的what属性）

     Spannable.SPAN_INCLUSIVE_INCLUSIVE ：前后都包括。前后都不包括（在标志位【start，end）前后添加文字，新添加的文字会有设置的属性）
     */


    /**
     * 设置某些文字颜色
     *
     * @param context
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param colorRes   设置的字体的颜色
     */
    public static void setForegroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的背景颜色
     *
     * @param context
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param colorRes   设置的字体的背景颜色
     */
    public static void setBackgroundColor(Context context, TextView textView, String str, int startIndex, int endIndex, int colorRes) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new BackgroundColorSpan(context.getResources().getColor(colorRes)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的点击事件
     *
     * @param textView
     * @param str
     * @param startIndex    字符串的某一个位置开始
     * @param endIndex      字符串的某一个位置结束
     * @param clickableSpan 点击的回调
     */
    public static void setClickableSpan(TextView textView, String str, int startIndex, int endIndex, ClickableSpan clickableSpan) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(clickableSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        // 设置此方法后，点击事件才能生效
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(style);
    }

    /**
     * 设置某些文字的模糊效果
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     */
    public static void setBlurMaskFilter(TextView textView, String str, int startIndex, int endIndex) {
        SpannableStringBuilder stringBuilder=new SpannableStringBuilder(str);
        MaskFilter filter=new BlurMaskFilter(4.0f,BlurMaskFilter.Blur.OUTER);
        MaskFilterSpan maskFilterSpan=new MaskFilterSpan(filter);
        stringBuilder.setSpan(maskFilterSpan,startIndex, endIndex,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(stringBuilder);
    }

    /**
     * 设置某些文字的删除线效果
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     */
    public static void setStrikethroughSpan(TextView textView, String str, int startIndex, int endIndex) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new StrikethroughSpan(), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的下滑线效果
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     */
    public static void setUnderlineSpan(TextView textView, String str, int startIndex, int endIndex) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new UnderlineSpan(), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的绝对大小效果
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param textSize   字体的大小
     */
    public static void setAbsoluteSizeSpan(TextView textView, String str, int startIndex, int endIndex, int textSize) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new AbsoluteSizeSpan(textSize, true), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的相对大小效果
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param textSize   字体的大小
     */
    public static void setRelativeSizeSpan(TextView textView, String str, int startIndex, int endIndex, float textSize) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new RelativeSizeSpan(textSize), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的粗体、斜体等（StyleSpan ）
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param typeface   正常：Typeface.NORMAL == 0 ，粗体：Typeface.BOLD == 1 ，斜体：Typeface.ITALIC == 2 ，粗斜体：Typeface.BOLD_ITALIC == 3
     */

    public static void setStyleSpan(TextView textView, String str, int startIndex, int endIndex, int typeface) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new StyleSpan(typeface), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的链接
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     * @param urlStr     要跳转的URL
     */

    public static void setURLSpan(TextView textView, String str, int startIndex, int endIndex, String urlStr) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new URLSpan(urlStr), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        // 设置此方法后，点击事件才能生效
        textView.setMovementMethod(new LinkMovementMethod());
        textView.setText(style);
    }

    /**
     * 设置某些文字的上标
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     */

    public static void setSuperscriptSpan(TextView textView, String str, int startIndex, int endIndex) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new SuperscriptSpan(), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }

    /**
     * 设置某些文字的下标
     *
     * @param textView
     * @param str
     * @param startIndex 字符串的某一个位置开始
     * @param endIndex   字符串的某一个位置结束
     */

    public static void setSubscriptSpan(TextView textView, String str, int startIndex, int endIndex) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new SubscriptSpan(), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }
}
