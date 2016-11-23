package com.example.wudz.launchermanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * USER：wudz on 2016/11/16 16:18
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = getContentLayout();
        View view = inflater.inflate(i, container, false);
        initView(view);
        return view;
    }


    protected abstract int getContentLayout();

    protected abstract void initView(View view);
}
