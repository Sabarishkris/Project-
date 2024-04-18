package com.flightticket.passenger;

import com.flightticket.datalayer.Database;
import com.flightticket.login.LoginView;
import com.flightticket.model.Flight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PassengerView {
    static int id = 100;

    private PassengerModel passengerModel;

    public PassengerView() {
        this.passengerModel = new PassengerModel(this);
    }


    public void createNewAccount(Scanner sc) {
        String tempId = "Pas" + id + 24;
        System.out.println("Passenger Id : " + tempId);
        System.out.println("Enter user name : ");
        String name = sc.nextLine();
        if (nameIsAvailable(name)) {
            System.out.println("Create new password : ");
            String password = sc.next();
            if (password.length() == 8) {
                passengerModel.addCredential(name, password, tempId);
                id++;

            } else {
                System.out.println("Create Password 8 Character only ");
                createNewAccount(sc);
            }
        } else {
            System.out.println(name + " already exist...");
            createNewAccount(sc);
        }
    }

    private boolean nameIsAvailable(String name) {
        return passengerModel.nameIsAvailable(name);
    }

    public void sendAlart(String s) {
        System.out.println(s);
    }

    public void selectChoice(String id) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select choice \n1 - > Book ticket \n2 - > Cancel Ticket \n3 - > Logout ");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    bookTicket(id);
                    break;
                case '2':
                    System.out.println("Enter flight No : ");
                    int flightId=sc.nextInt();
                    cancleTicket(id,flightId);
                    break;
                case '3':
                    new LoginView().selectChoice();
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        }
    }

    private void cancleTicket(String passengerId, int flightId) {
        if(passengerModel.checkpassengerId(flightId,passengerId)){

        }
    }

    private void bookTicket(String passengerid) {
        try {
            passengerModel.displayAvailableFight();
            Scanner sc = new Scanner(System.in);
            System.out.println("Passenger id : " + passengerid);
            System.out.println("Select Flight : ");
            int flightid = sc.nextInt();
            if (passengerModel.checkFlightId(flightid)) {
                System.out.println("Enter tickets : ");
                int tickets = sc.nextInt();
                Flight flight = passengerModel.getFlightInstance(flightid);
                if (tickets <=flight.getTickets()) {
                    Long amount = flight.getAmount() * tickets;
                    System.out.println("Your ticket amount is : " + amount + " \nPress ok to book any other key for cancel");
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("ok")) {
                        passengerModel.setDetails(passengerid, flightid, tickets, amount, flight);
                        System.out.println("Flight No : " + flightid + " tickets : " + tickets + "  booked successfully ! ");
                    } else {
                        System.out.println("Ticket Not booked \n Exiting..... ");
                        bookTicket(passengerid);
                    }
                } else {
                    System.out.println("FLight Id : "+flightid + " --- ticket is not available ");
                }
            } else {
                System.out.println("Invalid Flight Id ...");
                bookTicket(passengerid);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch..");
            bookTicket(passengerid);
        }
    }
}