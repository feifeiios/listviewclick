package com.example.listviewclick.secondshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listviewclick.R;
import com.example.listviewclick.adapter.WidgetClickAdapter;
import com.example.listviewclick.bean.WidgetBean;

import java.util.ArrayList;
import java.util.List;

public class WidgetClickActivity extends AppCompatActivity implements WidgetClickAdapter.WidgetClickAdapterI{

    private List<WidgetBean> list;
    private WidgetClickAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_click);

        list = new ArrayList<>();
        for (int i = 0 ; i< 18 ; i++) {
            WidgetBean bean = new WidgetBean();
            bean.setButtontitle("第 " + i + "按钮");
            bean.setText("第 " + i + "文本");
            list.add(bean);
        }
        adapter = new WidgetClickAdapter(this,list);
        adapter.setWidgetClickAdapterI(this);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    @Override
    public void buttonclick(int position) {
        WidgetBean bean = list.get(position);
        Log.e("flytosky","信息展示：我点击按钮—— " + bean.getButtontitle());

    }

    @Override
    public void textviewclick( String text) {

        Log.e("flytosky","信息展示：我点击文本—— " + text);

    }

}
