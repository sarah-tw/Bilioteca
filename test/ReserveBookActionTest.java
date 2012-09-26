import Bilioteca.ConsoleWriter;
import Bilioteca.ReserveBookAction;
import Bilioteca.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class ReserveBookActionTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }

    @Test
    public void shouldGetInputNumberMessage() {
        ReserveBookAction reserveBookAction = new ReserveBookAction();
        reserveBookAction.printInputNumber();
        assertEquals("Please input the book's number:\n", out.toString());
    }

    @Test
    public void shouldGetLoginRemindWhenRentBookWithoutLogin() {
        ReserveBookAction reserveBookAction = new ReserveBookAction();
        Session session = new Session();
        session.setLoggedIn(false);
        reserveBookAction.execute(null, null, session);
        assertEquals("You should login to reserve book!\n", out.toString());
    }

    @Test
    public void shouldGetSuccessMessageWhenRentBookWithLogin() {
        in = new ByteArrayInputStream("5".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction();
        Session session = new Session();
        session.setLoggedIn(true);
        reserveBookAction.execute(null, in, session);
        assertEquals("Please input the book's number:\n" +
                "Thank You! Enjoy the book.\n", out.toString());
    }

    @Test
    public void shouldGetFailedMessageWhenRentBookSuccess() {
        in = new ByteArrayInputStream("9".getBytes());
        ReserveBookAction reserveBookAction = new ReserveBookAction();
        reserveBookAction.rentBook(in);
        assertEquals("Sorry we don't have that book yet.\n", out.toString());
    }
}
