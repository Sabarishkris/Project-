package com.interviewpanel.companysetup;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.interviewer.Interviewerview;
import com.interviewpanel.login.LoginView;
import com.interviewpanel.model.Company;
import com.interviewpanel.receptionist.Receptionistview;
import com.interviewpanel.validation.Validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Companysetupview {
    static int id=1;

    private Companysetupmodel companysetupmodel;

    public Companysetupview(){
        companysetupmodel=new Companysetupmodel(this);
    }

    public  void companySetup() {
        try {
            System.out.println("---- Create company ----");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter company name : ");
            String companyName = sc.nextLine();

                System.out.println("Enter company Id : " + id);
                int companyId = id;

                System.out.println("Enter company Email : ");
                String email = sc.nextLine();
                System.out.println("Enter company phone No : ");
                long phoneNo = sc.nextLong();
                if(new Validation().validPhoneNo(phoneNo) &&
                new Validation().validMailId(email)) {
                    companysetupmodel.setCompanyDetails(companyName, companyId, email, phoneNo);
                    id++;
                }else {
                    System.out.println("Invalid email or phone no ....");
                    companySetup();
                }


        }catch (InputMismatchException e){
            System.out.println("Invalid Input !....");
            init();
        }
    }

    public void init(){
        companysetupmodel.checkCompanyStatus();
    }
    public void showAlert(String s) {
        System.out.println(s);
        manageCompany();
    }

    private void manageCompany() {
        Scanner sc=new Scanner(System.in);
        int choice=0;
        while(true) {
            System.out.println("\n1-> Create Interviewer \n2-> Set Receptionist \n3-> Logout \n4-> Exit ");
            try {
                 choice = sc.nextInt();
                if (choice == 4) {
                    System.out.println("Exiting....");
                    break;
                }
            }catch (InputMismatchException e ){
                System.out.println("InputMismatch ....");
                sc.nextLine();
                manageCompany();
            }
            switch (choice) {
                case 1:

                    if(Companydatabase.getInstance().getInterviewerInstance()==null){
                        new Interviewerview().init();
                    }else {
                        System.out.println("Interviewer already allotted");
                    }
                    break;
                case 2:
                       // Companydatabase.getInstance().intializeReceptionist();
                    if(Companydatabase.getInstance().getReceptionistInstance()==null){
                        new Receptionistview().init();
                    }else{
                        System.out.println("Receptionist already allotted ");
                    }
                    break;
                case 3:
                    System.out.println("Logout initiated....");
                    new LoginView().init();
                    break;
                default:
                    System.out.println("Invalid choice ! ");
            }
        }
    }
}
