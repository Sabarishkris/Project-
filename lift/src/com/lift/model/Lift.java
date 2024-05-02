package com.lift.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lift {
    private int[]lift;
    public Lift(){
        lift=new int[5];
    }

    public int[] getLift() {
        return lift;
    }

    public void setLift(int[] lift) {
        this.lift = lift;
    }

}
