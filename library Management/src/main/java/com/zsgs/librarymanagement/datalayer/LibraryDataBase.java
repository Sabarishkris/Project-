package com.zsgs.librarymanagement.datalayer;
//import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zsgs.librarymanagement.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDataBase {
    String filePathLibrarySetup="Library.json";
    String filePathBook="Book.json";
    String filePathUser="User.json";
    String fileGetBook="GetBook.json";
    String fileCredential="Credential.json";
    private static LibraryDataBase libraryDataBase;
    private String adminName="zsgs";
    private String adminPassword="admin";
    private static List<Book>bookList=new ArrayList<>();
    private List<User>userList=new ArrayList<>();
    private List<Getbook>getbooksList=new ArrayList<>();
    private  Library library;
    private List<Credentials>userCredentialList=new ArrayList<>();
    public String getAdminName(){
        return adminName;
    }
    public String getAdminPassword(){
        return adminPassword;
    }
public void writeData(List<Book> bookList){
        File file=new File(filePathBook);
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
        objectMapper.writeValue(file, bookList);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void writeData(Library library){
        File file=new File(filePathLibrarySetup);
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
            objectMapper.writeValue(file, library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeUserData(List<User>userList){
        File file=new File(filePathUser);
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
            objectMapper.writeValue(file, userList);
            // System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCredential(List<Credentials>userCredentialList){
        File file=new File(fileCredential);

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
            objectMapper.writeValue(file, userCredentialList);
            // System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeGetBookData(List<Getbook>getbooksList){
        File file=new File(fileGetBook);
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
            objectMapper.writeValue(file, getbooksList);
            // System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static LibraryDataBase getInstance() {
        if(libraryDataBase==null){
            libraryDataBase=new LibraryDataBase();
        }
        return libraryDataBase;
    }
    public Library getLibrary(){
        return library;
    }

    public void createInstance(Library library) {
        this.library=library;
    }

    public void insertBook(Book newBook) {

        bookList.add(newBook);
        writeData(bookList);
        System.out.println("successfully Added !...");
    }

    public Book updateBook(long n) {
        Book updateBook=null;
        for(Book temp : bookList){
            if(n==temp.getId()){
                updateBook=temp;
                bookList.remove(temp);
                break;
            }
        }

        return updateBook;
    }

    public List<Book> searchBook(String bookName) {
        List<Book>searchBookList=new ArrayList<>();
        for (Book temp: bookList){
            if(temp.getName().charAt(0)==bookName.charAt(0)){
                searchBookList.add(temp);
            }
        }
        return searchBookList;

    }

    public boolean isAvailble(int id) {
        for(Book temp:bookList){
            if(temp.getId()==id){
                return true;
            }
        }
            return false;

    }

    public void addUpdateBook(Book temp) {
        bookList.add(temp);
    }

    public boolean removeBook(int id) {
        for(Book temp : bookList){
            if(id==temp.getId()){
                bookList.remove(temp);
                return true;
            }
        }
        return false;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean addUser(User user) {
        int flag=0;
        for (User temp:userList){
            if(temp.getEmailId().equals(user.getEmailId())|| temp.getUserId()==user.getUserId()){
                flag=1;
                return false;
            }
        }
        if(flag==0){
        userList.add(user);
        writeUserData(userList);
        return true;}
        return false;
    }

    public boolean userIdIsAvailable(int userId) {
        for (User temp: userList){
            if(temp.getUserId()==userId){
                return false;
            }
        }
        return true;
    }

    public boolean checkBookCount(int bookId) {
        for (Book temp:bookList){
            if(temp.getId()==bookId){
                if(temp.getisAvailability()>0){
                    int decreaseAvailablity= temp.getisAvailability();
                    temp.setAvailability(--decreaseAvailablity);
                    return true;
                }
            }
        }
        return false;
    }

    public void addGetBook(Getbook getbook) {
        getbooksList.add(getbook);
        writeGetBookData(getbooksList);
    }

    public boolean checkUserGetBook(int userId) {
        int count=0;
      for (Getbook temp: getbooksList){
          if(temp.getUserId()==userId){
              count++;
          }
      }
      if(count>3){
          return false;
      }
        return true;
    }

    public boolean checkReturnBookDetails(int userId, int bookId) {
        Getbook details=null;
        for (Getbook temp : getbooksList){
           // System.out.println("1");
            if(temp.getUserId()==userId && temp.getBookId()==bookId){
                details=temp;
                for(Book temp1 :bookList){
                    if(temp1.getId()==bookId){
                        int availability=temp1.getisAvailability();
                        temp1.setAvailability(++availability);
                        getbooksList.remove(details);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addUserCredential(String userName, String password) {
        Credentials credentials=new Credentials();
        credentials.setName(userName);
        credentials.setPassword(password);
        userCredentialList.add(credentials);
        writeCredential(userCredentialList);
    }

    public boolean checkUserCredential(String userName, String password) {
//        System.out.println(userName + " "+password);
        for (Credentials temp:userCredentialList){
            if(temp.getName().equals(userName) && temp.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUserInstance(String userName, String password) {
        User user=null;
        for (User temp:userList){
            if(temp.getUserName().equals(userName)){
                user=temp;
            }
        }
        return user;
    }
}
