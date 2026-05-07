package com.siva.mini;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

public class BookIssuance {
    String name;
    String email;
    public BookIssuance(String name,String email){
        this.name=name;
        this.email=email;

    }
    public void bookIssuing(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Please tell the book name that u want to fetch from the library");
        String bookName=scan.nextLine();
        String query="select * from BookInformation where bookTitle=?";
        String query1="Update BookInformation set bookCapacity=? where bookTitle=?";
        String query2="insert into IssuedBookInformation values(?,?,?,?,?,?)";
        try {
          Connection con=DB.DbConnection();  
          PreparedStatement pst= con.prepareStatement(query);
          pst.setString(1,bookName);
          ResultSet rs=pst.executeQuery();
          if(rs.next()&&rs.getInt(1)>0){
                int Capacity =rs.getInt(1);
               System.out.println("The book is available now .if you want to fetch please enter yes to continue and enter no to exit");
                String choice=scan.nextLine();
                if(choice.equalsIgnoreCase("yes")){
                    System.out.println("You successfully fetched a book from the library and your return time is one week if the time limit exceeded the fine amount will be rupees.10 per day and long term fine will result in canceling your membership");
                    --Capacity;
                    PreparedStatement pst1=con.prepareStatement(query1);
                   pst1.setInt(1,Capacity);
                   pst1.setString(2,bookName);
                   pst1.executeUpdate();
                   PreparedStatement pst2=con.prepareStatement(query2);
                   pst2.setString(1,name);
                   pst2.setString(2,email);
                   pst2.setString(3,bookName);
                  LocalDate issuedDate =LocalDate.now();
                  LocalDate returnDate=issuedDate.plusDays(1);
                  pst2.setDate(4,java.sql.Date.valueOf(issuedDate)); 
                  pst2.setDate(5,java.sql.Date.valueOf(returnDate));
                 int initial_fine=0; 
                  pst2.setInt(6,initial_fine);
                  pst2.executeUpdate();
                   
                  
                }
                
                 
          }
          else{
              System.out.println("The book that you want to fetch is not available right now");
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
        

    }

