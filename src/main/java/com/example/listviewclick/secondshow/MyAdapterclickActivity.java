package com.example.listviewclick.secondshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.listviewclick.R;
import com.example.listviewclick.adapter.MyClickAdapter;
import com.example.listviewclick.bean.AdapterclickBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterclickActivity extends AppCompatActivity {

    private List<AdapterclickBean> list;
    private MyClickAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adapterclick);

        list = new ArrayList<>();
        for (int i = 0 ; i < 18 ; i++) {
            AdapterclickBean bean = new AdapterclickBean();
            bean.setTitle("我是第 "+i + " 个 item。请点击我");
            list.add(bean);
        }
        adapter = new MyClickAdapter(this,list);
        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter);
    }
}
