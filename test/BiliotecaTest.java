import Bilioteca.Bilioteca;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    public void shouldShowMenuListWhenSelect1() {
        Bilioteca bilioteca = new Bilioteca();
        assertEquals("1 - Book List\n" +
                "2 - Reserve a book\n" +
                "3 - Check library number\n" +
                "0 - Exit\n", bilioteca.getMenu().getMenuString());
    }

    @Test
    public void shouldGetResponseWhenIInputInvalidSelection() {
        Bilioteca bilioteca = new Bilioteca();
        assertEquals("Select a valid option!!", bilioteca.getMenu().selectMenu(5));
    }

    @Test
    public void shouldViewAllBooksInLibraryWhenSelect1(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bilioteca bilioteca = new Bilioteca();
        HashMap books = (HashMap)bilioteca.getMenu().selectMenu(in);
        assertEquals(5, books.size());
        assertEquals("Ruby Programming Language", books.get(1));
    }

    @Test
    public void shouldBeInformedToGetLibrarianWhenCheckLibraryNumber(){
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bilioteca bilioteca = new Bilioteca();
        String notice = (String)bilioteca.getMenu().selectMenu(in);
        assertEquals("Please talk to librarian. Thank you.", notice);
    }

    @Test
    public void shouldGetSuccessMessageWhenReserveExistBook(){
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bilioteca bilioteca = new Bilioteca(in, out);
        System.out.print(bilioteca.getMenu().getMenuString());
        String notice = (String)bilioteca.getMenu().selectMenu(2);
        assertEquals("Thank you! Enjoy the book", notice);
    }


}
