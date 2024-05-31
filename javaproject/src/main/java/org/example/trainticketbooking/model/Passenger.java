package org.example.trainticketbooking.model;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private Long passengerId;

    Passenger(String name, int age, String gender, Long passengerId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return passengerId;
    }

    public void setId(Long id) {
        this.passengerId = id;
    }
}
