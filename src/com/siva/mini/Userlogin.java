package com.siva.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Userlogin {
    public static void login(){
    Scanner scan=new Scanner(System.in);
       System.out.println("Enter your Id:");
       int id=scan.nextInt();
       System.out.println("Enter Your Member name:");
       scan.nextLine();
       String name=scan.nextLine();
       System.out.println("Enter the Member email:");
       String email=scan.nextLine();
      String query="select Memberid,Membername,Memberemail from MemberInformation where Memberid=? AND Membername=? AND Memberemail=?";
     try(
        Connection con=DB.DbConnection();
        
        PreparedStatement pst=con.prepareStatement(query);
        
     ){ 
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,email);
        ResultSet rs=pst.executeQuery();
        if(rs.next()) {
           System.out.println("Login Successful!");
            System.out.println("If you want to fetch book please enter 1 to Continue and if u want to return the book please enter 2 to continue");
            int option=scan.nextInt();
            if(option==1){
            BookIssuance books=new BookIssuance(name,email);
            books.bookIssuing();
            }
            else if(option==2){
               scan.nextLine();
               System.out.println("Tell me the name of the book that u want to  return");
               String returnBook=scan.nextLine();
            
            
              LocalDate ReturnDate=LocalDate.now();
              BookReturn cal=new BookReturn(name,email,returnBook);
              cal.bookReturn(ReturnDate);

            }
          
            }
            
               
    
}
      catch(SQLException e){
        e.printStackTrace();
        
        
     }

 //close the resources here
 finally

  {
    scan.close();
  }
   
}
}