package Bilioteca;

import java.io.*;

public class ReserveBookAction implements SimpleAction {
    private OutputStream out;
    private PrintWriter writer;

    public ReserveBookAction(OutputStream out) {
        this.out = out;
        writer = new PrintWriter(out);
    }
    public String getName() {
        return "Reserve a book";
    }


    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        printInputNumber();
        if(session.isLoggedIn()){
            return rentBook(in);
        }else {
            writer.println("You should login to reserve book!");
            writer.flush();
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
        writer.println("Please input the book's number:");
        writer.flush();
    }

    private boolean bookExist(String command) {
        PrintWriter writer = new PrintWriter(this.out);
        ListBookAction bookList = new ListBookAction(this.out);
        if(bookList.getBookList().containsKey(Integer.parseInt(command))){
            writer.println("Thank You! Enjoy the book.");
            writer.flush();
            return true;
        }else {
            writer.println("Sorry we don't have that book yet.");
            writer.flush();
            return false;
        }

    }
}
