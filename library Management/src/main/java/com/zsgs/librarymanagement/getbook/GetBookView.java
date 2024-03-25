package com.zsgs.librarymanagement.getbook;

import com.zsgs.librarymanagement.books.BookView;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GetBookView {
    private GetBookModel getBookModel;
    public GetBookView(){
        getBookModel=new GetBookModel(this);

    }
    public void init(User user){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user Id : " +user.getUserId());

            if (getBookModel.getBookUserIdIsAvailable(user.getUserId())) {
                sc.nextLine();
                new BookView().searchBook();
                System.out.println("Enter Book Id : ");
                int bookId = sc.nextInt();
                if (getBookModel.checkBookCount(bookId)) {
                    if (getBookModel.checkUserBookCount(user.getUserId())) {
                        getBookModel.addGetBook(user.getUserId(), bookId);
                        System.out.println("A Book is a gift you can open again and again !..");
                        System.out.println("-----Thank you------");
                    } else {
                        System.out.println("your book Limit is exceeded ");
                    }
                } else {
                    System.out.println("Book not available !...");
                }
            } else {
                System.out.println("User Id not available open new account .....");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input ....");
            init(user);
        }

    }
    public void returnBook(User user){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the userId : "+user.getUserId());
            int userId = user.getUserId();
            System.out.println("Enter the Book Id : ");
            int bookId = sc.nextInt();
            if(getBookModel.checkReturnBookDetails(userId, bookId)){
                System.out.println("Book return successful.....");
                System.out.println("----Thank you----");
            }else {
                System.out.println("Invalid UserId or Book Id ");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input ....");
            returnBook(user);
        }
    }

}
