package designpattern.hjq.hbg.www.com.iteratorpattern;

/**
 * Created by Administrator on 2018/10/16.
 *
 * 声明一个iterator方法，这是为了建立一个可对应聚合的Iterator
 * 如欲递增、遍历或逐一检查某一个聚合时，利用iterator方法即可建立一个
 * 实现Iterator 接口 的类对象实例。
 */

public interface Aggregate {

    designpattern.hjq.hbg.www.com.iteratorpattern.Iterator iterator();
}
