package com.zsgs.librarymanagement.books;

import com.zsgs.librarymanagement.datalayer.LibraryDataBase;
import com.zsgs.librarymanagement.getbook.GetBookView;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.manageuserview.ManageUserView;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.validation.Validation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookView {
    private BookModel bookModel;
    static long id=1;
    private Scanner scanner;
    public BookView(){
        scanner=new Scanner(System.in);

        bookModel=new BookModel(this);
    }
    public void init(){
        try {
        int availablity, volume,edition;
        System.out.println("Enter the book name : ");
        String bookName = scanner.nextLine();

        System.out.println("Enter author name : ");
        String authorName=scanner.nextLine();
        if (new Validation().nameChecker(authorName)) {

            System.out.println("Enter the publication (Year) : ");
            int publication = scanner.nextInt();

            System.out.println("Enter the bookId : " + id);
            long bookId = id;
            System.out.println("Enter the Edition : ");
            edition = scanner.nextInt();

            System.out.println("Book Availability :");
            availablity = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the book volume : ");
            volume = scanner.nextInt();
            bookModel.setBookDetails(bookName, authorName, publication, bookId, edition, availablity, volume);
            id++;
        }else {
            System.out.println("Invalid Name ...");
            init();
        }

    }catch (InputMismatchException e){
            System.out.println("Invalid Input !..");
            scanner.nextLine();
            init();
        }

    }
    public void updateBook (){
        try {
        System.out.println("Enter the book Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if(bookModel.isAvailable(id)){
            //Book temp=bookModel.updateBook(id);
            System.out.println("update book edition : ");
            int edition=scanner.nextInt();
            //temp.setEdition(edition);
            System.out.println("update book availability :  ");
            int availability=scanner.nextInt();
            //temp.setAvailability(availability);
            //scanner.nextLine();
            System.out.println("update book volume : ");
            int volume=scanner.nextInt();
            //temp.setVolume(volume);
           // bookModel.addUpdateBook(temp);
            bookModel.updateBooks(id,edition,availability,volume);
            System.out.println("Book updated successfully ....!");

        }else{
            System.out.println("Invalid book ID !..");
        } }catch (InputMismatchException e){
            System.out.println("Invalid Input !..");
            updateBook();
        }
    }
    public void searchBook(){
        try {
            System.out.println("Enter book name : ");
            String bookName=scanner.nextLine();
        List<Book>searchBook=bookModel.searchBook(bookName);
        if(searchBook.isEmpty()){
            System.out.println("Book List is empty !..");
        }else {
            bookModel.printList(searchBook);
        } }catch (InputMismatchException e){
            System.out.println("Invalid Input !..");
            searchBook();
        }
    }
    public void removeBook(){
        try {
            System.out.println("Enter the book remove Id : ");
            int bookId = scanner.nextInt();
            if (bookModel.isAvailable(bookId)) {
                if (bookModel.removeBook(bookId)) {
                    System.out.println("Book removed successful !...");
                }
            } else {
                System.out.println("Invalid Book Id !..");
            }
        }catch (InputMismatchException e){
        System.out.println("Invalid Input !..");
        removeBook();
    }
    }
    public void viewAllBook(){
        try {

            List<Book> bookList = bookModel.getBookList();
            if (bookList.isEmpty()) {
                System.out.println("Book space is empty !");
            } else {
                bookModel.printList(bookList);
            }
        }catch (InputMismatchException e){
        System.out.println("Invalid Input !..");
        viewAllBook();
    }
    }
    private boolean checkForChoice() {
        System.out.println("Do you want to continue ? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            return true;
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thank you....");
            return false;
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForChoice();
        }
        return false;
    }
    public void userCredential(User user){
        int choice=0;

        while (true) {
            System.out.println("----User Home Page ----");
            System.out.println("\n1-> Search Book \n2-> View all Books  " +
                    " \n3-> GetBook \n4-> ReturnBook \n5-> Logout \n6-> Exit ");
            try {
                choice = scanner.nextInt();
                if (choice == 6) {
                    System.out.println("Exiting......");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch....");
                choice=0;
                scanner.nextLine();
                userCredential(user);

            }
            switch (choice) {
                case 1:
                    searchBook();
                    if (checkForChoice()) {
                        searchBook();
                    }
                    break;
                case 2:
                    viewAllBook();
                    if (checkForChoice()) {
                        viewAllBook();
                    }
                    break;
                case 3:
                    new GetBookView().init(user);
                    if (checkForChoice()) {
                        new GetBookView().init(user);
                    }
                    break;
                case 4:
                    new GetBookView().returnBook(user);
                    if (checkForChoice()) {
                        new GetBookView().returnBook(user);
                    }
                    break;
                case 5:
                    System.out.println("\n-- You are logged out successfully -- \n\n");
                    new LoginView().init();
                    break;
                default:
                    System.out.println("Invalid choice ! ");
            }
        }

    }
    private void manageBook() {
        int choice = 0;
        while (true) {
            try {
                System.out.println("----Manage Book Page ----");
                System.out.println("\n1-> Add Book  \n2-> Update Book \n3-> Search Book " +
                        "\n4-> Remove Book  \n5-> View All Book \n6-> Back ");
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch....");
                scanner.nextLine();
                manageBook();

            }
            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1:

                    init();
                    if (checkForChoice()) {
                        scanner.nextLine();
                        init();
                    }
                    break;
                case 2:
                    updateBook();
                    if (checkForChoice()) {
                        updateBook();
                    }
                    break;
                case 3:

                    searchBook();
                    if (checkForChoice()) {
                        searchBook();
                    }
                    break;
                case 4:
                    removeBook();
                    if (checkForChoice()) {
                        removeBook();
                    }
                    break;
                case 5:
                    viewAllBook();
                    if (checkForChoice()) {
                        viewAllBook();
                    }
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        }
    }

    public void bookSection() {
        int choice=0;
            while (true) {
                try {
                    System.out.println("----Admin Home Page ----");
                    System.out.println("\n1-> Manage Book  \n2-> Add User \n3-> Logout " +
                            "\n4-> Exit ");
                    choice = scanner.nextInt();

                }catch (InputMismatchException e){
                    System.out.println("Input Mismatch....");
                    scanner.nextLine();
                    bookSection();

                }
                    if (choice == 4) {
                        System.out.println("Thank You....!");
                        System.exit(0);
                        break;
                    }

                    switch (choice) {
                        case 1:
                            manageBook();
                            break;
                        case 2:
                            new ManageUserView().initAdd();
                            break;
                        case 3:
                            System.out.println("\n-- You are logged out successfully -- \n\n");
                            new LoginView().init();
                            break;
                        default:
                            System.out.println("Invalid choice ! ");
                    }

            }
    }

    }
