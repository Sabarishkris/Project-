package com.flightticket.login;

import com.flightticket.datalayer.Database;
import com.flightticket.flight.FlightView;
import com.flightticket.passenger.PassengerView;

import java.util.Scanner;

public class LoginModel {
    private LoginView loginView;
    public LoginModel(LoginView loginView) {
        this.loginView=loginView;
    }

    public void checkLogin(String name, String password) {
        if(name.equals(Database.getInstance().getAdmin())){
            if (password.equals(Database.getInstance().getAdminPassword())){
                loginView.sendAlart(" --- Admin Login Successfully --- ");
                new FlightView().options();

            }else{
                loginView.sendAlart("Login password invalid ...");
            }
        }else if(Database.getInstance().checkPassengerCredential(name,password)){
            String passengerid=Database.getInstance().getPassengerId(name);
            loginView.sendAlart("-- "+name+" Passenger login successfully --- ");
            new PassengerView().selectChoice(passengerid);

        }else{
            loginView.sendAlart("Login name invalid");
        }
    }

    public void createNewAccount(Scanner sc) {
        new PassengerView().createNewAccount(sc);
    }

    public boolean CheckFlights() {
        if(Database.getInstance().CheckFlights()){
            return true;
        }else{
            loginView.sendAlart("NO flight available...");
            return false;
        }
    }
}
