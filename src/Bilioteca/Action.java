package Bilioteca;

import java.io.IOException;
import java.io.InputStream;

public interface Action {
    public String getName();

    Object execute(Object arg, InputStream in, Session session) throws IOException;
}