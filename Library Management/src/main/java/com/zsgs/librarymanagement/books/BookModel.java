package com.zsgs.librarymanagement.books;

import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.model.Book;

import java.util.List;

public class BookModel {

private  BookView bookView;
private LibraryDataBase libraryDataBase;

    public BookModel( BookView bookView) {
        this.bookView=bookView;
        this.libraryDataBase=LibraryDataBase.getInstance();
    }
    public void setBookDetails(String bookName, String authorName, int publication, long bookId, int edition, int availablity,int volume) {
   Book newBook=new Book();
    newBook.setName(bookName);
    newBook.setAuthor(authorName);
    newBook.setPublication(publication);
    newBook.setId(bookId);
    newBook.setEdition(edition);
    newBook.setAvailability(availablity);
   // newBook.setJourner(journer);
    newBook.setVolume(volume);
    libraryDataBase.insertBook(newBook);

    }

//    public Book updateBook(int n) {
//        return libraryDataBase.updateBook(n);
//    }

    public List<Book> searchBook(String bookName) {
        List<Book>searchBookList=libraryDataBase.searchBook(bookName);
        return searchBookList;
    }

    public boolean isAvailable(int id) {
        return libraryDataBase.isAvailble(id);
    }

    public void addUpdateBook(Book temp) {
        libraryDataBase.addUpdateBook(temp);
    }

    public void printList(List<Book> searchBook) {
        for (Book temp:searchBook){
            System.out.println("Book Name : "+temp.getName() );
            System.out.println("Book author name : "+temp.getAuthor());
            System.out.println("Book Id : "+temp.getId());
            System.out.println("Book edition : "+temp.getEdition());
            System.out.println("Book Availability : "+temp.getisAvailability());
            //System.out.println("Book journal : "+temp.getJourner());
            System.out.println("Book volume : "+temp.getVolume());
            System.out.println("*******************************************************************");
        }
    }

    public boolean removeBook(int n) {
        return libraryDataBase.removeBook( n);
    }

    public List<Book> getBookList() {
        return libraryDataBase.getBookList();
    }

    public void updateBooks(int id, int edition, int availability, int volume) {
        LibraryDataBase.getInstance().setBookUpdate(id,edition,availability,volume);
    }
}
