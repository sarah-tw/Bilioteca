package Bilioteca;

import java.io.InputStream;

public class CheckAction implements Action {
    public String getName() {
        return "Check library number";
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        if(!session.isLoggedIn()){
            ConsoleWriter.writer.println("Please talk to librarian. Thank you.");
        }else {
            ConsoleWriter.writer.println(session.getDetail());
        }

        return null;
    }
}
