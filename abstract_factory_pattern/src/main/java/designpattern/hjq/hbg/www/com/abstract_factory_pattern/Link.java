package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

/**
 * Created by Administrator on 2018/10/19.
 */

public abstract class Link extends Item{

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
