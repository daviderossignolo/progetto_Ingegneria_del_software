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
	public LoginPage() {		//frame usato come pagina di login per entrare nell'applicazione
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 160);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLbl = new JLabel("Username:\r\n");
		userLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLbl.setBounds(35, 11, 66, 26);
		contentPane.add(userLbl);
		
		JLabel passwordLbl = new JLabel("Password:");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(35, 48, 66, 26);
		contentPane.add(passwordLbl);
		
		userText = new JTextField();
		userText.setBounds(111, 14, 86, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		pswField = new JPasswordField();
		pswField.setBounds(111, 51, 86, 20);
		contentPane.add(pswField);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(new Color(245, 245, 245));
		enterButton.setBounds(76, 85, 89, 23);
		contentPane.add(enterButton);  
		enterButton.addKeyListener(new KeyListener() {			//permette di premere il pulsante enterButton con il tasto enter
			
			@Override
		    public void keyTyped(KeyEvent e) {}

		    @Override
		    public void keyReleased(KeyEvent e) {}

		    @Override
		    public void keyPressed(KeyEvent e) {				//controllo dei dati user e password inseriti
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String userValue = userText.getText();        
		    	    String passValue = pswField.getText(); 
		        	if (userValue.equals("user") && passValue.equals("1234")) {		//se corretti passa al JFrame Home
				    	  Home home = new Home();
				    	  setVisible(false);
				    	  dispose();
				    	  home.setLocationRelativeTo(null);
				    	  home.setAlwaysOnTop(rootPaneCheckingEnabled);
				    	  home.setVisible(true);
				    	  
				    	  
				      }  
				      else{										//se errati apre un pagina di avvertimento e rimuovo dai TextField i vecchi valori
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
		
		enterButton.addActionListener(new ActionListener() {			//permette di premere il pulsante enter cliccandoci sopra
			 public void actionPerformed(ActionEvent e){
				 
				 String userValue = userText.getText();        			//controllo dei dati user e password inseriti
				 String passValue = pswField.getText();
			     if (userValue.equals("user") && passValue.equals("1234")) {		//se corretti passa al JFrame Home
			    	 Home home = new Home();
			    	 dispose();
			    	 home.setAlwaysOnTop(true);
			    	 home.setLocationRelativeTo(null);
			    	 home.setVisible(true); 
			    }  
			    else{  											//se errati apre un pagina di avvertimento e rimuovo dai TextField i vecchi valori
			    	ExitMsg exit = new ExitMsg();
					exit.setBounds(100, 100, 420, 150);
					exit.infoLbl.setText("User o Password errati!!");
					exit.infoLbl.setBounds(60, 28, 400, 14);;
					JButton OkBtn = new JButton("Ok");				//aggiungo nel Frame di avvertimento il messaggio e il pulsante di conferma
					OkBtn.setBounds(300, 77, 89, 23);
					OkBtn.setBackground(new Color(245, 245, 245));
					exit.getContentPane().add(OkBtn);
					OkBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							exit.dispose();
							
						}
					});
					exit.setAlwaysOnTop(true);
					exit.setLocationRelativeTo(null);
					exit.setVisible(true); 
			   }
			}
		});
		
	}

}
