package org.example.trainticketbooking.login;

import org.example.trainticketbooking.datalayer.DataBase;

public class LoginModel {
    private LoginView loginView;

    public LoginModel(LoginView loginView) {
        this.loginView=loginView;
    }

    public boolean checkAdminLogin(String name, String password) {
        return DataBase.getInstance().checkLogin(name,password);
    }
}
