package com.lift;

import com.lift.input.InputView;

public class LiftApp{
    private String app_Name="Lift App";
    private String version="0.0.1";
    private LiftApp liftApp;

    public String getApp_Name() {
        return app_Name;
    }

    public void setApp_Name(String app_Name) {
        this.app_Name = app_Name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LiftApp getLiftApp() {
        return liftApp;
    }

    public void setLiftApp(LiftApp liftApp) {
        this.liftApp = liftApp;
    }

    public LiftApp getInstance(){
        if(liftApp==null){
            liftApp=new LiftApp();
        }
        return liftApp;
    }
    public void letsCreate(){
        InputView inputView=new  InputView();
        inputView.init();
    }
}
