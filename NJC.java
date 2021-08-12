package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class NJC {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
   static final String USER = "SCOTT";
   static final String PASS = "16296";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
     
	   		      
          String sql = "CREATE TABLE MOVIES " +
                   
                   "( Name VARCHAR(255), " +                                         //create Table Movies
                   " Actor VARCHAR(255), " +
		           " Actress VARCHAR(255),"+
                   " Director VARCHAR(255), " + 
                   " Year DATE      )"; 

         stmt.executeUpdate(sql);
         System.out.println("Created table in given database...");  
    
         
        

         // Execute a query
	 // insert record into table

         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO Movies VALUES (Border, 'Sunny Deol', 'Tabu', 'Jp Dutta',1997-06-13)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies VALUES (Ab Tumhare Hawale Watan Shathiyo , 'Akshay', 'Divya Khosla','Anil Sharma', 2004-10-24)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies VALUES (Bahubali, 'Prabhash', 'Anushka', 'RajaMauli',2015-06-15)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies VALUES(Kgf, 'Yash', 'Mouni Roy', 'Prasanth Neel',2021-09-09)";
         ResultSet rs=stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");

         //Retrieve Record from table

        

                 while(rs.next()) {    
                  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
                  }
	   }
         


	 catch (SQLException e) {
         e.printStackTrace();
         } 
      } 
   }
}