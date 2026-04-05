package com.siva.mini;
import java.util.*;

public class Members {
       private String name;
       private String email;
       private String address;
    
    public String getName() {
        return name;
    }

       public String getEmail() {
           return email;
       }

       public String getAddress() {
           return address;
       }

    Members(String name,String email,String address){
        this.name=name;
        this.email=email;
        this.address=address;
        
    }
    
    
}
