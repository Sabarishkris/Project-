package com.interviewpanel.candidate;
import java.util.*;

import com.interviewpanel.datalayer.Companydatabase;
import com.interviewpanel.model.Candidate;
import com.interviewpanel.model.Credential;

public class Candidatemodel {
    private Candidateview candidateview;
    public Candidatemodel(Candidateview candidateview) {
        this.candidateview=candidateview;
    }

    public void setdetails(String candidateName, int id, String qualification, int experience, String email, long phoneNo, String location) {
        Candidate candidate=new Candidate();
        candidate.setName(candidateName);
        candidate.setId(id);
        candidate.setQualification(qualification);
        candidate.setExperience(experience);
        candidate.setEmail(email);
        candidate.setPhoneno(phoneNo);
        candidate.setLocation(location);

        Companydatabase.getInstance().addCandidateDetails(candidate);

    }

    public boolean checkNameExist(String candidateName) {
        return Companydatabase.getInstance().checkNameExist(candidateName);
    }

    public boolean removeCandidate(int id) {
        return Companydatabase.getInstance().removeCandidate(id);
    }

    public List viewAllCandidate() { return Companydatabase.getInstance().viewAllCandidate();
    }

    public boolean setCredentialCredential(String candidateName, String password) {
        Credential credential=new Credential();
        credential.setName(candidateName);
        credential.setPassword(password);
        return Companydatabase.getInstance().setCandidateCredential(credential);
    }

    public List interviewStatus() {
        return Companydatabase.getInstance().getInterviewUpdate();
    }
}
