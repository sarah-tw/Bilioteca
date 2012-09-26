import bilioteca.Bilioteca;
import bilioteca.ConsoleWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

public class BiliotecaTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String EXIT = "0";
    private static final String BOOKLIST = "1";
    private static final String CHECK = "3";
    private static final String MOVIES = "4";
    private static final String INVALID = "15";
    private static final String VALIDE_USER = "000-0001 111111";
    private static final String IN_VALIDE_USER = "000-0001 121212";
    private static final Integer LOGIN = 5;
    @Before
    public void set(){
        ConsoleWriter.writer.setStream(out);
    }

    @Test
    public void shouldGetWelcomeMessage() {
        Bilioteca bilioteca = new Bilioteca(null);
        bilioteca.welcome();
        assertEquals("Welcome to Bilioceta\n", out.toString());
    }

    @Test
    public void shouldShowMenuList() {
        Bilioteca bilioteca = new Bilioteca(null);
        bilioteca.printMenu();
        assertEquals("=============Menu==========\n" +
                "1 - Book List\n" +
                "2 - Reserve a book\n" +
                "3 - Check library number\n" +
                "4 - Movies List\n" +
                "5 - Login\n" +
                "0 - Exit\n", out.toString());
    }

    @Test
    public void shouldGetResponseWhenIInputInvalidSelection() {
        in = new ByteArrayInputStream(INVALID.getBytes());
        Bilioteca bilioteca = new Bilioteca(in);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Select a valid option!!\n", out.toString());
    }

    @Test
    public void shouldViewAllBooksInLibraryWhenSelect1(){
        in = new ByteArrayInputStream(BOOKLIST.getBytes());
        Bilioteca bilioteca = new Bilioteca(null);
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
        Bilioteca bilioteca = new Bilioteca(null);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Please talk to librarian. Thank you.\n", out.toString());
    }


    @Test
    public void shouldGetMoviesListWhenInput4(){
        in = new ByteArrayInputStream(MOVIES.getBytes());
        Bilioteca bilioteca = new Bilioteca(null);
        bilioteca.getMenu().selectMenu(in);
        assertEquals("Movie Year    Director    Rating\n" +
                "Sholay 1975   Ramesh  Sippy   N/A\n" +
                "Spide-Man3 2012    Marc Webb   1\n", out.toString());
    }

    @Test
    public void shouldGetSuccessMessageWhenLoginWithValidUser() throws IOException {
        in = new ByteArrayInputStream(VALIDE_USER.getBytes());
        Bilioteca bilioteca = new Bilioteca(in);
        bilioteca.getMenu().selectMenu(LOGIN);
        assertEquals("Please input username and password separate by one space: \n" +
                "Login successfully!\n", out.toString());
    }

    @Test
    public void shouldGetFailedMessageWhenLoginWithInValidUser() throws IOException {
        in = new ByteArrayInputStream(IN_VALIDE_USER.getBytes());
        Bilioteca bilioteca = new Bilioteca(in);
        bilioteca.getMenu().selectMenu(LOGIN);
        assertEquals("Please input username and password separate by one space: \n" +
                "Wrong user name or password!\n", out.toString());
    }


    @Test
    public void shouldGetExitWhenInput0() throws IOException {
        in = new ByteArrayInputStream(EXIT.getBytes());
        Bilioteca bilioteca = new Bilioteca(in);
        bilioteca.service();
        assertEquals(false, bilioteca.isRunning());
    }



}
