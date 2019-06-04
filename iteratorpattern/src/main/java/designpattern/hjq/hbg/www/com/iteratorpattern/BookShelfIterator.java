package designpattern.hjq.hbg.www.com.iteratorpattern;


/**
 * Created by Administrator on 2018/10/16.
 *
 *  执行扫描书架用的“聚合”类
 */

class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    private int index;


    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf= bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index<bookShelf.getLength())
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;

        return book;
    }
}
