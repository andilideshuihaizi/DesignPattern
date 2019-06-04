package designpattern.hjq.hbg.www.com.designpattern;

import android.util.Log;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/2/26.
 */

public class Tool {
    static String paswrd = "";
    static final String trueWord = "123456";
    String but_num;
    EditText editText2;

    public void setBut_num(String but_num) {
        this.but_num = but_num;
    }

    public void setEditText2(EditText editText2) {
        this.editText2 = editText2;
    }

    public void setPaswrd(Callback callback){
        if (but_num.isEmpty())
            Log.i("main","but_num empty");
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher isNum = pattern.matcher(but_num);
        if (!isNum.matches()){
            Log.i("main","not num");
            if (but_num.equals("OK")){
                if (paswrd.equals(trueWord)){
                    paswrd = "";
                    callback.showToastTrue();
                }
                else{
                    paswrd = "";
                    callback.clearPaswrd();
                }
            }else {
                if (paswrd==null||paswrd.length()==0)
                    return;
                paswrd = paswrd.substring(0,paswrd.length()-1);
                callback.inputPaswrd();
            }
        }else {
            Log.i("main","is num:  "+Integer.parseInt(but_num));
            if (paswrd==null||paswrd.length()==0){
                Log.i("main","paswrd==null||paswrd.length()==0");
                paswrd = but_num;
            }else {
                paswrd = new StringBuilder(paswrd).append(but_num).toString();
            }
            callback.inputPaswrd();
        }

    }

}
