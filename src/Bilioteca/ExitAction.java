package Bilioteca;

public class ExitAction extends BasicSimpleAction {
    public ExitAction(String name){
        this.name = name;
    }

    @Override
    public Object execute(Object arg) {
        System.exit(0);
        return null;
    }
}
