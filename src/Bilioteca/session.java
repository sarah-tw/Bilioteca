package bilioteca;


public class Session {

    private boolean login;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public boolean isLoggedIn() {
        return login;
    }

    public void setLoggedIn(boolean login) {
        this.login = login;
    }

    public void setDetail(User user) {
        this.detail = user.getName() + " " + user.getAddress() + " " + user.getTelephone();
    }
}
