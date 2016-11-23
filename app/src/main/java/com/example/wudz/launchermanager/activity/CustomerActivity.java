package com.example.wudz.launchermanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.wudz.launchermanager.R;

/**
 * USER：wudz on 2016/11/21 14:41
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class CustomerActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ImageView imageView = (ImageView) findViewById(R.id.imgv);
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
        ta.setDuration(2000); //设置动画执行的时间
        ta.setFillAfter(true);//当动画结束后 动画停留在结束位置
//        imageView.startAnimation(ta);
    }
}
