package bodyByNumberz;

import java.io.Serializable;

public class InsertData implements Serializable{
	String data;
	String type;
	String un;
	public InsertData(String data, String type, String un){
		this.data = data;
		this.type = type;
		this.un = un;
	}
	public String getUN(){
		return un;
	}
	public String getData(){
		return data;
	}
	public String getType(){
		return type;
	}
}
