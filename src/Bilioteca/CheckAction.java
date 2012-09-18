package Bilioteca;

import java.io.InputStream;

public class CheckAction extends BasicSimpleAction {
    public CheckAction(String name){
        this.name = name;
    }
    @Override
    public Object execute(Object arg, InputStream in) {
        System.err.println("Please talk to librarian. Thank you.");
        return "Please talk to librarian. Thank you.";
    }
}
