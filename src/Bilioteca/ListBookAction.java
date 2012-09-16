package Bilioteca;

import java.util.LinkedList;
import java.util.List;

public class ListBookAction extends BasicSimpleAction {
    private List<String> bookList = new LinkedList<String>();

    public ListBookAction(String name){
        this.name = name;

        this.bookList.add("1 - Ruby Programming Language");
        this.bookList.add("2 - Test Driven Development");
        this.bookList.add("3 - Clean Code");
        this.bookList.add("4 - Head First Java");
        this.bookList.add("5 - Extreme Programming");
    }

    public Object execute(Object arg) {
        for(String item : bookList){
            System.err.println(item);
        }
        return bookList;
    }
}
