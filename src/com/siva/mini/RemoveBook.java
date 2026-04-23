package com.siva.mini; 
import java.sql.*;

public class RemoveBook { 
    String bookName;
    public RemoveBook(String bookName){
        this.bookName=bookName;

    }
    public void removeBook(){
        String query="Delete from BookInformation where bookTitle=?";
        
        try {
             Connection con= DB.DbConnection();
             PreparedStatement pst=con.prepareStatement(query); 
             pst.setString(1,bookName);
             pst.executeUpdate();

             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
