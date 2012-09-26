package Bilioteca;

import java.io.*;

public class ReserveBookAction implements Action {
    public String getName() {
        return "Reserve a book";
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        if(session.isLoggedIn()){
            printInputNumber();
            return rentBook(in);
        }else {
            ConsoleWriter.writer.println("You should login to reserve book!");
        }
        return null;

    }

    public Object rentBook(InputStream in) {
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

    public void printInputNumber() {
        ConsoleWriter.writer.println("Please input the book's number:");
    }

    private boolean bookExist(String command) {
        ListBookAction bookList = new ListBookAction();
        if(bookList.getBookList().containsKey(Integer.parseInt(command))){
            ConsoleWriter.writer.println("Thank You! Enjoy the book.");
            return true;
        }else {
            ConsoleWriter.writer.println("Sorry we don't have that book yet.");
            return false;
        }

    }
}
