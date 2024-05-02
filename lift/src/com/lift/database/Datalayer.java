package com.lift.database;

public class Datalayer {
    private static Datalayer datalayer;
    public static Datalayer getinstance(){
        if(datalayer==null){
            datalayer=new Datalayer();
        }
        return datalayer;
    }
}
