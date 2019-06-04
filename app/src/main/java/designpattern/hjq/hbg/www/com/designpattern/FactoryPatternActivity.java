package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.factory_method_pattern.IDCardFactory;
import designpattern.hjq.hbg.www.com.factory_method_pattern.Product;


/**
 * Created by Administrator on 2018/10/18.
 */

public class FactoryPatternActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factory_pattern);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        IDCardFactory factory = new IDCardFactory();

        Product product1 = factory.create("terry");
        Product product2 = factory.create("paul");
        Product product3 = factory.create("jim");

        textView.setText(product1.create()+"\n"+product2.use()+"\n"+product3.create());

    }
}
