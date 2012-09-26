import bilioteca.CheckAction;
import bilioteca.ConsoleWriter;
import bilioteca.Session;
import bilioteca.User;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class CheckActionTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }
    @Test
    public void shouldGetCheckMessageWhenIWantMyLibraryNumber() {
        Session session = new Session();
        CheckAction checkAction = new CheckAction();
        checkAction.execute(null, null, session);
        assertEquals("Please talk to librarian. Thank you.\n", out.toString());
    }

    @Test
    public void shouldGetDetailedInfoWhenICheckMyLibraryNumberWithLogin() {
        CheckAction checkAction = new CheckAction();
        Session session = new Session();
        session.setLoggedIn(true);
        User user = new User("000-0001", "111111", "ZhangSan", "12#112", "13012341234");
        session.setDetail(user);
        checkAction.execute(null, null, session);
        assertEquals("ZhangSan 12#112 13012341234\n", out.toString());
    }
}
