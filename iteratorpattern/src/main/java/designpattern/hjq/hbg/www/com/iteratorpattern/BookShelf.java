package designpattern.hjq.hbg.www.com.iteratorpattern;

/**
 * Created by Administrator on 2018/10/16.
 *
 *
 * 表示书架意图的类
 * 要实现Aggreagate接口 才能把这个类当作聚合来处理。
 */

public class BookShelf implements Aggregate {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public BookShelf appendBook(Book book){
        this.books[last] = book;
        last++;

        return this;
    }

    public int getLength(){
        return this.last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
