package it.univr.lavoratoriStagionali;
 
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
 
@SuppressWarnings("serial")
class LoginPage extends JFrame implements ActionListener{  
    
	// dichiarazione delle variabili utilizzate
	private JButton submitButton;  
	private JPanel loginPanel;  
	private JLabel userLabel, passLabel;  
	private final JTextField  userText, passText;  
      
	public LoginPage(){       
        
		// inizializzo campo utente
		userLabel = new JLabel();  
		userLabel.setText("Username");        
		userText = new JTextField(15);

		// inizializzo campo password 
		passLabel = new JLabel();  
		passLabel.setText("Password");      
        passText = new JPasswordField(15);    
        
        // bottone login
		submitButton = new JButton("SUBMIT");   
        
	      
		loginPanel = new JPanel(new GridLayout(3, 1));  
		loginPanel.add(userLabel);   
		loginPanel.add(userText);    
		loginPanel.add(passLabel);    
		loginPanel.add(passText);   
		loginPanel.add(submitButton);           
        
		
		add(loginPanel, BorderLayout.CENTER);  
        
       
		submitButton.addActionListener(this);    
		setTitle("LOGIN FORM");         
  }  
    
    
  public void actionPerformed(ActionEvent e){  
	  String userValue = userText.getText();        
      String passValue = passText.getText();      
         
      if (userValue.equals("utente1") && passValue.equals("password")) {
            
          System.out.println("Success");  
      }  
      else{  
          System.out.println("Error");  
      }  
  }  
}  
