package com.example.wudz.launchermanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wudz.launchermanager.R;
import com.example.wudz.launchermanager.model.AppInfo;

import java.util.List;


/**
 * USER：wudz on 2016/11/16 13:48
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class AppAdapter extends BaseAdapter {
    private Context context;
    private List<AppInfo> list;

    public AppAdapter(Context context, List<AppInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_app, null);
            holder.imgApp = (ImageView) convertView.findViewById(R.id.img_app);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_app);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(list.get(position).getAppName());
        holder.imgApp.setImageDrawable(list.get(position).getDrawable());
        return convertView;
    }

    class ViewHolder {
        TextView tvName;
        ImageView imgApp;
    }
}
