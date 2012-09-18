package Bilioteca;

import java.io.InputStream;

public class ExitAction extends BasicSimpleAction {
    public ExitAction(String name){
        this.name = name;
    }

    @Override
    public Object execute(Object arg, InputStream in) {
        System.exit(0);
        return null;
    }
}
