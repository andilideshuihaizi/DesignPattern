package designpattern.hjq.hbg.www.com.prototype_pattern;

import java.util.Hashtable;

/**
 * Created by Administrator on 2018/10/18.
 *
 *
 */

public class Manager {

    private Hashtable<String, Product> showCase = new Hashtable<>();

    public void register(String name, Product product){
        showCase.put(name,product);
    }

    public Product create(String protoName){
        Product p = showCase.get(protoName);

        return p.createClone();
    }


}
