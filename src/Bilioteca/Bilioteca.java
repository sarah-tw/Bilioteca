package bilioteca;

import java.io.*;

public class Bilioteca {
    private final InputStream in;
    private MenuList menu;
    private boolean running = true;

    public Bilioteca() {
        this(System.in);
    }

    public boolean isRunning() {
        return running;
    }

    public Bilioteca(InputStream in) {
        this.in = in;
        this.menu = new MenuList(this.in);
    }

    public MenuList getMenu() {
        return menu;
    }

    public void printMenu() {
        ConsoleWriter.writer.print(menu.getMenuString());
    }

    public void welcome() {
        ConsoleWriter.writer.println("Welcome to Bilioceta");
    }


    public void service() {
        try {
            welcome();
            while (running) {
                printMenu();
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
                String command = reader.readLine();
                if(Boolean.FALSE.equals(menu.selectMenu(Integer.valueOf(command)))){
                    running = false;
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Bilioteca().service();
    }
}
