package org.example.trainticketbooking.model;

public class Status {
    private String ticketId;
    private Long trainNo;
    private Long passengerId;
    private String name;
    private int age;
    private String status;

    Status(String ticketId, Long trainNo, Long passengerId, String name, int age, String status) {
        this.ticketId = ticketId;
        this.trainNo = trainNo;
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String  getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Long trainNo) {
        this.trainNo = trainNo;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
