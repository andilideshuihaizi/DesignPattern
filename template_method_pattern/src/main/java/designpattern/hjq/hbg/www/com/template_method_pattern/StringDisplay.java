package designpattern.hjq.hbg.www.com.template_method_pattern;

/**
 * Created by Administrator on 2018/10/17.
 */

public class StringDisplay extends AbstractDisplay {

    public String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public String open() {
        return printLine();
    }

    @Override
    public String print() {
        return "|"+string+"|\n";
    }

    @Override
    public String close() {
        return printLine();
    }

    private String printLine() {
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<width;i++){
            sb.append("*");
        }

        return sb.toString()+"\n";

    }

}
