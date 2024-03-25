package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.model.User;

public class LoginModel {
    private LoginView loginView;
    LoginModel(LoginView loginView){
        this.loginView =loginView;
    }

    public  User getUserInstance(String userName, String password) {
        return LibraryDataBase.getInstance().getUserInstance(userName,password);
        //return user;
    }

    public void Validator(LoginView loginView, String userName, String passWord) {
        if(userNameValidator(userName)){
            if(passWordValidator(passWord)){
                loginView.alart("Login successful");
                loginView.success();
            }else{
            loginView.alart("Invalid Password");}
            loginView.init();
        }else {
            loginView.alart("Invalid Username");
            loginView.init();
        }

    }
    private boolean userNameValidator(String userName ){
        return userName.equals(LibraryDataBase.getInstance().getAdminName());
    }
    private boolean passWordValidator(String userName ){
        return userName.equals(LibraryDataBase.getInstance().getAdminPassword());
    }

    public boolean checkUserCredential(String userName, String password) {
       return LibraryDataBase.getInstance().checkUserCredential(userName,password);
    }
}
