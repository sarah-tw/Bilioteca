package bilioteca;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MenuList {

    private HashMap<Integer, Action> menuItems = new LinkedHashMap<Integer, Action>();
    private InputStream in;
    private Session session = new Session();

    public MenuList(InputStream in) {
        this.in = in;
        initMenuItems();
    }

    public Object selectMenu(int i) throws IOException {
        if (!menuItems.containsKey(i)) {
            ConsoleWriter.writer.println("Select a valid option!!");
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
        StringBuilder buffer = new StringBuilder();
        buffer.append("=============Menu==========\n");
        while (it.hasNext()) {
            Integer k = (Integer) it.next();
            buffer.append(k).append(" - ").append(menuItems.get(k).getName()).append("\n");
        }
        return buffer.toString();
    }

    private void initMenuItems() {
        Action listBookAction = new ListBookAction();
        Action reserveBookAction = new ReserveBookAction();
        Action checkAction = new CheckAction();
        Action exitAction = new ExitAction();
        Action movieAction = new MoviesAction();
        Action loginAction = new LoginAction();

        menuItems.put(1, listBookAction);
        menuItems.put(2, reserveBookAction);
        menuItems.put(3, checkAction);
        menuItems.put(4, movieAction);
        menuItems.put(5, loginAction);
        menuItems.put(0, exitAction);
    }


}
