package designpattern.hjq.hbg.www.com.iteratorpattern;

/**
 * Created by Administrator on 2018/10/16.
 */

public interface Iterator {

    boolean hasNext();    //存在一条则返回true

    Object next();         //移到下一条记录
}
