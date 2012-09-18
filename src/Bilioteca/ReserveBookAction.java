package Bilioteca;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: sixiaojing
 * Date: 9/15/12
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBookAction implements SimpleAction {
    private OutputStream out;

    public ReserveBookAction(OutputStream out) {
        this.out = out;
    }
    public String getName() {
        return "Reserve a book";
    }


    @Override
    public Object execute(Object arg, InputStream in) {
        PrintWriter writer = new PrintWriter(this.out);
        writer.println("Please input the book's number:");
        writer.flush();
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
        ListBookAction bookList = new ListBookAction();
        if(bookList.getBookList().containsKey(Integer.parseInt(command))){
            System.out.println("Thank You! Enjoy the book.");
            return true;
        }else {
            System.out.println("Sorry we don't have that book yet.");
            return false;
        }
    }
}
