package com.zsgs.librarymanagement.manageuserview;

import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.validation.Validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageUserView {
    static int id=1;
    private ManageUserModel manageUserModel;
    public ManageUserView(){
        manageUserModel=new ManageUserModel(this);
    }
    public void createCredential(User user){

            System.out.println("Create credential : --> "+user.getUserName());
            Scanner sc=new Scanner(System.in);
            System.out.println("Name : "+user.getUserName());
            System.out.println("Create new password (minimum 8 character) : ");
            String password = sc.next();
            if(password.length()==8){
                manageUserModel.addUserCredential(user.getUserName(),password);
            }else {
                System.out.println("Invalid Password !..");
                createCredential(user);
            }

    }
    public void initAdd() {
        try {
        System.out.println("Enter the following user Details: ");
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter user Id : " +id);
        int userId= id;
        if(manageUserModel.userIdIsAvailable(userId)) {
            System.out.println("\nEnter user name:");
            String userName = scanner.nextLine();
            if (new Validation().nameChecker(userName)) {
                System.out.println("Enter user Phone No : ");
                long userPhoneno = scanner.nextLong();
                scanner.nextLine();
                System.out.println("\nEnter user emailId:");
                String userEmailId = scanner.nextLine();

                if (new Validation().validMailId(userEmailId)) {
                    if (new Validation().validPhoneNo(userPhoneno)) {
                        System.out.println("Enter user address : ");
                        String userAddress = scanner.nextLine();
                        manageUserModel.setUserDetails(user, userId, userName, userPhoneno, userAddress, userEmailId);
                        id++;
                        createCredential(user);
                        manageUserModel.addNewUser(user);
                        System.out.println("User credential created successfully ... Thank You !...");
                    } else {
                        System.out.println("Invalid Phone No !..");
                        initAdd();
                    }
                } else {
                    System.out.println("Invalid Email Id Address ! ...");
                    initAdd();
                }
            } else {
                System.out.println("User Id already exist ... ");
                initAdd();
            }
        }else {
            System.out.println("Invalid Name ...");
            initAdd();
        }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input !..");
            initAdd();
        }

    }

    public void showLibraryName(String libraryName) {

        System.out.println("Current Library Name - " + libraryName);
    }

    public void onUserAdded(User user) {
        System.out.println("\n------- User '" + user.getUserName()+ "' added successfully ------- \n");
        checkForAddNewUser();
    }

    public void onUserExist(User user) {
        System.out.println("\n------- User '" + user.getUserName() + "' already exist -------\n");
        checkForAddNewUser();
    }

    private void checkForAddNewUser() {
        System.out.println("Do you want to add more users? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            initAdd();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewUser();
        }
    }
}
