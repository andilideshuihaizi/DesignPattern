package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.singleton_pattern.Singleton;
import designpattern.hjq.hbg.www.com.singleton_pattern.normal;


/**
 * Created by Administrator on 2018/10/18.
 */

public class SingletonPatternActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleton_pattern);

        button = (Button) findViewById(R.id.Button01);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        normal obj3=new normal();
        normal obj4 =new normal();

        if(obj1==obj2){
            textView2.setText("obj1和obj2是同一对象实例");
        }else {
            textView2.setText("obj1和obj2不是同一对象实例");
        }

        if (obj3==obj4){
            textView3.setText("obj3和obj4是同一对象实例");
        }else {
            textView3.setText("obj3和obj4不是同一对象实例");
        }

    }
}
