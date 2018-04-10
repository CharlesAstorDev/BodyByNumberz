package bodyByNumberz;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAccountControl implements ActionListener
{

	private CardLayout cl;
	private JPanel container;
	private ChatClient client;
	private int isValid;
	private Boolean flag;
	private User user;
	private String sex;
	private String age;
	private String height;
	private String goal;
	private String goalWeight;
	private String activityLevel;
	private String weight;
	public CreateAccountControl(CardLayout cl, JPanel container,ChatClient client)
	{
		this.cl = cl;
		this.container = container;
		this.client = client;
	}

	public void actionPerformed(ActionEvent ae)
	{



		// Extract the username/password from the LoginPanel
		//within the actionPerformed method of LoginControl

		//
		// cl.show(container, "3");
		int count = container.getComponentCount();
		LoginPanel lp = (LoginPanel)container.getComponent(1);
		CreateAccount ap = (CreateAccount)container.getComponent(3);
		ProfilePanel profilePanel = (ProfilePanel)container.getComponent(2);
		if(ae.getActionCommand().equals("Cancel")){
			cl.show(container,"1");
			isValid = client.getValid();
			
		} else if (ae.getActionCommand().contentEquals("Submit")) {
			//cl.show(container, "3");
			//System.out.println( lp.getUserName().getText());
			//System.out.println(lp.getPassword().getText());
			String username = lp.getUserName().getText();
			String password = lp.getPassword().getText();

			if(!username.equals("") && !password.equals("")){

				//db.writeToFile(username, password);
				LoginData loginData = new LoginData(username, password,0);
				try {
					client.sendToServer(loginData);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(300);//This is used to wait until server response gets back
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//used to wait for server response, not sure if this actually works but seem to
				//work for testing. obviously not the best method but the server response seems to work
				for(int i = 0; i < 1000000000;i++)
					i+=1;
				for(int i = 0; i < 1000000000;i++)
					i+=1;
				for(int i = 0; i < 1000000000;i++)
					i+=1;
				isValid = client.getValid();
				System.out.println(isValid + " is this valid");
				if(isValid == 1){ // is valid, inside of the data base
					lp.setField("Enter username/password",0);
					cl.show(container, "3");

				}
				else {
					lp.setField("Invalid Username/Password", 1);
				}
			}
		 else {
			System.out.println("Empty");
			lp.setField("Invalid Username/Password(Empty Fields)", 1);
		}



		//if()
	} else if (ae.getActionCommand().contentEquals("Create")){
		//
//		 sex = ap.getSex().getText();
//		 age = ap.getAge().getText();
//		 height = ap.getHeightt().getText();
//		 goal = ap.getGoal().getText();
//		 goalWeight = ap.getgoalWeight().getText();
//		 activityLevel = ap.getActivityLevel().getText();
//		 weight = ap.getWeight().getText();
//		
		
		 sex = ap.getSex();
		 age = ap.getAge();
		 height = ap.getHeightt();
		 goal = ap.getGoal();
		 goalWeight = ap.getgoalWeight();
		 activityLevel = ap.getActivityLevel();
		 weight = ap.getWeight();
		
		String username = ap.getUserName().getText();
		String password = ap.getPassword().getText();
		String rePass = ap.getPassword2().getText();
		
		if(!password.equals(rePass)) 
			ap.setField("Invalid, passwords MUST match", 1);
		if(password.length() < 6 || rePass.length() < 6)
			ap.setField("Invalid, password MUST be more than 5 characters long", 1);
		
		if(sex.equals("") || age.equals("") || height.equals("")
				|| goal.equals("") || goalWeight.equals("")
				|| activityLevel.equals("") 	|| weight.equals("") 
				|| password.equals("") || rePass.equals("") || username.equals("")) {
			ap.setField("Invalid, fields must not be empty", 1);
		}
//		if(password.equals("") || rePass.equals("") || username.equals(""))
//			ap.setField("Invalid, fields must not be empty", 1);
		else if(password.equals(rePass) && password.length() >= 6 && rePass.length() >= 6
			&& username.length() >= 1){
			//send username/password to server to be checked
			CreateAccountData createAccountData = new CreateAccountData(username, password,
					sex, age, height, weight, goal, activityLevel, goalWeight,1);
			try {
				client.sendToServer(createAccountData);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < 1000000000;i++)
				i+=1;
			try {
				Thread.sleep(300);//This is used to wait until server response gets back
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(client.getValid() == 9) {
				ap.setField("Invalid, username is already taken", 1);
			} else {
				user = new User(username);
				setUserData();
				profilePanel.setUser(user);
				 
				cl.show(container, "3");
			}
				
		}
	}
	

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


	


}
