package com.interviewpanel.interviewer;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.login.LoginView;
import com.interviewpanel.model.Candidate;
import com.interviewpanel.model.Interviewerstaus;
import com.interviewpanel.validation.Validation;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class Interviewerview {
    private Interviewermodel interviewermodel;

    public Interviewerview() {
        interviewermodel = new Interviewermodel(this);
    }

    public void init() {
        try {
            System.out.println("---Appoint Interviewer---");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Interviewer name : ");
            String interviewerName = sc.next();
            if(new Validation().nameChecker(interviewerName)) {
                if (Companydatabase.getInstance().getReceptionistName() == null ||
                        !Companydatabase.getInstance().getReceptionistName().equals(interviewerName)) {
                    System.out.println("Enter Email : ");
                    String email = sc.next();
                    System.out.println("Enter phone no : ");
                    long phoneNo = sc.nextLong();
                    if (new Validation().validPhoneNo(phoneNo) &&
                            new Validation().validMailId(email)) {
                        sc.nextLine();
                        System.out.println("Enter address : ");
                        String address = sc.nextLine();
                        interviewermodel.setInterviewerDetails(interviewerName, email, phoneNo, address);
                        System.out.println("********************************************");
                        if(createCredential(interviewerName,sc)){
                            System.out.println("Credential created....");
                        }
                    } else {
                        System.out.println("Invalid email or phone no ....");
                        init();
                    }
                }else {
                    System.out.println("Invalid Interviewer name !...( Name already exist ) ");

                    init();
                }
            }else {
                System.out.println("Invalid Name....");
                init();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input !...");
            init();
        }
    }

    private boolean createCredential(String interviewerName,Scanner sc) {
        System.out.println("Create credential password !...");
        System.out.println("Credential name : " + interviewerName);
        System.out.println("Create password (in 8 character) : ");
        String interviewPassword = sc.next();
        if (interviewPassword.length() == 8) {
            interviewermodel.setInterviewerCredential(interviewerName, interviewPassword);
            return true;
        } else {
            System.out.println("Invalid Password !...(Password must in 8 character) ");
            createCredential(interviewerName,sc);
        }
        return false;
    }


    public void showalert(String s) {
        System.out.println(s);
    }

    public void interviewerSetUp() {
        manageInterviewerSetup();
    }

    public void sendCandidate() {
        Queue<Candidate> candidateQueue = interviewermodel.checkCandidateIs();
        if (!candidateQueue.isEmpty()) {
            getIN(candidateQueue.poll());

        } else {
            System.out.println("No candidate is there .....");
        }
    }

    private void getIN(Candidate poll) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Candidate Details");
        System.out.println("Name : "+poll.getName());
        System.out.println("Id : "+poll.getId());
        System.out.println("Qualification : "+poll.getQualification());
        System.out.println("Experience : "+poll.getExperience());
        System.out.println("Email : "+poll.getEmail());
        System.out.println("Phone No : "+poll.getPhoneno());
        System.out.println("Location : "+poll.getLocation());
        System.out.println("Enter Mark (0-5): ");
        int mark =sc.nextInt();
        if(mark<0 || mark>5){
            System.out.println("Invalid Mark ...");
            getIN(poll);
        }else{
            if(statusupdate(mark)){
                poll.setStatus("Selected");
                interviewermodel.setInterviewerStatus(poll,mark);
            }else{
                poll.setStatus("Not Selected");
                interviewermodel.setInterviewerStatus(poll,mark);
            }

        }
    }
    private boolean statusupdate(int mark) {
            if(mark < 3){
               return false;
            }else{
                return true;
            }
    }


    private void manageInterviewerSetup() {
        System.out.println("---- Interviewer Home Page ----");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("\n1-> Candidate get in \n2-> Logout \n3-> Exit ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch....");
                manageInterviewerSetup();
            }
            if(choice==3){
                System.out.println("Exiting....");
                System.exit(0);
            }
            switch (choice) {
                case 1:
                    sendCandidate();
                    break;
                case 2:
                    new LoginView().init();
                    break;
                default:
                    System.out.println("Invalid input ");
                    break;

            }
        }
    }
}

