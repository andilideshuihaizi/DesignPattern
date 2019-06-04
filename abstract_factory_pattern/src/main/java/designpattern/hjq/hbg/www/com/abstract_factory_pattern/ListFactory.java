package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

/**
 * Created by Administrator on 2018/10/22.
 */

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }

}
