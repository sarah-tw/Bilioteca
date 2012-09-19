import Bilioteca.ListBookAction;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/19/12
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListBookActionTest {
    @Test
    public void shouldGetBookList() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ListBookAction listBookAction = new ListBookAction(out);
        listBookAction.execute(null, null);
        assertEquals("1 - Ruby Programming Language\n" +
                "2 - Test Driven Development\n" +
                "3 - Clean Code\n" +
                "4 - Head First Java\n" +
                "5 - Extreme Programming\n", out.toString());
    }
}
