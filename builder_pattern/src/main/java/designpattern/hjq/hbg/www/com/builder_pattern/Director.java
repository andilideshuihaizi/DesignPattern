package designpattern.hjq.hbg.www.com.builder_pattern;

/**
 * Created by Administrator on 2018/10/19.
 */

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Object construct(){
        builder.makeTitle("terry");
        builder.makeString("android developer");
        builder.makeItems(new String[]{"Framework","java","native","HAL","Service"});
        builder.makeString("windows phone 7 developer");
        builder.makeItems(new String[]{"for silverlight","XNA"});

        return builder.getResult();
    }
}
