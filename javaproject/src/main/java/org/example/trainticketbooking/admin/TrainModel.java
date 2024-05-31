package org.example.trainticketbooking.admin;

import org.example.trainticketbooking.datalayer.DataBase;

import javax.xml.crypto.Data;
import java.util.List;

public class TrainModel {
    private TrainView trainView;
    public TrainModel(TrainView trainView) {
        this.trainView=trainView;
    }

    public boolean addTrain(Long trainId, String trainName, int departure, int arrival, int stopCount, int amount, List<String> route,String from,String to) {
        return DataBase.getInstance().addTrain( trainId,trainName,departure, arrival,  stopCount,  amount, route,from ,to) ;
    }

    public void displayBookedTickets(Long trainNo) {
            DataBase.getInstance().displayBookedTickets(trainNo);
        }

    public boolean trainIsAvailable(Long trainNo) {
        return DataBase.getInstance().trainIsAvailable(trainNo);
    }
}
