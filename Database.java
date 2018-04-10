//package lab7in;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class Database
//{
//  private Connection conn;
//  //Add any other data fields you like – at least a Connection object is mandatory
//  public Database()
//  {
//    //Add your code here
//	//Read properties file
//	Properties prop = new Properties();
//	FileInputStream fis = null;    
//	try{
//		fis = new FileInputStream("lab7in/db.properties");
//	} catch(FileNotFoundException e){
//		e.printStackTrace();
//	}
//	
//	try{
//		prop.load(fis);
//	} catch (IOException e){
//		e.printStackTrace();
//	}
//	String url = prop.getProperty("url");
//	String user = prop.getProperty("user");
//	String pass = prop.getProperty("password");
//	
//	try{
//		//Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager.getConnection(url, user, pass);
//	} catch (SQLException e){
//	      e.printStackTrace();
//	}
//  }
//  
//  public ArrayList<String> query(String query)
//  {
//	    ResultSet rs = null;
//	    ResultSetMetaData rmd;
//    //Add your code here
//	try{
//		//Create a statement
//	     Statement stmt = conn.createStatement();
//	    
//	    //1 Take the input parameter query and use it executeQuery()
//	    rs = stmt.executeQuery(query);
//	    //2 Take the resultSet and extract each column in each row
//	    //Get metadata about the query
//	    rmd = rs.getMetaData();
//	    int column_no = 0;
//	    //3 Create a String from the columns - concatenate to create a comma delimited String field1,field2,..field3
//	    String cols = rmd.getColumnName(column_no);
//	    //4 Store each String in the ArrayList
//	    while(rs.next()) 
//	      {
//	        query = rs.getString(cols);
//	      }
//	    //5 Return the ArrayList containing the Strings or null if no data found
//	  System.out.print(query);
//	} catch (SQLException e){
//		e.printStackTrace();
//	}
//	
//	if(rs.toString().isEmpty())
//	{
//		return null;
//	}
//	  return null;
//	
//  }
//  
//  public boolean executeDML(String dml)
//  {
//    //Add your code here
//	// Use execute instead of executeQuery
//	// No result set
//	return true;
//  }
//  
//}
//
//
//
//
//





package bodyByNumberz;


import java.sql.*;
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


public class Database
{
	private ArrayList<String> username = new ArrayList<String>();
	private ArrayList<String> password = new ArrayList<String>();
  private Connection conn;
  private ArrayList<Food> food; 
  //Add any other data fields you like – at least a Connection object is mandatory
  public Database()
  {
    //Add your code here
	  //read from the properties named db.properties
	  //Create Connection
	  //Read properties file
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("try hard");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	    Properties prop = new Properties();
	    
	    FileInputStream fis = null;
	   
	    //food = new ArrayList();
	    try {
	    	
	    	fis = new FileInputStream("bodyByNumberz/db.properties");
	    	 
	    	
	    } catch (IOException e){
	    	System.out.println(e);
	    }
	    try {
	    	prop.load(fis);
	    } catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    System.out.println("Gets here");
	    String url = prop.getProperty("url");
	    String user = prop.getProperty("user");
	    String pass = prop.getProperty("password"); 
	    try
	    {
	    	 System.out.println("Gets here too");
	      //Read the connection properties as Strings
	    	 System.out.println(url);
	      
	      //Perform the Connection
      conn = DriverManager.getConnection(url,user,pass);
     // food = getFoodData();
	    } catch (SQLException sql) {
	    	 System.out.println("Gets error");
	    	System.out.println(sql);
	    }
	    System.out.println("Gets here");
  }
  
  public ArrayList<Food> getFood(){
	  return food;
  }
  
  public ArrayList getFoodData(){
	  ArrayList<Food> foodD = new ArrayList();
	  try {
			 Statement stmt = conn.createStatement();
			  // Dynamically 
			  //take the input parameter query and ue in execute query()
			  //2. take the results set and extract(parse) each column in each row
			 ResultSet rs;
			 System.out.println("its me3");
			 rs=stmt.executeQuery("select * from food");  
			  //create a string from the columns - concatnate to create a comma
			  // delimited string field1, field2,...field3
			 ResultSetMetaData rmd;
			 rmd = rs.getMetaData();
			 int no_columns = rmd.getColumnCount();
			  //store each string in the array list
			int i = 1;
			 while(rs.next()) 
		      {
				
		        String foodName = rs.getString(1);
		     int fat = Integer.parseInt(rs.getString(2));
		        int carbs = Integer.parseInt(rs.getString(3));
		       int protein = Integer.parseInt(rs.getString(4));
		    Food tmpFood = new Food(foodName, new Nutrition(fat,carbs,protein));
		        foodD.add(tmpFood);
		      }
		      
			  //return the arraylist containing the strings or null if no data found
			  
		  }catch (SQLException sql) {
			  System.out.println(sql);
		  }
		 
	  
	  
	  return foodD;
  }

