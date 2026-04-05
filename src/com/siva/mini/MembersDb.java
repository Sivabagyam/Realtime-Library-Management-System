package com.siva.mini;
import java.sql.*;

public class MembersDb {
    public static void insertMember(Members mem){
        
        String memberName=mem.getName();
        String memberEmail=mem.getEmail();
        String memberAddress=mem.getAddress();

        try{
       Connection con= DB.DbConnection();
       String query="insert into MemberInformation(Membername,Memberemail,Memberlocation) values(?,?,?)";
       PreparedStatement pst=con.prepareStatement(query);
    
       pst.setString(1,memberName);
       pst.setString(2,memberEmail);
       pst.setString(3,memberAddress);
       pst.executeUpdate();
       con.close();
        }

        catch(SQLException e){
            e.printStackTrace();
             
        }
        


    
    
}
}
