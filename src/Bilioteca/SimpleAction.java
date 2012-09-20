package Bilioteca;

import java.io.IOException;
import java.io.InputStream;

public interface SimpleAction {
    public Object execute(Object arg, InputStream in) throws IOException;
    public String getName();
}