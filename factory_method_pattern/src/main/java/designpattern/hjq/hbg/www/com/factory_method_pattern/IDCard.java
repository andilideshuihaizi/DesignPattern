package designpattern.hjq.hbg.www.com.factory_method_pattern;

/**
 * Created by Administrator on 2018/10/18.
 */

public class IDCard extends Product {

    private String owner;

    public IDCard(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String create() {
        return "建立 "+owner+"的卡";
    }

    @Override
    public String use() {
        return "使用"+owner+"的卡";
    }
}
