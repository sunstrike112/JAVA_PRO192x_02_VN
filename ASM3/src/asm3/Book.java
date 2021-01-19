/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Class định nghĩa các biến, hàm tạo, ...

public class Book {
    private String id;
    private String title;
    private String author;   
    private boolean isBorrowed = false;
    
    public Book(String id, String title, String author, Boolean isBorrowed){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public boolean getBorrowed(){
        return isBorrowed;
    }
    
    public void setBorrowed(Boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }
    
    @Override
    public String toString(){
        return String.format("%-10s%-20s%-20s%-20s", id, title, author, isBorrowed);
    }
}
