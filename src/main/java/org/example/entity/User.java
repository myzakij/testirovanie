package org.example.entity;


public class User {
    private Integer id;
    private String login;
    private String password;
    private Boolean isOnline;

    public User(Integer id, String login, String password, Boolean isOnline) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isOnline = isOnline;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getOnline() {
        return isOnline;
    }
}
