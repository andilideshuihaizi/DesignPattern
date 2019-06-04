package designpattern.hjq.hbg.www.com.bridge_pattern;

/**
 * Created by Administrator on 2018/10/22.
 */

public class Display {

    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public String open(){
        return impl.rawOpen();
    }

    public String print(){
        return impl.rawPrint();
    }

    public String close(){
        return impl.rawClose();
    }

    public final String display(){
        open();

        String text = print();

        close();

        return text;
    }
}
