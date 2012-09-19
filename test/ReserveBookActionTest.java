import Bilioteca.ReserveBookAction;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/19/12
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBookActionTest {
    @Test
    public void shouldGetSuccessMessageWhenRentBookSuccess() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction(out);
        reserveBookAction.execute(null, in);
        assertEquals("Please input the book's number:\nThank You! Enjoy the book.\n", out.toString());
    }

    @Test
    public void shouldGetFailedMessageWhenRentBookSuccess() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("9".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction(out);
        reserveBookAction.execute(null, in);
        assertEquals("Please input the book's number:\nSorry we don't have that book yet.\n", out.toString());
    }
}
