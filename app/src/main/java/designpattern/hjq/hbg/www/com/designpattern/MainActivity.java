package designpattern.hjq.hbg.www.com.designpattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button AdapterPattern;
    Button Template_Pattern;
    Button iteratorPattern;
    Button Factory_Pattern;
    Button Singleton_Pattern;
    Button Prototype_Pattern;
    Button Builder_Pattern;
    Button Abstract_Factory_Pattern;
    Button Bridge_Pattern;
    Button gridview;
    Button mapview;
    Button ui_view;
    Button waterFall_view;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterPattern = findViewById(R.id.AdapterPattern);
        Template_Pattern = findViewById(R.id.Template_Pattern);
        iteratorPattern = findViewById(R.id.iteratorPattern);
        Factory_Pattern = findViewById(R.id.Factory_Pattern);
        Singleton_Pattern = findViewById(R.id.Singleton_Pattern);
        Prototype_Pattern = findViewById(R.id.Prototype_Pattern);
        Builder_Pattern = findViewById(R.id.Builder_Pattern);
        Abstract_Factory_Pattern = findViewById(R.id.Abstract_Factory_Pattern);
        Bridge_Pattern = findViewById(R.id.Bridge_Pattern);
        gridview = findViewById(R.id.gridview);
        mapview = findViewById(R.id.mapview);
        ui_view = findViewById(R.id.ui_view);
        waterFall_view = findViewById(R.id.waterFall_view);

        iteratorPattern.setOnClickListener(this);
        AdapterPattern.setOnClickListener(this);
        Template_Pattern.setOnClickListener(this);
        Factory_Pattern.setOnClickListener(this);
        Singleton_Pattern.setOnClickListener(this);
        Prototype_Pattern.setOnClickListener(this);
        Builder_Pattern.setOnClickListener(this);
        Abstract_Factory_Pattern.setOnClickListener(this);
        Bridge_Pattern.setOnClickListener(this);
        gridview.setOnClickListener(this);
        mapview.setOnClickListener(this);
        ui_view.setOnClickListener(this);
        waterFall_view.setOnClickListener(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iteratorPattern://迭代器模式
                Intent i = new Intent(this,IteratorPatternActivity.class);
                startActivity(i);
                break;
            case R.id.AdapterPattern://适配器模式
                Intent i2 = new Intent(this,AdapterPatternActivity.class);
                startActivity(i2);
                break;
            case R.id.Template_Pattern://模板模式
                Intent i3 = new Intent(this,TemplatePatternActivity.class);
                startActivity(i3);
                break;
            case R.id.Factory_Pattern://工厂模式
                Intent i4 = new Intent(this,FactoryPatternActivity.class);
                startActivity(i4);
                break;
            case R.id.Singleton_Pattern://单例模式
                Intent i5 = new Intent(this,SingletonPatternActivity.class);
                startActivity(i5);
                break;
            case R.id.Prototype_Pattern://原型模式
                Intent i6 = new Intent(this,PrototypePatternActivity.class);
                startActivity(i6);
                break;
            case R.id.Builder_Pattern://生成器模式
                Intent i7 = new Intent(this,BuilderPatternActivity.class);
                startActivity(i7);
                break;
            case R.id.Abstract_Factory_Pattern://抽象工厂模式
                Intent i8 = new Intent(this,AbstractFactoryPatternActivity.class);
                startActivity(i8);
                break;
            case R.id.Bridge_Pattern://桥接模式
                Intent i9 = new Intent(this,BridgePatternActivity.class);
                startActivity(i9);
                break;
            case R.id.gridview:
                Intent i10 = new Intent(this,UserGridView.class);
                startActivity(i10);
                break;
            case R.id.mapview:
                Intent i11 = new Intent(this,MapActivity.class);
                startActivity(i11);
                break;
            case R.id.ui_view:
                Intent i12 = new Intent(this,UiActivity.class);
                startActivity(i12);
                break;
            case R.id.waterFall_view:
                Intent i13 = new Intent(this,WaterFallActivity.class);
                startActivity(i13);
                break;
        }
    }
}
