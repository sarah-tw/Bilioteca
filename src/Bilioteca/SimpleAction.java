package Bilioteca;

import java.io.InputStream;

public interface SimpleAction {
    public Object execute(Object arg, InputStream in);
    public String getName();
}