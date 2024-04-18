package com.flightticket.flight;

import com.flightticket.datalayer.Database;
import com.flightticket.model.Flight;
import com.flightticket.model.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FLightModel {
    private FlightView flightView;

    public FLightModel(FlightView flightView) {
        this.flightView = flightView;
    }

    public boolean addflight(int id, int ticket, long amount) {
        return Database.getInstance().addFlight(id, ticket, amount);
    }
    public boolean checkFlight(){
        return Database.getInstance().CheckFlights();
    }

    public void displayFLight() {
        if (checkFlight()) {
            List<Flight> flightList = Database.getInstance().displayAvailableFlight();
            for (Flight temp : flightList) {
                System.out.printf("%-10s %-10s %-10s", "FLight No", "Tickets", "Ticket Amount");
                System.out.println();
                System.out.printf("%-10s %-10s %-10s", temp.getFlightId(), temp.getTickets(), temp.getAmount());
                System.out.println();
                System.out.println("************************************");
            }

        } else {
            flightView.sendAlart("No flights available... ");
        }
    }

    public void ticketBookedDetails(int flightNo) {
        List<Flight> flightList = Database.getInstance().displayAvailableFlight();
       for (Flight temp:flightList){
           if(flightNo==temp.getFlightId()){
              displayPassengerList(temp.getPassengerList());
           }
       }
    }

    private void displayPassengerList(List<Passenger> passengerList) {
        int count=0;
        for (Passenger temp:passengerList){
            System.out.printf("%-10s%-10s %-10s", "Passenger Id","Tickets","Paid Amount");
            System.out.println();
            count++;
            System.out.printf("%-10s%-10s %-10s", temp.getPassengerId(),temp.getTicket(),temp.getPaidAmount());
            System.out.println();
            System.out.println("********************************");
        }
        flightView.sendAlart("Total number of ticket booked : "+count);
        System.out.println("--------------------------------------------------");
    }


    public boolean checkFlightNoIsAvailable() {
        if (Database.getInstance().CheckFlights()) {
            return true;
        }
        return false;
    }
}

