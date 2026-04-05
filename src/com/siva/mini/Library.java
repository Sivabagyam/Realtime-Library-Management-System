package com.siva.mini;

import java.sql.SQLException;
import java.util.Scanner;

public class Library  {
        public static void main(String[] args) {
         final int AdminPassword=12334; 
         System.out.println("Please enter your Admin password:"); 
        Scanner scan =new Scanner(System.in); 

         int n=scan.nextInt(); 
        
         if(n==AdminPassword){ 
            System.out.println("Do u want to add books then enter 1");
            System.out.println("Do u want to check book availability enter 2"); 
            System.out.println("Do u want add members to the library community enter 3");
            System.out.println("Do u want to verify the library members enter 4"); 
           int a=scan.nextInt();
         if(a==1){
            System.out.println("Enter the id of the book");
            int id=scan.nextInt();
            scan.nextLine();
            System.out.println("Enter the Title of the Book");
            String title=scan.nextLine();
            System.out.println("Enter the Author of the book");
            String author=scan.nextLine();
            System.out.println("Enter the Capacity of the book");
            int capacity=scan.nextInt();
            Books bk=new Books(id,title,author,capacity);
             BooksDb booksdata=new BooksDb();
             booksdata.insertBook(bk);
             
         }
         else if(a==2){
            BooksDb b1=new BooksDb();
            b1.Bookinfo();
             }
         else if(a==3){
            System.out.println("Enter the  Name:");
            String name=scan.nextLine();
            System.out.println("Enter the Email: ");
            String email=scan.nextLine();
            System.out.println("Enter Your Current Location");
             String address=scan.nextLine();
            Members mem=new Members(name,email,address);
               MembersDb.insertMember(mem);
               }
            else if(a==4){
              Verify.verifyUser();
      
            }
  
           else{
            System.out.println("please select one of Correct Options to continue");
           }
    
    }
    else{
      System.out.println("Wrong Admin Password ! Try again");
    }


    scan.close();
    }
   
}
