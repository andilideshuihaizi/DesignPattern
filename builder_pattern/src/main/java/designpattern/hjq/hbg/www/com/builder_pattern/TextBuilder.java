package designpattern.hjq.hbg.www.com.builder_pattern;

/**
 * Created by Administrator on 2018/10/19.
 *
 */

public class TextBuilder extends Builder {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("=========================\n");
        buffer.append(title+"\n");
    }

    @Override
    public void makeString(String string) {
        buffer.append(string+"\n");
    }

    @Override
    public void makeItems(String[] items) {

        for (String str:items){
            buffer.append(str+"\n");
        }
    }

    @Override
    public Object getResult() {
        buffer.append("======================\n");

        return buffer.toString();
    }
}
