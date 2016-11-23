package com.example.wudz.launchermanager.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.wudz.launchermanager.R;
import com.example.wudz.launchermanager.adapter.HeaderAdapter;
import com.example.wudz.launchermanager.listener.SlidListener;
import com.example.wudz.launchermanager.model.HeaderModel;
import com.example.wudz.launchermanager.widget.HorizontialListView;

import java.util.ArrayList;
import java.util.List;

/**
 * USER：wudz on 2016/11/16 16:28
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class MainHeaderFragment extends BaseFragment {
    private SlidListener listener;
    private HorizontialListView listView;
    private List<HeaderModel> list = new ArrayList<>();

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main_header;
    }

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 10; i++) {
            HeaderModel headerModel = new HeaderModel();
            headerModel.setName("应用" + i);
            headerModel.setImage(R.mipmap.ic_launcher);
            list.add(headerModel);
        }
        listView = (HorizontialListView) view.findViewById(R.id.listview_header);
        listView.setAdapter(new HeaderAdapter(getActivity(), list));
        listView.setOnItemClickListener(itemClickListener);
    }

    public void setSlidListener(SlidListener listener) {
        this.listener = listener;
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listener.click();
        }
    };
}
