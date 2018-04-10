package bodyByNumberz;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FuturePlanPanel extends JPanel {

	private JLabel title;
	private String[] selectionArray = {"Week Plan",
			"Month Plan", "3 Month Plan"};
	private JTextArea planArea;
	
	JComboBox<String> plans; 
	public FuturePlanPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		plans =  new JComboBox<>(selectionArray);
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(4,2));
		planArea = new JTextArea(10,18);
		title = new JLabel("View your Plan",JLabel.CENTER);
		
		JPanel planPanel = new JPanel();
		planPanel.add(new JScrollPane(planArea));
		
		JButton submit = new JButton("Select Plan");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
		
	    
	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	    inner.add(plans);
	    inner.add(planPanel);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
	}
	
	public String getPlan() {
		String futureStringPlan = (String) plans.getSelectedItem();
		
		return futureStringPlan;
	}
	
	public void setFuturePlan(String futureString) {
		planArea.setText(futureString);
	}
}
