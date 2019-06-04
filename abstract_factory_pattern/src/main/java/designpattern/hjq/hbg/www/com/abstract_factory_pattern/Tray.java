package designpattern.hjq.hbg.www.com.abstract_factory_pattern;

import java.util.Vector;

/**
 * Created by Administrator on 2018/10/19.
 */

public abstract class Tray extends Item {

    protected Vector<Item> tray = new Vector<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item){
        tray.add(item);
    }

}
