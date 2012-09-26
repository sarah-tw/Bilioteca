package Bilioteca;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String telephone;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public User(String username, String password, String name, String address, String telephone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;

        this.telephone = telephone;
    }

    public boolean isValidUser(String usernamePassword) {
        return (username + " " + password).equals(usernamePassword);
    }
}
