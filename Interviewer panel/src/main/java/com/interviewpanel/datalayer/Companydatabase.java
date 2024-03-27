package com.interviewpanel.datalayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.interviewpanel.model.*;
//import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Companydatabase {
    private String adminName="zsgs";
    private String adminPassword="admin";
    String filePathInterviewer="Interviewer.json";
    String filePathReceptionist="Receptionist.json";
    String filePathCandidate="Candidate.json";
    String filePathCandidateList="CandidateList.json";
    String filePathCompany="Company.json";
     String filePathReceptionistName="ReceptionistName.json";
    String filePathReceptionistPassword="ReceptionistPassword.json";
    String filePathInterviewerName="InterviewerName.json";
    String filepathInterviewerPassword="InterviewerPassword.json";
    String filePathCredentialList="CredentialList.json";
    String filepathInterviewStatus="Interviewstatus.json";
    private  Company company;
    private Interviewer interviewer;
    private Credential credential;
    private Receptionist receptionist;
    private static Companydatabase companydatabase;
    private String interviewerName ;
    private String interviewerPassword ;
    private String receptionistName;
    private String receptionistPassword;
    private List<Candidate> candidateList=new ArrayList<>();
    private Queue<Candidate>candidateQueue=new LinkedList<>();

    private List<Credential>credentialList=new ArrayList<>();
    private List<Interviewerstaus>interviewerstausList=new ArrayList<>();
   // private List<Interviewerstaus>interviewerstausListpath=readInterviewerstatusList();
    public void writeInterviewerInstanceData(Interviewer interviewer){
        File file=new File(filePathInterviewer);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, interviewer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeReceptionistInstanceData(Receptionist receptionist){
        File file=new File(filePathReceptionist);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, receptionist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCompanyInstanceData(Company company){
        File file=new File(filePathCompany);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCandidateQueue(Queue<Candidate> candidateQueue){

        File file=new File(filePathCandidate);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, candidateQueue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initializeInterviewStatus(){
        this.interviewerstausList=readInterviewerstatusList();
    }

    private List<Interviewerstaus> readInterviewerstatusList() {
        File file=new File(filepathInterviewStatus);
        if(file.length()==0){
            return new ArrayList<>();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Interviewerstaus>interviewerstaus=new ArrayList<>();

        try {
            interviewerstaus=objectMapper.readValue(file,new TypeReference<List<Interviewerstaus>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return interviewerstaus;
    }

    public void credentialListInitialize(){
        this.credentialList=readCredentialList();
    }
    private List<Credential> readCredentialList() {
        File file=new File(filePathCredentialList);
        if(file.length()==0){
            return new ArrayList<>();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Credential>credentials=new ArrayList<>();

        try {
            credentials=objectMapper.readValue(file,new TypeReference<List<Credential>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }
    public void candidateListQueueintialize(){
      this.candidateList=readCandidateList();
       this.candidateQueue=readCandidate();
    }
    private List<Candidate> readCandidateList() {
        File file=new File(filePathCandidateList);
        if(file.length()==0){
            return new ArrayList<>();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Candidate>candidates=new ArrayList<>();

        try {
            candidates=objectMapper.readValue(file,new TypeReference<List<Candidate>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidates;
    }
    public Queue<Candidate> readCandidate(){
        File file=new File(filePathCandidate);
        if(file.length()==0){
            return new LinkedList<>();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Queue<Candidate>candidates=new LinkedList<>();

        try {
            candidates=objectMapper.readValue(new File(filePathCandidate),new TypeReference<Queue<Candidate>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidates;
    }
public String getAdminName(){
    return adminName;
}
public String getAdminPassword(){
    return adminPassword;
}
public static Companydatabase getInstance(){
    if(companydatabase==null){
        companydatabase=new Companydatabase();
    }
        return companydatabase;
}
public void setCompanyInstance(Company company){
        this.company=company;
    writeCompanyInstanceData(company);

}
public Company getCompanyInstance(){
    return company;
}
public void companyInitialize(){
        this.company=readCompanyInstance();
}
    private Company readCompanyInstance() {
        File file=new File(filePathCompany);
        if(file.length()==0){
            return null;
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Company company1=null;

        try {
            company1=objectMapper.readValue(file,new TypeReference <Company>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return company1;
    }


    public void setInterviewerInstance(Interviewer interviewer) {
    this.interviewer=interviewer;
    writeInterviewerInstanceData(interviewer);
    }
    public Interviewer getInterviewerInstance(){
    return interviewer;
    }

    public boolean setInterviewerCredential(String interviewName, String interviewPassword) {
    if(interviewerName==null && interviewerPassword==null){
        this.interviewerName=interviewName;
        this.interviewerPassword=interviewPassword;
        writeInterviewerName(interviewerName);
        writeInterviewerPassword(interviewerPassword);
        return true;
    }
    return false;
    }

    public String getInterviewerName() {
    return interviewerName;
    }
    public String getInterviewerPassword() {
        return interviewerPassword;
    }

    public void setReceptionistInstance(Receptionist receptionist) {
        if(this.receptionist==null){
        this.receptionist=receptionist;
        writeReceptionistInstanceData(receptionist);}
    }
    public  void intializeReceptionist(){
        if(readReceptionistInstance()!=null) {
            this.receptionist = readReceptionistInstance();
            //System.out.println(readReceptionistName());
            this.receptionistName =readReceptionistName();
           //System.out.println(readReceptionistPassword());
            this.receptionistPassword = readReceptionistPassword();
        }
    }
    public  void intializeInterviewer(){
        if(readInterviewerInstance()!=null) {
            this.interviewer =readInterviewerInstance();
            //System.out.println(readInterviewerName());
            this.interviewerName =readInterviewerName();
            // System.out.println(readInterviewerPassword());
            this.interviewerPassword = readInterviewerPassword();
        }
    }

    private String readInterviewerPassword() {
            File file=new File(filepathInterviewerPassword);
            if(file.length()==0){
                return "";
            }
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String interviewerPassword="";

            try {
                interviewerPassword=objectMapper.readValue(file,new TypeReference <String>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }

            return interviewerPassword;

    }

    private String readInterviewerName() {
            File file=new File(filePathInterviewerName);
            if(file.length()==0){
                return "";
            }
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String interviewerName="";

            try {
               interviewerName=objectMapper.readValue(file,new TypeReference <String>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }

            return interviewerName;

    }

    public void writeInterviewerName(String interviewerName){
        File file=new File(filePathInterviewerName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, interviewerName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeInterviewerPassword(String interviewerPassword){
        File file=new File(filepathInterviewerPassword);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, interviewerPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Interviewer readInterviewerInstance() {
            File file=new File(filePathInterviewer);
            if(file.length()==0){
                return null;
            }
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            Interviewer interviewer1=null;

            try {
                interviewer1=objectMapper.readValue(file,new TypeReference <Interviewer>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }

            return interviewer1;
        }

    private Receptionist readReceptionistInstance() {
        File file=new File(filePathReceptionist);
        if(file.length()==0){
            return null;
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       Receptionist receptionist1=null;

        try {
            receptionist1=objectMapper.readValue(file,new TypeReference <Receptionist>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receptionist1;
    }



    public Receptionist getReceptionistInstance(){
    return receptionist;
    }

    public boolean setReceptionistCredential(String receptionistName, String receptionistPassword) {
        if(this.receptionistName==null && this.receptionistPassword==null){
            this.receptionistName=receptionistName;
            this.receptionistPassword=receptionistPassword;
            writeReceptionistName(receptionistName);
            writeReceptionistPassword(receptionistPassword);
            return true;
        }
        return false;
    }
    public void writeReceptionistName(String receptionistName){
        File file=new File(filePathReceptionistName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, receptionistName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeReceptionistPassword(String receptionistPassword){
        File file=new File(filePathReceptionistPassword);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, receptionistPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void initializereceptionistCredential(){
//        this.receptionistName=readReceptionistName();
//        this.receptionistPassword=readReceptionistPassword();
//    }
    public String getReceptionistName(){
    return receptionistName;
    }
    public String getReceptionistPassword(){
    return receptionistPassword;
    }
    private String readReceptionistName() {
        File file=new File(filePathReceptionistName);
        if(file.length()==0){
            System.out.println("1");
            return "";
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String receptionistName="";

        try {
            receptionistName=objectMapper.readValue(file,new TypeReference <String>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receptionistName;
    }
    private String readReceptionistPassword() {
        File file=new File(filePathReceptionistPassword);
        if(file.length()==0){
            System.out.println("1");
            return "";
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String receptionistPassword="";

        try {
            receptionistPassword=objectMapper.readValue(file,new TypeReference <String>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receptionistPassword;
    }
    public void addCandidateDetails(Candidate candidate) {
    candidateList.add(candidate);
        writeCandidateList(candidateList);
    candidateQueue.add(candidate);
    writeCandidateQueue(candidateQueue);

    }

    private void writeCandidateList(List<Candidate> candidateList) {

            File file=new File(filePathCandidateList);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            try {
                objectMapper.writeValue(file, candidateList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public boolean checkNameExist(String candidateName) {
    int flag=0;
    for (Candidate temp : candidateList){
        if(temp.getName().equals(candidateName)){
            return false;
        }
    }
    if(!candidateName.equals(receptionistName) && !candidateName.equals(interviewerName)) {
        return true;
    }
    return false;
    }

    public boolean removeCandidate(int id) {
    for (Candidate temp: candidateList){
        if(temp.getId()==id){
            candidateList.remove(temp);
            candidateQueue.remove(temp);
            return true;
        }
    }
    return false;
    }

    public List viewAllCandidate() {
         return candidateList;
    }

    public boolean setCandidateCredential(Credential credential) {
    credentialList.add(credential);
    writeCredentialList(credentialList);
    return true;
    }
    private void writeCredentialList(List<Credential> credentialList) {

        File file=new File(filePathCredentialList);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, credentialList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queue<Candidate> getCandidateQueue() {
    return candidateQueue;
    }

    public void setInterviewerStatus(Interviewerstaus interviewerstaus) {

        interviewerstausList.add(interviewerstaus);
        writeInterviewStatus(interviewerstausList);
    }
    private void writeInterviewStatus(List<Interviewerstaus> interviewerstaus) {

        File file=new File(filepathInterviewStatus);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(file, interviewerstaus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkAdminPassword(String password) {
    return adminPassword.equals(password);
    }

    public boolean checkAdminName(String userName) {
    return adminName.equals(userName);
    }

    public List getInterviewUpdate() {
    return interviewerstausList;
    }

    public boolean checkUserName(String userName, String password) {
    for (Credential temp :credentialList){
        if(temp.getName().equals(userName) && temp.getPassword().equals(password)){
            return true;
        }
    }
    return false;

    }
    public Candidate getCandidateInstance(String userName) {
    Candidate candidate=null;
        for (Candidate temp :candidateList){
            if(temp.getName().equals(userName)){
                candidate=temp;
            }
        }
        return candidate;

    }
}

