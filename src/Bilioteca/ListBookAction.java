package Bilioteca;

import java.io.InputStream;
import java.util.*;

public class ListBookAction implements SimpleAction {
    private HashMap<Integer, String> bookList = new LinkedHashMap<Integer, String>();
    public HashMap<Integer, String> getBookList() {
        return bookList;
    }

    public String getName() {
        return "Book List";
    }

    public ListBookAction(){
        this.bookList.put(1, "Ruby Programming Language");
        this.bookList.put(2, "Test Driven Development");
        this.bookList.put(3, "Clean Code");
        this.bookList.put(4, "Head First Java");
        this.bookList.put(5, "Extreme Programming");
    }

    public Object execute(Object arg, InputStream in) {
        Iterator it = bookList.keySet().iterator();
        while (it.hasNext()) {
            Integer k = (Integer) it.next();
            System.out.println(k + " - " + bookList.get(k));
        }
        return bookList;
    }
}
