package it.univr.lavoratoriStagionali;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AddNewWorkerContact extends JFrame {

	private JPanel contentPane;
	private JTextField nameField_1;
	private JTextField surnameField_1;
	private JTextField phoneField_1;
	private JTextField mailField_1;
	private JTextField nameField_2;
	private JTextField surnameField_2;
	private JTextField phoneField_2;
	private JTextField mailField_2;
	private JTextField nameField_3;
	private JTextField surnameField_3;
	private JTextField phoneField_3;
	private JTextField mailField_3;
	private JLabel error_1 = new JLabel("*");
	private JLabel error_2 = new JLabel("*");
	private JLabel error_3 = new JLabel("*");
	private JLabel error_4 = new JLabel("*");
	private JLabel error_1_2 = new JLabel("*");
	private JLabel error_2_2 = new JLabel("*");
	private JLabel error_3_2 = new JLabel("*");
	private JLabel error_4_2 = new JLabel("*");
	private JLabel error_1_3 = new JLabel("*");
	private JLabel error_2_3 = new JLabel("*");
	private JLabel error_3_3 = new JLabel("*");
	private JLabel error_4_3 = new JLabel("*");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewWorkerContact frame = new AddNewWorkerContact();
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
	public AddNewWorkerContact() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel emergencyLbl = new JLabel("Registrazione lavoratore: Contatti di emergenza");
		emergencyLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		emergencyLbl.setBounds(10, 0, 474, 30);
		contentPane.add(emergencyLbl);
		
		nameField_1 = new JTextField();
		nameField_1.setColumns(10);
		nameField_1.setBounds(10, 97, 86, 20);
		contentPane.add(nameField_1);
		JLabel Error_1 = this.error_1;
		Error_1.setForeground(new Color(255, 0, 0));
		Error_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_1.setBounds(41, 81, 46, 14);
		contentPane.add(Error_1);
		isEmpty(Error_1, nameField_1);
		
		surnameField_1 = new JTextField();
		surnameField_1.setColumns(10);
		surnameField_1.setBounds(162, 97, 86, 20);
		contentPane.add(surnameField_1);
		JLabel Error_2 = this.error_2;
		Error_2.setForeground(Color.RED);
		Error_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_2.setBounds(215, 81, 46, 14);
		contentPane.add(Error_2);
		isEmpty(Error_2, surnameField_1);
		
		phoneField_1 = new JTextField();
		phoneField_1.setColumns(10);
		phoneField_1.setBounds(10, 141, 123, 20);
		contentPane.add(phoneField_1);
		JLabel Error_3 = this.error_3;
		Error_3.setForeground(Color.RED);
		Error_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_3.setBounds(58, 128, 46, 14);
		contentPane.add(Error_3);
		emptyPhoneNumber(Error_3, phoneField_1);
		
		mailField_1 = new JTextField();
		mailField_1.setColumns(10);
		mailField_1.setBounds(160, 141, 206, 20);
		contentPane.add(mailField_1);
		JLabel Error_4 = this.error_4;
		Error_4.setForeground(Color.RED);
		Error_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_4.setBounds(236, 128, 46, 14);
		contentPane.add(Error_4);
		emptyMail(Error_4, mailField_1);
		
		JLabel nameLbl_1 = new JLabel("Nome");
		nameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameLbl_1.setBounds(10, 83, 46, 14);
		contentPane.add(nameLbl_1);
		
		JLabel surnameLbl_1 = new JLabel("Cognome\r\n");
		surnameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		surnameLbl_1.setBounds(162, 83, 65, 14);
		contentPane.add(surnameLbl_1);
		
		JLabel phoneLbl_1 = new JLabel("Telefono");
		phoneLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneLbl_1.setBounds(10, 128, 71, 14);
		contentPane.add(phoneLbl_1);
		
		JLabel mailLbl_1 = new JLabel("Indirizzo mail");
		mailLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		mailLbl_1.setBounds(160, 128, 86, 14);
		contentPane.add(mailLbl_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(220, 220, 220));
		separator.setBounds(10, 172, 439, 2);
		contentPane.add(separator);
		
		JLabel firstLbl = new JLabel("Primo contatto");
		firstLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		firstLbl.setBounds(10, 52, 107, 14);
		contentPane.add(firstLbl);
		
		nameField_2 = new JTextField();
		nameField_2.setColumns(10);
		nameField_2.setBounds(10, 230, 86, 20);
		contentPane.add(nameField_2);
		nameField_2.setEditable(false);
		JLabel Error_1_2 = this.error_1_2;
		Error_1_2.setForeground(Color.RED);
		Error_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_1_2.setBounds(41, 214, 46, 14);
		Error_1_2.setVisible(false);
		contentPane.add(Error_1_2);
		
		
		surnameField_2 = new JTextField();
		surnameField_2.setColumns(10);
		surnameField_2.setBounds(162, 230, 86, 20);
		contentPane.add(surnameField_2);
		surnameField_2.setEditable(false);
		JLabel Error_2_2 = this.error_2_2;
		Error_2_2.setForeground(Color.RED);
		Error_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_2_2.setBounds(215, 216, 46, 14);
		Error_2_2.setVisible(false);
		contentPane.add(Error_2_2);
		
		
		phoneField_2 = new JTextField();
		phoneField_2.setColumns(10);
		phoneField_2.setBounds(10, 274, 123, 20);
		contentPane.add(phoneField_2);
		phoneField_2.setEditable(false);
		JLabel Error_3_2 = this.error_3_2;
		Error_3_2.setForeground(Color.RED);
		Error_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_3_2.setBounds(58, 261, 46, 14);
		Error_3_2.setVisible(false);
		contentPane.add(Error_3_2);
		
		
		mailField_2 = new JTextField();
		mailField_2.setColumns(10);
		mailField_2.setBounds(160, 274, 206, 20);
		contentPane.add(mailField_2);
		mailField_2.setEditable(false);	
		JLabel Error_4_2 = this.error_4_2;
		Error_4_2.setForeground(Color.RED);
		Error_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_4_2.setBounds(236, 261, 46, 14);
		Error_4_2.setVisible(false);
		contentPane.add(Error_4_2);
		
		
		JLabel nameLbl_2 = new JLabel("Nome");
		nameLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameLbl_2.setBounds(10, 216, 46, 14);
		contentPane.add(nameLbl_2);
		
		JLabel surnameLbl_2 = new JLabel("Cognome\r\n");
		surnameLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		surnameLbl_2.setBounds(162, 216, 65, 14);
		contentPane.add(surnameLbl_2);
		
		JLabel phoneLbl_2 = new JLabel("Telefono");
		phoneLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneLbl_2.setBounds(10, 261, 71, 14);
		contentPane.add(phoneLbl_2);
		
		JLabel mailLbl_2 = new JLabel("Indirizzo mail");
		mailLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		mailLbl_2.setBounds(160, 261, 86, 14);
		contentPane.add(mailLbl_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(220, 220, 220));
		separator_1.setBounds(10, 305, 439, 2);
		contentPane.add(separator_1);
		
		JLabel secondLbl = new JLabel("Secondo contatto");
		secondLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		secondLbl.setBounds(10, 185, 137, 14);
		contentPane.add(secondLbl);
		
		nameField_3 = new JTextField();
		nameField_3.setColumns(10);
		nameField_3.setBounds(10, 363, 86, 20);
		nameField_3.setEditable(false);
		contentPane.add(nameField_3);
		JLabel Error_1_3 = this.error_1_3;
		Error_1_3.setForeground(Color.RED);
		Error_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_1_3.setBounds(41, 349, 46, 14);
		Error_1_3.setVisible(false);
		contentPane.add(Error_1_3);
		
		
		surnameField_3 = new JTextField();
		surnameField_3.setColumns(10);
		surnameField_3.setBounds(162, 363, 86, 20);
		surnameField_3.setEditable(false);
		contentPane.add(surnameField_3);
		JLabel Error_2_3 = this.error_2_3;
		Error_2_3.setForeground(Color.RED);
		Error_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_2_3.setBounds(215, 349, 46, 14);
		Error_2_3.setVisible(false);
		contentPane.add(Error_2_3);
		
		
		phoneField_3 = new JTextField();
		phoneField_3.setColumns(10);
		phoneField_3.setBounds(10, 407, 123, 20);
		phoneField_3.setEditable(false);
		contentPane.add(phoneField_3);
		JLabel Error_3_3 = this.error_3_3;
		Error_3_3.setForeground(Color.RED);
		Error_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_3_3.setBounds(58, 394, 46, 14);
		Error_3_3.setVisible(false);
		contentPane.add(Error_3_3);
		
		
		mailField_3 = new JTextField();
		mailField_3.setColumns(10);
		mailField_3.setBounds(160, 407, 206, 20);
		mailField_3.setEditable(false);
		contentPane.add(mailField_3);
		JLabel Error_4_3 = this.error_4_3;
		Error_4_3.setForeground(Color.RED);
		Error_4_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_4_3.setBounds(236, 394, 46, 14);
		Error_4_3.setVisible(false);
		contentPane.add(Error_4_3);
		
		
		JLabel infoError = new JLabel("*-> campo non valido");
		infoError.setForeground(Color.RED);
		infoError.setFont(new Font("Tahoma", Font.BOLD, 13));
		infoError.setBounds(10, 460, 162, 14);
		contentPane.add(infoError);
		
		JLabel nameLbl_3 = new JLabel("Nome");
		nameLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameLbl_3.setBounds(10, 349, 46, 14);
		contentPane.add(nameLbl_3);
		
		JLabel surnameLbl_3 = new JLabel("Cognome\r\n");
		surnameLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		surnameLbl_3.setBounds(162, 349, 65, 14);
		contentPane.add(surnameLbl_3);
		
		JLabel phoneLbl_3 = new JLabel("Telefono");
		phoneLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneLbl_3.setBounds(10, 394, 71, 14);
		contentPane.add(phoneLbl_3);
		
		JLabel mailLbl_3 = new JLabel("Indirizzo mail");
		mailLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		mailLbl_3.setBounds(160, 394, 86, 14);
		contentPane.add(mailLbl_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(220, 220, 220));
		separator_2.setBounds(10, 438, 439, 2);
		contentPane.add(separator_2);
		
		JLabel thirdLbl = new JLabel("Terzo contatto");
		thirdLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		thirdLbl.setBounds(10, 318, 107, 14);
		contentPane.add(thirdLbl);
		
		JLabel infoLbl = new JLabel("*Nota: almeno un contatto deve esser obbligatoriamente compilato");
		infoLbl.setForeground(new Color(128, 128, 128));
		infoLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		infoLbl.setBounds(10, 27, 344, 14);
		contentPane.add(infoLbl);
		
		
		JToggleButton contact2Btn = new JToggleButton("Abilita");
		contact2Btn.setBounds(360, 185, 89, 20);
		contact2Btn.setBackground(new Color(255, 51, 51));
		contentPane.add(contact2Btn);
		contact2Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contact2Btn.isSelected()) {
					nameField_2.setEditable(true);
					Error_1_2.setVisible(true);
					surnameField_2.setEditable(true);
					Error_2_2.setVisible(true);
					mailField_2.setEditable(true);
					Error_3_2.setVisible(true);
					phoneField_2.setEditable(true);
					Error_4_2.setVisible(true);
				}
				else {
					nameField_2.setEditable(false);
					nameField_2.setText("");
					Error_1_2.setVisible(false);
					surnameField_2.setEditable(false);
					surnameField_2.setText("");
					Error_2_2.setVisible(false);
					mailField_2.setEditable(false);
					mailField_2.setText("");
					Error_3_2.setVisible(false);
					phoneField_2.setEditable(false);
					phoneField_2.setText("");
					Error_4_2.setVisible(false);
				}
				repaint();
				revalidate();
				
			}
		});
		isEmptyWBtn(Error_1_2, nameField_2, contact2Btn);
		isEmptyWBtn(Error_2_2, surnameField_2, contact2Btn);
		emptyPhoneNumberWBtn(Error_3_2, phoneField_2, contact2Btn);
		emptyMailWBtn(Error_4_2, mailField_2, contact2Btn);
		
		
		
		JToggleButton contact3Btn = new JToggleButton("Abilita");
		contact3Btn.setText("Abilita");
		contact3Btn.setBounds(360, 318, 89, 20);
		contact3Btn.setBackground(new Color(255, 51, 51));
		contentPane.add(contact3Btn);
		contact3Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contact3Btn.isSelected()) {
					nameField_3.setEditable(true);
					Error_1_3.setVisible(true);
					surnameField_3.setEditable(true);
					Error_2_3.setVisible(true);
					mailField_3.setEditable(true);
					Error_3_3.setVisible(true);
					phoneField_3.setEditable(true);
					Error_4_3.setVisible(true);
				}
				else {
					nameField_3.setEditable(false);
					nameField_3.setText("");
					Error_1_3.setVisible(false);
					surnameField_3.setEditable(false);
					surnameField_3.setText("");
					Error_2_3.setVisible(false);
					mailField_3.setEditable(false);
					mailField_3.setText("");
					Error_3_3.setVisible(false);
					phoneField_3.setEditable(false);
					phoneField_3.setText("");
					Error_4_3.setVisible(false);
				}
				repaint();
				revalidate();
				
			}
		});
		isEmptyWBtn(Error_1_3, nameField_3, contact3Btn);
		isEmptyWBtn(Error_2_3, surnameField_3, contact3Btn);
		emptyPhoneNumberWBtn(Error_3_3, phoneField_3, contact3Btn);
		emptyMailWBtn(Error_4_3, mailField_3, contact3Btn);
		
		UIManager.put("ToggleButton.select", Color.decode("#32cd32"));
		SwingUtilities.updateComponentTreeUI(contact2Btn);
		SwingUtilities.updateComponentTreeUI(contact3Btn);
		
		
		JButton indietroBtn = new JButton("Indietro");
		indietroBtn.setBackground(new Color(245, 245, 245));
		indietroBtn.setBounds(261, 451, 89, 23);
		contentPane.add(indietroBtn);
		indietroBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExitMsg exit = new ExitMsg();
				JButton CancelBtn = new JButton("Cancella\r\n");
				CancelBtn.setBounds(285, 77, 89, 23);
				CancelBtn.setBackground(new Color(245, 245, 245));
				exit.getContentPane().add(CancelBtn);
				CancelBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
							exit.dispose();
					}
				});
				
				JButton OkBtn = new JButton("Ok");
				OkBtn.setBounds(186, 77, 89, 23);
				OkBtn.setBackground(new Color(245, 245, 245));
				exit.getContentPane().add(OkBtn);
				OkBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						exit.dispose();
				    	dispose();
					}
				});
				exit.setAlwaysOnTop(true);
				exit.setLocationRelativeTo(null);
				exit.setVisible(true); 

			}
		});
		
		JButton avantiBtn = new JButton("Avanti");
		avantiBtn.setBackground(new Color(245, 245, 245));
		avantiBtn.setBounds(360, 451, 89, 23);
		contentPane.add(avantiBtn);
		avantiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExitMsg exit = new ExitMsg();
				exit.setBounds(100, 100, 420, 150);
				exit.infoLbl.setText("Qualche campo non è compilato correttamente!!");
				exit.infoLbl.setBounds(60, 28, 400, 14);;
				JButton OkBtn = new JButton("Ok");
				OkBtn.setBounds(300, 77, 89, 23);
				OkBtn.setBackground(new Color(245, 245, 245));
				exit.getContentPane().add(OkBtn);
				OkBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						exit.dispose();
					}
				});
				if(Error_1.isVisible() || Error_2.isVisible() || Error_3.isVisible() || Error_4.isVisible()) {
					if((contact2Btn.isSelected()) || Error_1_2.isVisible() || Error_2_2.isVisible() || Error_3_2.isVisible() || Error_4_2.isVisible()) {
						if((contact3Btn.isSelected()) || Error_1_3.isVisible() || Error_2_3.isVisible() || Error_3_3.isVisible() || Error_4_3.isVisible()) {
							exit.setAlwaysOnTop(true);
							exit.setLocationRelativeTo(null);
							exit.setVisible(true);
						}
						exit.setAlwaysOnTop(true);
						exit.setLocationRelativeTo(null);
						exit.setVisible(true);	
					}
					exit.setAlwaysOnTop(true);
					exit.setLocationRelativeTo(null);
					exit.setVisible(true);
				}
				else {
					AddNewWorkerJobs jobs = new AddNewWorkerJobs();
					jobs.setAlwaysOnTop(true);
					jobs.setLocationRelativeTo(null);
					jobs.setVisible(true);
				}
				
			}
		});
	}
	
	public void sameDataPhone() {
		if((phoneField_1.getText().equals(phoneField_2.getText())) && !phoneField_1.getText().isEmpty()) {
			error_3.setVisible(true);
			error_3_2.setVisible(true);
		}
	
		if((phoneField_1.getText().equals(phoneField_3.getText())) && !phoneField_1.getText().isEmpty()) {
			error_3.setVisible(true);
			error_3_3.setVisible(true);
		}
	
		if((phoneField_1.getText().equals(phoneField_3.getText()) && phoneField_2.getText().equals(phoneField_3.getText())) && phoneField_3.getText().isEmpty()) {
			error_3.setVisible(true);
			error_3_2.setVisible(true);
			error_3_3.setVisible(true);
		}

		
	}
	
	public void sameDataMail() {
		if((mailField_1.getText().equals(mailField_2.getText())) && !mailField_1.getText().isEmpty()) {
			error_4.setVisible(true);
			error_4_2.setVisible(true);
		}
		if((mailField_1.getText().equals(mailField_3.getText())) && !mailField_1.getText().isEmpty()) {
			error_4.setVisible(true);
			error_4_3.setVisible(true);
		}
		if((mailField_1.getText().equals(mailField_3.getText()) && mailField_2.getText().equals(mailField_3.getText())) && !mailField_3.getText().isEmpty()) {
			error_4.setVisible(true);
			error_4_2.setVisible(true);
			error_4_3.setVisible(true);
		}
	}
	
	
	public class EmptyListener implements DocumentListener {

        private final Timer timer;

        public EmptyListener(int timeOut, ActionListener listener, boolean repeats) {
            timer = new Timer(timeOut, listener);
            timer.setRepeats(repeats);
        }

        public void start() {timer.start();}

        public void stop() {timer.stop();}

        @Override
        public void insertUpdate(DocumentEvent e) {timer.restart();}

        @Override
        public void removeUpdate(DocumentEvent e) {timer.restart();}

        @Override
        public void changedUpdate(DocumentEvent e) {timer.restart();}
    }

	public void emptyPhoneNumber(JLabel error, JTextField phone) {
		EmptyListener phoneListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = phone.getText();
        		String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
        		Pattern phonePat = Pattern.compile(phoneRegex);
        		Matcher matcher = phonePat.matcher(text);
        		if((matcher.find() == false && !text.isEmpty())) {
    				error.setVisible(true);
    			}
    			else {
    				//sameDataPhone();
    				error.setVisible(false);
    				sameDataPhone();
    			}
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(phone, phoneListener);;
		
	}
	
	public void emptyPhoneNumberWBtn(JLabel error, JTextField phone, JToggleButton btn) {
		EmptyListener phoneListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = phone.getText();
        		String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
        		Pattern phonePat = Pattern.compile(phoneRegex);
        		Matcher matcher = phonePat.matcher(text);
        		if((!matcher.find() || text.isEmpty()) && btn.isSelected()) {
        			error.setVisible(true);
        		}
        		else {
        			//sameDataPhone();
        			error.setVisible(false);
        			sameDataPhone();
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(phone, phoneListener);;
		
	}
	
	public void isEmpty(JLabel error, JTextField field) {
		EmptyListener emptyListener = new EmptyListener(500, new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent e) {
        		if(field.getText().isEmpty()) { 
        			error.setVisible(true);
        		}
        		else{
        			error.setVisible(false);
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		
		addListener(field, emptyListener);
    }
	
	public void isEmptyWBtn(JLabel error, JTextField field, JToggleButton btn) {
		EmptyListener emptyListener = new EmptyListener(500, new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent e) {
        		if(field.getText().isEmpty() && btn.isSelected()) { 
        			error.setVisible(true);
        		}
        		else{
        			error.setVisible(false);
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		
		addListener(field, emptyListener);
    }
	
	public void emptyMail(JLabel error, JTextField mail) {
		EmptyListener mailListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = mail.getText();
    			String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    							+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        		Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
        		Matcher matcher = mailPat.matcher(text);
    			if(matcher.find() == false && !text.isEmpty()) {
    				error.setVisible(true);
    			}
    			else {
					error.setVisible(false);
					sameDataMail();
    			}
        		
        		
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(mail, mailListener);
	}
	
	public void emptyMailWBtn(JLabel error, JTextField mail, JToggleButton btn) {
		EmptyListener mailListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = mail.getText();
    			String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    							+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        		Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
        		Matcher matcher = mailPat.matcher(text);
        		if((!matcher.find() || text.isEmpty()) && btn.isSelected()) {
        			error.setVisible(true);
        		}
        		else {
    				error.setVisible(false);
    				sameDataMail();
        		}
        		
        		revalidate();
    			repaint();
            }
        }, true);
		addListener(mail, mailListener);
	}
	
	public void addListener(JTextField field, EmptyListener listener) {
		field.getDocument().addDocumentListener(listener);
		contentPane.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	listener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	listener.stop();
            }
        });
	}
}
