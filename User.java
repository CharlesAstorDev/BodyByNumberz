package bodyByNumberz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class User implements Serializable 
{
	private ArrayList<Food> food;
	private int totalCalories;
	private int remainingCalories;
	private String username;
	private String password;
	private String goal;
	private int weight;
	private int goalWeight;
	private int age;
	private int height;
	private String sex;
	private Object userData;
	private String activityLevel;
	private int proteinPercent;
	private int carbPercent;
	private int fatPercent;
	private int BMI;
	
	public User(String username) {
		this.username = username;
	}
	
	public ArrayList<Food> getFood()
	{
		return food;
	}
	public void setFood2(Food food){
		this.food.add(food);
	}
	public void setFoodArList(ArrayList<Food> foodArList){
		this.food = foodArList;
	}
	public void setFood(Food[] food)
	{
		ArrayList<Food> arrayList = new ArrayList<Food>(Arrays.asList(food));
		this.food = arrayList;
	}
	public int getTotalCalories()
	{
		return totalCalories;
	}
	public void setTotalCalories(int totalCalories)
	{
		this.totalCalories = totalCalories;
	}
	public int getRemainingCalories()
	{
		return remainingCalories;
	}
	public void setRemainingCalories(int remainingCalories)
	{
		this.remainingCalories = remainingCalories;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getGoal()
	{
		return goal;
	}
	public void setGoal(String goal)
	{
		this.goal = goal;
	}
	public int getWeight()
	{
		return weight;
	}
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	public int getGoalWeight()
	{
		return goalWeight;
	}
	public void setGoalWeight(int goalWeight)
	{
		this.goalWeight = goalWeight;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public Object getUserData()
	{
		return userData;
	}
	public void setUserData(Object userData)
	{
		this.userData = userData;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	public String getActivityLevel() {
		return activityLevel;
	}
}