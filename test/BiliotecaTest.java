import Bilioteca.Bilioteca;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
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
        HashMap books = (HashMap)bilioteca.selectMenu(1);
        assertEquals(5, books.size());
        assertEquals("Ruby Programming Language", books.get(1));
    }

    @Test
    public void shouldBeInformedToGetLibrarianWhenCheckLibraryNumber(){
        Bilioteca bilioteca = new Bilioteca();
        String notice = (String)bilioteca.selectMenu(3);
        assertEquals("Please talk to librarian. Thank you.", notice);
    }

    @Test
    public void shouldTestInput() throws Exception {
        Bilioteca bilioteca = new Bilioteca();
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        String notice = (String)bilioteca.selectMenu(in);
        assertEquals("Please talk to librarian. Thank you.", notice);
    }

    @Test
    public void shouldGetSuccessMessageWhenReserveExistBook(){
        byte[] book = "3".getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(book);
        Bilioteca bilioteca = new Bilioteca(in, null);
        String notice = (String)bilioteca.selectMenu(2);
        assertEquals("Thank you! Enjoy the book", notice);
    }



}
