package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

/**
 * Created by Administrator on 2018/10/22.
 */

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return " <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
