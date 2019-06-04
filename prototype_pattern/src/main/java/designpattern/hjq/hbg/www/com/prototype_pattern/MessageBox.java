package designpattern.hjq.hbg.www.com.prototype_pattern;

/**
 * Created by Administrator on 2018/10/18.
 *
 *
 */

public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public String use(String s) {
        int length = s.getBytes().length;
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<length+4;i++){
            sb.append(decochar);
        }

        sb.append(decochar + "\n\"" + s + "\"\n" + decochar);

        for (int i=0;i<length+4;i++){
            sb.append(decochar);
        }

        sb.append("");

        return sb.toString();
    }

    @Override
    public Product createClone() {
        Product p = null;

        try {
            p = (Product) clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }

}