  public ArrayList getUserPass(String query) {
	  ArrayList queryString = new ArrayList<String>();
	  try {
			 Statement stmt = conn.createStatement();
			  // Dynamically 
			  //take the input parameter query and ue in execute query()
			  //2. take the results set and extract(parse) each column in each row
			 ResultSet rs;
			 System.out.println("its me3");
			 rs=stmt.executeQuery("select '"
			 		+ query +"' , aes_decrypt(password,'key') "
			 				+ " from bbn_users");  
			  //create a string from the columns - concatnate to create a comma
			  // delimited string field1, field2,...field3
			 ResultSetMetaData rmd;
			 rmd = rs.getMetaData();
			 int no_columns = rmd.getColumnCount();
			  //store each string in the array list
			int i = 1;
			 while(rs.next()) 
		      {
				
		        System.out.println("all");
		    
		        queryString.add(rs.getString(i));
		      }
		      
			  //return the arraylist containing the strings or null if no data found
			  
		  }catch (SQLException sql) {
			  System.out.println(sql);
		  }
		  if(queryString.size() > 0)
			  return queryString;
	  return null;
  }
  public String getUserTable(String user)
  {
	  int no_columns = 0;
	 
	  ArrayList queryString = new ArrayList<String>();
	  try {
		 Statement stmt = conn.createStatement();
		  // Dynamically 
		  //take the input parameter query and ue in execute query()
		  //2. take the results set and extract(parse) each column in each row
		 ResultSet rs;
		 System.out.println("its me4");
//		 rs=stmt.executeQuery("select username, sex, age, weight"
//		 		+ ", goal , goal_weight,"
//		 		+ "height, activity_level from bbn_users where username = '"+user+"'");  
		 rs=stmt.executeQuery("select * from bbn_users where username = '"+user+"'"); 
		  //create a string from the columns - concatnate to create a comma
		  // delimited string field1, field2,...field3
		 ResultSetMetaData rmd;
		 rmd = rs.getMetaData();
		  no_columns = rmd.getColumnCount();
		 String result = "";
		 int i = 1;
		 
		while(rs.next()){
		  //store each string in the array list
			queryString.add(rs.getString(i));
		 result = rs.getString(1) +  "," +
				 rs.getString(3) + "," + rs.getString(4) + "," +
				 rs.getString(5) + "," + rs.getString(6) + "," +
				 rs.getString(7) + "," + rs.getString(8) + "," +
				 rs.getString(9) + "," + rs.getString(10) + "," +
				 rs.getString(11);
		 
		}
		//i++;
		
		
	if(result.length() >0)
		return result;
	  }catch (SQLException sql) {
		  System.out.println(sql);
	  }
	  return "" +  "wwww" ;
  }
  public ArrayList<String> query(String query)
  {
    //Add your code here
	  ArrayList queryString = new ArrayList<String>();
	  try {
		 Statement stmt = conn.createStatement();
		  // Dynamically 
		  //take the input parameter query and ue in execute query()
		  //2. take the results set and extract(parse) each column in each row
		 ResultSet rs;
		 System.out.println("its me123");
		 rs=stmt.executeQuery("select * from bbn_users");  
		  //create a string from the columns - concatnate to create a comma
		  // delimited string field1, field2,...field3
		 ResultSetMetaData rmd;
		 rmd = rs.getMetaData();
		 int no_columns = rmd.getColumnCount();
		  //store each string in the array list
		int i = 1;
		 while(rs.next()) 
	      {
			
	        System.out.println("all");
	    
	        queryString.add(rs.getString(i));
	      }
	      
		  //return the arraylist containing the strings or null if no data found
		  
	  }catch (SQLException sql) {
		  System.out.println(sql);
	  }
	  if(queryString.size() > 0)
		  return queryString;
	  
	  return null;
  }
  public ArrayList<String> queryUsername(String query)
  {
    //Add your code here
	  ArrayList queryString = new ArrayList<String>();
	  try {
		 Statement stmt = conn.createStatement();
		  // Dynamically 
		  //take the input parameter query and ue in execute query()
		  //2. take the results set and extract(parse) each column in each row
		 ResultSet rs;
		 System.out.println("it's me");
		 rs=stmt.executeQuery("select  username from bbn_users");  
		  //create a string from the columns - concatnate to create a comma
		  // delimited string field1, field2,...field3
		 ResultSetMetaData rmd;
		 rmd = rs.getMetaData();
		 int no_columns = rmd.getColumnCount();
		  //store each string in the array list
		int i = 1;
		 while(rs.next()) 
	      {
	        System.out.println("username");
	        queryString.add(rs.getString(i));
	      }
	      
		  //return the arraylist containing the strings or null if no data found
		  
	  }catch (SQLException sql) {
		  System.out.println(sql);
	  }
	  if(queryString.size() > 0)
		  return queryString;
	  
	  return null;
  }
  public ArrayList<String> queryPassword(String query)
  {
    //Add your code here
	  ArrayList queryString = new ArrayList<String>();
	  try {
		 Statement stmt = conn.createStatement();
		  // Dynamically 
		  //take the input parameter query and ue in execute query()
		  //2. take the results set and extract(parse) each column in each row
		 ResultSet rs;
		 System.out.println("its meeee");
		 rs=stmt.executeQuery("select * aes_decrypt(password,'key') from bbn_users");  
		  //create a string from the columns - concatnate to create a comma
		  // delimited string field1, field2,...field3
		 ResultSetMetaData rmd;
		 rmd = rs.getMetaData();
		 int no_columns = rmd.getColumnCount();
		  //store each string in the array list
		int i = 1;
		 while(rs.next()) 
	      {
	        System.out.println("is this working");
	        queryString.add(rs.getString(i));
	      }
	      
		  //return the arraylist containing the strings or null if no data found
		  
	  }catch (SQLException sql) {
		  System.out.println(sql);
	  }
	  if(queryString.size() > 0)
		  return queryString;
	  
	  return null;
  }
  public boolean isThere(String username, String password)
  {
    //Add your code here
	  
	  try {
		 Statement stmt = conn.createStatement();
		  // Dynamically 
		  //take the input parameter query and ue in execute query()
		  //2. take the results set and extract(parse) each column in each row
		 ResultSet rs;
		 System.out.println("its me2");
		 rs=stmt.executeQuery("select username, password from bbn_users"
		 		+ " where username ='"+username+"' and"
		 	+ " password  = aes_encrypt('"+password+"','key')");  
		  //create a string from the columns - concatnate to create a comma
		  // delimited string field1, field2,...field3
		 ResultSetMetaData rmd;
		 if(!rs.isBeforeFirst())
			 return false;
		 rmd = rs.getMetaData();
		 int no_columns = rmd.getColumnCount();
		  //store each string in the array list
		int i = 1;
		 while(rs.next()) 
	      {
	        System.out.println("is this working");
	        
	      }
	      
		  //return the arraylist containing the strings or null if no data found
		  
	  }catch (SQLException sql) {
		  System.out.println(sql);
	  }
	 
	  
	  return true;
  }
  public boolean executeFood(String name,String fat,String carbs, String protein){
	  
	  
	  try {
			 Statement stmt = conn.createStatement();

			 
			 String dml2 = "insert into food values('"+name+"','"+fat+"','"+carbs+"','"+protein+"','10')";
			  
			 stmt.execute(dml2);
			 System.out.println("inserted");
			 return true;
			
		  }catch (SQLException sql) {
			  
		  }
	  
	  
	  return false;
  }
  
public boolean executeGoalUpdate(String user, String goal, String goalWeight){
	  
	  try {
			 Statement stmt = conn.createStatement();			 
			 
			// UPDATE bbn_users SET weight = '111' WHERE username = 'aa';
			 String dml2 = "update bbn_users set goal = '"+goal+"',  goal_weight = '"+goalWeight+"' where"
			 		+ " username = '"+user+"'";
			 stmt.executeUpdate(dml2);
			 System.out.println("inserted");
			 return true;
			
			  
		  }catch (SQLException sql) {
			  
		  }
	  return false;
  }
  public boolean executeWeight(String weight, String un){
	  
	  try {
			 Statement stmt = conn.createStatement();			 
			 
			// UPDATE bbn_users SET weight = '111' WHERE username = 'aa';
			 String dml2 = "update bbn_users set weight = '"+weight+"' where"
			 		+ " username = '"+un+"'";
			 stmt.executeUpdate(dml2);
			 System.out.println("inserted");
			 return true;
			
			  
		  }catch (SQLException sql) {
			  
		  }
	  return false;
  }
  public boolean executeDML(String username, String password, String sex, String age,
		  String weight, String goal_weight, String height, String goal,
		  String activity_level, String totalCalories, String remainingCalories)
		   {
    //Add your code here
	  try {
			 Statement stmt = conn.createStatement();
//			 String dml2 = "insert into user values('"+username+"',"
//			 		+ "aes_encrypt('"+password+"','key') )";
//			 
			 
			 
			 String dml2 = "insert into bbn_users values('"+username+"',"
				 		+ "aes_encrypt('"+password+"','key'),'"+sex+"','"+age+"','"+weight+"','"+goal_weight+"','"+height+"','"+goal+"','"+activity_level+"','"+totalCalories+"','"+remainingCalories+"')";
			  // Dynamically 
			  //take the input parameter query and ue in execute query()
			  //2. take the results set and extract(parse) each column in each row
			 stmt.execute(dml2);
			 System.out.println("inserted");
			 return true;
			// insert into test1
		   //	   values('Joe Smith', '1215 Main', '329-2981');

			  //create a string from the columns - concatnate to create a comma
			  // delimited string field1, field2,...field3
			  
			  
			  //store each string in the array list
			  
			  //return the arraylist containing the strings or null if no data found
			  
		  }catch (SQLException sql) {
			  
		  }
	  //use execute instead of execute query
	  //no result set
	  return false;
  }
  
}