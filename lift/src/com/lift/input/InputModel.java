package com.lift.input;

import com.lift.model.Lift;

import java.sql.ClientInfoStatus;


public class InputModel {
    private InputView inputView;
    private static Lift lift;
    private final static int CAPACITY_WEIGHT = 20;

    public InputModel(InputView inputView) {
        this.inputView = inputView;
        lift = new Lift();
    }

    public boolean checkCapacity(int persons) {
        if ((persons) <= CAPACITY_WEIGHT) {
            return true;
        }
        return false;
    }

    public void assignLift(int currentFloor, int destinationFloor) {
        int lifts[] = lift.getLift();
        if (currentFloor >= -1 && currentFloor <= 5 && destinationFloor >= -1 && destinationFloor <= 5 ) {
            findNearBy(lifts[0], lifts[1], lifts[4], currentFloor, destinationFloor, lifts, 0, 1);
        } else if (currentFloor >= 6 && currentFloor <= 10 && destinationFloor >= 6 && destinationFloor <= 10 || currentFloor == 0 || destinationFloor == 0 ||currentFloor==-1 || destinationFloor==-1) {
            findNearBy(lifts[2], lifts[3], lifts[4], currentFloor, destinationFloor, lifts, 2, 3);
        } else {
            lifts[4] = destinationFloor;
            inputView.sendalart("L5 assigned successfully ..!");
        }
//        int []lifts=lift.getLift();
//        int i = currentFloor >= 6 ? 2 : 0;
//        int floorlimit = currentFloor >= 6 && destinationFloor == 0 ? 4 : 5;
//
//        int index = i;
//        int flag=0;
//        int max = Math.abs(currentFloor - lifts[i]);
//        for (; i < floorlimit; i++) {
//            int minPath = Math.abs(currentFloor - lifts[i]);
//            if (max > minPath && lifts[i]!=-1 ) {
//                max = minPath;
//                index = i;
//                flag=1;
//            }
//        }
//        if (flag == 1) {
//            lifts[index] = destinationFloor;
//            inputView.sendalart("L" + (index + 1) + " assigned successfully ..!");
//        }else{
//            lifts[index] = destinationFloor;
//            inputView.sendalart("L" + (index + 1) + " assigned successfully ..!");
//        }

    }

    private void findNearBy(int lift1, int lift2, int lift5, int cur, int des, int[] lifts, int index1, int index2) {

        int min1 = Math.abs(lift1 - cur);
        int min2 = Math.abs(lift2 - cur);
        int min3 = Math.abs(lift5 - cur);

        if(lift1==0 && lift2==0 && lift5==0){
            lifts[index1] = des;
            inputView.sendalart("L" + (index1 + 1) + "  assigned successfully ..!");
        } else if (min1 < min2 && min1<min3 ) {
           if(lift1!=-1) {
               lifts[index1] = des;
               inputView.sendalart("L" + (index1 + 1) + "  assigned successfully ..!");
           }else if(lift2!=-1){
               lifts[index2] = des;
               inputView.sendalart("L" + (index2 + 1) + "  assigned successfully ..!");
           }else if(lift5!=-1){
               lifts[4] = des;
               inputView.sendalart("L5  assigned successfully ..!");
           }else{
               inputView.sendalart("All lifts under maintains...");
           }

        } else if (min2 < min1 && min2<min3) {
            if(lift2!=-1) {
                lifts[index2] = des;
                inputView.sendalart("L" + (index2 + 1) + "  assigned successfully ..!");
            }else if(lift1!=-1){
                lifts[index1] = des;
                inputView.sendalart("L" + (index1 + 1) + "  assigned successfully ..!");
            }else if(lift5!=-1){
                lifts[4] = des;
                inputView.sendalart("L5  assigned successfully ..!");
            }else{
                inputView.sendalart("All lifts under maintains...");
            }
        } else {
            if(min1 < min2 && lift5!=0 ){
                lifts[index1] = des;
                inputView.sendalart("L" + (index1 + 1) + "  assigned successfully ..!");
            }else if( min2<min1 && lift5!=0){
                lifts[index2] = des;
                inputView.sendalart("L" + (index2 + 1) + "  assigned successfully ..!");
            }else if(lift5!=-1){
            lifts[4] = des;
            inputView.sendalart("L5  assigned successfully ..!");
            } else if(lift1!=-1){
                lifts[index1] = des;
                inputView.sendalart("L" + (index1 + 1) + "  assigned successfully ..!");
            }else if(lift2!=-1){
                lifts[index2] = des;
                inputView.sendalart("L" + (index2 + 1) + "  assigned successfully ..!");
            }else{
                inputView.sendalart("All lifts under maintains...");
            }
        }
    }

    public void displayLift() {
        int[] lifts = lift.getLift();
        System.out.printf("%-5s %-5s %-5s %-5s %-5s", "L1", "L2", "L3", "L4", "L5");
        System.out.println();
        System.out.printf("%-5s %-5s %-5s %-5s %-5s", lifts[0], lifts[1], lifts[2], lifts[3], lifts[4]);
        System.out.println();


    }

    public void setIndex(int index,int num) {
        int lifts[] = lift.getLift();
        lifts[index] = num;
    }
}
