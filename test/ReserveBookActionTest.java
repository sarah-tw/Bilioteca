import Bilioteca.ReserveBookAction;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class ReserveBookActionTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void shouldGetInputNumberMessage() {
        ReserveBookAction reserveBookAction = new ReserveBookAction(out);
        reserveBookAction.printInputNumber();
        assertEquals("Please input the book's number:\n", out.toString());
    }

    @Test
    public void shouldGetSuccessMessageWhenRentBookSuccess() {
        in = new ByteArrayInputStream("5".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction(out);
        reserveBookAction.rentBook(in);
        assertEquals("Thank You! Enjoy the book.\n", out.toString());
    }

    @Test
    public void shouldGetFailedMessageWhenRentBookSuccess() {
        in = new ByteArrayInputStream("9".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction(out);
        reserveBookAction.rentBook(in);
        assertEquals("Sorry we don't have that book yet.\n", out.toString());
    }
}
