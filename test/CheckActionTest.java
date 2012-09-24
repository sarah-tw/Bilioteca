import Bilioteca.CheckAction;
import Bilioteca.Session;
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
        checkAction.execute(null, null, session);
        assertEquals("Si Xiaojing, 13012341234, 12#114\n", out.toString());
    }
}
