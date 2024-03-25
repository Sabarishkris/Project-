package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.books.BookModel;
import com.zsgs.librarymanagement.books.BookView;
import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Library;

public class LibrarySetupModel {
private LibrarySetupView librarySetupView;
private Library library;
    public LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView=librarySetupView;
        library=LibraryDataBase.getInstance().getLibrary();
    }

    public void setUp() {
        library=LibraryDataBase.getInstance().getLibrary();
        if(library==null || library.getId()==0){
            librarySetupView.inititate();
        }else{
            librarySetupView.onSetupCompleted();
        }
    }

    public void createLibrary(Library library) {
        boolean vaild=true;
        if(vaild){
            LibraryDataBase.getInstance().createInstance(library);
            LibraryDataBase.getInstance().writeData(library);
            librarySetupView.onSetupCompleted();
        }else{
            System.out.println("Invalid library data ! ");
        }
    }


    public void setLibraryDetails(Library library, String libraryName, int libraryId, long libraryPhoneNo, String libraryEmail, String libraryAddress) {
                       library.setName(libraryName);
                       library.setId(libraryId);
                        library.setPhone(libraryPhoneNo);
                        library.setEmailId(libraryEmail);
                        library.setAddress(libraryAddress);
                          createLibrary(library);
    }
}
