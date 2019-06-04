package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.huewu.pla.lib.WaterFallListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/22.
 */
public class WaterFallActivity extends AppCompatActivity {

    private MyAdapter adapter;
    WaterFallListView waterFallListView;
    private List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object>map;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usergridview);

//        listView = findViewById(R.id.listview);
        waterFallListView = new WaterFallListView(this);

        waterFallListView.findViewById(R.id.listview);

        waterFallListView.computeScroll();

        waterFallListView.setRefreshTime("200");

        //初始化数据
        for (int i = 0; i < 8; i++) {
            map = new HashMap<>();
            map.put("Id", "100"+i);
            map.put("Name","Name_"+i);
            list.add(map);
        }

        adapter = new MyAdapter(this,list);

        waterFallListView.setAdapter(adapter);

    }

}
