package bodyByNumberz;

import java.io.Serializable;

public class InsertFood implements Serializable{

	String name;
	String fat;
	String carb;
	String protein;
	public InsertFood(String name, String fat, String carb, String protein){
		this.name = name;
		this.fat = fat;
		this.carb = carb;
		this.protein = protein;
		
	}
	
	public String getName(){
		return name;
		
	}
	public String getFat(){
		return fat;
	}
	public String getCarb(){
		return carb;
	}
	public String getProtein(){
		return protein;
	}
}
