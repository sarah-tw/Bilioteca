import Bilioteca.LoginAction;
import Bilioteca.MoviesAction;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginActionTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
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
        login.login(in);
        assertEquals("Wrong user name or password!\n", out.toString());
    }

    @Test
    public void shouldShowSuccessMessageIfLoginCorrect()  throws IOException {
        in = new ByteArrayInputStream("000-0001 111111".getBytes());
        LoginAction login = new LoginAction(out);
        login.login(in);
        assertEquals("Login successfully!\n", out.toString());
    }
}
