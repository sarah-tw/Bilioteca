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
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String BOOKLIST = "1";
    private String RESERVE = "2";
    private String CHECK = "3";
    private String MOVIES = "4";
    private String INVALID = "5";
    private String EXIT = "0";

    @Test
    public void shouldGetWelcomeMessage() {
        Bilioteca bilioteca = new Bilioteca(null, out);
        bilioteca.welcome();
        assertEquals("Welcome to Bilioceta\n", out.toString());
    }

    @Test
    public void shouldShowMenuList() {
        Bilioteca bilioteca = new Bilioteca(null, out);
        bilioteca.printMenu();
        assertEquals("=============Menu==========\n" +
                "1 - Book List\n" +
                "2 - Reserve a book\n" +
                "3 - Check library number\n" +
                "4 - Movies List\n" +
                "0 - Exit\n", out.toString());
    }

    @Test
    public void shouldGetResponseWhenIInputInvalidSelection() {
        in = new ByteArrayInputStream(INVALID.getBytes());
        Bilioteca bilioteca = new Bilioteca(in, out);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Select a valid option!!\n", out.toString());
    }

    @Test
    public void shouldViewAllBooksInLibraryWhenSelect1(){
        in = new ByteArrayInputStream(BOOKLIST.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bilioteca bilioteca = new Bilioteca(null, out);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("1 - Ruby Programming Language\n" +
                "2 - Test Driven Development\n" +
                "3 - Clean Code\n" +
                "4 - Head First Java\n" +
                "5 - Extreme Programming\n", out.toString());
    }

    @Test
    public void shouldBeInformedToGetLibrarianWhenCheckLibraryNumber(){
        in = new ByteArrayInputStream(CHECK.getBytes());
        Bilioteca bilioteca = new Bilioteca(null, out);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Please talk to librarian. Thank you.\n", out.toString());
    }

    @Test
    public void shouldGetSuccessMessageWhenReserveExistBook(){
        in = new ByteArrayInputStream(RESERVE.getBytes());
        Bilioteca bilioteca = new Bilioteca(in, out);
        bilioteca.getMenu().selectMenu(2);
        assertEquals("Please input the book's number:\n" +
                "Thank You! Enjoy the book.\n", out.toString());
    }

    @Test
    public void shouldGetMoviesListWhenInput4(){
        in = new ByteArrayInputStream(MOVIES.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bilioteca bilioteca = new Bilioteca(null, out);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Movie Year    Director    Rating\n" +
                "Sholay 1975   Ramesh  Sippy   N/A\n" +
                "Spide-Man3 2012    Marc Webb   1\n", out.toString());
    }


}
