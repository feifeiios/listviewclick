package com.example.listviewclick.secondshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listviewclick.R;
import com.example.listviewclick.adapter.ListviewclickAdapter;
import com.example.listviewclick.bean.ListviewclickBean;

import java.util.ArrayList;
import java.util.List;

public class ListvewclickActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<ListviewclickBean> listviewclickBeens;
    private ListviewclickAdapter listviewclickAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listvewclick);
        listView = (ListView) findViewById(R.id.listview);
        listviewclickBeens = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ){
            ListviewclickBean bean = new ListviewclickBean();
            bean.setTitle("第"+ i+ "个");
            listviewclickBeens.add(bean);
        }
        listviewclickAdapter = new ListviewclickAdapter(this , listviewclickBeens);

        listView.setAdapter(listviewclickAdapter);

        listView.setOnItemClickListener(this);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ListviewclickBean bean = listviewclickBeens.get(position);
//                Log.e("flytosky","信息展示：我点击的是—— " + bean.getTitle())；
//            }
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListviewclickBean bean = listviewclickBeens.get(position);
        Log.e("flytosky","信息展示：我点击的是—— " + bean.getTitle());
    }
}
