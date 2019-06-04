package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.bridge_pattern.CountDisplay;
import designpattern.hjq.hbg.www.com.bridge_pattern.Display;
import designpattern.hjq.hbg.www.com.bridge_pattern.StringDisplayImpl;

/**
 * Created by Administrator on 2018/10/22.
 */

public class BridgePatternActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bridge_pattern);

        button = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView5);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Display display = new Display(new StringDisplayImpl("ling kong"));

        CountDisplay countDisplay = new CountDisplay(new StringDisplayImpl("android example"));

        textView.setText(display.display()+"\n"+countDisplay.multiDisplay(5));
    }

}
