package com.example.wudz.launchermanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.wudz.launchermanager.R;

/**
 * USER：wudz on 2016/11/16 17:12
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class DetailActivity extends BaseActivity {
    private TextView tvDetail;
    private String key = "content";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }
    private void initView(){
        tvDetail = (TextView) findViewById(R.id.tv_content);
        tvDetail.setText(getIntent().getStringExtra(key));
    }
}
