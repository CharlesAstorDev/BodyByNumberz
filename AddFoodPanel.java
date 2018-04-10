package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddFoodPanel extends JPanel {

	private JLabel title;
	private JTextField foodName;
	private JTextField protein;
	private JTextField carb;
	private JTextField fat;

	
	public AddFoodPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(11,2));
		title = new JLabel("Please add a Food",JLabel.CENTER);
		foodName = new JTextField(30);
		protein = new JTextField(15);
		carb = new JTextField(15);
		fat = new JTextField(15);
		JButton submit = new JButton("Add New Food");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
		JPanel foodNameP = new JPanel(new FlowLayout());
	    foodNameP.add(new JLabel("Enter Food Name"));
	    foodNameP.add(foodName);
	    JPanel proteinP = new JPanel(new FlowLayout());
	    proteinP.add(new JLabel("Protein"));
	    proteinP.add(protein);
	    JPanel carbP = new JPanel(new FlowLayout());
	    carbP.add(new JLabel("Carbohydrate"));
	    carbP.add(carb);
	    JPanel fatP = new JPanel(new FlowLayout());
	    fatP.add(new JLabel("Fat"));
	    fatP.add(fat);
	    
	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	    inner.add(foodNameP);
	    inner.add(proteinP);
	    inner.add(carbP);
	    inner.add(fatP);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
		
		
		
	}
	
	public JTextField getFoodName(){
		return foodName;
	}
	
	public JTextField getCarb() {
		return carb;
		
	}
	public JTextField getProtein() {
		return protein;
	}
	
	public JTextField getFat() {
		return fat;
	}
}
