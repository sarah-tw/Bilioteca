package Bilioteca;

import java.io.*;
import java.util.ArrayList;


public class LoginAction implements SimpleAction {
    private ArrayList<String> loginList = new ArrayList<String>();
    private OutputStream out;
    private PrintWriter writer;
    private ArrayList<User> users = new ArrayList<User>();

    public LoginAction(OutputStream out) {
        this.out = out;
        this.writer = new PrintWriter(out);
        initialUserList();
    }

    @Override
    public Object execute(Object arg, InputStream in, Session session) throws IOException {
        printInputLogin();
        login(in, session);
        return null;
    }

    @Override
    public String getName() {
        return "Login";
    }
    public void printInputLogin() {
        writer.println("Please input username and password");
        writer.flush();
    }

    public void login(InputStream in, Session session) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String command = reader.readLine();
        if(loginSuccess(command, session)){
            writer.println("Login successfully!");
            writer.flush();
        }else {
            session.setLoggedIn(false);
            writer.println("Wrong user name or password!");
            writer.flush();
        }
    }

    private boolean loginSuccess(String username, Session session) {
        for(User user : users){
            if(user.isValidUser(username)){
                session.setLoggedIn(true);
                session.setDetail(user);
                return true;
            }
        }
        return false;
    }

    private void initialUserList() {
        users.add(new User("000-0001", "111111", "ZhangSan", "12#112", "13012341234"));
        users.add(new User("000-0002", "222222", "LiSi", "12#113", "13012341235"));
        users.add(new User("000-0003", "222222", "WangWu", "12#114", "13012341236"));
        users.add(new User("000-0004", "333333", "ZhaoLiu", "12#115", "13012341237"));
    }
}
