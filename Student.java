import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Student {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
        ResultSet  rs = null;

      try {
    	  sc=new Scanner(System.in);
    	  int no=0;
    	  String name=null;
		  int rollno=0;
    	
    	  if(sc!=null) {
    		  System.out.println("Enter Student Roll number::");
    		  no=sc.nextInt(); // gives 101
    		  System.out.println("Enter Student Name::");
    		   name=sc.next(); //gives raja
    		  
    	  }//if
    	 
    	  name="'"+name+"'"; //gives 'raja'
    	 
    	 //Load jdbc driver
    	  //Establish the connection
    	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"  ,"SCOTT",  "16296");
    	    //CreateStatement object
    	    if(con!=null)
    	    	st=con.createStatement();
    	    //prepare SQL query
    	     
    	       String query="INSERT INTO STUDENT VALUES("+no+","+name+")";
    	       System.out.println(query);
    	       
    	       //send and execute SQL query in Db s/w
    	       int count=0;
    	       if(st!=null)
    	    	   count=st.executeUpdate(query);
    	       
    	       //process the results
    	       if(count==0)
    	    	     System.out.println("record not inserted");
    	       else
    	    	   System.out.println("record inserted");


                 System.out.println("Enter Student Roll_no who want to Retrieve Record :");
                 rollno=sc.nextInt();
                 
              String query1 = "SELECT ROLL_NO ,NAME FROM STUDENT WHERE ROLL_NO="+rollno;
			  if (st!=null)
			  rs= st.executeQuery(query1);
			  boolean flag=false;
			  if(rs!=null) {
				 
				while(rs.next()) {
					
					flag=true;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
				} 
	          }
			  if(flag=false)
				System.out.println("NO RECORD FOUND ");
			  else
				System.out.println(" RECORD FOUND ");
			 
		   
                     





         }//try
         catch(SQLException se) {  
        	   se.printStackTrace();
         }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
        finally {
        	//close jdbc objs
        	try {
        	if(st!=null)
        		st.close();
        	}
        	catch(SQLException se) {
        		se.printStackTrace();
        	}
        	
        	try {
            	if(con!=null)
            		con.close();
            	}
            	catch(SQLException se) {
            		se.printStackTrace();
            	}
        	
        	try {
            	if(sc!=null)
            		sc.close();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        	
        }//finally

	}//main
}//class
