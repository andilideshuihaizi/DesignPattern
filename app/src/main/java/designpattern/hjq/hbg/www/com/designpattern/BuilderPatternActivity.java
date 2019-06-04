package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.builder_pattern.Builder;
import designpattern.hjq.hbg.www.com.builder_pattern.Director;
import designpattern.hjq.hbg.www.com.builder_pattern.HtmlBuilder;
import designpattern.hjq.hbg.www.com.builder_pattern.TextBuilder;


/**
 * Created by Administrator on 2018/10/19.
 *
 */

public class BuilderPatternActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.builder_pattern);

        button1 = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button5);
        textView1 = (TextView) findViewById(R.id.textView6);
        textView2 = (TextView) findViewById(R.id.textView7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                Builder builder = new TextBuilder();
                Director director = new Director(builder);
                String target = (String) director.construct();
                textView1.setText(target);
                break;
            case R.id.button5:
                Builder builder2 = new HtmlBuilder();
                Director director2 = new Director(builder2);
                String target2 = (String) director2.construct();
                textView2.setText(target2);
                break;
        }
    }
}
