import Bilioteca.Bilioteca;
import org.junit.Test;
import Bilioteca.MenuList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/19/12
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuListTest {
    @Test
    public void shouldGetResponseMessageWhenIInputInvalidSelection() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        MenuList menu = new MenuList(in, out);
        menu.selectMenu(in);
        assertEquals("Select a valid option!!\n", out.toString());
    }
}
