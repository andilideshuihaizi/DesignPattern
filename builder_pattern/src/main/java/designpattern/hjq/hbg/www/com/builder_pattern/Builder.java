package designpattern.hjq.hbg.www.com.builder_pattern;

/**
 * Created by Administrator on 2018/10/19.
 *
 * 声明产生“文件”的所有方法的抽象类。
 */

public abstract class Builder {

    public abstract void makeTitle(String title);;//产生文件中的标题

    public abstract void makeString(String string);//产生文件中的字符串

    public abstract void makeItems(String[] items); //产生文件中的项目

    public abstract Object getResult();  //取得完成文件的方法

}
