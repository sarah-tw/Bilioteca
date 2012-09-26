import Bilioteca.ConsoleWriter;
import org.junit.Before;
import org.junit.Test;
import Bilioteca.MenuList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class MenuListTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void initWriter(){
        ConsoleWriter.writer.setStream(out);
    }
    @Test
    public void shouldGetResponseMessageWhenIInputInvalidSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream("15".getBytes());
        MenuList menu = new MenuList(in);
        menu.selectMenu(in);
        assertEquals("Select a valid option!!\n", out.toString());
    }
}
