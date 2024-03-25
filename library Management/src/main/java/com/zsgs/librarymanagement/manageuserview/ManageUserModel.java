package com.zsgs.librarymanagement.manageuserview;

import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.model.User;

public class ManageUserModel {
    private ManageUserView manageUserView;

    public ManageUserModel(ManageUserView manageUserView) {
        this.manageUserView=manageUserView;
    }

    public void setUserDetails(User user, int userId, String userName, long userPhoneno, String userAddress,String userEmailAddress) {
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPhoneNo(userPhoneno);
        user.setEmailId(userEmailAddress);
        user.setAddress(userAddress);
       // user.setMembership(memberShip);
    }

    public void addNewUser(User user) {
        if(LibraryDataBase.getInstance().addUser(user)){
            manageUserView.onUserAdded(user);
        }else{
            manageUserView.onUserExist(user);
        }

    }

    public boolean userIdIsAvailable(int userId) {
       return LibraryDataBase.getInstance().userIdIsAvailable(userId);
    }

    public void addUserCredential(String userName, String password) {
        LibraryDataBase.getInstance().addUserCredential(userName,password);
    }
}
