package bodyByNumberz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel
{
  private JTextField username;
  private JPasswordField password;
  private JLabel jlabel;
  
  
  public void setField(String lbl, int num) {
	  if(num == 1){
		  jlabel.setForeground(Color.RED);
	  }
	  else {
		  jlabel.setForeground(Color.BLACK);
	  }
	  jlabel.setText(lbl);
  }
  public JTextField getUserName()
  {
    return username;
  }
  
  public JPasswordField getPassword()
  {
    return password;
  }
 
  public LoginPanel(CardLayout cl, JPanel container, ChatClient client)
  {
    
    JPanel inner = new JPanel(new GridLayout(5,2));
    
     jlabel = new JLabel("Enter username/password",JLabel.CENTER);
    username = new JTextField(15);
    password = new JPasswordField(15);
    JButton submit = new JButton("Submit");
    submit.setPreferredSize(new Dimension(30,30));
    
    LoginControl lc = new LoginControl(cl,container,client);
    submit.addActionListener(lc);
    JButton previous = new JButton("Cancel");
    previous.addActionListener(lc);
    
    JPanel un = new JPanel(new FlowLayout());
    un.add(new JLabel("Username"));
    un.add(username);
    JPanel pw = new JPanel(new FlowLayout());
    pw.add(new JLabel("Password"));
    pw.add(password);
    
    inner.add(jlabel);
    inner.add(un);
    inner.add(pw);
    inner.add(submit);
    inner.add(previous);
    
    this.add(inner);
    
  }
  
 
}
