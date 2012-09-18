package Bilioteca;

import java.io.InputStream;
import java.util.*;

public class ListBookAction extends BasicSimpleAction {
    private HashMap<Integer, String> bookList = new LinkedHashMap<Integer, String>();
//    private List<String> bookList = new LinkedList<String>();

    public HashMap<Integer, String> getBookList() {
        return bookList;
    }

    public ListBookAction(String name){
        this.name = name;
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
            System.out.println(k + "-" + bookList.get(k));
        }
        return bookList;
    }
}
