package Bilioteca;

public abstract class BasicSimpleAction implements SimpleAction{
    protected String name;

    public abstract Object execute(Object arg);

    public String getName(){
        return name;
    }
}