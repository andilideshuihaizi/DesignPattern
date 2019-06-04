package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import designpattern.hjq.hbg.www.com.template_method_pattern.AbstractDisplay;
import designpattern.hjq.hbg.www.com.template_method_pattern.CharDisplay;
import designpattern.hjq.hbg.www.com.template_method_pattern.StringDisplay;


/**
 * Created by Administrator on 2018/10/17.
 *
 *模板
 */

public class TemplatePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_pattern);

        Button result=(Button)findViewById(R.id.btn_result);

        final EditText et_result=(EditText)findViewById(R.id.result);

        final AbstractDisplay d1 = new CharDisplay('H');
        final AbstractDisplay d2 = new StringDisplay("Template pattern");

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_result.setText(d1.display()+"\n"+d2.display());
            }
        });

    }
}
