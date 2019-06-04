package designpattern.hjq.hbg.www.com.bridge_pattern;

/**
 * Created by Administrator on 2018/10/22.
 */

public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public String multiDisplay(int times){
        StringBuffer buffer = new StringBuffer();

        buffer.append(open()+"\n");

        for (int i=0;i<times;i++){
            buffer.append(print()+"\n");
        }

        buffer.append(close()+"\n");

        return buffer.toString();
    }
}
