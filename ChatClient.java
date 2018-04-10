package bodyByNumberz;

import java.util.ArrayList;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
	private String foodStr;
	private int valid = 2;
  private String userString;
  public ChatClient()
  {
    super("localhost",8300);
  }
 public int getValid() {
	 return valid;
 }
 public String getUserString() {
	 return userString;
 }
 public String getFoodStr(){
	 return foodStr;
 }
  @Override
  public void handleMessageFromServer(Object arg0)
  {
	  String str = (String)arg0;
	  ///
String we = (String)arg0;
	  
	  if(we.length() > 70  ){
		  foodStr = we;
		  return;
	  }else {
		  foodStr = "www";
	  }
	 
		 
	//  if(str.length() > 10){
		  userString = str;
	//  } else {
	  System.out.println("Server Message sent to Client " + (String)arg0);
	  if(isNumeric((String)arg0)){
		  System.out.println("isnumeric");
	 valid = Integer.parseInt((String)arg0);
	  }
	  
	  
 
	  }  
//	   else  {
//		  System.out.println("arraylist");
//		  arrayList = (ArrayList<String>) arg0; 
	//  }
   

  //}
  
  public void connectionException (Throwable exception) 
  {
    //Add your code here
  }
  public void connectionEstablished()
  {
    //Add your code here
  }
  public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

}
