package bodyByNumberz;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;


public class ClientGUI extends JFrame
{
  private JPanel view1;  //3 views
  private JPanel view2;
  private JPanel view3;
  private JPanel view4;
  private JPanel view5;
  private JPanel view6;
  private JPanel view7;
  private JPanel view8;
  private JPanel view9;
  private JPanel view10;
  
  private ChatClient client;
  
  private CardLayout cl = new CardLayout(); //Card Layout
  private JPanel container = new JPanel(cl);
  public ClientGUI()
  {
    //Set close
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    client = new ChatClient();
    client.setHost("localhost");
    client.setPort(8300);
    try
    {
      client.openConnection();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    //Set container to CardLayout
    container = new JPanel(cl);
    
    //Create the different views
    view1 = new InitialPanel(cl,container);
    view2 = new LoginPanel(cl,container,client);
   // view3 = new ContactPanel(cl,container);
    view3 = new ProfilePanel(cl,container, client);
    view4 = new CreateAccount(cl,container,client);
    view5 = new UpdateGoalsPanel(cl,container,client);
    view6 = new FuturePlanPanel(cl,container,client);
    view7 = new WeighInPanel(cl,container,client);
    view8 = new LogFoodPanel(cl,container,client);
    view9 = new UpdateMacrosPanel(cl,container,client);
    view10 = new AddFoodPanel(cl,container,client);
    
    
    
    //Add the different views to the CardLayoutContainer
    container.add(view1,"1");
    container.add(view2,"2");
   container.add(view3,"3");
   container.add(view4,"4");
   container.add(view5,"5");
   container.add(view6,"6");
   container.add(view7,"7");
   container.add(view8,"8");
   container.add(view9,"9");
   container.add(view10,"10");
    
    //Show the first 1
    cl.show(container, "1");
    
    this.add(container,BorderLayout.CENTER);
    
    //this.add(view1,BorderLayout.CENTER);
    
    this.setSize(1100,800);
    this.setVisible(true);
    
  }
  
 
  
 
  
  public static void main(String[] args)
  {
    new ClientGUI();
  }
  
}
