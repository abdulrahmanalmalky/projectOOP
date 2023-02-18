package com.mycompany.bookshop2;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {
    private int month;
    private int day;
    private int year;
    
    Library(int month, int day, int year){ 
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void setmonth(int month){
        this.month = month;
    }
    public int getmonth(){
        return month;
    }

    public void setday(int day){
        this.day = day;
    }
    public int getday(){
        return day;
    }
    
    public void setyear(int year){
        this.year = year;
    }
    
    public int getyear(){
        return year;
    }
    
    
    /*this Method works to print the date of establishment of the library*/
    public void displayDate(){
        System.out.println("Abdulrahman Library and it was established in Date: " + month +"/"+day+"/"+year);
    }
    
    
    /* This method prints all books in the array */
    public static void displayAllBook(){
        ArrayList<Book>listBook = Book.bookList ;
        if (listBook == null) {
            System.out.println("There is no books.");
        } else {
            for (Iterator<Book> it = Book.bookList.iterator(); it.hasNext();){
                Book book = it.next();
                System.out.println("Name: " + book.getName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
                System.out.println(" ");
            }
        }  
    }
    
    
    /* This method works to add books */
    public static void AddBook(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the count of book : ");
        int countBook = input.nextInt();
        if (countBook <= 0){
            System.out.println("Count must be one or more.");
        } else {
            int i = 0;
            while (i < countBook) {
                System.out.println("Enter Book " + (i+1) + " name");
                String nameBook = input.next();
                
                System.out.println("Enter Book " + (i+1) + " author"); 
                String authorBook = input.next();
                
                System.out.println("Enter Book " + (i+1) + " price");
                double priceBook = input.nextDouble();
                
                Book book = new Book();
                book.setName(nameBook);
                book.setAuthor(authorBook);
                book.setPrice(priceBook);
                Book.bookList.add(book);
                i++;
            }
        }
    }
    
    /* This method removes books */
    public static boolean deleteBook(Book book) { // Test
        if(Book.bookList == null) {
            return false ;
        } else {
            Book.bookList.remove(book);
            return true ;
        }
    }
    
    
    /* This method prints explanatory sentences about removing the book */
    public static void display(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name Book ");
                    String bookName = input.next();
                    Book book = Book.getBook(bookName); // Test
                    if (book == null) {
                        System.out.println("no book founded");
                    }else{
                        if(Library.deleteBook(book)){
                            System.out.println(" successfully");
                        }else{
                           System.out.println(" failed"); 
                        }
     }
    }
}

