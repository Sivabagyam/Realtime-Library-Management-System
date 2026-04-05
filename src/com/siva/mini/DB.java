package com.siva.mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String  url="jdbc:mysql://localhost:3306/BookDetails";
    private static final String  userName="root";
    private  static final String Pass=System.getenv("DB_PASSWORD");
           
    public static Connection DbConnection()throws SQLException{
                  
            try {
                  
            Class.forName("com.mysql.cj.jdbc.Driver");     
                
            } 
            catch (Exception e) {
                System.out.println("There is a DataBase Connectivity Issue");
            }
            return DriverManager.getConnection(url,userName,Pass);
        }
    
}
