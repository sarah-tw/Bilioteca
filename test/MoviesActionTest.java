package test;

import Bilioteca.ConsoleWriter;
import Bilioteca.MoviesAction;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class MoviesActionTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }
    @Test
    public void shouldShowMoviesList() {
        MoviesAction movies = new MoviesAction();
        movies.execute(null, null, null);
        assertEquals("Movie Year    Director    Rating\n" +
                "Sholay 1975   Ramesh  Sippy   N/A\n" +
                "Spide-Man3 2012    Marc Webb   1\n", out.toString());
    }


}
