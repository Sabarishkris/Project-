package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.books.BookView;
import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;
import com.zsgs.librarymanagement.model.User;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    private LibrarySetupView librarySetupView=new LibrarySetupView();
    public LoginView(){
        loginModel=new LoginModel(this);
    }
    public void init() {
        System.out.println("-----"+ LibraryManagement2024.getInstance().getAppName() +"-----"+
                LibraryManagement2024.getInstance().getAppVersion());
        System.out.println("\n\nPlease login to proceed.");

        getLoginDetails();
    }

    private void getLoginDetails() {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the User Name : ");
        String userName=sc.next();
        System.out.println("Enter the password : ");
        String password= sc.next();
        if (loginModel.checkUserCredential(userName,password)){
            User user=loginModel.getUserInstance(userName,password);
            new BookView().userCredential(user);
        }else{
        loginModel.Validator(this,userName,password);
        }
    }

    public void alart(String loginSuccessful) {
        System.out.println(loginSuccessful);
    }

    public void success() {
        System.out.flush();
        librarySetupView.init();
    }
}
