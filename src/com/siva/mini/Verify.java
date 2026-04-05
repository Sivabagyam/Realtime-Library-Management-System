package com.siva.mini;
import java.util.*;
import java.sql.*;

public class Verify{
    public static void verifyUser(){
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
           rs.getInt(1);
           rs.getString(2);
           rs.getString(3);
           System.out.println("Member Verification Successful");
            }
            else{
               System.out.println("Member verification failed");
            }
    
}
      catch(SQLException e){
        e.printStackTrace();
     }

 scan.close();
    
}
}
