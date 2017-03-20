package com.example.listviewclick.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listviewclick.R;
import com.example.listviewclick.bean.ListviewclickBean;

import java.util.List;

/**
 * Created by zzcz on 2017/3/2.
 */
public class ListviewclickAdapter extends BaseAdapter {
    private Context context;
    private List<ListviewclickBean> list;
    private ListviewclickView listviewclickView;

    public ListviewclickAdapter(Context context, List<ListviewclickBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? 0 : position;
    }

    @Override
    public long getItemId(int position) {
        return list == null ? 0 : position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listviewclickView = null;
        ListviewclickBean bean = list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_listviewclick,parent,false);
            listviewclickView = new ListviewclickView();
            listviewclickView.titleView = (TextView) convertView.findViewById(R.id.title_textview);
            convertView.setTag(listviewclickView);
        }else {
            listviewclickView = (ListviewclickView) convertView.getTag();
        }
        listviewclickView.titleView.setText(bean.getTitle());
        return convertView;
    }
    static class ListviewclickView {
        private TextView titleView ;
    }
}
