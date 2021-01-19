
package asm3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Manager {

 public static void main(String[] args) {
     BookList BookList = new BookList();          
     boolean process = true;
     Scanner in = new Scanner(System.in);
     while(process){
         System.out.println("Welcome to Library Manager System !!!!!!!");
         System.out.println("========================");
         System.out.println("1. Enter a new book");
         System.out.println("2. Search a book by title");
         System.out.println("3. Display books");
         System.out.println("4. Borrow a book by book id");
         System.out.println("5. Exit");
         System.out.print("Your choice: ");
         int choice = in.nextInt();
         System.out.println("========================");
         switch (choice){
             case 1 :
                 BookList.add();
                 break;
             case 2 :
                 BookList.search();
                 break;
             case 3 :
                 BookList.display();
                 break;
             case 4 :
                 BookList.borrow();
                 break;
             case 5 :
                 process = BookList.exit();
                 break;
         }
     }     
    }
}
