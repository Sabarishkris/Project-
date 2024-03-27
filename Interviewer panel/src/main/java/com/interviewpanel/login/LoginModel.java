package com.interviewpanel.login;

import com.interviewpanel.candidate.Candidateview;
import com.interviewpanel.companysetup.Companysetupview;
import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.interviewer.Interviewerview;
import com.interviewpanel.model.Candidate;
import com.interviewpanel.receptionist.Receptionistview;

public class LoginModel {
    private LoginView loginView;
    public LoginModel(LoginView loginView) {
        this.loginView=loginView;
    }

    public void Validator(String userName, String password) {
        if(Companydatabase.getInstance().checkAdminName(userName) &&
               Companydatabase.getInstance().checkAdminPassword(password)){
                loginView.alert("Login successful ! ");
                new Companysetupview().init();
            }else if(userName.equals(Companydatabase.getInstance().getInterviewerName()) &&
                password.equals(Companydatabase.getInstance().getInterviewerPassword())){
            loginView.alert("---Interviewer login....---");
            new Interviewerview().interviewerSetUp();

        }else if(userName.equals(Companydatabase.getInstance().getReceptionistName()) &&
        password.equals(Companydatabase.getInstance().getReceptionistPassword())){
            loginView.alert("---Receptionist login....---");


            new Receptionistview().receptionistSetup();
        } else if(Companydatabase.getInstance().checkUserName(userName,password)){
            Candidate candidate=Companydatabase.getInstance().getCandidateInstance(userName);
            loginView.alert("---User Login...---");
            new Candidateview().candidateViewStatus(candidate);
        }else{
                loginView.alert("Invalid password ! ");
                loginView.init();
            }

    }

}
