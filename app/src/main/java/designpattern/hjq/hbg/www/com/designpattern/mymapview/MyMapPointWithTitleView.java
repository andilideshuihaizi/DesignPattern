package designpattern.hjq.hbg.www.com.designpattern.mymapview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;

import designpattern.hjq.hbg.www.com.designpattern.R;

/**
 * 自定义 地图 坐标 点
 * Created by Administrator on 2016/6/30.
 */
public class MyMapPointWithTitleView extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    public static final int RED_POINT = 0;
    public static final int BLUE_POINT = 1;
    public static final int GRAY_POINT = 2;
    public static final int BLACK_POINT = 3;
    public static final int PEOPLE_POINT = 4;
    public static final int DEFAULT_POINT = 5;

    private ImageView pointIcon;
    private TextView pointTitle;

    private Context context;
    // 初始 位置
    private double firstX;
    private double firstY;

    // 点的 边界
    private double borderTop;
    private double borderLeft;
    // 点 的 显示 状态
    private int state;
    // 点 的 名称
    private String title;
    // 是否 显示 点 名称
    private boolean isTitleShow;

    public MyMapPointWithTitleView(Context context) {
        super(context);
        init();
    }

    public MyMapPointWithTitleView(Context context, double pointX, double pointY, int state, boolean isTitleShow, String title) {
        super(context);
        this.context = context;
        this.firstX = pointX;
        this.firstY = pointY;
        this.state = state;
        this.title = title;
        this.isTitleShow = isTitleShow;
        init();
    }

    public void setFirstXShow(float x) {
        x -= borderLeft;
        setX(x);
    }

    public void setFirstYShow(float y) {
        y -= borderTop;
        setY(y);
    }


    public void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_mymap_point, this);
        pointIcon = (ImageView) view.findViewById(R.id.pointIcon);
        pointTitle = (TextView) view.findViewById(R.id.pointTitle);

        // 设置 显示 内容
        setPointIcon();
        pointTitle.setText(title);

        // 测量 边界
        measureBorder();

        // 设置 监听
        this.setOnClickListener(this);
        this.setOnLongClickListener(this);
    }

    /**
     * 测量 地图点 的 边界
     */
    private void measureBorder() {
        int height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int width = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        this.pointIcon.measure(width, height);
        this.pointTitle.measure(width, height);
        this.measure(width, height);

        if (!isTitleShow) {
            pointTitle.setVisibility(INVISIBLE);
        } else {
            pointTitle.setVisibility(VISIBLE);
        }


        this.borderLeft = (this.getMeasuredWidth() - this.pointIcon.getMeasuredWidth()) / 2;
        this.borderTop = (this.getMeasuredHeight() - this.pointIcon.getMeasuredHeight() - this.pointTitle.getMeasuredHeight());

        Log.i("testss", this.borderLeft + "fffffff=========" + this.borderTop);
    }

    /**
     * 设置 显示 图标
     */
    private void setPointIcon() {
        // 默认 点显示 在 左上角的位置
        String pointPictureName;
        switch (this.state) {
            case RED_POINT:
                pointPictureName = "PointIcon_red.png";
                break;
            case BLUE_POINT:
                pointPictureName = "PointIcon_blue.png";
                break;
            case GRAY_POINT:
                pointPictureName = "PointIcon_gray.png";
                break;
            case BLACK_POINT:
                pointPictureName = "PointIcon_black.png";
                break;
            case PEOPLE_POINT:
                pointPictureName = "pointIcon_people.png";
                break;
            case DEFAULT_POINT:
            default:
                pointPictureName = "PointIcon_default.png";
                break;
        }
        InputStream open = null;
        try {
            open = getResources().getAssets().open(pointPictureName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.pointIcon.setImageBitmap(BitmapFactory.decodeStream(open));

    }

    public double getFirstX() {
        return firstX;
    }

    public double getFirstY() {
        return firstY;
    }

    public float getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, this.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show();
        return true;
    }
}
