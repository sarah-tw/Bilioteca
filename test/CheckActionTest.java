import Bilioteca.CheckAction;
import Bilioteca.Session;
import Bilioteca.User;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class CheckActionTest {
    @Test
    public void shouldGetCheckMessageWhenIWantMyLibraryNumber() {
        Session session = new Session();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CheckAction checkAction = new CheckAction(out);
        checkAction.execute(null, null, session);
        assertEquals("Please talk to librarian. Thank you.\n", out.toString());
    }

    @Test
    public void shouldGetDetailedInfoWhenICheckMyLibraryNumberWithLogin() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CheckAction checkAction = new CheckAction(out);
        Session session = new Session();
        session.setLoggedIn(true);
        User user = new User("000-0001", "111111", "ZhangSan", "12#112", "13012341234");
        session.setDetail(user);
        checkAction.execute(null, null, session);
        assertEquals("ZhangSan 12#112 13012341234\n", out.toString());
    }
}
