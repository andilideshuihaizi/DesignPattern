package designpattern.hjq.hbg.www.com.designpattern;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import designpattern.hjq.hbg.www.com.designpattern.mymapview.MyMapPointView;
import designpattern.hjq.hbg.www.com.designpattern.mymapview.MyMapPointWithTitleView;
import designpattern.hjq.hbg.www.com.designpattern.mymapview.MyMapView;

public class MapActivity extends AppCompatActivity implements MyMapView.MyMapViewOnLongClickListener {

    private MyMapView myMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        myMapView = findViewById(R.id.myMapView);
        InputStream open = null;
        try {
            open = getResources().getAssets().open("big_map.png");
            Bitmap bitmap = BitmapFactory.decodeStream(open);
            myMapView.setMapState(bitmap, bitmap.getWidth(), bitmap.getHeight());
            Log.i("testss", bitmap.getWidth() + "=========" + bitmap.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }


        MyMapPointWithTitleView myMapPointWithTitleView =
                new MyMapPointWithTitleView(this, 189.474903681507, 143.937981592466, MyMapPointView.RED_POINT, true, "点标题");
        myMapView.addMapPoint(myMapPointWithTitleView);
        myMapView.setMapOnLongClickListener(this);
    }

    int i = 0;

    @Override
    public void myMapViewOnLongClick(float downX, float downY) {
        MyMapPointWithTitleView myMapPointWithTitleView =
                new MyMapPointWithTitleView(this, downX, downY, MyMapPointView.RED_POINT, true, "" + (i++));
        myMapView.addMapPoint(myMapPointWithTitleView);
        Toast.makeText(this, "" + downX + "-" + downY, Toast.LENGTH_SHORT).show();
    }

    float x = 10;
    float y = 10;

    public void addLine(View view) {
        myMapView.addMapLine(x, y);
        x += 100;
        y += 100;
    }

    public void addPoint(View view) {
        MyMapPointWithTitleView myMapPointWithTitleView =
                new MyMapPointWithTitleView(this, 306.761283528198, 236.623538514443, MyMapPointView.RED_POINT, false, "点标题");
        myMapView.addMapPoint(myMapPointWithTitleView);
    }
}
