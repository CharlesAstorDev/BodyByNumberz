package bodyByNumberz;







import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class CreateAccount extends JPanel
{
  private JTextField username;
  private JPasswordField password;
  private JPasswordField rePassword;
  private JLabel jlabel;
  
//  private JTextField weight;
//  private JTextField sex;
//  private JTextField goal;
//  private JTextField age;
//  private JTextField goalWeight;
//  private JTextField activityLevel;
//  private JTextField heightt;
  
  private JComboBox<String> weight;
private JComboBox<String> sex;
private JComboBox<String> goal;
private JComboBox<String> age;
private JComboBox<String> goalWeight;
private JComboBox<String> activityLevel;
private JComboBox<String> heightt;
  
  
  
  public void setField(String lbl, int num) {
	  if(num == 1){
		  jlabel.setForeground(Color.RED);
	  }
	  else {
		  jlabel.setForeground(Color.BLACK);
	  }
	  jlabel.setText(lbl);
  }
  
  
//  public JTextField getHeightt()
//  {
//    return heightt;
//  }
//  
//  public JTextField getWeight()
//  {
//    return weight;
//  }
//  public JTextField getSex()
//  {
//    return sex;
//  }
//  public JTextField getAge()
//  {
//    return age;
//  }
//  public JTextField getGoal()
//  {
//    return goal;
//  }
//  public JTextField getgoalWeight()
//  {
//    return goalWeight;
//  }
//  public JTextField getActivityLevel()
//  {
//    return activityLevel;
//  }
//  public JTextField getUserName()
//  {
//    return username;
//  }
//  
//  public JPasswordField getPassword()
//  {
//    return password;
//  }
//  public JPasswordField getPassword2() {
//	  return rePassword;
//  }
  public String getHeightt()
  {
	  String selectedFood = (String) heightt.getSelectedItem();
		return selectedFood;
  }
  
  public String getWeight()
  {
	  String selectedFood = (String)weight.getSelectedItem();
		return selectedFood;
  }
  public String getSex()
  {
	  String selectedFood = (String)sex.getSelectedItem();
		return selectedFood;
  }
  public String getAge()
  {
	  String selectedFood = (String) age.getSelectedItem();
		return selectedFood;
  }
  public String getGoal()
  {
	  String selectedFood = (String) goal.getSelectedItem();
		return selectedFood;
  }
  public String getgoalWeight()
  {
	  String selectedFood = (String)goalWeight.getSelectedItem();
		return selectedFood;
  }
  public String getActivityLevel()
  {
	  String selectedFood = (String) activityLevel.getSelectedItem();
		return selectedFood;
  }
  public JTextField getUserName()
  {
    return username;
  }
  
  public JPasswordField getPassword()
  {
    return password;
  }
  public JPasswordField getPassword2() {
	  return rePassword;
  }
 
  public CreateAccount(CardLayout cl, JPanel container, ChatClient client)
  {
    
    JPanel inner = new JPanel(new GridLayout(11,2));
    
     jlabel = new JLabel("Enter username/password",JLabel.CENTER);
     String[] mf = {"Male", "Female"};
     sex = new JComboBox<>(mf);
     String[] height = new String[250];
     for(int i = 0 ; i < 250;i++)
    	 height[i] = ""+i;
     
     heightt = new JComboBox<>(height);
     
     String[] weightAR = new String[500];
     for(int i = 0 ; i < 500;i++)
    	 weightAR[i] = ""+i;
     weight = new JComboBox<>(weightAR);
     String[] ageAR =  new String[100];
     for(int i = 0 ; i < 100;i++)
    	 ageAR[i] = ""+i;
     age = new JComboBox<>(ageAR);
     String[] activityAR = {"Low","Medium","High"};
     activityLevel = new JComboBox<>(activityAR);
     String[] goalAR = {"Lose","Lose Fast"};
     goal = new JComboBox<>(goalAR);
//     String[] weightAR = {};
//     for(int i = 0 ; i < 500;i++)
//    	 weightAR[i] = ""+i;
     goalWeight = new JComboBox<>(weightAR);
     
     
     
    username = new JTextField(15);
//    heightt = new JTextField(15);
//    sex = new JTextField(15);
//    weight = new JTextField(15);
//    age = new JTextField(15);
//    activityLevel = new JTextField(15);
//    goal = new JTextField(15);
//    goalWeight = new JTextField(15);
    password = new JPasswordField(15);
    rePassword = new JPasswordField(15);
    JButton submit = new JButton("Create");
  //  submit.setPreferredSize();
    
    CreateAccountControl ca = new CreateAccountControl(cl,container,client);
    submit.addActionListener(ca);
    JButton previous = new JButton("Cancel");
    previous.addActionListener(ca);
    
    JPanel un = new JPanel(new FlowLayout());
    un.add(new JLabel("Username"));
    un.add(username);
    JPanel pw = new JPanel(new FlowLayout());
    pw.add(new JLabel("Password"));
    pw.add(password);
    JPanel sexP = new JPanel(new FlowLayout());
    sexP.add(new JLabel("Sex"));
    sexP.add(sex);
    JPanel heightP = new JPanel(new FlowLayout());
    heightP.add(new JLabel("Height"));
    heightP.add(heightt);
    JPanel ageP = new JPanel(new FlowLayout());
    ageP.add(new JLabel("Age"));
    ageP.add(age);
    JPanel weightP = new JPanel(new FlowLayout());
    weightP.add(new JLabel("Weight"));
    weightP.add(weight);
    JPanel goalP = new JPanel(new FlowLayout());
    goalP.add(new JLabel("Goal"));
    goalP.add(goal);
    JPanel activityP = new JPanel(new FlowLayout());
    activityP.add(new JLabel("Activity Level"));
    activityP.add(activityLevel);
    JPanel goalWeightP = new JPanel(new FlowLayout());
    goalWeightP.add(new JLabel("Goal Weight"));
    goalWeightP.add(goalWeight);
    JPanel rPW = new JPanel(new FlowLayout());
    rPW.add(new JLabel("Re-Enter password"));
    rPW.add(rePassword);
    JPanel submitPrevious = new JPanel(new FlowLayout());
    submitPrevious.add(submit);
    submitPrevious.add(previous);
    inner.add(jlabel);
    inner.add(un);
    inner.add(pw);
    inner.add(sexP);
    inner.add(heightP);
    inner.add(ageP);
    inner.add(weightP);
    inner.add(goalP);
    inner.add(activityP);
    inner.add(goalWeightP);
    
    inner.add(rPW);
    inner.add(submitPrevious);
  //  inner.add(submit);
 //   inner.add(previous);
 //  
    this.add(inner);
    
  }
  
 
}
