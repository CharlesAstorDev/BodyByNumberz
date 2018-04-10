package bodyByNumberz;

import java.io.Serializable;

public class LoginData implements Serializable 

{
  //Private data fields declared here
	private String username;
	private String password;
	private int num;
  //Public getters/setters go here
	
  public LoginData(String username, String password, int num)
  {
    this.username = username;
    this.password = password;
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

	

}
