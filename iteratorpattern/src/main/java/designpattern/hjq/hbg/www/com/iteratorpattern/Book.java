package designpattern.hjq.hbg.www.com.iteratorpattern;

/**
 * Created by Administrator on 2018/10/16.
 */

public class Book {

    private String name = "";


    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
