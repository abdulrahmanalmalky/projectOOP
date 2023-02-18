package com.mycompany.bookshop2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Book {
    static ArrayList<Book> bookList = new ArrayList();
    private String name;
    private String author;
    private double price;

    Book(){

    }

    public Book(String name , String author , double price){
       this.name = name ;
       this.author = author;
       this.price = price;  
    }

    public void setName(String name){
        this.name = name ;
    }
    
    public String getName(){
        return name ;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getAuthor(){
        return author ;
    }

    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    
/*This method receives a name and then searches whether there is a book
in the array with that name or not */
    public static Book getBook(String name){
        for (Iterator<Book> it = bookList.iterator(); it.hasNext();) {
            Book book = it.next();
            if(book.name.equals(name)){
                return book;
            }
        }
        return null;
    }

    /* This method works to update books */
    public static boolean updateBook(Book newBook , Book oldBook){
       if(Book.bookList.size() > 0) {
           int index = -5;
           int i = 0;
           while (i < Book.bookList.size()){
               if (Book.bookList.get(i).getName().equals(oldBook.getName())){
                   index = i;
                   i++;
                   break;
               }
           }
           
           if(index != -5){
                Book.bookList.get(index).setName(newBook.getName());
                Book.bookList.get(index).setAuthor(newBook.getAuthor());
                Book.bookList.get(index).setPrice(newBook.getPrice());
                return true ;
           }
       }
       return false;
    }
/* This method displays the edit menu */
     public static void  updateBooks (){
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("******* update Menu *******");
            System.out.println("1 - update Book name");
            System.out.println("2 - update Book author");
            System.out.println("3 - update Book price");
            System.out.println("4 - back to previous menu ");
            System.out.println("5 - Exit ");
            System.out.println("Enter your choice : ");

            choice = input.nextInt();
            if(choice == 1){
                System.out.print("Enter book name : "); // Test
                String bookName = input.next();
                Book Old = Book.getBook(bookName);
                Book New = Book.getBook(bookName);

                if(Old == null){
                    System.out.println("This book is not found");
                } else { 
                    System.out.println("Enter book new name : "); // Prime
                    String newName = input.next();
                    New.setName(newName);
                    if(Book.updateBook(New, Old)){
                        System.out.println("The modification has been completed");
                    } else {
                       System.out.println("The modification failed"); 
                    }
                }
            } else if(choice == 2){
                System.out.println("Enter book name : ");
                String bookName = input.next();
                Book Old = Book.getBook(bookName);
                Book New = Book.getBook(bookName);
                if(Old == null){
                    System.out.println("This book is not found");
                } else { 
                    System.out.println("Enter book new Author : ");
                    String newAuthor = input.next();
                    New.setAuthor(newAuthor);
                    if (Book.updateBook(New, Old)){
                        System.out.println("The modification has been completed");
                    } else {
                       System.out.println("The modification failed"); 
                    }
                } 
            } else if(choice == 3){
                System.out.println("Enter book name : ");
                String bookName = input.next();
                Book Old = Book.getBook(bookName);
                Book New = Book.getBook(bookName);
                if(Old == null){
                    System.out.println(" This book is not found ");
                } else { 
                    System.out.println(" Enter book new price : ");
                    double newprice = input.nextDouble();
                    New.setPrice(newprice);
                    if(Book.updateBook(New, Old)){
                        System.out.println("The modification has been completed");
                    } else {
                       System.out.println("The modification failed"); 
                    }
                 } 
            } else if(choice == 4){
                Bookshop2 bs = new Bookshop2();
               
            } else if(choice == 5){
                exit();
            } else {
                System.out.println("Wrong selection, please choose (1-5) only.");
            }
        }
        while(choice != 4);
    } 

    public static void exit(){
        System.exit(0);
    }
    
    
}
