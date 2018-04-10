package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class ProfileController implements ActionListener {

	private ArrayList<String> alUser;
	private CardLayout cl;
	private JPanel container;
	private ChatClient client;
	private int isValid;
	private Boolean flag;
	private String actionCommand;
	private User user;
	private ProfilePanel profilePanel;
	private String userName;
	CalculateUserData calc;
	private String sex;
	private String age;
	private String height;
	private String goal;
	private String goalWeight;
	private String activityLevel;
	private String weight;
	private String userString;
	
	public ProfileController(CardLayout cl, JPanel container,ChatClient client)
	{
		this.cl = cl;
		this.container = container;
		this.client = client;
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		UpdateMacrosPanel macroPanel = (UpdateMacrosPanel)container.getComponent(8);
		WeighInPanel weightPanel = (WeighInPanel)container.getComponent(6);
		 profilePanel = (ProfilePanel)container.getComponent(2);
		AddFoodPanel addFoodPanel = (AddFoodPanel)container.getComponent(9);
		LogFoodPanel logFoodPanel = (LogFoodPanel)container.getComponent(7);
		UpdateGoalsPanel updateGoalPanel = (UpdateGoalsPanel)container.getComponent(4);
		FuturePlanPanel futurePlanPanel = (FuturePlanPanel)container.getComponent(5);
		
		actionCommand = ae.getActionCommand();
		if(user == null)
			setUser();
		if(actionCommand.contentEquals("Add Food")) {
			System.out.println("addfood");
			cl.show(container, "10");
		}
		
		
         if(actionCommand.contentEquals("Update Macros")) {
        	 System.out.println("Update Macros");
        	 
        	 cl.show(container, "9");
		}
         if(actionCommand.contentEquals("Add New Food")) {
        	 System.out.println("Fat "+ addFoodPanel.getFat().getText()
        			 +"Carbs: " +addFoodPanel.getCarb().getText()+
        			 "Protein "+  addFoodPanel.getProtein().getText());
 			Food newFood = new Food(addFoodPanel.getFoodName().getText(),
 		   new Nutrition(Integer.parseInt(addFoodPanel.getFat().getText()),
 		Integer.parseInt(addFoodPanel.getCarb().getText()),
 		Integer.parseInt(addFoodPanel.getProtein().getText())));
 			System.out.println("What is this"+ newFood +" "+ newFood.getFoodName()
 			+newFood.getNutrition().getCarbs() + " "+newFood.getNutrition().getFat() 
 			+" "+ newFood.getNutrition().getProtein());
 			//user.setFood2(newFood);
 			InsertFood data = new InsertFood(addFoodPanel.getFoodName().getText(),
 		 		   addFoodPanel.getFat().getText(),
 		 			 		addFoodPanel.getCarb().getText(),
 		 			 		addFoodPanel.getProtein().getText());
 			submitToServer2(data);
 			cl.show(container, "3");
 		}
         if(actionCommand.contentEquals("Submit New Food")) {
        	 //Update remaining calories only
        	 //Check if same day;
        	 Food logFood = new Food("No Food",new Nutrition(10,10,10));
        	 ArrayList<Food> food = user.getFood();
        	 String foodSelected = logFoodPanel.getFood();
        	
        	 for(int i = 0; i <food.size();i++){
        		 if(food.get(i).getFoodName().equals(foodSelected)){
        			 logFood = food.get(i);
        			 break;
        		 }
        	 }
        	 
        	 int pro = logFood.getNutrition().getProtein();
        	 int carb = logFood.getNutrition().getCarbs();
        	 int fat = logFood.getNutrition().getFat();
        	 System.out.println(" Food Logged" + logFood.getFoodName() + "pro: "+ pro + "carb "+ carb+ "fat"+ fat );
        	 calc.calcLogFood(pro, carb, fat);
        	 //calc.calcLogFood(10, 20, 30);
        	 profilePanel.updateRemain();
        	 
        	 cl.show(container, "3");
         }
         
         if(actionCommand.contentEquals("Log Food")) {
        	 System.out.println("Log Food");
        	 logFoodPanel.setFoodArEmpty();
        	 InsertData id = new InsertData("getfood","getfood","getfood");
        	 submitToServer4(id);
        	 String foodString1 = client.getFoodStr();
        	 System.out.println(foodString1);
        	 //fooStrTo
        	 Food food1 = new Food("food1",new Nutrition(11,222,44));
        	 Food food2 = new Food("food2",new Nutrition(11,222,44));
        	 Food food3 = new Food("food3",new Nutrition(11,222,44));
        	 Food[] foodAr = {food1,food2,food3};
        	// user.setFood(foodAr);
        	// user.setFood2(foodAr);
        	 ArrayList<Food> foodArList = setFoodArList(foodString1);
        	 user.setFoodArList(foodArList);
        	 String[] food = new String[foodArList.size()];
        	 System.out.println(foodArList.size());
        	 for(int i = 0; i < foodArList.size(); i++){
        		 food[i] = foodArList.get(i).getFoodName();
        	 }
        	 
        	 logFoodPanel.setFoodArray(food);
        	 cl.show(container, "8");
 		}
         
         
         
         if(actionCommand.contentEquals("Update Goals")) {
        	 System.out.println("Update Goals");
        	 cl.show(container, "5");
 		}
         
         
         if(actionCommand.contentEquals("View Future Plan")) {
        	 System.out.println("View Future Plan");
        	 cl.show(container, "6");
 		}
         
         
         
         if(actionCommand.contentEquals("Weigh In")) {
        	 System.out.println("Weight In");
        	 cl.show(container, "7");
 		}
         
         
         if(actionCommand.contentEquals("Log Out")) {
        	 System.out.println("Log Out");
        	 cl.show(container, "1");
 		}
         
         if(actionCommand.contentEquals("Go Back")) {
        	 cl.show(container, "3");
         }
         if(actionCommand.contentEquals("Submit New Goals")) {
        	 user.setGoal(updateGoalPanel.getGoal());
        	 user.setGoalWeight(Integer.parseInt(updateGoalPanel.getGoalWeight()));
        	 GoalData gd = new GoalData( user.getUsername(), updateGoalPanel.getGoal(), updateGoalPanel.getGoalWeight());
        	 submitToServerNewGoals(gd);
     		profilePanel.setUser(user);
        	 //save to server
        	 
        	 cl.show(container, "3");
         }
        
         if(actionCommand.contentEquals("Submit")) {
        	 //Calculate userData
        	 //DisplayUserData
        	 
        	 cl.show(container, "3");
         }
         if(actionCommand.contentEquals("Refresh")) {
        	 //Calculate userData
        	 //DisplayUserData
        	 setUsername();
        	 UserName un = new UserName(profilePanel.getUserStr());
        	 try {
				client.sendToServer(un);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 try {
					Thread.sleep(400);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 System.out.println("Refresh "+ client.getUserString());

        		userString = client.getUserString();
        	 alUser = new ArrayList(Arrays.asList(userString.split("\\s*,\\s*")));
        	
        	 sex = alUser.get(1);
        		 age= alUser.get(2);
        		height= alUser.get(5);
        		goal= alUser.get(6);
        		 goalWeight = alUser.get(4);
        		 activityLevel= alUser.get(7);
        		 weight= alUser.get(3);
        		setUserData();
        		profilePanel.setUser(user);
        		//profilePanel.setUserProfile();
        		
        	
        	// cl.show(container, "3");
         }
         
         if(actionCommand.contentEquals("Submit Macros")) {
        	 int fatP =  Integer.parseInt(macroPanel.getFat().getText());
        	 int proP =  Integer.parseInt(macroPanel.getProtein().getText());
        	 int carbP =  Integer.parseInt(macroPanel.getCarb().getText());
        	if((fatP + proP + carbP) != 100) {
        		macroPanel.setError();
        	} else {
        		//Update
        		calc.calcPercentages(fatP, proP, carbP);
        		calc.DynamicCalorieUpdate();
        		calc.updateRemains();
        		profilePanel.UpdateMacros();
        		//profilePanel
        		cl.show(container, "3");
        	}
         }
         
         
         if(actionCommand.contentEquals("Enter Weight")) {
        	 if(isNumeric(weightPanel.getWeight())) {
        	 int weight = Integer.parseInt(weightPanel.getWeight());
        	 if(weight < 90 ) {
        		 //invalid weight
        	 }
        	 user.setWeight(Integer.parseInt(weightPanel.getWeight()));
        	 calc.DynamicCalorieUpdate();
        	 profilePanel.setWeightIn();
          InsertData data = new InsertData(weightPanel.getWeight(), "weight", user.getUsername());
        	 submitToServer(data);
        	 //Calculate userData
        	 //DisplayUserData
            	 cl.show(container, "3");
            	
            	 
        	 } else {
        		 //invalid, please enter a number
        	 }
        	
        	 
         }
         
         if(actionCommand.contentEquals("Select Plan"))
         {
        	 String sendBack = "";
        	 String  plan = futurePlanPanel.getPlan();
        	 if(plan.equals("Week Plan")) {
        		 for(int i = 0; i < 7;i++)
        			 sendBack += "Day "+(i+1)+" Calories " +calc.getDailyCalories()+ "\n";
        		 futurePlanPanel.setFuturePlan(sendBack);
        	 } 
        	 if(plan.equals("Month Plan")) {
        		 int dec = 0;
        		 if(user.getGoal().contentEquals("Lose"))
        			 dec = 100;
        			 if(user.getGoal().contentEquals("Lose Fast"))
        			 dec = 200;
        			 int count = 0;
        			 int cal = calc.getDailyCalories();
        		 for(int i = 0; i < 30;i++){
        			 
        			 sendBack += "Day "+(i+1)+" Calories " +cal + "\n";
        			 count++;
        			 if(count == 7){
        				 cal-=dec;
        				 count = 0;
        			 }
        		 }
        		 futurePlanPanel.setFuturePlan(sendBack);
        	 } 
        	 if(plan.equals("3 Month Plan")) {
        		 int dec = 0;
        		 if(user.getGoal().contentEquals("Lose"))
        			 dec = 100;
        			 if(user.getGoal().contentEquals("Lose Fast"))
        			 dec = 200;
        			 int count = 0;
        			 int cal = calc.getDailyCalories();
        		 for(int i = 0; i < 90;i++){
        			 
        			 sendBack += "Day "+(i+1)+" Calories " +cal + "\n";
        			 count++;
        			 if(count == 7){
        				 cal-=dec;
        				 count = 0;
        			 }
        		 }
        		 futurePlanPanel.setFuturePlan(sendBack);
        	 } 
         }
        	 
        
		
	}
	public void submitToServer2(InsertFood data){
		 try {
				client.sendToServer(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 try {
					Thread.sleep(400);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void submitToServer4(InsertData data){
		 try {
				client.sendToServer(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 try {
					Thread.sleep(400);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void submitToServerNewGoals(GoalData data){
		 try {
				client.sendToServer(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 try {
					Thread.sleep(400);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void submitToServer(InsertData data){
		 try {
				client.sendToServer(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     	 try {
					Thread.sleep(400);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void setUsername() {
		this.user = profilePanel.getUser();
		this.userName = profilePanel.getUser().getUsername();
	}
	public void setUser(){
		this.user = profilePanel.getUser();
		this.calc = profilePanel.getUserDataCal();
	}

	public void setUserData() {
	user.setSex(sex); 
	user.setGoal(goal);
	user.setHeight(Integer.parseInt(height));
	user.setAge(Integer.parseInt(age));
	user.setWeight(Integer.parseInt(weight));
	user.setGoalWeight(Integer.parseInt(goalWeight));
	user.setActivityLevel(activityLevel);
	}
	public ArrayList<Food> setFoodArList(String al){
		ArrayList<String> tmp = new ArrayList();
		tmp = new ArrayList(Arrays.asList(al.split("\\s*,\\s*")));
		for(int i = 0; i < tmp.size();i++)
			System.out.print(tmp.get(i)+" ");
		ArrayList<Food> fa = new ArrayList();
		Nutrition n = new Nutrition (5,5,5);
		int count = 0;
		for(int i = 0; i < tmp.size() ; i += 4){
			//for(int j = i; j < i+3; j++){
			//if(isNumeric(tmp.get(j+1 )) && isNumeric(tmp.get(j+2 )) && isNumeric(tmp.get(j+3))){
				
			 n = new Nutrition(Integer.parseInt(tmp.get(i+1)),
					Integer.parseInt(tmp.get(i+2 )),
					  Integer.parseInt(tmp.get(i+3)));	
				
			//} else {
			//	 n = new Nutrition(5,5,5);
			//}
			
		//	}
			Food tmpFood = new Food(tmp.get(i),n);
			fa.add(tmpFood);
			
			//i+=3;
		}
		return fa;
	}
	 public boolean isNumeric(String s) {  
  	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
  	}  
	
	
	 

}

