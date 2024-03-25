package com.zsgs.librarymanagement.model;

public class Credentials {
    private String name ;
    private String password;

    public void setName(String userId) {
        this.name = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
