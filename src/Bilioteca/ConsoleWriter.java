package bilioteca;

import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleWriter {
    private PrintStream stream;

    private ConsoleWriter(PrintStream stream) {
        this.stream = stream;
    }

    public void setStream(OutputStream os) {
        this.stream = new PrintStream(os);
    }

    public static final ConsoleWriter writer = new ConsoleWriter(System.out);

    public void println(String string){
        stream.println(string);
    }

    public void print(String string) {
        stream.print(string);
    }
}
