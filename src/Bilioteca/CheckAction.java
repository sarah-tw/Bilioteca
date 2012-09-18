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
    public Object execute(Object arg, InputStream in) {
        PrintWriter writer = new PrintWriter(this.out);
        writer.println("Please talk to librarian. Thank you.");
        writer.flush();
        return "Please talk to librarian. Thank you.";
    }
}
