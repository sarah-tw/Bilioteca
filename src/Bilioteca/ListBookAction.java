package Bilioteca;

import java.util.LinkedList;
import java.util.List;

public class ListBookAction extends BasicSimpleAction {
    private List<String> bookList = new LinkedList<String>();

    public ListBookAction(String name){
        this.name = name;

        this.bookList.add("Ruby Programming Language");
        this.bookList.add("Ruby Programming Language");
        this.bookList.add("Ruby Programming Language");
        this.bookList.add("Ruby Programming Language");
        this.bookList.add("Ruby Programming Language");
    }

    public Object execute(Object arg) {
        for(String item : bookList){
            System.err.println(item);
        }
        return bookList;
    }
}
