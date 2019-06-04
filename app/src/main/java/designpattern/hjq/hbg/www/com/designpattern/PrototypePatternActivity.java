package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.prototype_pattern.Manager;
import designpattern.hjq.hbg.www.com.prototype_pattern.MessageBox;
import designpattern.hjq.hbg.www.com.prototype_pattern.Product;


/**
 * Created by Administrator on 2018/10/18.
 */

public class PrototypePatternActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prototype_pattern);

        button = (Button) findViewById(R.id.Button01);
        textView = (TextView) findViewById(R.id.textView233);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Manager manager =new Manager();

        MessageBox messageBox = new MessageBox('*');
        manager.register("prototype",messageBox);

        Product product = manager.create("prototype");

        textView.setText(product.use("android ap Pattern"));

    }
}
