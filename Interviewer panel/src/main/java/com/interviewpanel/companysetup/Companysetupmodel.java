package com.interviewpanel.companysetup;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.interviewer.Interviewerview;
import com.interviewpanel.model.Company;

public class Companysetupmodel {
    private Companysetupview companysetupview;
    private Company company;

    public Companysetupmodel(Companysetupview companysetupview) {
        Companydatabase.getInstance().companyInitialize();
        this.companysetupview = companysetupview;
        this.company = Companydatabase.getInstance().getCompanyInstance();
    }

    public void setCompanyDetails(String companyName, int companyId, String email, long phoneNo) {
        company = new Company();
        company.setName(companyName);
        company.setId(companyId);
        company.setEmail(email);// ompanyName,companyId,email,phoneNo
        company.setPhone(phoneNo);
        Companydatabase.getInstance().setCompanyInstance(company);
        companysetupview.showAlert("Company successfully Created.!!!");
    }

    public void setInterviewerCredential(String interviewerName, String interviewPassword) {
        if (Companydatabase.getInstance().setInterviewerCredential(interviewerName, interviewPassword)) {
            new Interviewerview().showalert("Interviewer credential created successfully....!");
        } else {
            new Interviewerview().showalert("Interviewer credential created unsuccessful....!");

        }
    }

    public void checkCompanyStatus() {
        if( Companydatabase.getInstance().getCompanyInstance()==null){
            companysetupview.companySetup();
        }else{
           companysetupview.showAlert("Already Company is Created ");
        }

    }
}
