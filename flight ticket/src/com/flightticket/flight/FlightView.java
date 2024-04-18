package com.flightticket.flight;

import com.flightticket.login.LoginView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightView {
    static int id=1;
    private FLightModel fLightModel;
    private Scanner sc;
    public FlightView(){
        this.fLightModel=new FLightModel(this);
        this.sc=new Scanner(System.in);
    }
    public void init(){
        System.out.println("Flight id : "+id);
        System.out.println("Enter the Flight tickets : ");
        int ticket=sc.nextInt();
        System.out.println("Enter the ticket amount : ");
        long amount=sc.nextLong();
        if(fLightModel.addflight(id,ticket,amount)){
            System.out.println("Flight no : "+id +" Created successfully ");
            id++;
            checkContinue(sc);
        }else{
            System.out.println("FLight no : "+id+" Created unsuccessfully");
        }
    }

    private void checkContinue(Scanner sc) {
        System.out.println("Enter yes - > continue No - > Back ");
        String s=sc.next();
        if(s.equalsIgnoreCase("yes")){
            init();
        }else{
            System.out.println("--- Thank you ---");
        }
    }

    public void options(){
        while (true) {
            System.out.println("Select choice \n1 - > Create FLight \n2 - > Display Flight \n3 - > Ticket booked Details \n4 - > Logout ");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    init();
                    break;
                case '2':
                    fLightModel.displayFLight();
                    break;
                case '3':
                    totalBookedTicket();
                    break;
                case '4':
                    new LoginView().selectChoice();
                    break;
                default:
                    System.out.println("Invalid input ...");
            }
        }
    }

    private void totalBookedTicket() {
        if(fLightModel.checkFlight()) {
            fLightModel.displayFLight();
            try {
                System.out.println("Enter the flight no : ");
                int flightNo = sc.nextInt();
                if (fLightModel.checkFlightNoIsAvailable()) {
                    fLightModel.ticketBookedDetails(flightNo);
                } else {
                    System.out.println("Invalid flight number ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch...");

            }
        }else {
            System.out.println("No booked ticket available");
        }


    }

    public void sendAlart(String s) {
        System.out.println(s);
    }
}
