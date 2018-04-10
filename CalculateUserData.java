package bodyByNumberz;

public class CalculateUserData
{
	private int remainingCalories = 0;
	private int remainingProtein = 0;
	private int remainingCarb = 0;
	private int remainingFat = 0;
	private int dailyFat;
	private int dailyCarbs;
	private int dailyProtein;
	private int dailyCalories;
	private User user;
	private Object weekFuturePlan;
	private Object monthFuturePlan;
	private Object threeMonthFuturePlan;
	private int nextWeighIn;
	private int BMI;
	private double fatPercent;
	private double carbPercent;
	private double proPercent;
	double activityLevel = 0;
	private Food food;
	private int foodCals;
	
	
	//BASIC METABOLIC RATE => Women BMR = 655 + (9.6 X weight in kg) + (1.8 x height in cm) – (4.7 x age in yrs) 
	//						  Men BMR = 66 + (13.7 X weight in kg) + (5 x height in cm) – (6.8 x age in yrs)
	//ACTIVITY ADJUSTMENT  => Little/No Exercise = BMR * 1.2  (less than 30 minutes per week)
	//						  Light Exercise = BMR * 1.375  (30-90 minutes per week)
	//						  Moderate Exercise = BMR * 1.55  (90-150 minutes per week)
	//						  Heavy Exercise = BMR * 1.9      (150+ minutes per week, strenuous jobs, extra heavy workouts)
	//IDEAL MACROS => 20% carb, 40% fat, 40% protein (this is highly arguable but in general the sort of people looking to use an app like this should be limiting carbs
	//A gram of protein is 4 calories
	//A gram of carbs is 4 calories
	//A gram of fat is 9 calories
	public CalculateUserData(User user) {
		this.user = user;
		this.fatPercent = 40;
		this.proPercent = 40;
		this.carbPercent = 20;
		
	}
	public void calcLogFood(int pro,int carbs, int fat){
		remainingProtein = remainingProtein - pro;
		remainingCarb-= carbs;
		remainingFat-= fat;
		remainingCalories-= ((remainingProtein * 4) +
				(remainingCarb * 4) + (remainingFat * 9));
	}
	public void DynamicCalorieUpdate()
	{
		if(user.getActivityLevel().equalsIgnoreCase("Low")){
			this.activityLevel = 1.2;
		}
		if(user.getActivityLevel().equalsIgnoreCase("Medium")){
			this.activityLevel = 1.55;
		}
        if(user.getActivityLevel().equalsIgnoreCase("High")){
        	this.activityLevel = 1.9;
		}
		
		double BMR; 
		if(user.getSex().equalsIgnoreCase("Female"))
		{
			BMR =  (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) - 161;
		}
		else
		{

			//BMR = 66 + ( 6.2 × weight in pounds ) + 
			//( 12.7 × height in inches ) – ( 6.76 × age in years )
			BMR =  (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5;
		}
		
		//need to modify this by activity level idk where we have that data kept
		
		dailyCalories = (int) ((int) BMR * activityLevel);
		
		//this should give the amount of grams per macronutrient to be eaten daily
		
		double protein =  ((proPercent * .01) * dailyCalories) / 4;
		dailyProtein = (int) protein;
		
		double fat = ((fatPercent * .01)  * dailyCalories) / 9;
		dailyFat = (int) fat;
		
		double carb = ((carbPercent * .01)  * dailyCalories) / 4;
		dailyCarbs = (int) carb;
		
		
		
	}
	public int calculateBMI(){
		 double heightBMI = user.getHeight() * .01;
		 
		BMI = (int) (  user.getWeight() /(heightBMI * heightBMI) );
		return BMI;
	}
	public int getRemainingCalories()
	{
		return remainingCalories;
	}
	public void setRemainingCalories(int currentCalories)
	{
		this.remainingCalories =  dailyCalories - remainingCalories ;
	}
	public int getRemainingProtein()
	{
		return remainingProtein;
	}
	public void setRemainingProtein(int currentProtein)
	{
		this.remainingProtein =  currentProtein - remainingProtein ;
	}
	public int getRemainingCarbs()
	{
		return remainingCarb;
	}
	public void setRemainingCarbs(int currentCarbs)
	{
		this.remainingCarb = currentCarbs - remainingCarb  ;
	}
	public int getRemainingFat()
	{
		return remainingFat;
	}
	public void setRemainingFat(int currentFat)
	{
		this.remainingFat =  currentFat - remainingFat ;
	}
	public int getDailyFat()
	{
		return dailyFat;
	}
	public void setDailyFat(int dailyFat)
	{
		this.dailyFat = dailyFat;
	}
	public int getDailyCarbs()
	{
		return dailyCarbs;
	}
	public void setDailyCarbs(int dailyCarbs)
	{
		this.dailyCarbs = dailyCarbs;
	}
	public int getDailyProtein()
	{
		return dailyProtein;
	}
	public void setDailyProtein(int dailyProtein)
	{
		this.dailyProtein = dailyProtein;
	}
	public int getDailyCalories()
	{
		return dailyCalories;
	}
	public void setDailyCalories(int dailyCalories)
	{
		this.dailyCalories = dailyCalories;
	}
	public int getNextWeighIn()
	{
		return nextWeighIn;
	}
	public void setNextWeighIn(int nextWeighIn)
	{
		this.nextWeighIn = nextWeighIn;
	}
	public void updateRemains() {
		remainingCarb = (int) (((carbPercent * .01) * remainingCalories) / 4);
		remainingProtein = (int) (((proPercent * .01)  * remainingCalories) / 4);
		remainingFat = (int) (((fatPercent * .01)  * remainingCalories) / 9);
		
		//this should give the amount of grams per macronutrient to be eaten daily
		
	}
	public void calcPercentages(int fatP, int proP, int carbP){
		this.fatPercent = fatP;
		this.proPercent = proP;
		this.carbPercent = carbP;
	}
	
	

}