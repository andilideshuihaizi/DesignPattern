package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

import java.util.Iterator;

/**
 * Created by Administrator on 2018/10/22.
 */

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHtml() {
        StringBuffer sb = new StringBuffer();

        sb.append("<html><head><title>" + title + "</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>" + title + "<h1>\n");
        sb.append("<ul>\n");

        Iterator<Item> it = content.iterator();
        while (it.hasNext()){
            Item item = it.next();
            sb.append(item.makeHTML());
        }

        sb.append("</ul>\n");
        sb.append("<hr><address>"+author+"</address>");
        sb.append("</body></html>\n");

        return sb.toString();
    }
}
