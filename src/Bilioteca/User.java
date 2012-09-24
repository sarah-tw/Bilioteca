package Bilioteca;

public class User {
    private String username;
    private String password;
    private String name;
    private String adress;
    private String telphone;


    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getTelphone() {
        return telphone;
    }

    public User(String username, String password, String name, String adress, String telphone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.adress = adress;

        this.telphone = telphone;
    }

    public boolean isValidUser(String usernamePassword) {
        return (username + " " + password).equals(usernamePassword);
    }
}
