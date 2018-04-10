package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeighInPanel extends JPanel {

	private JLabel title;
	private JComboBox<String> weight;
	
	public WeighInPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(11,2));
		title = new JLabel("Please Weigh In",JLabel.CENTER);
		String[] weightAr = new String[500];
		for(int i = 0; i < 500; i++)
			weightAr[i] =""+ i;
		weight = new JComboBox<>(weightAr);
		JButton submit = new JButton("Enter Weight");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
		
	    JPanel weightP = new JPanel(new FlowLayout());
	    weightP.add(new JLabel("Weight in KG: "));
	    weightP.add(weight);
	    
	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	    
	    inner.add(weightP);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
		
	}
	
	public String getWeight(){
		return (String) weight.getSelectedItem();
	}
}
