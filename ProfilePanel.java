package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProfilePanel extends JPanel implements Serializable{
	public String userStr;
	private int currentCal;
	private int currentCarb;
	private int currentFat;
	private int currentPro;
	private ArrayList<String> arrayList;
	private String sex;
	private String age;
	private String height;
	private String goal;
	private String goalWeight;
	private String activityLevel;
	private String weight;
	
	private String BMIStr;
	private CalculateUserData calc;
	private JButton add;
	private JButton delete;
	private JButton logOut;
	private JPanel addDelete;
	private JTextArea contactArea;
	private JPanel contactPanel;
	private JPanel verticalPanel;
	private JLabel userLabel;
	private User user;
	private JLabel goalLabel;
	private JLabel goalWeightLabel;
	private JLabel remainingCaloriesLabel;
	private JLabel remainingProteinLabel;
	private JLabel remainingFatLabel;
	private JLabel remainingCarbLabel;
	private JLabel BMI;
	
	private JLabel dailyCaloriesLabel;
	private JLabel recentWeighInsLabel;
	ChatClient client;
	
	public ProfilePanel(CardLayout cl, JPanel container, ChatClient client) {
		this.client = client;
		JPanel inner = new JPanel(new GridLayout(16,2));
		JLabel profilePic = new JLabel(new ImageIcon("Portions.jpg"), JLabel.CENTER);
		userLabel = new JLabel("Welcome",JLabel.CENTER);
		goalLabel = new JLabel("Welcome",JLabel.CENTER);
		goalWeightLabel = new JLabel("Welcome",JLabel.CENTER);
		remainingCaloriesLabel = new JLabel("Welcome",JLabel.CENTER);
//		remainingProteinLabel = new JLabel("Welcome",JLabel.CENTER);
//		 remainingFatLabel  = new JLabel("Welcome",JLabel.CENTER);
//		 remainingCarbLabel = new JLabel("Welcome",JLabel.CENTER);
//		
		 dailyCaloriesLabel  = new JLabel("Welcome",JLabel.CENTER);
		  recentWeighInsLabel  = new JLabel("Welcome",JLabel.CENTER);
		 BMI  = new JLabel("Welcome",JLabel.CENTER);
		
		JButton addFood = new JButton("Add Food");
		JButton updateMacros = new JButton("Update Macros");
		JButton logFood = new JButton("Log Food");
		JButton updateGoals = new JButton("Update Goals");
		JButton futurePlan = new JButton("View Future Plan");
		JButton weighIn = new JButton("Weigh In");
		JButton refresh = new JButton("Refresh");
		JButton logOut = new JButton("Log Out");
		
		
		
		
		
		ProfileController profileControl = new ProfileController(cl,container,client);
		addFood.addActionListener(profileControl);
		updateMacros.addActionListener(profileControl);
		logFood.addActionListener(profileControl);
		updateGoals.addActionListener(profileControl);
		futurePlan.addActionListener(profileControl);
		weighIn.addActionListener(profileControl);
		refresh.addActionListener(profileControl);
		logOut.addActionListener(profileControl);
		
		inner.add(profilePic);
		inner.add(userLabel);
		inner.add(goalLabel);
		inner.add(goalWeightLabel);
		inner.add(dailyCaloriesLabel);
		inner.add(remainingCaloriesLabel);
		
		inner.add(recentWeighInsLabel);
		inner.add(BMI);
		
		
		
		
		
		
		inner.add(addFood);
		inner.add(updateMacros);
		inner.add(logFood);
		inner.add(updateGoals);
		inner.add(futurePlan);
		inner.add(weighIn);
		inner.add(refresh);
		inner.add(logOut);
		
		this.add(inner);
//		//user = new User(username);
//		verticalPanel  = new JPanel();
//		verticalPanel.setLayout(new BoxLayout(verticalPanel,BoxLayout.Y_AXIS) );
//		contactArea = new JTextArea(7,14);
//		//contactArea.add(new JScrollPane(contactArea));
//		contactArea.setText("(List all contacts here-- \n"
//				+ "those currently logged in \n"
//				+ "will have \n"
//				+ "bolded font)");
//		contactPanel = new JPanel();
//		contactPanel.add(new JScrollPane(contactArea));
//		
//		contactLabel = new JLabel("Contactssss");
//		contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		verticalPanel.add(contactLabel);
//		verticalPanel.add(contactPanel);
//		add = new JButton("Add Contact");
//		delete = new JButton("Delete Contact");
//		logOut = new JButton("Log out");
//		logOut.setAlignmentX(Component.CENTER_ALIGNMENT);
//		addDelete = new JPanel(new FlowLayout());
//		addDelete.add(add);
//		addDelete.add(delete);
//		verticalPanel.add(addDelete);
//		verticalPanel.add(logOut);
//		this.add(verticalPanel);
	}
	public void setUserLog(User user) {
		this.user = user;
		userLabel.setText("Welcome " + userStr);
		try {
			Thread.sleep(300);//This is used to wait until server response gets back
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sendUserToServer();
	}
	public void setUser(User user) {
		System.out.println("Hello");
		this.user = user;
		setUserProfile();
		userLabel.setText("Welcome " + user.getUsername());
		goalLabel.setText("Your Goal is " + user.getGoal());
		goalWeightLabel.setText("Your Goal Weight is "+  user.getGoalWeight());
		remainingCaloriesLabel.setText("Remaining Calories: "+ calc.getRemainingCalories() 
		+ " Remaining Carbs: " + calc.getRemainingCarbs()
		+ " Remaining Fat: " + calc.getRemainingFat()
		+ " Remaining Protein: " + calc.getRemainingProtein());
		dailyCaloriesLabel.setText("Daily Calories: "+ calc.getDailyCalories() 
		+ " Carbs: " + calc.getDailyCarbs()
		+  " Fat: " + calc.getDailyFat()
		+ " Protein: " + calc.getDailyProtein());
		BMI.setText("BMI: "+ BMIStr );
		recentWeighInsLabel.setText("Last Weigh In Weight: "+user.getWeight());
		
	}
	
	public void setUserProfile(){
		calc = new CalculateUserData(user);
		calc.DynamicCalorieUpdate();
		currentCal = calc.getDailyCalories();
	currentCarb = 	calc.getDailyCarbs();
		currentFat = calc.getDailyFat();
	currentPro = 	calc.getDailyProtein();
		calc.setRemainingCalories(currentCal);
		calc.setRemainingFat(currentFat);
		calc.setRemainingProtein(currentPro);
		calc.setRemainingCarbs(currentCarb);
		
		
		BMIStr = ""+ calc.calculateBMI();
		
	}
	
	public void setWeightIn() {
		currentCal = calc.getDailyCalories();
		currentCarb = 	calc.getDailyCarbs();
			currentFat = calc.getDailyFat();
		currentPro = 	calc.getDailyProtein();
//			calc.setRemainingCalories(currentCal);
//			calc.setRemainingFat(currentFat);
//			calc.setRemainingProtein(currentPro);
//			calc.setRemainingCarbs(currentCarb);
			calc.updateRemains();
			
			BMIStr = ""+ calc.calculateBMI();
			userLabel.setText("Welcome " + user.getUsername());
			goalLabel.setText("Your Goal is " + user.getGoal());
			goalWeightLabel.setText("Your Goal Weight is "+  user.getGoalWeight());
			remainingCaloriesLabel.setText("Remaining Calories: "+ calc.getDailyCalories()
			+ " Remaining Carbs: " + calc.getRemainingCarbs()
			+ " Remaining Fat: " + calc.getRemainingFat()
			+ " Remaining Protein: " + calc.getRemainingProtein());
			dailyCaloriesLabel.setText("Daily Calories: "+ calc.getDailyCalories() 
			+ " Carbs: " + calc.getDailyCarbs()
			+  " Fat: " + calc.getDailyFat()
			+ " Protein: " + calc.getDailyProtein());
			BMI.setText("BMI: "+ BMIStr );
			recentWeighInsLabel.setText("Last Weigh In Weight: "+user.getWeight());
	}
	public void UpdateMacros(){
		remainingCaloriesLabel.setText("Remaining Calories: "+ calc.getRemainingCalories() 
		+ " Remaining Carbs: " + calc.getRemainingCarbs()
		+ " Remaining Fat: " + calc.getRemainingFat()
		+ " Remaining Protein: " + calc.getRemainingProtein());
		dailyCaloriesLabel.setText("Daily Calories: "+ calc.getDailyCalories() 
		+ " Carbs: " + calc.getDailyCarbs()
		+  " Fat: " + calc.getDailyFat()
		+ " Protein: " + calc.getDailyProtein());
	}
	
//	public void sendUserToServer() {
//		String un = user.getUsername();
//		try {
//			client.sendToServer("Hello");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			Thread.sleep(300);//This is used to wait until server response gets back
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		
		//arrayList = client.getAL();
	
	
	public User getUser() {
		return user;
	}
	
	public String getUserStr() {
		return userStr;
	}
	public void setUserString(String userString) {
		this.userStr = userString;
	}
	public CalculateUserData getUserDataCal() {
		return calc;
	}
	public void updateRemain(){
		remainingCaloriesLabel.setText("Remaining Calories: "+ calc.getRemainingCalories() 
		+ " Remaining Carbs: " + calc.getRemainingCarbs()
		+ " Remaining Fat: " + calc.getRemainingFat()
		+ " Remaining Protein: " + calc.getRemainingProtein());
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
