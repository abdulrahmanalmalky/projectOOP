package com.mycompany.bookshop2;


import java.util.Scanner;
public class Bookshop2 {

    public static void main(String[] args) {
        Library date = new Library(02,02,2030);
        date.setmonth(date.getmonth());
        date.setday(date.getday());
        date.setyear(date.getyear());

        date.displayDate();

        int choiceNumber;
        Scanner input = new Scanner(System.in); 
        do{
            System.out.println("******* Menu *******");
            System.out.println("1 - Display all Book");
            System.out.println("2 - Add Book ");
            System.out.println("3 - Update Book ");
            System.out.println("4 - Delete Book ");
            System.out.println("5 - Exit ");
            System.out.print("Enter your choice : ");

            choiceNumber = input.nextInt();
            switch (choiceNumber) {
               case 1:
                    Library.displayAllBook();
                    break;
                case 2:
                    Library.AddBook();
                    break;
                case 3:
                    Book.updateBooks();
                    break;
                case 4:
                    Library.display();
                    break;
                case 5:
                    break;
            }
        }
        while(choiceNumber != 5);
    }
}

