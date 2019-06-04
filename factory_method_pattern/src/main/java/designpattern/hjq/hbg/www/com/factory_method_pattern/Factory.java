package designpattern.hjq.hbg.www.com.factory_method_pattern;

/**
 * Created by Administrator on 2018/10/17.
 */

public abstract class Factory {
    public final Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);

        return product;
    }

    protected abstract void registerProduct(Product product);

    protected abstract Product createProduct(String owner);
}
