package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

import java.util.Iterator;

/**
 * Created by Administrator on 2018/10/22.
 */

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();

        sb.append("<li>\n");
        sb.append(caption + "\n");
        sb.append("<ul>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            sb.append(item.makeHTML());    //调用 ListLink实现完成后的makeHtml
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}
