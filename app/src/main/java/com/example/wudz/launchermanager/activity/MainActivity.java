package com.example.wudz.launchermanager.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.wudz.launchermanager.R;
import com.example.wudz.launchermanager.adapter.MyPortAdapter;
import com.example.wudz.launchermanager.adapter.ViewPagerAdapter;
import com.example.wudz.launchermanager.fragment.ContentFragment;
import com.example.wudz.launchermanager.fragment.MainHeaderFragment;
import com.example.wudz.launchermanager.listener.SlidListener;
import com.example.wudz.launchermanager.model.ContentModel;
import com.example.wudz.launchermanager.widget.HorizontialListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewPager;
    private HorizontialListView listView;
    private List<Boolean> listChecked = new ArrayList<>();
    private MyPortAdapter myPortAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    //初始化View
    private void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        MainHeaderFragment mainHeaderFragment = new MainHeaderFragment();
        mainHeaderFragment.setSlidListener(listener);
        transaction.add(R.id.lin_header, mainHeaderFragment).commit();


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        listView = (HorizontialListView) findViewById(R.id.listView);

        List<Fragment> list = new ArrayList<>();
        List<ContentModel> listContent = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i < 39; i++) {
            if (i % 4 == 0) {
                List<ContentModel> listContent2 = new ArrayList<>();
                listContent2.addAll(listContent);
                ContentFragment contentFragment1 = new ContentFragment();
                contentFragment1.setData(listContent2);
                list.add(contentFragment1);
                if (flag) {
                    listChecked.add(flag);
                    flag = false;
                } else {
                    listChecked.add(flag);
                }
                listContent.clear();
            }
            ContentModel contentModel = new ContentModel();
            contentModel.setImg(R.mipmap.ic_launcher);
            contentModel.setName("入口" + i);
            listContent.add(contentModel);
        }
        myPortAdapter = new MyPortAdapter(this, listChecked);
        listView.setAdapter(myPortAdapter);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), list));
        viewPager.setOnPageChangeListener(onPageChangeListener);
    }

    //接口回调，打开侧滑菜单
    SlidListener listener = new SlidListener() {
        @Override
        public void click() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
        }
    };

    //ViewPage滑动监听
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int k = listChecked.size();
            listChecked.clear();
            for (int i = 0; i < k; i++) {
                if (i == position) {
                    listChecked.add(true);
                } else {
                    listChecked.add(false);
                }
            }
            myPortAdapter.notifyDataSetChanged();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
