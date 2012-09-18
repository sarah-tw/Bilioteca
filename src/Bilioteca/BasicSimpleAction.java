package Bilioteca;

import java.io.InputStream;

public abstract class BasicSimpleAction implements SimpleAction{
    protected String name;

    public abstract Object execute(Object arg, InputStream in);

    public String getName(){
        return name;
    }
}