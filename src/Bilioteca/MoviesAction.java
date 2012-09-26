package Bilioteca;

import java.io.InputStream;

public class MoviesAction implements Action {
    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        ConsoleWriter.writer.println("Movie Year    Director    Rating");
        ConsoleWriter.writer.println("Sholay 1975   Ramesh  Sippy   N/A");
        ConsoleWriter.writer.println("Spide-Man3 2012    Marc Webb   1");
        return null;
    }

    @Override
    public String getName() {
        return "Movies List";
    }
}
