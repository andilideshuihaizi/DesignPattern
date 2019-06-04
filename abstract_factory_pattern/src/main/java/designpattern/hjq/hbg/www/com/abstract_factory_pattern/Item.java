package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

/**
 * Created by Administrator on 2018/10/19.
 */

public abstract class Item {

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
