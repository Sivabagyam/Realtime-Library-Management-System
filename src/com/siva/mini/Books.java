package com.siva.mini;
import java.util.*;
import java.sql.*;

 public class Books{ 
   private int id;
   private  String title; 
   private  String author; 
   private int capacity;
     Books(int id,String title,String author,int capacity )
     { 
      this.id=id;
      this.title=title;
      this.author=author;
      this.capacity=capacity;
     }
            
    public int getId() {
      return id;
    }

     public String getTitle() {
       return title;
     }

     public String getAuthor() {
       return author;
     }

     public int getCapacity() {
       return capacity;
     }

    public  String toString(){
    return title+" "+author+" "+capacity;
                }
         }
    

