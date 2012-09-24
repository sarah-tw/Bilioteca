package Bilioteca;

public class Session {

    private boolean login;

    public Session() {

    }

    public boolean isLoggedIn() {
        return login;
    }

    public void setLoggedIn(boolean login) {
        this.login = login;
    }
}
