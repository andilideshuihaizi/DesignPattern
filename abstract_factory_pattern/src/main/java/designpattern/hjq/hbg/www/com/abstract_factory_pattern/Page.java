package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

import java.util.Vector;

/**
 * Created by Administrator on 2018/10/19.
 */

public abstract class Page {

    protected String title;
    protected String author;
    protected Vector<Item> content = new Vector<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }

    public String outPut(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(title+".html\n");
        buffer.append(makeHtml());

        return buffer.toString();
    }

    public abstract String makeHtml();


}
