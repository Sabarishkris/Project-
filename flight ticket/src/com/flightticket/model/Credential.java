package com.flightticket.model;

public class Credential {
    private String name;
    private String password;
    private String passengerId;
    public Credential(String name, String password, String id){
        this.name=name;
        this.password=password;
        this.passengerId=id;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
