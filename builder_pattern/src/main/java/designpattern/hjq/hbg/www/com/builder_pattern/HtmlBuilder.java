package designpattern.hjq.hbg.www.com.builder_pattern;

/**
 * Created by Administrator on 2018/10/19.
 *
 */

public class HtmlBuilder extends Builder {

    private StringBuffer writer = new StringBuffer();

    private String fileName;

    @Override
    public void makeTitle(String title) {
        fileName = title+".html";
        writer.append(fileName);

        writer.append("<html><head><title>"+title+"</title></head><body>");
        writer.append("<h1>"+title+"</h1>");

    }

    @Override
    public void makeString(String string) {
        writer.append("<p>"+string+"</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.append("<ul>");
        for (String str:items){
            writer.append("<li>"+str+"</li>");
        }

        writer.append("</ul>");
    }

    @Override
    public Object getResult() {
        writer.append("</body></html>");
        return writer.toString();
    }
}
