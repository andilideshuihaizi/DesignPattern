package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import designpattern.hjq.hbg.www.com.adapterpattern.Pattern_one.Print;
import designpattern.hjq.hbg.www.com.adapterpattern.Pattern_one.PrintBanner;
/**
 * Created by Administrator on 2018/10/17.
 *
 * 适配器
 */

public class AdapterPatternActivity extends AppCompatActivity {

    private Button one, two;
    private EditText etOne, etTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_pattern);

        one = (Button) findViewById(R.id.one);

        two = (Button) findViewById(R.id.two);

        etOne = (EditText) findViewById(R.id.et_one);

        etTwo = (EditText) findViewById(R.id.et_two);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Print p = new PrintBanner("Android Adapter 类的继承");
                etOne.setText(p.printWeak() + "\n" + p.printStrong());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designpattern.hjq.hbg.www.com.adapterpattern.Pattern_two.Print p = new designpattern.hjq.hbg.www.com.adapterpattern.Pattern_two.PrintBanner(
                        "Android Adapter 对象的委托");
                etTwo.setText(p.printWeak() + "\n" + p.printStrong());
            }
        });


    }
}
