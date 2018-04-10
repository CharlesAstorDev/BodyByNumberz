package bodyByNumberz;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatServer extends AbstractServer
{
	private ArrayList al = new ArrayList<String>();
	private ArrayList pw = new ArrayList<String>();
	private ArrayList user = new ArrayList<String>();
	private ArrayList userTable = new ArrayList<String>();
  private JTextArea log;
  private JLabel status;
  private String username;
  private String password;
  private String age;
  private Database database;
  private String sex;
  private String weight;
  private String goalWeight;
  private String height;
  private String goal;
  private String activityLevel;
  private String totalCalories;
  private String favFood;
  private String remainingCalories;
  //private User userObj;
  
  
  public void setDatabase(Database database) 
  {
	  this.database = database;
	  System.out.println("database set");
  }
  public ChatServer()
  {
    super(12345);
  }
  
  public ChatServer(int port)
  {
    super(port);
  }
  
  public void setLog(JTextArea log)
  {
    this.log = log;
  }
  
  public JTextArea getLog()
  {
    return log;
  }
  
  public void setStatus(JLabel status)
  {
    this.status = status;
  }
  
  public JLabel getStatus()
  {
    return status;
  }
  public void sentFoodToClient(){
	  
  }
  
  
  @Override
  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
  {
	  
	  
//  {
//	  String msg = (String) arg0;
//		int id = (int) arg1.getId();
//		log.append("\nClient"+ id +" "+ msg);
//		try {
//			arg1.sendToClient(msg);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	 System.out.println("Message From Client Received");
	  //System.out.println("This is called ");
    // TODO Auto-generated method stub
   //System.out.println("Message from Client" + arg0.toString() + arg1.toString());
    //log.append("Message from Client" + arg0.toString() + arg1.toString() + "\n");
	  DatabaseFile db = new DatabaseFile();
	  db.readFile();
  	al = database.query("query");
  	pw = database.queryPassword("pass");
  	user = database.queryUsername("username");
  	System.out.println("Beforee");
  	if(arg0 instanceof GoalData){
  		GoalData id = (GoalData)arg0;
  		String user = id.getUser();
  		String goal = id.getGoal();
  		String goalWeight = id.getGoalWeight();
  		
  		database.executeGoalUpdate(user, goal,goalWeight);
  	}
  	if(arg0 instanceof InsertFood) {
  		InsertFood insertFood = (InsertFood)arg0;
  		String name = insertFood.getName();
  		String fat = insertFood.getFat();
  		String carbs = insertFood.getCarb();
  		String protein = insertFood.getProtein();
  		database.executeFood(name, fat, carbs, protein);
  	}
  	if(arg0 instanceof InsertData) {
  		//String data = database.getUserTable(userName);
  		InsertData id = (InsertData)arg0;
  		String data = id.getData();
  		String type = id.getType();
  		String un = id.getUN();
  		if(type.contentEquals("weight")){
  			database.executeWeight(data, un);
  		}else {
  		//if(type.contentEquals("getfood")){
  			ArrayList<Food> fd = database.getFoodData();
  			String str = makeFoodString(fd);
  			try {
  				//arg1.sendToClient("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
				arg1.sendToClient(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
  		//}
  	}
  	
  	if(arg0 instanceof UserName) {
  		System.out.println("afterIf");
  		UserName userObj = (UserName)arg0;
  		String userName = userObj.getUsername();
  		//userTable = database.getUserTable(userName);
  		String userString = database.getUserTable(userName);
  		//String userString = "wwwwwhehehhehehehehehe";
  	//	userString += "whhhh";
  		try {
			arg1.sendToClient(userString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("did not work");
		}
  		return;
  	}
  	else
  	if(arg0 instanceof CreateAccountData) {

        CreateAccountData createData = (CreateAccountData)arg0;
        username = createData.getUserName();
        password = createData.getPassword();
        age = createData.getAge();
        sex = createData.getSex();
        weight = createData.getWeight();
        goalWeight = createData.getGoalWeight();
        height = createData.getHeight();
        goal = createData.getGoal();
        activityLevel = createData.getActivityLevel();
        totalCalories ="1";
        remainingCalories = "1";
        favFood = "1";
//        username, password, sex, age, weight, goalWeight, height,
//		   goal, activityLevel,totalCalories, remainingCalories, favFood);
  	  if(createData.getNum() == 1){ //Create new account
   	   if(user.contains(username)){
   		   try {
   		 		arg1.sendToClient("9");
   		 	} catch (IOException e) {
   		 		// TODO Auto-generated catch block
   		 		System.out.println("exception here");
   		 		e.printStackTrace();
   		 	}
   	   }else {
   		   System.out.println("new user");
   		   boolean didWork = false;
   		  didWork = database.executeDML(username, password, sex, age, weight, goalWeight, height,
   				   goal, activityLevel,totalCalories, remainingCalories);
   		 System.out.println(""+didWork);
   		 //  db.writeToFile(username, password);
   		   try {
  		 		arg1.sendToClient("8");
  		 	} catch (IOException e) {
  		 		// TODO Auto-generated catch block
  		 		System.out.println("exception here");
  		 		e.printStackTrace();
  		 	}
   	   }
      }
  	}
  	else if (arg0 instanceof LoginData)
    {
    	
   
    	
    	//	lp.setField("Enter username/password",0);
    
       LoginData loginData = (LoginData)arg0;
       username = loginData.getUserName();
       password = loginData.getPassword();
       
       if(loginData.getNum() == 1){ //Create new account
    	   if(user.contains(username)){
    		   try {
    		 		arg1.sendToClient("9");
    		 	} catch (IOException e) {
    		 		// TODO Auto-generated catch block
    		 		System.out.println("exception here");
    		 		e.printStackTrace();
    		 	}
    	   }else {
    		   database.executeDML(username, password, sex, age, weight, goalWeight, height,
       				   goal, activityLevel,totalCalories, remainingCalories);
    		   
    		  
    		  // db.writeToFile(username, password);
    		   try {
   		 		arg1.sendToClient("8");
   		 	} catch (IOException e) {
   		 		// TODO Auto-generated catch block
   		 		System.out.println("exception here");
   		 		e.printStackTrace();
   		 	}
    	   }
       }else {
    	al = database.getUserPass(username);
    	boolean isThere = database.isThere(username,password);
      // if(al.contains(username+" " +password)){
    	if(isThere){
       System.out.println("Username/Password " + loginData.getUserName() + " " + loginData.getPassword());
       
     try {
 		arg1.sendToClient("1");
 	} catch (IOException e) {
 		// TODO Auto-generated catch block
 		System.out.println("exception here");
 		e.printStackTrace();
 	}
     
       
    } else {
    	try {
    		arg1.sendToClient("0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Does not exist");
	//	lp.setField("Invalid Username/Password", 1);
    		}
       }
       
    }

//ghgh
  }
  
  
//  public void setUserB() {
//	  try {
//			arg1.sendToClient("weeeeeeeee");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("did not work");
//		}
//  }
  protected void listeningException(Throwable exception) 
  {
	  System.out.println("This is an exception 123");
    //Display info about the exception
    System.out.println("Listening Exception:" + exception);
    exception.printStackTrace();
    System.out.println(exception.getMessage());
    System.out.println("This is wwww");
	log.append("\n" + exception.getMessage().toString());
	log.append("\nPress Listen To Restart Server");
	status.setText("Exception Occurred when Listening");
	status.setForeground(Color.RED);
	System.out.println("Listening Exception occured");
	System.out.println(exception.getMessage().toString());
	exception.printStackTrace();
    /*if (this.isListening())
    {
      log.append("Server not Listening\n");
      status.setText("Not Connected");
      status.setForeground(Color.RED);
    }*/
    
  }
  
  protected void serverStarted() 
  {
    System.out.println("Server Started");
    //log.append("Server Started\n");

	//status turn label to Listening and color = green
	status.setText("Listening");
	log.setText("Server Started");
	 
	   status.setForeground(Color.GREEN);
  }
  
  protected void serverStopped() 
  {
	  log.append("\nServer Stopped Accepting New Clients - Press Listen to Start Accepting New Clients");
		System.out.println("stopped was called");
		 status.setText("Stopped");
		   status.setForeground(Color.RED);
    System.out.println("Server Stopped");
    //log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
  }
  
  protected void serverClosed() 
  {
		
		System.out.println("closed was called");
	//	log.setText("ServerStarted "
		//		+ "\nServer Stopped Accepting New Clients - Press Listen to Start Accepting New Clients"
//+ "\nServer and all current clients are closed - Press Listen to Restart");
		log.append("\nServer and all current clients are closed - Press Listen to Restart");
		 status.setText("Close");
		   status.setForeground(Color.RED);
    System.out.println("Server and all current clients are closed - Press Listen to Restart");
    //log.append("Server and all current clients are closed - Press Listen to Restart\n");
  }
public String makeFoodString(ArrayList<Food> fd){
	String tmpStr = "";
	for(int i = 0; i < fd.size();i++){
		tmpStr+= fd.get(i).getFoodName() + ",";
		tmpStr+= fd.get(i).getNutrition().getFat() + ",";
		tmpStr+= fd.get(i).getNutrition().getCarbs() + ",";
		tmpStr+= fd.get(i).getNutrition().getProtein() + ",";
		
	}
	return tmpStr;
}
  
  protected void clientConnected(ConnectionToClient client) 
  {
    System.out.println("Client Connected");
    //log.append("Client Connected\n");
    log.append("\nClient "+ client.getId() + " connected");
	try {
		
		client.sendToClient("Client" + client.getId());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  


}
