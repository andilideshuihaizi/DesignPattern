package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import designpattern.hjq.hbg.www.com.abstract_factory_pattern.Factory;
import designpattern.hjq.hbg.www.com.abstract_factory_pattern.Link;
import designpattern.hjq.hbg.www.com.abstract_factory_pattern.ListFactory;
import designpattern.hjq.hbg.www.com.abstract_factory_pattern.Page;
import designpattern.hjq.hbg.www.com.abstract_factory_pattern.Tray;


/**
 * Created by Administrator on 2018/10/22.
 */

public class AbstractFactoryPatternActivity extends AppCompatActivity implements View.OnClickListener {

    Button button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abstract_factory_pattern);

        textView = (TextView) findViewById(R.id.textView4);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Factory factory = Factory.getFactory(ListFactory.class);

        Link cnblogs = factory.createLink("Cnblogs","http://www.cnblogs.com/terryblog");
        Link cto = factory.createLink("51CTO", "http://terryblog.blog.51cto.com/");
        Link cnds = factory.createLink("cnds","http://blog.csdn.net/terryyhl");

        Tray cnblogsTray = factory.createTray("First Cnblogs");
        cnblogsTray.add(cnblogs);

        Tray ctoTray = factory.createTray("Second Cnblogs");
        ctoTray.add(cto);

        Tray csdnTray = factory.createTray("Thrid Cnblogs");
        csdnTray.add(cnds);

        Page page = factory.createPage("my example","ling");
        page.add(cnblogsTray);
        page.add(ctoTray);
        page.add(csdnTray);

        textView.setText(page.outPut());


    }
}
