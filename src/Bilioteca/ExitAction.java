package Bilioteca;

import java.io.InputStream;

public class ExitAction implements SimpleAction {
    public String getName() {
        return "Exit";
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        System.exit(0);
        return null;
    }

}
