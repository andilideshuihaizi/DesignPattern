package designpattern.hjq.hbg.www.com.adapterpattern.Pattern_one;

/**
 * Created by Administrator on 2018/10/17.
 */

public class PrintBanner extends Banner implements Print{

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public String printWeak() {
        return showWithAster();
    }

    @Override
    public String printStrong() {
        return showWithParan();
    }
}
