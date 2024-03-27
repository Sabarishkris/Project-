package com.interviewpanel.interviewer;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.model.Candidate;
import com.interviewpanel.model.Interviewer;
import com.interviewpanel.model.Interviewerstaus;

import java.util.Queue;

public class Interviewermodel {
private Interviewerview interviewerview;
private Interviewer interviewer;
    public Interviewermodel(Interviewerview interviewerview) {
        this.interviewerview=interviewerview;
    }

    public void setInterviewerDetails(String interviewerName, String email, long phoneNo, String address) {
        interviewer=new Interviewer();
        interviewer.setName(interviewerName);
        interviewer.setEmail(email);
        interviewer.setPhone(phoneNo);
        interviewer.setAddress(address);
        Companydatabase.getInstance().setInterviewerInstance(interviewer);
        interviewerview.showalert("---Interviewer appointed successfully---");
    }

    public void setInterviewerCredential(String interviewerName, String interviewPassword) {
        if(Companydatabase.getInstance().setInterviewerCredential(interviewerName,interviewPassword)) {
            new Interviewerview().showalert("Interviewer credential created successfully....!");
        }else {
            new Interviewerview().showalert("Interviewer credential created unsuccessful....!");

        }
    }

    public Queue<Candidate> checkCandidateIs() {
        return Companydatabase.getInstance().getCandidateQueue();
    }

    public void setInterviewerStatus(Candidate poll,int mark) {
        Interviewerstaus interviewerstausupdate=new Interviewerstaus();
        interviewerstausupdate.setName(poll.getName());
        interviewerstausupdate.setId(poll.getId());
        interviewerstausupdate.setQualification(poll.getQualification());
        interviewerstausupdate.setEmail(poll.getEmail());
        interviewerstausupdate.setPhoneno(poll.getPhoneno());
       interviewerstausupdate.setLocation(poll.getLocation());
       interviewerstausupdate.setStatus(poll.getStatus());
       interviewerstausupdate.setExperience(poll.getExperience());
       interviewerstausupdate.setMark(mark);
        Companydatabase.getInstance().setInterviewerStatus(interviewerstausupdate);
    }
}
