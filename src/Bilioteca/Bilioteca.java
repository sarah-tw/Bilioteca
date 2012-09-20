package Bilioteca;

import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Bilioteca {
    private final InputStream in;
    private final OutputStream out;
    private PrintWriter writer;

    private MenuList menu;

    public Bilioteca() {
        this(System.in, System.out);
    }


    public Bilioteca(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        this.writer = new PrintWriter(out);
        this.menu = new MenuList(this.in, this.out);
    }

    public MenuList getMenu() {
        return menu;
    }

    public void printMenu() {
        writer.print(menu.getMenuString());
        writer.flush();
    }

    public void welcome() {
        writer.println("Welcome to Bilioceta");
        writer.flush();
    }


    public void service() {
        try {
            welcome();
            while (true) {
                printMenu();
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
                String command = reader.readLine();
                menu.selectMenu(Integer.valueOf(command));
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();
    }


    public static void main(String[] args) {
        new Bilioteca().service();
    }
}
