import bilioteca.ConsoleWriter;
import bilioteca.ListBookAction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class ListBookActionTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }
    @Test
    public void shouldGetBookList() {
        ListBookAction listBookAction = new ListBookAction();
        listBookAction.execute(null, null, null);
        assertEquals("1 - Ruby Programming Language\n" +
                "2 - Test Driven Development\n" +
                "3 - Clean Code\n" +
                "4 - Head First Java\n" +
                "5 - Extreme Programming\n", out.toString());
    }
}
