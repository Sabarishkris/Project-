package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.books.BookView;
import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.validation.Validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySetupView {
    private LibrarySetupModel librarySetupModel;
    private Library library;
    private Scanner sc;
    private Validation valid;
    static int id=1;
    public LibrarySetupView(){
        librarySetupModel=new LibrarySetupModel(this);
        library=new Library();
         valid=new Validation();
        sc=new Scanner(System.in);
    }
    public void init(){
        librarySetupModel.setUp();
    }


    public void showAlart() {
        System.out.println("\n print any error here ");
    }

    public void inititate() {
        try {
            System.out.println("Get library details here !");


            System.out.println("Enter the library name : ");
            String libraryName = sc.nextLine();
            if(new Validation().nameChecker(libraryName)) {

                System.out.println("Enter the Library Id : " + id);
                int libraryId = id;

                System.out.println("Enter Library phone no : ");
                long libraryPhoneNo = sc.nextLong();
                sc.nextLine();

                System.out.println("Enter Library Email : ");
                String libraryEmail = sc.nextLine();

                System.out.println("Enter library Address : ");
                String libraryAddress = sc.nextLine();
                if (valid.validMailId(libraryEmail)) {
                    if (valid.validPhoneNo(libraryPhoneNo)) {
                        librarySetupModel.setLibraryDetails(library,libraryName,libraryId,libraryPhoneNo,libraryEmail,libraryAddress);
//                        library.setName(libraryName);
//                        library.setId(libraryId);
//                        library.setPhone(libraryPhoneNo);
//                        library.setEmailId(libraryEmail);
//                        library.setAddress(libraryAddress);
//                        librarySetupModel.createLibrary(library);
                        id++;
                    } else {
                        System.out.println("Invalid Phone Number !...");
                        inititate();
                    }
                } else {
                    System.out.println("Invalid Email address !...");
                    inititate();
                }
            }else {
                System.out.println("Invalid Name ....");
                inititate();
            }

        }catch (InputMismatchException e){
            System.out.println("Invalid input !..");
            sc.nextLine();
            inititate();
        }
    }

    public void onSetupCompleted() {
        System.out.flush();
        System.out.println("\n Library setup already completed "+ "Library Name - > "+ LibraryDataBase.getInstance().getLibrary().getName() );
        new BookView().bookSection();
        }
    }
