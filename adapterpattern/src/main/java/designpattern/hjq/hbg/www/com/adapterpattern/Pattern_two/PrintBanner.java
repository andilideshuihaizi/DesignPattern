package designpattern.hjq.hbg.www.com.adapterpattern.Pattern_two;

import designpattern.hjq.hbg.www.com.adapterpattern.Pattern_one.Banner;

/**
 * Created by Administrator on 2018/10/17.
 */

public class PrintBanner extends Print{

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public String printWeak() {
        return banner.showWithParan();
    }

    @Override
    public String printStrong() {
        return banner.showWithAster();
    }
}
