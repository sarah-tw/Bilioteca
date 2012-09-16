import Bilioteca.Bilioteca;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BiliotecaTest {
    @Test
    public void shouldGetWelcomeMessage() {
        Bilioteca bilioteca = new Bilioteca();
        assertEquals("Welcome to Bilioceta", bilioteca.welcome());
    }

    @Test
    public void shouldShowMenuList() {
        Bilioteca bilioteca = new Bilioteca();
        assertEquals("1 - Book List\n" +
                "2 - Reserve a book\n" +
                "3 - Check library number\n" +
                "9 - Exit\n", bilioteca.menu());
    }

    @Test
    public void shouldGetResponseWhenIInputInvalidSelection() {
        Bilioteca bilioteca = new Bilioteca();
        assertEquals("Select a valid option!!", bilioteca.selectMenu(5));
    }

    @Test
    public void shouldViewAllBooksInLibrary(){
        Bilioteca bilioteca = new Bilioteca();
        List books = (List)bilioteca.selectMenu(1);
        assertEquals(5, books.size());
        assertEquals("2 - Test Driven Development", books.get(1));
    }

    @Test
    public void shouldBeInformedToGetLibrarianWhenCheckLibraryNumber(){
        Bilioteca bilioteca = new Bilioteca();
        String notice = (String)bilioteca.selectMenu(3);
        assertEquals("Please talk to librarian. Thank you.", notice);
    }
}
