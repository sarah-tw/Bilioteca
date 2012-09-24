package Bilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MoviesAction implements SimpleAction{
    private OutputStream out;
    public MoviesAction(OutputStream out) {
         this.out = out;
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        PrintWriter writer = new PrintWriter(this.out);
        writer.println("Movie Year    Director    Rating");
        writer.println("Sholay 1975   Ramesh  Sippy   N/A");
        writer.println("Spide-Man3 2012    Marc Webb   1");
        writer.flush();
        return "helo";
    }

    @Override
    public String getName() {
        return "Movies List";
    }
}
