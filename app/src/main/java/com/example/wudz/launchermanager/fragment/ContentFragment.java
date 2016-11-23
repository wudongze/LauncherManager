package com.example.wudz.launchermanager.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.wudz.launchermanager.R;
import com.example.wudz.launchermanager.adapter.ContentAdapter;
import com.example.wudz.launchermanager.model.ContentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * USER：wudz on 2016/11/16 16:53
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class ContentFragment extends BaseFragment {
    private GridView gridView;
    private List<ContentModel> list = new ArrayList<>();
    private String key = "content";
    private ContentAdapter contentAdapter;
    @Override
    protected int getContentLayout() {
        return R.layout.fragment_content;
    }

    @Override
    protected void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.gridview_content);
        gridView.setOnItemClickListener(itemClickListener);
        contentAdapter = new ContentAdapter(getActivity(), list);
        gridView.setAdapter(contentAdapter);
    }

    public void setData(List<ContentModel> list) {
        this.list = list;
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            String path = "";
            String packageName = "com.example.wudz.launcher";
            if ("入口1".equals(list.get(position).getName())) {
                path = "com.example.wudz.launcher.TestActivity1";
            } else if ("入口2".equals(list.get(position).getName())) {
                path = "com.example.wudz.launcher.TestActivity2";
            } else if ("入口3".equals(list.get(position).getName())) {
                path = "com.example.wudz.launcher.TestActivity3";
            } else if ("入口4".equals(list.get(position).getName())) {
                path = "com.example.wudz.launcher.TestActivity4";
            } else if ("入口5".equals(list.get(position).getName())) {
                path = "com.example.wudz.launcher.TestActivity8";
            }
            if (!isPkgInstalled(packageName)) {
                Toast.makeText(getActivity(), "应用不存在", Toast.LENGTH_SHORT).show();
                return;
            }
            ComponentName comp = new ComponentName(packageName, path);
            intent.setComponent(comp);
            intent.setAction("android.intent.action.VIEW");
            if (!isActivity(intent)) {
                Toast.makeText(getActivity(), "应用页面不存在", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(intent);
        }
    };

    /**
     * 判断应用是否存在
     *
     * @param pkgName 包名
     * @return
     */
    private boolean isPkgInstalled(String pkgName) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getActivity().getPackageManager().getPackageInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断应用中的这个页面是否存在
     *
     * @param intent 意图
     * @return
     */
    private boolean isActivity(Intent intent) {
        List<ResolveInfo> list = getActivity().getPackageManager().queryIntentActivities(intent, 0);
        if (list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
