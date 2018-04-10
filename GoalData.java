package bodyByNumberz;

import java.io.Serializable;

public class GoalData implements Serializable{

	private String user;
	private String goal;
	private String goalWeight;
	public GoalData(String user, String goal, String goalWeight){
		this.user = user;
		this.goal = goal;
		this.goalWeight = goalWeight;
	}
	
	public String getUser(){
		return user;
	}
	public String getGoalWeight(){
		return goalWeight;
	}
	public String getGoal(){
		return goal;
	}
}
