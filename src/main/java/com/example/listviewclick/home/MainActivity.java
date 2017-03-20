package com.example.listviewclick.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewclick.R;
import com.example.listviewclick.adapter.HomeAdapter;
import com.example.listviewclick.secondshow.ListvewclickActivity;
import com.example.listviewclick.secondshow.MyAdapterclickActivity;
import com.example.listviewclick.secondshow.WidgetClickActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listview;
    private HomeAdapter homeAdapter;
    private String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);

        strings = new String[]{
                "  写在ListView的点击事件",
                "  写在Adapter的点击事件",
                "  写在item控件的点击事件"
        };
        homeAdapter = new HomeAdapter(this, strings);
        listview.setAdapter(homeAdapter);

        listview.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent listviewclickintent = new Intent(MainActivity.this, ListvewclickActivity.class);
                startActivity(listviewclickintent);

                break;
            case 1:
                Intent adapterclickintent = new Intent(MainActivity.this, MyAdapterclickActivity.class);
                startActivity(adapterclickintent);

                break;
            case 2:
                Intent widgetintent = new Intent(MainActivity.this, WidgetClickActivity.class);
                startActivity(widgetintent);
                break;
            default:
                Toast.makeText(this, "不在数据范围",Toast.LENGTH_LONG).show();
        }
    }
}
