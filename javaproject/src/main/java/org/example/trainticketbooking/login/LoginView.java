package org.example.trainticketbooking.login;

import org.example.trainticketbooking.admin.TrainView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    private Scanner sc;
    public LoginView(){
        loginModel=new LoginModel(this);
        sc=new Scanner(System.in);
    }
    public void init(){
        System.out.println("Login name : ");
        String name=sc.next();
        System.out.println("Login password : ");
        String password=sc.next();
        if(loginModel.checkAdminLogin(name,password)) {
            new TrainView().init();
        }else{
            System.out.println("Invalid password !!!");
        }
    }
}
