package com.example.listviewclick.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listviewclick.R;
import com.example.listviewclick.bean.AdapterclickBean;

import java.util.List;

/**
 * Created by zzcz on 2017/3/20.
 */
public class MyClickAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    private List<AdapterclickBean> list ;
    private Context context;
//    private

    public MyClickAdapter(Context context, List<AdapterclickBean> list) {
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
        MyClickView myClickView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_myclickadapter,parent,false);
            myClickView = new MyClickView();
            myClickView.textView = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(myClickView);
        }else {
            myClickView = (MyClickView) convertView.getTag();
        }
        AdapterclickBean bean = list.get(position);
        myClickView.textView.setText(bean.getTitle());
        ((ListView)parent).setOnItemClickListener(this);//设置点击事件

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AdapterclickBean bean = list.get(position);

        Log.e("flytosky","信息展示 点击 ：" + bean.getTitle());
    }

    static class MyClickView {
        private TextView textView;
    }
}
