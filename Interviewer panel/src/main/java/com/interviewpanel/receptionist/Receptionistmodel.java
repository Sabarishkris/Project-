package com.interviewpanel.receptionist;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.interviewer.Interviewerview;
import com.interviewpanel.model.Interviewer;
import com.interviewpanel.model.Receptionist;

public class Receptionistmodel {
    private Receptionist receptionist;
    private Receptionistview receptionistview;
    public Receptionistmodel(Receptionistview receptionistview) {
        this.receptionistview=receptionistview;
    }

    public void setReceptionistDetails(String receptionistName, String email, long phoneNo, String address) {
        receptionist=new Receptionist();
        receptionist.setName(receptionistName);
        receptionist.setEmail(email);
        receptionist.setPhone(phoneNo);
        receptionist.setAddress(address);
        Companydatabase.getInstance().setReceptionistInstance(receptionist);
        receptionistview.showalert("---Receptionist appointed successfully---");
    }

    public void setReceptionistCredential(String receptionistName, String receptionistPassword) {

        if( Companydatabase.getInstance().setReceptionistCredential(receptionistName,receptionistPassword)) {
            new Receptionistview().showalert("Receptionist credential created successfully....!");
        }else {
            new Receptionistview().showalert("Receptionist credential created unsuccessful....!");

        }
    }

}
