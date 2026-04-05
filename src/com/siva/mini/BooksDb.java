package com.siva.mini;
import java.sql.*;


public class BooksDb {
    private  Connection con;
    public void insertBook(Books bk){
       int id=bk.getId();
       String title=bk.getTitle();
       String author=bk.getAuthor();
       int capacity=bk.getCapacity();
       try {
         con= DB.DbConnection();
    PreparedStatement pst=con.prepareStatement("Insert into BookInformation (bookId,bookTitle,bookAuthor,bookCapacity)values(?,?,?,?)");
    pst.setInt(1,id); 
    pst.setString(2,title);
    pst.setString(3,author);
    pst.setInt(4,capacity);
    pst.executeUpdate();
        
       } catch (SQLException e) {
          e.printStackTrace();
       }
        
    }
    public  void Bookinfo(){
        try{
        con=DB.DbConnection();
        String query="select * from BookInformation";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.print(rs.getInt(1)+" "); 
            System.out.print(rs.getString(2)+" ");
            System.out.print(rs.getString(3)+" ");
            System.out.print(rs.getInt(4));
        }
        st.close();
        rs.close();
        con.close(); 
    }
    catch(SQLException e){
        e.printStackTrace();
    }

       

    }
    
}
