package com.lift.input;

import com.lift.LiftApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private InputModel inputModel;
    private Scanner scanner;

    public InputView() {
        inputModel = new InputModel(this);
        scanner = new Scanner(System.in);
    }

    public void init() {
        System.out.println("App Name : " + new LiftApp().getApp_Name());
        System.out.println("App Version : " + new LiftApp().getVersion());
        System.out.println("*****************************************************");
        start();
    }

    private void start() {
        inputModel.displayLift();
        try {
            while (true) {
                System.out.println("Select choice  \n1)Use lift \n2)Manage maintain \n3)Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        useLift();
                        break;
                    case 2:
                        liftMaintain();
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input...");
                }
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            sendalart("Input mismatch ...!");
        }
    }


    private void useLift() {
        try {
            System.out.println("Enter current floor : ");
            int currentFloor = scanner.nextInt();
            System.out.println("Enter designation floor : ");
            int designationFloor = scanner.nextInt();
            System.out.println("Enter no of person : ");
            int persons = scanner.nextInt();
            if (currentFloor >= 0 && currentFloor <= 10 && designationFloor >= 0 && designationFloor <= 10) {
                if (inputModel.checkCapacity(persons)) {
                    inputModel.assignLift(currentFloor, designationFloor);
                } else {
                    sendalart("20 persons only allowed !");
                }
            } else {
                System.out.println("Invalid input .. !");
                start();
            }
        } catch (InputMismatchException e) {
            sendalart("Input mismatch ...!");
        }
    }

    private void liftMaintain() {
        try {
            System.out.println("Select choice \n1)Set Service \n2)Service Done");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter the lift no 1 2 3 4 5 ");
                int index = scanner.nextInt();
                if (index >= 1 && index <= 5) {
                    index = index - 1;
                    inputModel.setIndex(index, -1);
                    checkToBeContinue();
                } else {
                    System.out.println("Invalid selection  ..");
                    liftMaintain();
                }
            } else if (choice == 2) {
                System.out.println("Enter the lift no 1 2 3 4 5 ");
                int index = scanner.nextInt();
                if (index >= 1 && index <= 5) {
                    index = index - 1;
                    inputModel.setIndex(index, 0);
                    checkToBeContinue();
                } else {
                    System.out.println("Invalid selection  ..");
                    liftMaintain();
                }
            } else {
                System.out.println("Invalid Selection ....");
                liftMaintain();
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Input Mismatch...");
            liftMaintain();
        }
    }

    public void sendalart(String s) {
        System.out.println(s);
        System.out.println("****************************");
        checkToBeContinue();
    }

    private void checkToBeContinue() {
        System.out.println("Enter yes for continue press any key for exit ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            start();
        } else {
            System.out.println("Exiting....!");
            System.exit(0);
        }
    }
}
