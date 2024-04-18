package com.flightticket;

import com.flightticket.login.LoginView;

public class FLightBookingApp{
    private String appName ="--- Flight ticket Booking ---";
    private String version="0.0.1";
   private static FLightBookingApp flightBookingApp;
   FLightBookingApp(){

   }
    public static FLightBookingApp getInstance(){
        if(flightBookingApp==null){
            flightBookingApp=new FLightBookingApp();
        }
        return flightBookingApp;
    }

    public void createInstance() {
        LoginView loginView=new LoginView();
        loginView.init();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
