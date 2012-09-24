package Bilioteca;

import com.sun.deploy.security.SessionCertStore;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MenuList {

    private HashMap<Integer, SimpleAction> menuItems = new LinkedHashMap<Integer, SimpleAction>();
    private InputStream in;
    private OutputStream out;
    private Session session = new Session();

    public MenuList(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        initMenuItems();
    }

    public Object selectMenu(int i) throws IOException {
        PrintWriter writer = new PrintWriter(this.out);
        if (!menuItems.containsKey(i)) {
            writer.println("Select a valid option!!");
            writer.flush();
            return "Select a valid option!!";
        }
        return menuItems.get(i).execute(null, this.in, session);
    }

    public Object selectMenu(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String s = reader.readLine();
            return selectMenu(Integer.parseInt(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMenuString() {
        Iterator it = menuItems.keySet().iterator();
        StringBuffer buffer = new StringBuffer();
        buffer.append("=============Menu==========\n");
        while (it.hasNext()) {
            Integer k = (Integer) it.next();
            buffer.append(k + " - " + menuItems.get(k).getName()).append("\n");
        }
        return buffer.toString();
    }

    private void initMenuItems() {
        SimpleAction listBookAction = new ListBookAction(out);
        SimpleAction reserveBookAction = new ReserveBookAction(out);
        SimpleAction checkAction = new CheckAction(out);
        SimpleAction exitAction = new ExitAction();
        SimpleAction movieAction = new MoviesAction(out);
        SimpleAction loginAction = new LoginAction(out);

        menuItems.put(1, listBookAction);
        menuItems.put(2, reserveBookAction);
        menuItems.put(3, checkAction);
        menuItems.put(4, movieAction);
        menuItems.put(5, loginAction);
        menuItems.put(0, exitAction);
    }


}
