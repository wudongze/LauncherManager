package com.example.wudz.launchermanager.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wudz.launchermanager.R;
import com.example.wudz.launchermanager.model.HeaderModel;

import java.util.List;

/**
 * USER：wudz on 2016/11/18 14:08
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class HeaderAdapter extends BaseAdapter {
    private Context context;
    private List<HeaderModel> list;

    public HeaderAdapter(Context context, List<HeaderModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_header, null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getName());
        Drawable drawable = context.getResources().getDrawable(list.get(position).getImage());
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        holder.tv.setCompoundDrawables(null, drawable, null, null);
        return convertView;
    }

    class ViewHolder {
        TextView tv;
    }
}
