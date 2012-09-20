package Bilioteca;

import java.io.*;

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
