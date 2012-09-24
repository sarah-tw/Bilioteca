import Bilioteca.ListBookAction;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class ListBookActionTest {
    @Test
    public void shouldGetBookList() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ListBookAction listBookAction = new ListBookAction(out);
        listBookAction.execute(null, null, null);
        assertEquals("1 - Ruby Programming Language\n" +
                "2 - Test Driven Development\n" +
                "3 - Clean Code\n" +
                "4 - Head First Java\n" +
                "5 - Extreme Programming\n", out.toString());
    }
}
