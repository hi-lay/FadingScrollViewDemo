package com.qienanxiang.fadingscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LogPrinter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by ZHL on 2016/12/19.
 */

public class FadingScrollView extends ScrollView {

    private static String TAG = "-----------FadingScrollView----------";
    //渐变view
    private View fadingView;
    //滑动view的高度，如果这里fadingHeightView是一张图片，
    // 那么就是这张图片上滑至完全消失时action bar 完全显示，
    // 过程中透明度不断增加，直至完全显示
    private View fadingHeightView;
    private int oldY;
    //滑动距离，默认设置滑动500 时完全显示，根据实际需求自己设置
    private int fadingHeight = 500;

    public FadingScrollView(Context context) {
        super(context);
    }

    public FadingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFadingView(View view){this.fadingView = view;}
    public void setFadingHeightView(View v){this.fadingHeightView = v;}

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(fadingHeightView != null)
        fadingHeight = fadingHeightView.getMeasuredHeight();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
//        l,t  滑动后 xy位置，
//        oldl lodt 滑动前 xy 位置-----
        float fading = t>fadingHeight ? fadingHeight : (t > 30 ? t : 0);
        updateActionBarAlpha( fading / fadingHeight);

    }

    void updateActionBarAlpha(float alpha){
        try {
            setActionBarAlpha(alpha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setActionBarAlpha(float alpha) throws Exception{
        if(fadingView==null){
            throw new Exception("fadingView is null...");
        }
        fadingView.setAlpha(alpha);
    }

}
