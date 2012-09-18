package Bilioteca;

import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Bilioteca {
    private HashMap<Integer, SimpleAction> menuItems = new LinkedHashMap<Integer, SimpleAction>();
    private final InputStream in;
    private final OutputStream out;
    private MenuList menu = new MenuListener();

    public Bilioteca() {
        this(System.in, System.out);
    }

    public Bilioteca(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        SimpleAction listBookAction = new ListBookAction("Book List");
        SimpleAction reserveBookAction = new ReserveBookAction("Reserve a book");
        SimpleAction checkAction = new CheckAction("Check library number");
        SimpleAction exitAction = new ExitAction("Exit");

        menuItems.put(1, listBookAction);
        menuItems.put(2, reserveBookAction);
        menuItems.put(3, checkAction);
        menuItems.put(9, exitAction);
    }


    private String getMenuString() {
        Iterator it = menuItems.keySet().iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()) {
            Integer k = (Integer) it.next();
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
        if (!menuItems.containsKey(i)) {
            System.err.println("Select a valid option!!");
            return "Select a valid option!!";
        }
        return menuItems.get(i).execute(null, in);
    }

    public Object selectMenu(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String s = reader.readLine();
            return selectMenu(Integer.valueOf(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void service() {
        PrintWriter writer = new PrintWriter(this.out);
        try {
            writer.println(welcome());
            while (true) {
                writer.println("=============Menu==========");
                writer.print(menu());
                writer.flush();
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
                String command = reader.readLine();
                selectMenu(Integer.valueOf(command));
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.flush();
        writer.close();
    }


    public static void main(String[] args) {
        new Bilioteca().service();
    }
}
