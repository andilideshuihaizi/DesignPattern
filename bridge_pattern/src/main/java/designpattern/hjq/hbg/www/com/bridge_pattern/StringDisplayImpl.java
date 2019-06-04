package designpattern.hjq.hbg.www.com.bridge_pattern;

/**
 * Created by Administrator on 2018/10/22.
 */

public class StringDisplayImpl extends DisplayImpl {

    private String string;

    public StringDisplayImpl(String string) {
        this.string = string;
    }

    @Override
    public String rawOpen() {
        return printLine();
    }

    @Override
    public String rawPrint() {
        return "|"+string+"|";
    }

    @Override
    public String rawClose() {
        return printLine();
    }

    private String printLine() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("+");
        for (int i=0;i<string.length();i++){
            buffer.append("-");
        }
        buffer.append("+"+"\n");

        return buffer.toString();
    }

}
