package Bilioteca;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MenuList {

    private HashMap<Integer, SimpleAction> menuItems = new LinkedHashMap<Integer, SimpleAction>();
    private InputStream in;
    private OutputStream out;

    public MenuList(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        initMenuItems();
    }

    public Object selectMenu(int i) {
        PrintWriter writer = new PrintWriter(this.out);
        if (!menuItems.containsKey(i)) {
            writer.println("Select a valid option!!");
            writer.flush();
            return "Select a valid option!!";
        }
        return menuItems.get(i).execute(null, this.in);
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

    public String getMenuString() {
        Iterator it = menuItems.keySet().iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()) {
            Integer k = (Integer) it.next();
            buffer.append(k + " - " + menuItems.get(k).getName()).append("\n");
        }
        return buffer.toString();
    }

    private void initMenuItems() {
        SimpleAction listBookAction = new ListBookAction();
        SimpleAction reserveBookAction = new ReserveBookAction(out);
        SimpleAction checkAction = new CheckAction(out);
        SimpleAction exitAction = new ExitAction();

        menuItems.put(1, listBookAction);
        menuItems.put(2, reserveBookAction);
        menuItems.put(3, checkAction);
        menuItems.put(0, exitAction);
    }


}
