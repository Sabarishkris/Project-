package com.flightticket.passenger;

import com.flightticket.datalayer.Database;
import com.flightticket.model.Credential;
import com.flightticket.model.Flight;
import com.flightticket.model.Passenger;

import java.util.List;

public class PassengerModel {
    private PassengerView passengerView;

    public PassengerModel(PassengerView passengerView) {
        this.passengerView = passengerView;
    }

    public void addCredential(String name, String password, String passengerId) {
        Database.getInstance().addCredential(new Credential(name, password, passengerId));
        passengerView.sendAlart("--- " + name + " Account created successfully ---");
    }

    public boolean nameIsAvailable(String name) {

        return Database.getInstance().nameIsAvailable(name);
    }

    public boolean checkFlightId(int flightid) {
        return Database.getInstance().checkFlightId(flightid);
    }

    public Flight getFlightInstance(int id) {
        return Database.getInstance().getFlightInstance(id);
    }

    public void setDetails(String passengerId, int flightid, int tickets, Long amount, Flight flight) {
        flight.setTickets(flight.getTickets() - tickets);
        flight.setAmount(flight.getAmount() + (tickets * 200));
        flight.addPassenger(new Passenger(passengerId, tickets, flightid, amount));
    }

    public boolean checkpassengerId(int flightId, String passengerId) {
        Flight flight = Database.getInstance().getFlightInstance(flightId);
        Passenger passenger = null;
        Long refund=0L;
        int tickets=0;
        for (Passenger temp : flight.getPassengerList()) {
            if (temp.getPassengerId() == passengerId) {
                //passenger=temp;
                refund = refundAmount(passengerId, flight);
                tickets=temp.getTicket();
                flight.getPassengerList().remove(temp);
                ticketIncrement(tickets,flightId);
                passengerView.sendAlart("Amount refunded : " + refund);
                return true;
            }
        }
        return false;
    }

    private void ticketIncrement(int tickets,int flightNo) {
        Database.getInstance().addTicket(tickets,flightNo);
    }

    private Long refundAmount(String passengerId, Flight flight) {
        for (Passenger temp : flight.getPassengerList()) {
            if (temp.getPassengerId() == passengerId) {
                return temp.getPaidAmount();
            }
        }
        return 0L;
    }

    public void displayAvailableFight() {
        List<Flight> flightList=Database.getInstance().displayAvailableFlight();
        for (Flight temp:flightList){
            System.out.printf("%-10s %-10s %-10s","FLight No","Tickets","Ticket Amount");
            System.out.println();
            System.out.printf("%-10s %-10s %-10s",temp.getFlightId(),temp.getTickets(),temp.getAmount());
            System.out.println();
            System.out.println("************************************");
        }

    }
}
