/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class chứa các phương thức xử lý của chương trình

public class BookList {

    List<Book> myBooks = new ArrayList<>();
    
    Scanner in = new Scanner(System.in);
    
    //Phương thức thêm sách vào thư viện
    public void add(){
        System.out.println("Enter information for the new book: ");
        
        System.out.println("ID: ");
        String id = in.nextLine();
        
        System.out.println("Title: ");
        String title = in.nextLine();
        
        System.out.println("Author: ");
        String author = in.nextLine();
        
        System.out.println("Is borrow (1 = yes, 0 = no): ");
        int choice = Integer.parseInt(in.nextLine());
        boolean isBorrowed = false;
        switch (choice){
            case 1:
                isBorrowed = true;
                break;
            case 0:
                isBorrowed = false;
                break;
        }
        addToList(id, title, author, isBorrowed);
        System.out.println("A new book has been added");
    }

    public void addToList(String id, String title, String author, Boolean isBorrowed){
        Book book = new Book(id, title, author, isBorrowed);
        myBooks.add(book);
    }
    
    //Phương thức tìm kiếm sách theo Title
    List<Book> booksFound = new ArrayList<>();
    public void search(){
        if (myBooks.isEmpty()){
            System.out.println("There are no books in the library, please add books.");
        }
        else{
            booksFound.clear();
            System.out.println("Enter title to search : ");
            String title = in.nextLine();
            for (Book book : myBooks){
                if (book.getTitle().equals(title)){
                    booksFound.add(book);
                }
            }
            if (booksFound.isEmpty()){
                System.out.println("No book is found");
            } else{
                System.out.println(String.format("%-10s%-20s%-20s%-20s", "Id", "Title", "Author", "IsBorrowed"));
                for (Book book : booksFound){
                    System.out.println(book.toString());
                }
            }
        }
    }
    
    //Phương thức hiển thị toàn bộ thông tin sách
    public void display(){
        if (myBooks.isEmpty()){
            System.out.println("There are no books in the library");
        } else{
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "Id", "Title", "Author", "IsBorrowed"));
            for (Book book : myBooks){
                System.out.println(book.toString());
            }
        }
    }
    
    //Phương thức mượn sách theo ID
    public void borrow(){
        if (myBooks.isEmpty()){
            System.out.println("There are no books in the library, please add books.");
        }
        else{
            System.out.println("Enter id to borrow : ");
            String id = in.nextLine();
            for (Book aBook : myBooks){
                if (aBook.getId().equals(id)){
                    if (aBook.getBorrowed()){
                        System.out.println("You can not borrow this book. The book has been borrowed");
                    } else{
                        aBook.setBorrowed(true);
                        System.out.println("You have succesfully borrow the book : " + aBook.getId());
                    }
                }
            }
        }
    }
    
    //Phương thức dừng lại chương trình
    public boolean exit(){
        return false;
    }
}
