package Bilioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: sixiaojing
 * Date: 9/15/12
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBookAction extends BasicSimpleAction {
    public ReserveBookAction(String name) {
        this.name = name;
    }

    @Override
    public Object execute(Object arg, InputStream in) {
        System.err.println("Please input the book's number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String command = null;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(bookExist(command)){
            return "Thank you! Enjoy the book";
        }else {
            return "Sorry we don't have that book yet";
        }
    }

    private boolean bookExist(String command) {
        ListBookAction bookList = new ListBookAction("Book List");
        if(bookList.getBookList().containsKey(Integer.parseInt(command))){
            System.out.println("Thank You! Enjoy the book.");
            return true;
        }else {
            System.out.println("Sorry we don't have that book yet.");
            return false;
        }
    }
}
