import bilioteca.ConsoleWriter;
import bilioteca.LoginAction;
import bilioteca.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginActionTest {
    private ByteArrayInputStream in;
    private Session session = new Session();
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }
    @Test
    public void shouldShowInputLoginMessage() {
        LoginAction login = new LoginAction();
        login.printInputLogin();
        assertEquals("Please input username and password separate by one space: \n", out.toString());
    }

    @Test
    public void shouldShowFailedMessageIfLoginIncorrect() throws IOException {
        in = new ByteArrayInputStream("000-0001 10111".getBytes());
        LoginAction login = new LoginAction();
        login.login(in, session);
        assertEquals("Wrong user name or password!\n", out.toString());
    }

    @Test
    public void shouldShowSuccessMessageIfLoginCorrect()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111111".getBytes());
        LoginAction login = new LoginAction();
        login.login(in, session);
        assertEquals("Login successfully!\n", out.toString());
    }

    @Test
    public void shouldLoginInSession()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111111".getBytes());
        LoginAction login = new LoginAction();
        login.execute(null, in, session);
        assertTrue(session.isLoggedIn());
    }

    @Test
    public void shouldLoginFailedIfUsernamePasswordMismatch()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111112".getBytes());
        LoginAction login = new LoginAction();
        Session session = new Session();
        login.execute(null, in, session);
        assertFalse(session.isLoggedIn());
    }

}
