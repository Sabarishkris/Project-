package org.example.trainticketbooking.datalayer;

import org.example.trainticketbooking.model.Passenger;
import org.example.trainticketbooking.model.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {
    private String adminName = "zsgs";
    private String adminPassword = "admin";
    private static DataBase dataBase;
    private List<Train> trains=new ArrayList<>();
    private List<Passenger>passengerList=new ArrayList<>();

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public boolean checkLogin(String name, String password) {
        return adminName.equals(name) && adminPassword.equals(password);
    }

    public boolean addTrain(Long trainId, String trainName, int departure, int arrival, int stopCount, int amount, List<String> route,String from,String to) {
        Train train = new Train(trainId, trainName, departure, arrival, stopCount, amount, route,from,to);
        if (trains.isEmpty()) {
            trains.add(train);
        }else {
            for (Train temp : trains) {
                if (temp.getName().equals(trainName)) {
                    return false;
                }
            }
            trains.add(train);
        }
        return true;


    }

    public void displayBookedTickets(Long trainNo) {
        Train train=null;
        for (Train temp:trains){
            if(Objects.equals(temp.getTrainNo(), trainNo)){
                train=temp;
            }
        }
        System.out.println( "Train Number"+" || "+ "Train Name"+" || "+
                "Departure Time"+" || "+ "Arrival Time"+" || "+ "From"+"||"+ "To"+"||"+ "Total Fare");
        System.out.print( train.getTrainNo()+""+ train.getName()+""+
                train.getDepartureTime()+""+ train.getArrival()+""+ train.getFrom()+""+ train.getTo()+""+ train.getFare());
        }

    public boolean trainIsAvailable(Long trainNo) {
        for (Train temp:trains){
            if(Objects.equals(temp.getTrainNo(), trainNo)){
                return true;
            }
        }
        return false;
    }
}
