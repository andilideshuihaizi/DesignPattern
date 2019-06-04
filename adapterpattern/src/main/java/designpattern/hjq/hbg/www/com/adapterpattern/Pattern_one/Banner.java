package designpattern.hjq.hbg.www.com.adapterpattern.Pattern_one;

/**
 * Created by Administrator on 2018/10/17.
 */

public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public String showWithParan(){
        return "("+string+")";
    }

    public String showWithAster(){
        return "*"+string+"*";
    }
}
