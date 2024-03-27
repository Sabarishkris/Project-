package com.interviewpanel.candidate;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.login.LoginView;
import com.interviewpanel.model.Candidate;
import com.interviewpanel.model.Interviewerstaus;
import com.interviewpanel.validation.Validation;

import java.util.*;

import java.util.Scanner;

public class Candidateview {
    private Candidatemodel candidatemodel;
    static int id = 1;

    public Candidateview() {
        candidatemodel = new Candidatemodel(this);
    }

    public void init() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the candidate name : ");
            String candidateName = sc.nextLine();
            if (new Validation().nameChecker(candidateName)) {
                if (candidatemodel.checkNameExist(candidateName)) {
                    System.out.println("Candidate Id : " + id);
                    System.out.println("Enter qualification : ");
                    String qualification = sc.nextLine();
                    System.out.println("Enter experience : ");
                    int experience = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter email : ");
                    String email = sc.nextLine();
                    System.out.println("Enter phone no : ");
                    long phoneNo = sc.nextLong();
                    if (new Validation().validPhoneNo(phoneNo) &&
                            new Validation().validMailId(email)) {
                        sc.nextLine();
                        System.out.println("Enter Location : ");
                        String location = sc.nextLine();
                        candidatemodel.setdetails(candidateName, id, qualification, experience, email, phoneNo, location);
                        id++;
                        credential(candidateName);
                        System.out.println("Adding another candidate ... ");
                        if (continueOrNot()) {
                            init();
                        } else {
                            System.out.println("Thank you for adding Candidates....");
                        }
                    } else {
                        System.out.println("Invalid email or Phone no....");
                        init();
                    }
                } else {
                    System.out.println("Name already exist..");
                    init();
                }

            } else {
                System.out.println("Invalid name .....");
                init();
            }
        }catch (InputMismatchException e ){
            System.out.println("Input Mismatch....");
            init();
        }
    }

    private void credential(String candidateName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create credential : " + candidateName);
        System.out.println("Enter password in (8 Character) : ");
        String password = sc.nextLine();
        if (password.length() == 8) {
            if (candidatemodel.setCredentialCredential(candidateName, password)) {
                System.out.println("Credential created successfully !..");
            }
        } else {
            System.out.println("Invalid Password !...");
            credential(candidateName);
        }
    }

    private boolean continueOrNot() {
        Scanner sc = new Scanner(System.in);
        System.out.println("To continue (Yes / No)");
        String decission = sc.nextLine();
        if (decission.equalsIgnoreCase("yes")) {
            return true;
        } else if (decission.equalsIgnoreCase("No")) {
            return false;
        } else {
            System.out.println("Invalid input ....");
            continueOrNot();
        }
        return false;
    }

    public void removeCandidate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter candidate Id : ");
        int id = sc.nextInt();
        if (candidatemodel.removeCandidate(id)) {
            System.out.println("---- Candidate remove successfully ----");
            System.out.println("Remove another candidate ... ");
            if (continueOrNot()) {
                removeCandidate();
            }
        } else {
            System.out.println("---- Candidate id not found ----");

        }
    }

    public void viewAllCandidate() {
        System.out.println("---- Candidates ----");
        List<Candidate> candidateList = candidatemodel.viewAllCandidate();
        for (Candidate temp : candidateList) {
            System.out.println("Name : " + temp.getName());
            System.out.println("Id : " + temp.getId());
            System.out.println("Experience : " + temp.getExperience());
            System.out.println("Email : " + temp.getEmail());
            System.out.println("Phone No : " + temp.getPhoneno());
            System.out.println("Location : " + temp.getLocation());
            System.out.println("Status : " + temp.getStatus());
            System.out.println("**************************************************************************");
        }
    }

    public void candidateStatus(Candidate candidate) {
        int flag=0;
        System.out.println("---- Details ----");
        List<Interviewerstaus> candidateList = candidatemodel.interviewStatus();
        for (Interviewerstaus temp : candidateList) {
            if(candidate.getId()== temp.getId()) {
                System.out.println("Name : " + temp.getName());
                System.out.println("Id : " + temp.getId());
                System.out.println("Experience : " + temp.getExperience());
                System.out.println("Email : " + temp.getEmail());
                System.out.println("Phone No : " + temp.getPhoneno());
                System.out.println("Location : " + temp.getLocation());
                System.out.println("Mark : " + temp.getMark());
                System.out.println("Status : " + temp.getStatus());
                System.out.println("**************************************************************************");
                flag=1;
            }
        }
        if (flag==0){
            System.out.println("Interview not done.....");
        }
    }

    public void candidateViewStatus(Candidate candidate) {
        System.out.println("---- candidate Home Page ----");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("\n1-> View Status \n2-> Logout \n3-> Exit ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch....");
                candidateViewStatus(candidate);
            }
            if (choice == 3) {
                System.out.println("Exiting....");
                System.exit(0);
            }
            switch (choice) {
                case 1:
                    candidateStatus(candidate);
                    break;
                case 2:
                    new LoginView().init();
                    break;
                default:
                    System.out.println("Invalid Input .....");
            }
        }
    }
}
