import Bilioteca.CheckAction;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class CheckActionTest {
    @Test
    public void shouldGetCheckMessageWhenIWantMyLibraryNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CheckAction checkAction = new CheckAction(out);
        checkAction.execute(null, null);
        assertEquals("Please talk to librarian. Thank you.\n", out.toString());
    }
}
