package bodyByNumberz;

public class Food
{
	private String name;
	private Nutrition nutrition;
	
	public Food(String name, Nutrition nutrition)
	{
		
		this.name = name;
		this.nutrition = nutrition;
		//not sure what default is
	}
	public String getFoodName(){
		return name;
	}
	public Food getFood()
	{
		
		return this;
	}
	public Nutrition getNutrition() {
		return nutrition;
	}
	
	public void setFood(String name, Nutrition nutrition)
	{
		this.name = name;
		this.nutrition = nutrition;
	}

}