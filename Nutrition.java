package bodyByNumberz;

public class Nutrition
{
	private int fat;
	private int carbs;
	private int protein;
	
	public Nutrition(int fat, int carbs, int protein){
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
	}
	public int getFat()
	{
		return fat;
	}
	public void setFat(int fat)
	{
		this.fat = fat;
	}
	public int getCarbs()
	{
		return carbs;
	}
	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}
	public int getProtein()
	{
		return protein;
	}
	public void setProtein(int protein)
	{
		this.protein = protein;
	}
	
}