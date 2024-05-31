package org.example.trainticketbooking.home;

import org.example.trainticketbooking.login.LoginView;

import java.util.Scanner;

public class HomeView {
    private HomeModel homeModel;
    private Scanner sc;
    public HomeView(){
        homeModel=new HomeModel(this);
        sc=new Scanner(System.in);
    }

    public void init() {
        System.out.println("--- Welcome to Indian Railway ---  \n1) Booking \n2) Get PNR Status" +
                " \n3) Cancel Tickets \n4) Search Passenger \n5) List train Routes " +
                "\n6) Admin Page ");
        char choice=sc.next().charAt(0);
        while (true){
            switch (choice){
                case '6':
                    new LoginView().init();
            }
        }

    }
}
