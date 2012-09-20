package test;

import Bilioteca.MoviesAction;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoviesActionTest {
    @Test
    public void shouldShowMoviesList() {
        ByteOutputStream out = new ByteOutputStream();
        MoviesAction movies = new MoviesAction(out);
        movies.execute(null, null);
        assertEquals("Movie Year    Director    Rating\n" +
                "Sholay 1975   Ramesh  Sippy   N/A\n" +
                "Spide-Man3 2012    Marc Webb   1\n", out.toString());
    }


}
