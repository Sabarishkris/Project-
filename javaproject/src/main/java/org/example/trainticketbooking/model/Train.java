package org.example.trainticketbooking.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.list;

public class Train {
    private Long trainNo;
    private String name;
    private int departureTime;
    private int arrival;
    private int travelTime;
    private String from;
    private String to;
    private int fare;
    private List<String>route;
    private List<Integer> seats;

    public Train(Long trainNo, String name, int departureTime, int arrival, int travelTime, int fare, List<String> route,String from,String to) {
        this.trainNo = trainNo;
        this.name = name;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.travelTime = travelTime;
        this.fare = fare;
       this.route=route;
       this.from=from;
       this.to=to;
        seats = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public Long getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Long trainNo) {
        this.trainNo = trainNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }
}
