package Bilioteca;

import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Bilioteca {
    private final InputStream in;
    private MenuList menu;

    public Bilioteca() {
        this(System.in);
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
            while (true) {
                printMenu();
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
                String command = reader.readLine();
                menu.selectMenu(Integer.valueOf(command));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Bilioteca().service();
    }
}
