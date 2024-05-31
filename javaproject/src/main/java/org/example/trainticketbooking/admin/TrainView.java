package org.example.trainticketbooking.admin;

import org.example.trainticketbooking.home.HomeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrainView {
    private TrainModel trainModel;
    private Scanner sc;
   // static Long trainId = 2000L;

    public TrainView() {
        trainModel = new TrainModel(this);
        sc = new Scanner(System.in);
    }

    public void init() {
        while (true) {
            System.out.println("--- Welcome Admin Home Page --- \n1) Add Train \n2) Booked Tickets \n3) Display Trains" +
                    " \n4) Change ticket status of a passenger \n5) Back \n6) Logout");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    trainModel.addTrain(2000L, "Nellai", 3, 4, 5, 6, Arrays.asList("madu"), "ch", "ma");
                    //addTrain();
                    break;
                case '2':
                    displayBookedTickets();
                    break;
//                case '3':
//                    displayTrains();
//                    break;
//                case '4':
//                    deleteTrain();
//                    break;
//                case '5':
//                    back();
//                    break;
                case '6':
                    new HomeView().init();
                    return;
                default:
                    System.out.println("Invalid choice : ");
                    break;
            }
        }
    }

    private void displayBookedTickets() {
        System.out.println("Enter the train number: ");
        Long trainNo = sc.nextLong();

        if (trainModel.trainIsAvailable(trainNo)) {
            trainModel.displayBookedTickets(trainNo);
        } else {
            System.out.println("Train not available.");
            if (checkContinue()) {
                displayBookedTickets();
            } else {
                init();
            }
        }
    }

    private boolean checkContinue() {
        System.out.println("Enter 'yes' to continue, or any other key to exit: ");
        String choice = sc.next();
        return choice.equalsIgnoreCase("yes");
    }

    private void addTrain() {

        System.out.println("Train No : ");
        Long trainId=sc.nextLong();
        sc.nextLine();
        System.out.println("Train name:");
        String trainName = sc.nextLine();

        System.out.println("From:");
        String from = sc.nextLine();
        System.out.println("To:");
        String to = sc.nextLine();
        System.out.println("Departure time (24hrs):");
        int departure = sc.nextInt();
        System.out.println("Arrival time (24hrs):");
        int arrival = sc.nextInt();

        if (departure > 0 && arrival > 0 && arrival <= 24 && departure < arrival) {
            System.out.println("Enter the stops count:");
            int stopCount = sc.nextInt();
            sc.nextLine();
            List<String> route = addRoute(stopCount);
            int travelTime = arrival - departure;
            System.out.println("Ticket amount:");
            int amount = sc.nextInt();

            if (trainModel.addTrain(trainId, trainName, departure, arrival, travelTime, amount, route, from, to)) {
                System.out.println("Train No: " + trainId + " Train Name: " + trainName + " added successfully");
               // trainId++;
                if (checkContinue()) {
                    addTrain();
                } else {
                    init();
                }
            } else {
                System.out.println("Train name already exists.");
                if (checkContinue()) {
                    addTrain();
                } else {
                    init();
                }
            }
        } else {
            System.out.println("Invalid departure or arrival time.");
            if (checkContinue()) {
                addTrain();
            } else {
                init();
            }
        }
    }

    private List<String> addRoute(int stopCount) {
        List<String> route = new ArrayList<>();
        for (int i = 0; i < stopCount; i++) {
            System.out.println("Enter stop " + (i + 1) + ":");
            route.add(sc.nextLine());
        }
        return route;
    }
}
