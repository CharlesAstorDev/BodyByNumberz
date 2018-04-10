package bodyByNumberz;

import java.io.Serializable;

public class UserName implements Serializable {
	private String username;
	private String userString;
	
	public UserName (String username) {
		this.username = username;
	}
	
	public void setUserStr(String userString){
		this.userString = userString;
	}
	public String getUserStr(){
		return userString;
	}
	public String getUsername() {
		return username;
	}
}
