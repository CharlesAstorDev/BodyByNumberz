package bodyByNumberz;


import java.io.Serializable;

public class CreateAccountData implements Serializable 

{
  //Private data fields declared here
	private String username;
	private String password;
	private int num;
	private String sex;
	private String age;
	private String height;
	private String weight;
	private String goal;
	private String activityLevel;
	private String goalWeight;
  //Public getters/setters go here
	
  public CreateAccountData(String username, String password,
		  String sex, String age, String height, String weight,
		  String goal, String activityLevel, String goalWeight,
		  int num)
  {
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.goal = goal;
    this.activityLevel = activityLevel;
    this.goalWeight = goalWeight;
    
    this.num = num;
  }
  public int getNum() {
	  return num;
  }
  public String getUserName() {
	  return username;
  }
  public String getPassword() {
	  return password;
  }

  public String getSex() {
	  return sex;
  }
  public String getAge() {
	  return age;
  }
  public String getHeight() {
	  return height;
  }
  public String getWeight() {
	  return weight;
  }
  public String getGoal() {
	  return goal;
  }
  public String getActivityLevel() {
	  return activityLevel;
  }
  public String getGoalWeight() {
	  return goalWeight;
  }
	

}