package com.zsgs.librarymanagement.getbook;

import com.zsgs.librarymanagement.books.BookView;
import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.manageuserview.ManageUserModel;
import com.zsgs.librarymanagement.manageuserview.ManageUserView;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.Getbook;

import java.util.List;

public class GetBookModel {
    private GetBookView getBookView;
    public GetBookModel(GetBookView getBookView) {
       this.getBookView=getBookView;
    }

    public boolean getBookUserIdIsAvailable(int userId) {
        if(LibraryDataBase.getInstance().userIdIsAvailable(userId)==false){
            return true;
        }else{
            return false;
        }
    }


    public boolean checkBookCount(int bookId) {
        return LibraryDataBase.getInstance().checkBookCount(bookId);
    }

    public boolean checkUserBookCount(int userId) {
        return LibraryDataBase.getInstance().checkUserGetBook(userId);

    }

    public void addGetBook(int userId, int bookId) {
       // System.out.println("userid : "+userId);
        Getbook getbook=new Getbook();
        getbook.setUserId(userId);
        getbook.setBookId(bookId);
        LibraryDataBase.getInstance().addGetBook(getbook);
        //LibraryDataBase.getInstance().displayGetBook();
    }

    public boolean checkReturnBookDetails(int userId, int bookId) {

        return LibraryDataBase.getInstance().checkReturnBookDetails(userId,bookId);
    }
}
