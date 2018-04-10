package bodyByNumberz;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogFoodPanel extends JPanel {

	private JLabel title;
	private JTextField foodName;
	private JTextField protein;
	private JTextField carb;
	private JTextField fat;
	private String[] foodArray; 
   JComboBox<String> foods; 

//add to the parent container (e.g. a JFrame):
//add(bookList);
//
////get the selected item:
//String selectedBook = (String) bookList.getSelectedItem();
//System.out.println("You seleted the book: " + selectedBook);
	public LogFoodPanel(CardLayout cl, JPanel container, ChatClient client)
	{
		foodArray = new String[] {};

		foods =  new JComboBox<>(foodArray);
		ProfileController profileControl = new ProfileController(cl,container,client);
		JPanel inner = new JPanel(new GridLayout(11,2));
		title = new JLabel("Please Log Your Food",JLabel.CENTER);
		
		JButton submit = new JButton("Submit New Food");
		JButton goBack = new JButton("Go Back");
		JButton logout = new JButton("Log Out");
		
		
	    
	    JPanel bottom = new JPanel(new FlowLayout());
	    bottom.add(submit);
	   
	    bottom.add(goBack);
	    bottom.add(logout);
	    inner.add(title);
	    inner.add(foods);
	    inner.add(bottom);
	    
	    goBack.addActionListener(profileControl);
	    submit.addActionListener(profileControl);
	    logout.addActionListener(profileControl);
	    
	    
	    this.add(inner);
		
		
	}
	public void setFoodArEmpty(){
		foods.removeAllItems();
	}
	public void setFoodArray(String[] food) {
	 for(int i = 0; i < food.length;i++)
		foods.addItem(food[i]);
	}
	
	public String getFood(){
		String selectedFood = (String) foods.getSelectedItem();
		return selectedFood;
	}
	
	
}
