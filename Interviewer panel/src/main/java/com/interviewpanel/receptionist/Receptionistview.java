package com.interviewpanel.receptionist;

import com.interviewpanel.candidate.Candidateview;
import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.login.LoginView;
import com.interviewpanel.validation.Validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Receptionistview {
    private Receptionistmodel receptionistmodel;
    public Receptionistview() {
        receptionistmodel=new Receptionistmodel(this);
    }
    public void init(){
        try{
            System.out.println("---Appoint Receptionist---");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Receptionist name : ");
            String receptionistName=sc.next();
            if(new Validation().nameChecker(receptionistName)) {
                if (Companydatabase.getInstance().getInterviewerName() == null ||
                        !Companydatabase.getInstance().getInterviewerName().equals(receptionistName)) {
                    System.out.println("Enter Email : ");
                    String email = sc.next();
                    System.out.println("Enter phone no : ");
                    long phoneNo = sc.nextLong();
                    if (new Validation().validPhoneNo(phoneNo) &&
                            new Validation().validMailId(email)) {
                        sc.nextLine();
                        System.out.println("Enter address : ");
                        String address = sc.nextLine();
                        receptionistmodel.setReceptionistDetails(receptionistName, email, phoneNo, address);
                        System.out.println("********************************************");
                        System.out.println("Create credential password !...");
                        System.out.println("Credential name : " + receptionistName);
                        System.out.println("Create password (in 8 character) : ");
                        String receptionistPassword = sc.next();
                        if (receptionistPassword.length() == 8) {
                            receptionistmodel.setReceptionistCredential(receptionistName, receptionistPassword);
                        } else {
                            System.out.println("Invalid Password !...(Password must in 8 character) ");
                        }
                    } else {
                        System.out.println("Invalid Receptionist name !...( Name already exist ) ");
                    }
                }else{
                    System.out.println("Invalid email or phone no .....");
                    init();
                }
            }else {
                System.out.println("Invalid Name ....");
                init();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input !...");
            init();
        }
    }


    public void showalert(String s) {
        System.out.println(s);
    }

    public void receptionistSetup() {
        manageReceptionist();
    }

    private void manageReceptionist() {
        System.out.println("---- Receptionist Home Page ----");
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(true){
            System.out.println("\n1-> Add Candidate \n2-> view all candidate \n3-> Remove Candidate \n4-> Logout \n5-> Exit ");
            try {
                choice=sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Input Mismatch....");
                manageReceptionist();
            }
            if(choice==5){
                System.out.println("Existing .....");
                System.exit(0);
            }
            switch (choice){
                case 1:
                    new Candidateview().init();
                    break;
                case 2:
                    new Candidateview().viewAllCandidate();
                    break;
                case 3:
                    new Candidateview().removeCandidate();
                    break;
                case 4:
                    new LoginView().init();
                    break;
                default:
                    System.out.println("Invalid input ");
                    break;


            }
        }
    }
}

