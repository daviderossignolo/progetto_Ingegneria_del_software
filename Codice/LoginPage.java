package it.univr.lavoratoriStagionali;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField pswField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 160);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserLbl = new JLabel("Username:\r\n");
		UserLbl.setHorizontalAlignment(SwingConstants.CENTER);
		UserLbl.setBounds(35, 11, 66, 26);
		contentPane.add(UserLbl);
		
		JLabel PasswordLbl = new JLabel("Password:");
		PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLbl.setBounds(35, 48, 66, 26);
		contentPane.add(PasswordLbl);
		
		userText = new JTextField();
		userText.setBounds(111, 14, 86, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		pswField = new JPasswordField();
		pswField.setBounds(111, 51, 86, 20);
		contentPane.add(pswField);
		
		JButton EnterButton = new JButton("Enter");
		EnterButton.setBackground(new Color(245, 245, 245));
		EnterButton.setBounds(76, 85, 89, 23);
		contentPane.add(EnterButton);  
		EnterButton.addKeyListener(new KeyListener() {
			
			@Override
		    public void keyTyped(KeyEvent e) {}

		    @Override
		    public void keyReleased(KeyEvent e) {}

		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String userValue = userText.getText();        
		    	    String passValue = pswField.getText(); 
		        	if (userValue.equals("user") && passValue.equals("1234")) {
				    	  Home home = new Home();
				    	  setVisible(false);
				    	  dispose();
				    	  home.setLocationRelativeTo(null);
				    	  home.setAlwaysOnTop(rootPaneCheckingEnabled);
				    	  home.setVisible(true);
				    	  
				    	  
				      }  
				      else{  
				    	  JFrame tmp = new JFrame();
				    	  userText.setText("");
				    	  pswField.setText("");
				    	  tmp.setAlwaysOnTop(true);
				    	  tmp.setLocationRelativeTo(null);
				    	  JOptionPane.showMessageDialog(tmp, "User o Password errati!!");
				      }
				 }
		        }

		});
		
		EnterButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 
				 String userValue = userText.getText();        
				 String passValue = pswField.getText();
			     if (userValue.equals("user") && passValue.equals("1234")) {
			    	 Home home = new Home();
			    	 setVisible(false);
			    	 dispose();
			    	 home.setAlwaysOnTop(rootPaneCheckingEnabled);
			    	 home.setLocationRelativeTo(null);
			    	 home.setVisible(true); 
			    }  
			    else{  
			    	JFrame tmp = new JFrame();
			    	userText.setText("");
			    	pswField.setText("");
			    	tmp.setAlwaysOnTop(true);
			    	tmp.setLocationRelativeTo(null);
			    	JOptionPane.showMessageDialog(tmp, "User o Password errati!!");
			   }
			}
		});
		
	}

}
