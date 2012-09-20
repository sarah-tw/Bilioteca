package Bilioteca;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/20/12
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction implements SimpleAction {
    private ArrayList<String> loginList = new ArrayList<String>();
    private OutputStream out;
    private PrintWriter writer;

    public LoginAction(OutputStream out) {
        this.out = out;
        this.writer = new PrintWriter(out);
        loginList.add("000-0001 111111");
        loginList.add("000-0002 222222");
        loginList.add("000-0003 333333");
        loginList.add("000-0004 444444");
    }

    @Override
    public Object execute(Object arg, InputStream in) throws IOException {
        printInputLogin();
        login(in);
        return null;
    }

    @Override
    public String getName() {
        return "Login";
    }
    public void printInputLogin() {
        writer.println("Please input username and password");
        writer.flush();
    }

    public void login(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String command = reader.readLine();
        if (!loginList.contains(command)) {
            writer.println("Wrong user name or password!");
            writer.flush();
        } else {
            writer.println("Login successfully!");
            writer.flush();
        }

    }
}
