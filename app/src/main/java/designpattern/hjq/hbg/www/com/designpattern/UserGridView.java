package designpattern.hjq.hbg.www.com.designpattern;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/19.
 */
public class UserGridView extends AppCompatActivity {

    private EditText editText2;
    private GridView gridview;
    private ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usergridview);

        int length = 12;
        gridview = findViewById(R.id.gridview);
        editText2 =  findViewById(R.id.editText2);
        listview = findViewById(R.id.listview);

        ArrayList<HashMap<String, String>> lstImageItem = new ArrayList<>();
        for (int i = 0;i<length;i++){
            HashMap<String, String> map = new HashMap<>();
            if (i<=8)
                map.put("ID",Integer.toString(i+1));
            else if(i==9)
                map.put("ID","←");
            else if (i==10)
                map.put("ID","0");
            else
                map.put("ID","OK");
            lstImageItem.add(map);
        }

        SimpleAdapter adapter2 = new SimpleAdapter(this, getData(),
                R.layout.device_query, new String[] { "title", "info" },
                new int[] { R.id.title, R.id.info });
        listview.setAdapter(adapter2);

        SimpleAdapter adapter = new SimpleAdapter(this,lstImageItem,R.layout.item,new String[]{"ID"},new int[]{R.id.text1});
        gridview.setAdapter(adapter);
        final Tool tool = new Tool();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,Integer.toString(position),Toast.LENGTH_LONG).show();
                //final TextView textView = (TextView) findViewById(R.id.text1);
                GridView gridview2 = (GridView) parent;
                HashMap<String, String> map = (HashMap<String, String>) gridview2.getItemAtPosition(position);
                String s = map.get("ID");
                //                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                tool.setBut_num(s);
                tool.setEditText2(editText2);
                tool.setPaswrd(new Callback() {
                    @Override
                    public void inputPaswrd() {
                        editText2.setText(Tool.paswrd);
                    }

                    @Override
                    public void showToastTrue() {
                        Toast.makeText(UserGridView.this,"password is true",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void clearPaswrd() {
                        Toast.makeText(UserGridView.this,"password is wrong",Toast.LENGTH_SHORT).show();
                        editText2.setText("");
                    }
                });
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        // SD卡容量
        if (ExistSDCard()) {
            map = new HashMap<String, Object>();
            map.put("title", "SDCard");
            map.put("info", "总大小：" + formatSize(getTotalSDSize()) + " 可用空间:"
                    + formatSize(getAvailSDSize()));
            list.add(map);
        }

        // CPU型号与频率
        String[] cpuInfo = getCpuInfo();
        map = new HashMap<String, Object>();
        map.put("title", "CPU");
        map.put("info", "型号：" + cpuInfo[0] + " 频率：" + cpuInfo[1] + "MHz");
        list.add(map);

        // RAM 大小
        map = new HashMap<String, Object>();
        map.put("title", "RAM");
        map.put("info", "总大小:" + formatSize(getTotalRAMSize()) + " 可用空间："
                + formatSize(getAvailRAMSize()));
        list.add(map);

        // ROM 大小
        map = new HashMap<String, Object>();
        map.put("title", "ROM");
        map.put("info", "总大小：" + formatSize(getTotalROMSize()) + " 可用空间："
                + formatSize(getAvailROMSize()));
        list.add(map);

        // MAC 地址
        map = new HashMap<String, Object>();
        map.put("title", "MAC");
        map.put("info", getMacAddress());
        list.add(map);

        // 设备型号
        map = new HashMap<String, Object>();
        map.put("title", "设备型号");
        map.put("info", android.os.Build.MODEL);
        list.add(map);

        // 系统版本
        map = new HashMap<String, Object>();
        map.put("title", "系统版本");
        map.put("info", "Android " + android.os.Build.VERSION.RELEASE);
        list.add(map);

        // 开机时长
        map = new HashMap<String, Object>();
        map.put("title", "开机时长");
        map.put("info", getElapsedTime());
        list.add(map);

        // 屏幕分辨率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels; // 当前分辨率 宽度
        int height = dm.heightPixels; // 当前分辨率高度
        map = new HashMap<String, Object>();
        map.put("title", "屏幕分辨率");
        map.put("info", width + "X" + height);
        list.add(map);

        return list;
    }

    // SD卡 可用空间
    public long getAvailSDSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // 获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSize();
        // 空闲的数据块的数量
        long availBlocks = sf.getAvailableBlocks();
        // 返回SD卡空闲大小
        return availBlocks * blockSize; // Byte
    }

    // SD卡总大小
    public long getTotalSDSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // 获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSize();
        // 获取所有数据块数
        long totalBlocks = sf.getBlockCount();
        // 返回SD卡大小
        return totalBlocks * blockSize; // Byte
    }

    // 获得CPU信息
    public String[] getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
        String[] cpuInfo = { "", "" }; // 1-cpu型号 //2-cpu频率
        String[] arrayOfString;
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            for (int i = 2; i < arrayOfString.length; i++) {
                cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
            }
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            cpuInfo[1] += arrayOfString[2];
            localBufferedReader.close();
        } catch (IOException e) {
        }
        // Log.i(TAG, "cpuinfo:" + cpuInfo[0] + " " + cpuInfo[1]);
        return cpuInfo;
    }

    // RAM 总大小
    public long getTotalRAMSize() {
        String str1 = "/proc/meminfo";// 系统内存信息文件
        String str2;
        String[] arrayOfString;
        long totalSize = 0;
        try {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(
                    localFileReader, 8192);
            str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小
            arrayOfString = str2.split("\\s+");
            // 获得系统总内存，单位是KB，乘以1024转换为Byte
            totalSize = Integer.valueOf(arrayOfString[1]).intValue() * 1024;
            localBufferedReader.close();

        } catch (IOException e) {
        }
        return totalSize;
    }

    // RAM 可用空间
    public long getAvailRAMSize() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(memInfo);
        return memInfo.availMem;
    }

    // ROM总大小
    public long getTotalROMSize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize; // Byte
    }

    // ROM可用空间
    public long getAvailROMSize() {

        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize; // Byte

    }

    // MAC地址
    public String getMacAddress() {
        String macStr = "";
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo.getMacAddress() != null) {
            macStr = wifiInfo.getMacAddress();// MAC地址
        } else {
            macStr = "null";
        }

        return macStr;
    }

    // 取得开机时长
    public String getElapsedTime() {
        long ut = SystemClock.elapsedRealtime() / 1000;
        if (ut == 0) {
            ut = 1;
        }
        int m = (int) ((ut / 60) % 60);
        int h = (int) ((ut / 3600));
        return h + " " + "小时 " + m + " " + "分钟";
    }

    // 判断存储卡是否存在
    public boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }

    // 格式化数据
    public String formatSize(long size) {
        String suffix = "B";// Byte
        float fSize = 0;

        if (size >= 1024) {
            suffix = "KB";
            fSize = size / 1024;
            if (fSize >= 1024) {
                suffix = "MB";
                fSize /= 1024;
            }
            if (fSize >= 1024) {
                suffix = "GB";
                fSize /= 1024;
            }
        } else {
            fSize = size;
        }
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        StringBuilder resultBuffer = new StringBuilder(df.format(fSize));
        if (suffix != null)
            resultBuffer.append(suffix);
        return resultBuffer.toString();
    }
}
