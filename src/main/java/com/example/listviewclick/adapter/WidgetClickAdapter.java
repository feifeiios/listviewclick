package com.example.listviewclick.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.listviewclick.R;
import com.example.listviewclick.bean.WidgetBean;

import java.util.List;

/**
 * Created by zzcz on 2017/3/20.
 */
public class WidgetClickAdapter extends BaseAdapter {
    private List<WidgetBean> list ;
    private Context context;

    public void setWidgetClickAdapterI(WidgetClickAdapterI widgetClickAdapterI) {
        this.widgetClickAdapterI = widgetClickAdapterI;
    }

    private WidgetClickAdapterI widgetClickAdapterI;

    public WidgetClickAdapter(Context context, List<WidgetBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        WidgetView widgetView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_widgetclick,parent,false);
            widgetView = new WidgetView();
            widgetView.textView = (TextView) convertView.findViewById(R.id.textview);
            widgetView.button = (Button) convertView.findViewById(R.id.button);
        }else {
            widgetView = (WidgetView) convertView.getTag();
        }
        WidgetBean bean = list.get(position);
        widgetView.textView.setText(bean.getText());
        widgetView.button.setText(bean.getButtontitle());
        widgetView.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (widgetClickAdapterI == null){//判断是否实现WidgetClickAdapterI的接口，如果没有实现，则退出点击的调用
                    return;
                }
                widgetClickAdapterI.textviewclick(((TextView) v).getText().toString());//将类型为View的v转为TextView，获取它的文字
            }
        });
        widgetView.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (widgetClickAdapterI == null){//判断是否实现WidgetClickAdapterI的接口，如果没有实现，则退出点击的调用
                    return;
                }
                widgetClickAdapterI.buttonclick(position);
            }
        });
        return convertView;
    }



    static class WidgetView {
        private Button button;
        private TextView textView ;
    }

    public interface WidgetClickAdapterI {
        public void buttonclick (int position);//传入点击item的索引位置
        public void textviewclick (String text);//传入文字
    }
}
