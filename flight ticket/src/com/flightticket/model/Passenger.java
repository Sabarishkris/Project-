package com.flightticket.model;

public class Passenger {
    private String passengerId;
    private int tickets;
    private int flightId;
    private long paidAmount;
    public Passenger(String passengerId, int tickets, int flightId, Long paidAmount){
        this.passengerId=passengerId;
        this.flightId=flightId;
        this.tickets=tickets;
        this.paidAmount=paidAmount;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public int getTicket() {
        return tickets;
    }

    public void setTicket(int ticket) {
        this.tickets = ticket;
    }

    public int getFlight() {
        return flightId;
    }

    public void setFlight(int flight) {
        this.flightId = flight;
    }

    public long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(long paidAmount) {
        this.paidAmount = paidAmount;
    }
}
