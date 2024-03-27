package com.interviewpanel;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.login.LoginView;
public class InterviewPanel2024 {
    private static InterviewPanel2024 interviewPanel;

    private String appName = "Interview Panel";
    static int flag=0;

    private String appVersion = "0.0.1";
    private InterviewPanel2024() {}
    public static InterviewPanel2024 getInstance() {
        if (interviewPanel == null) {
           interviewPanel = new InterviewPanel2024();
            flag=1;
        }
        return interviewPanel;
    }
    private void create() {
        LoginView loginView = new LoginView();
        System.out.println("Fetching data.....");
        Companydatabase.getInstance().intializeReceptionist();
        Companydatabase.getInstance().intializeInterviewer();
        Companydatabase.getInstance().credentialListInitialize();
        Companydatabase.getInstance().candidateListQueueintialize();
        Companydatabase.getInstance().initializeInterviewStatus();
        System.out.println("Fetching data..... Done ");
        loginView.init();
    }
    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] args) {
        InterviewPanel2024.getInstance().create();
    }
}
