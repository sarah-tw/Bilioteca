import Bilioteca.LoginAction;
import Bilioteca.Session;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginActionTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Session session = new Session();
    @Test
    public void shouldShowInputLoginMessage() {
        LoginAction login = new LoginAction(out);
        login.printInputLogin();
        assertEquals("Please input username and password\n", out.toString());
    }

    @Test
    public void shouldShowFailedMessageIfLoginIncorrect() throws IOException {
        in = new ByteArrayInputStream("000-0001 10111".getBytes());
        LoginAction login = new LoginAction(out);
        login.login(in, session);
        assertEquals("Wrong user name or password!\n", out.toString());
    }

    @Test
    public void shouldShowSuccessMessageIfLoginCorrect()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111111".getBytes());
        LoginAction login = new LoginAction(out);
        login.login(in, session);
        assertEquals("Login successfully!\n", out.toString());
    }

    @Test
    public void shouldLoginInSession()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111111".getBytes());
        LoginAction login = new LoginAction(out);
        login.execute(null, in, session);
        assertTrue(session.isLoggedIn());
    }

    @Test
    public void shouldLoginFailedIfUsernamePasswordMismatch()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111112".getBytes());
        LoginAction login = new LoginAction(out);
        Session session = new Session();
        login.execute(null, in, session);
        assertFalse(session.isLoggedIn());
    }

}
