package designpattern.hjq.hbg.www.com.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import designpattern.hjq.hbg.www.com.iteratorpattern.Book;
import designpattern.hjq.hbg.www.com.iteratorpattern.BookShelf;
import designpattern.hjq.hbg.www.com.iteratorpattern.Iterator;


/**
 * Created by Administrator on 2018/10/17.
 *
 *迭代器
 */

public class IteratorPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iterator_pattern);

        EditText et=(EditText)findViewById(R.id.EditText01);

        BookShelf bookShelf=new BookShelf(5);

        bookShelf.appendBook(new Book("android developer"))
                .appendBook(new Book("Windows Phone 7 developer"))
                .appendBook(new Book("IOS developer"))
                .appendBook(new Book("BADA developer"))
                .appendBook(new Book("Lion developer"));

        bookShelf.getBookAt(2);

        Iterator iterator=bookShelf.iterator();
        while(iterator.hasNext()){
            Book book=(Book)iterator.next();
            et.setText(et.getText()+"\n"+book.getName());
        }

    }
}
