package com.flightticket.datalayer;

import com.flightticket.model.Credential;
import com.flightticket.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Credential>credentialList=new ArrayList<>();
    private List<Flight>flightList=new ArrayList<>();
    private static Database database;
    private String admin="zsgs";
    private String adminPassword="admin";

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public static Database getInstance(){
        if(database==null){
            database=new Database();
        }
        return database;
    }

    public void addCredential(Credential newCredential) {
        credentialList.add(newCredential);
    }

    public boolean nameIsAvailable(String name) {
        if(!credentialList.isEmpty()) {
            for (Credential temp : credentialList) {
                if (temp.getName().equalsIgnoreCase(name)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkPassengerCredential(String name, String password) {
        if(!credentialList.isEmpty()){
            for (Credential temp : credentialList) {
                if (temp.getName().equals(name) && temp.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getPassengerId(String name) {
        for (Credential temp : credentialList){
            if(temp.getName().equals(name)){
                return temp.getPassengerId();
            }
        }
        return "";
    }

    public boolean checkFlightId(int flightid) {
        if(!flightList.isEmpty()){
            for (Flight temp:flightList){
                if(temp.getFlightId()==flightid){
                    return true;
                }
            }
        }
        return false;
    }

    public Flight getFlightInstance(int id) {
        Flight flight=null;
        for (Flight temp:flightList){
            if(temp.getFlightId()==id){
                 flight=temp;
            }
        }
        return flight;
    }

    public void addTicket(int tickets, int flightNo) {
        for(Flight temp:flightList){
            if(flightNo==temp.getFlightId()){
                temp.setTickets(temp.getTickets()-tickets);
                temp.setAmount(temp.getAmount()-(tickets*200));
            }
        }
    }

    public List<Flight> displayAvailableFlight() {
        return flightList;

    }

    public boolean CheckFlights() {
        if(flightList.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean addFlight(int id, int ticket, long amount) {
        flightList.add(new Flight(id,ticket,amount));
        return true;
    }
}
