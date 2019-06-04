package designpattern.hjq.hbg.www.com.singleton_pattern;

/**
 * Created by Administrator on 2018/10/18.
 */

public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton(){
    }

    public static  Singleton getInstance(){
        return singleton;
    }

}
