package com.core.newbie.model;

public class User {

    private Integer id;

    private String login;

    private String password;

    private Boolean isAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(final Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
