package designpattern.hjq.hbg.www.com.factory_method_pattern;

import java.util.Vector;

/**
 * Created by Administrator on 2018/10/18.
 */

public class IDCardFactory extends Factory {

    private Vector<String> owner = new Vector<>();

    public Vector<String> getOwner() {
        return owner;
    }

    @Override
    protected void registerProduct(Product product) {
        owner.add(((IDCard)product).getOwner());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

}
