package designpattern.hjq.hbg.www.com.designpattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/22.
 */
public class MyAdapter extends BaseAdapter {
    List<Map<String, Object>> list;
    Context context;
    LayoutInflater inflater;

    public MyAdapter(Context context, List<Map<String, Object>> lstImageItem) {
        list = lstImageItem;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item, null);
            TextView textView = convertView.findViewById(R.id.text1);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = textView;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv1.setText(list.get(position).get("Id").toString());

        return convertView;
    }

    //辅助类
    class ViewHolder{
        TextView tv1;

        public ViewHolder(TextView tv1) {
            this.tv1 = tv1;
        }

        public ViewHolder() {
        }
    }

}
