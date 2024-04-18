package com.flightticket.login;

import com.flightticket.FLightBookingApp;
import com.flightticket.datalayer.Database;


import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    private Scanner sc;
    public LoginView(){
        this.sc=new Scanner(System.in);
        this.loginModel=new LoginModel(this);
    }
    public void init(){
        FLightBookingApp.getInstance();
        System.out.println("---App name :  "+FLightBookingApp.getInstance().getAppName()
        +"--- App Version : "+FLightBookingApp.getInstance().getVersion()+"---");
        selectChoice();
    }

    public void selectChoice() {
        while (true){
            System.out.println(" Select your Choice \n1 - > Login \n2 - > Create account \n3 - > Exit ");
            String choice=String.valueOf(sc.nextInt());
            switch (choice){
                case "1":
                    getLoginDetails();
                    break;
                case "2":
                    sc.nextLine();
                    if(loginModel.CheckFlights()) {
                        loginModel.createNewAccount(sc);
                    }
                    break;
                case "3":
                    System.out.println("Exiting.....");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input ...");
            }
        }
    }

    private void getLoginDetails() {
        sc.nextLine();
        System.out.println("Enter user name : ");
        String name=sc.nextLine();
        System.out.println("Enter password : ");
        String password=sc.nextLine();
        loginModel.checkLogin(name,password);
    }

    public void sendAlart(String loginSuccessfully) {
        System.out.println(loginSuccessfully);
    }
}
