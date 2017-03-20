package com.example.listviewclick.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listviewclick.R;

/**
 * Created by zzcz on 2017/3/1.
 */
public class HomeAdapter extends BaseAdapter {
    private String[] homeStrings;
    private Context context;
    private HomeView homeView ;


    public HomeAdapter(Context context, String[] homeStrings) {
        this.context = context;
        this.homeStrings = homeStrings;
    }

    @Override
    public int getCount() {
        return homeStrings != null ? homeStrings.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return homeStrings != null ? position : null;
    }

    @Override
    public long getItemId(int position) {
        return homeStrings != null ? position : null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        homeView = null ;
        if (convertView == null ){

            homeView = new HomeView();
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_home, parent,false);
            homeView.textView = (TextView) convertView.findViewById(R.id.textview);
            homeView.topdivideline = convertView.findViewById(R.id.topline);
            homeView.bottomdivideline = convertView.findViewById(R.id.bottomline);
            convertView.setTag(homeView);
        }else {
            homeView = (HomeView) convertView.getTag();
        }
        homeView.textView.setText(homeStrings[position]);


        if (position == 0){
            homeView.topdivideline.setVisibility(View.VISIBLE);
            homeView.bottomdivideline.setVisibility(View.GONE);

        } else if (position == homeStrings.length-1) {
            homeView.topdivideline.setVisibility(View.GONE);
            homeView.bottomdivideline.setVisibility(View.VISIBLE);

        } else  {
            homeView.topdivideline.setVisibility(View.GONE);
            homeView.bottomdivideline.setVisibility(View.GONE);
        }

        return convertView;
    }
    static class HomeView {
        private View topdivideline;
        private View bottomdivideline;
        private TextView textView;
    }
}
