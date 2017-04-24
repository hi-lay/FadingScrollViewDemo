package com.qienanxiang.fadingscrolldemo;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/***
 * 详细代码说明见csdn：http://blog.csdn.net/u011343735/article/details/53761170
 */
public class MainActivity extends AppCompatActivity {


    private View layout;
    private FadingScrollView fadingScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        layout = findViewById(R.id.nac_layout);
        layout.setAlpha(0);

        fadingScrollView = (FadingScrollView)findViewById(R.id.nac_root);
        fadingScrollView.setFadingView(layout);
        fadingScrollView.setFadingHeightView(findViewById(R.id.nac_image));
    }
}
