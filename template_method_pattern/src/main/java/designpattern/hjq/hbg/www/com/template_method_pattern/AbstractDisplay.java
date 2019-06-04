package designpattern.hjq.hbg.www.com.template_method_pattern;

/**
 * Created by Administrator on 2018/10/17.
 *
 *
 * 作为模板的方法要定义在父类，而方法的定义中使用到抽象方法。因此如果只看父类部分的程序，根本不知道到底会是怎样处理内容，最多只能了解该如何调用处理抽象方法而已。
 *
 * 实际实现抽象方法的是子类。要在子类实现方法，才能决定具体的操作。理论上，如果在不同的子类执行不同的实现，应该就能发展出不同的处理内容 。
   不过无论在哪个子类执行任何一种实现，处理的大致流程都是还要依照父类的制定方式。
 */

public abstract class AbstractDisplay {

    public abstract String open();

    public abstract String print();

    public abstract String close();

    public final String display(){
        StringBuffer sb = new StringBuffer();
        sb.append(open());
        for (int i=0;i<5;i++){
            sb.append(print());
        }
        sb.append(close());

        return sb.toString();
    }

}
