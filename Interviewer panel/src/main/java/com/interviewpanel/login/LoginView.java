package com.interviewpanel.login;

import com.interviewpanel.InterviewPanel2024;
import com.interviewpanel.datalayer.Companydatabase;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    public LoginView(){
        this.loginModel=new LoginModel(this);

    }

    public void init() {
        System.out.println("----"+InterviewPanel2024.getInstance().getAppName()+"----"+
                InterviewPanel2024.getInstance().getAppVersion()+"----");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username : ");
        String userName=sc.nextLine();
        System.out.println("Enter password : ");
        String password=sc.nextLine();

        loginModel.Validator(userName,password);
    }
    public  void alert (String s){
        System.out.println(s);

    }
}
