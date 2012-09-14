package Bilioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Bilioteca {
    private HashMap<Integer, SimpleAction> menuItems = new LinkedHashMap<Integer, SimpleAction>();

    public Bilioteca() {
        SimpleAction listBookAction = new ListBookAction("Book List");
        SimpleAction reserveBookAction = new ReserveBookAction("Reserve a book");
        SimpleAction checkAction = new CheckAction("Check library number");
        SimpleAction exitAction = new ExitAction("Exit");

        menuItems.put(1, listBookAction);
        menuItems.put(2, reserveBookAction);
        menuItems.put(3, checkAction);
        menuItems.put(9, exitAction);
    }

    private String getMenuString(){
        Iterator it = menuItems.keySet().iterator();
        StringBuffer buffer = new StringBuffer();
        while(it.hasNext()){
            Integer k = (Integer)it.next();
            buffer.append(k + " - " + menuItems.get(k).getName()).append("\n");
        }
        return buffer.toString();
    }

    public String menu() {
        return getMenuString();
    }

    public String welcome() {
        return "Welcome to Bilioceta";
    }

    public Object selectMenu(int i) {
        if(!menuItems.containsKey(i)){
            return "Select a valid option!!";
        }
        return menuItems.get(i).execute(null);
    }

    public static void main(String[] args) {
        Bilioteca bilioteca = new Bilioteca();
        bilioteca.welcome();
        while(true){
            System.err.print(bilioteca.menu());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String command = reader.readLine();
                bilioteca.selectMenu(Integer.valueOf(command));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
