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
    private MenuList menu;


    public Bilioteca() {
        this(System.in, System.out);
    }

    public Bilioteca(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        this.menu = new MenuList(this.in, this.out);
    }

    public MenuList getMenu() {
        return menu;
    }

    public String welcome() {
        return "Welcome to Bilioceta";
    }


    public void service() {
        PrintWriter writer = new PrintWriter(this.out);
        try {
            writer.println(welcome());
            while (true) {
                writer.println("=============Menu==========");
                writer.print(menu.getMenuString());
                writer.flush();
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
                String command = reader.readLine();
                menu.selectMenu(Integer.valueOf(command));
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
