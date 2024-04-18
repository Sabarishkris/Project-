package com.flightticket.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int flightId;
    private int tickets;
    private long amount;
private List<Passenger> passengerList;
public Flight(int id, int tickets, Long amount){
    this.flightId=id;
    this.tickets=tickets;
    this.amount=amount;
    passengerList=new ArrayList<>();
}

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    public void addPassenger(Passenger passenger){
    passengerList.add(passenger);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

//    public void setPassengerList(List<Passenger> passengerList) {
//        this.passengerList = passengerList;
//    }
}
