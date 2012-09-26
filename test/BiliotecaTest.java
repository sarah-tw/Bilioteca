import Bilioteca.Bilioteca;
import Bilioteca.ConsoleWriter;
import Bilioteca.Session;
import Bilioteca.LoginAction;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BiliotecaTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String BOOKLIST = "1";
    private String RESERVE_IO = "2";
    private String CHECK = "3";
    private String MOVIES = "4";
    private String INVALID = "15";
    private String VALIDE_USER = "000-0001 111111";
    private String IN_VALIDE_USER = "000-0001 121212";
    private Integer LOGIN = 5;
    private Integer RESERVE = 2;
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
        assertEquals("Please input username and password\n" +
                "Login successfully!\n", out.toString());
    }

    @Test
    public void shouldGetFailedMessageWhenLoginWithInValidUser() throws IOException {
        in = new ByteArrayInputStream(IN_VALIDE_USER.getBytes());
        Bilioteca bilioteca = new Bilioteca(in);
        bilioteca.getMenu().selectMenu(LOGIN);
        assertEquals("Please input username and password\n" +
                "Wrong user name or password!\n", out.toString());
    }



}
