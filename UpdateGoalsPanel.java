package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateGoalsPanel  extends JPanel {
	private JLabel title;
	private JComboBox<String> goal;
	private JComboBox<String> goalWeight;
	
	public UpdateGoalsPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(11,2));
		title = new JLabel("Update your Goals",JLabel.CENTER);
		String[] weightAR = new String[500];
	     for(int i = 0 ; i < 500;i++)
	    	 weightAR[i] = ""+i;
		String[] goalAR = {"Lose","Lose Fast"};
	     goal = new JComboBox<>(goalAR);
	     goalWeight = new JComboBox<>(weightAR);
		
		JButton submit = new JButton("Submit New Goals");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
		JPanel goalP = new JPanel(new FlowLayout());
	    goalP.add(new JLabel("Enter New Goal"));
	    goalP.add(goal);
	    JPanel goalWeightP = new JPanel(new FlowLayout());
	    goalWeightP.add(new JLabel("Enter new Goal Weight"));
	    goalWeightP.add(goalWeight);

	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	    inner.add(goalP);
	    inner.add(goalWeightP);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
		
		
		
	}
	
	public String getGoal(){
		return (String) goal.getSelectedItem();
	}
	
	public String getGoalWeight() {
		return (String) goalWeight.getSelectedItem();
		
	}
	
		
	
}
