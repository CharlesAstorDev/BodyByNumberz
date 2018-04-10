package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateMacrosPanel extends JPanel {

	private JLabel title;
	
	private JTextField proteinPercent;
	private JTextField carbPercent;
	private JTextField fatPercent;
	public UpdateMacrosPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(11,2));
		title = new JLabel("Please Adjust your macro nutrient ratio Preference",JLabel.CENTER);
		
		proteinPercent = new JTextField(15);
		carbPercent = new JTextField(15);
		fatPercent = new JTextField(15);
		JButton submit = new JButton("Submit Macros");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
	    JPanel proteinP = new JPanel(new FlowLayout());
	    proteinP.add(new JLabel("Protein Percent"));
	    proteinP.add(proteinPercent);
	    JPanel carbP = new JPanel(new FlowLayout());
	    carbP.add(new JLabel("Carbohydrate Percent"));
	    carbP.add(carbPercent);
	    JPanel fatP = new JPanel(new FlowLayout());
	    fatP.add(new JLabel("FatPercent"));
	    fatP.add(fatPercent);
	    
	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	  
	    inner.add(proteinP);
	    inner.add(carbP);
	    inner.add(fatP);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
		
		
		
	}
	
	public void setError() {
		title.setText("Invalid, inputs must equal 100");
		
	}
	public JTextField getCarb() {
		return carbPercent;
		
	}
	public JTextField getProtein() {
		return proteinPercent;
	}
	
	public JTextField getFat() {
		return fatPercent;
	}
		 
	
}
