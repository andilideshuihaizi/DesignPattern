package designpattern.hjq.hbg.www.com.prototype_pattern;

/**
 * Created by Administrator on 2018/10/18.
 *
 *
 */

public interface Product extends Cloneable {

    String use(String s);

    Product createClone();

}
