package com.siva.mini;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.*;

public class BookReturn {
    String name;
    String email;
    String returnBook;
    public BookReturn(String name,String email,String returnBook){
        this.name=name;
        this.email=email;
        this.returnBook=returnBook;

    }
    public void bookReturn(LocalDate actualreturnDate){
        try {
            Connection con= DB.DbConnection();
       String query="select returnDate from IssuedBookInformation where membername=? and memberemail=?";
       String query1="update issuedbookInformation set fine=? where memberemail=?";
       String query3="select bookCapacity from BookInformation where bookTitle=?";
       String query2="update BookInformation set bookCapacity=? where bookTitle=? ";
       PreparedStatement st=con.prepareStatement(query);
       PreparedStatement pst=con.prepareStatement(query1);
       PreparedStatement pst0=con.prepareStatement(query3);
       PreparedStatement pst1=con.prepareStatement(query2);
       st.setString(1,name);
       st.setString(2,email);
      
      ResultSet rs= st.executeQuery();
      if(rs.next()){

          LocalDate returnDate=rs.getDate(1).toLocalDate();
          if(actualreturnDate.isAfter(returnDate)){
            long daysLate= ChronoUnit.DAYS.between(returnDate, actualreturnDate);
            long fine1=daysLate*10;
            System.out.println("You exceeded the time limit please pay "+fine1+" to return the book");
             pst.setLong(1,fine1);
                pst.setString(2,email);
                pst.executeUpdate();
           
            }
            else{
                System.out.println("book returned on time.");
                pst0.setString(1,returnBook);
               ResultSet rs1= pst0.executeQuery();
                    if(rs1.next()){
                        int capacity=rs1.getInt(1);
                        capacity++;
                        pst1.setInt(1,capacity);
                        pst1.setString(2,returnBook);
                        pst1.executeUpdate();
                        System.out.println("Capacity updated");
                    }


            }
        }
            else {
               
               System.out.println("Something went wrong");
                }
               
            
            
          }

      
            
         catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
    

