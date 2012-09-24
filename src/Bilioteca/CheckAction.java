package Bilioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CheckAction implements SimpleAction {
    private OutputStream out;
    public String getName() {
        return "Check library number";
    }

    public CheckAction(OutputStream out) {
        this.out = out;
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) {
        PrintWriter writer = new PrintWriter(this.out);
        if(!session.isLoggedIn()){
            writer.println("Please talk to librarian. Thank you.");
            writer.flush();
        }else {
            writer.println(session.getDetail());
            writer.flush();
        }

        return null;
    }
}
