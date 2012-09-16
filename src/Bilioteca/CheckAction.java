package Bilioteca;

public class CheckAction extends BasicSimpleAction {
    public CheckAction(String name){
        this.name = name;
    }
    @Override
    public Object execute(Object arg) {
        return "Please talk to librarian. Thank you.";
    }
}
