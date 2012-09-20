import org.junit.Test;
import Bilioteca.MenuList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

public class MenuListTest {
    @Test
    public void shouldGetResponseMessageWhenIInputInvalidSelection() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("15".getBytes());
        MenuList menu = new MenuList(in, out);
        menu.selectMenu(in);
        assertEquals("Select a valid option!!\n", out.toString());
    }
}
