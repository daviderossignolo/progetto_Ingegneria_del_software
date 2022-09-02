package it.univr.lavoratoriStagionali;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import it.univr.lavoratoriStagionali.AddNewWorkerContact.EmptyListener;

public class AddNewWorker extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField dateField;
	private JTextField bornField;
	private JTextField homeField;
	private JTextField phoneField;
	private JTextField mailField;
	private JTextField nationField;
	private JTextField languagesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewWorker frame = new AddNewWorker();
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
	public AddNewWorker() {		//frame usato per l'inserimento dei vari dati anagrafici di un nuovo lavoratore
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new LineBorder(new Color(171, 173, 179))));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Registrazione lavoratore: Dati");
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setBounds(94, 6, 304, 30);
		contentPane.add(title);
		
		JLabel notValidLbl = new JLabel("* -> campo non valido");
		notValidLbl.setVisible(true);
		notValidLbl.setForeground(new Color(255, 0, 0));
		notValidLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		notValidLbl.setBounds(10, 394, 174, 14);
		contentPane.add(notValidLbl);
		
/**********************************************************************************************************************/
		JLabel nameLbl = new JLabel("Nome");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameLbl.setBounds(10, 47, 46, 14);
		contentPane.add(nameLbl);
		
		nameField = new JTextField();
		nameField.setBounds(10, 61, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel error_1 = new JLabel("*");
		error_1.setForeground(Color.RED);
		error_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_1.setBounds(42, 47, 32, 14);
		contentPane.add(error_1);
		error_1.setVisible(true);
		isEmpty(error_1, nameField);		//chiamata a funzione per far comparire il messaggio di errore
		
/**********************************************************************************************************************/	
		JLabel surnameLbl = new JLabel("Cognome\r\n");
		surnameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		surnameLbl.setBounds(162, 47, 65, 14);
		contentPane.add(surnameLbl);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(162, 61, 86, 20);
		contentPane.add(surnameField);
		
		JLabel error_2 = new JLabel("*");
		error_2.setForeground(Color.RED);
		error_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_2.setBounds(216, 47, 32, 14);
		contentPane.add(error_2);
		error_2.setVisible(true);
		isEmpty(error_2, surnameField);		//chiamata a funzione per far comparire il messaggio di errore
		
/**********************************************************************************************************************/
		JLabel dateLbl = new JLabel("Data di nascita");
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateLbl.setBounds(10, 99, 86, 14);
		contentPane.add(dateLbl);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(10, 114, 102, 20);
		contentPane.add(dateField);
		
		JLabel error_3 = new JLabel("*");
		error_3.setForeground(Color.RED);
		error_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_3.setBounds(94, 99, 32, 14);
		contentPane.add(error_3);
		error_3.setVisible(true);
		emptyDate(error_3);
		
/**********************************************************************************************************************/
		JLabel bornLbl = new JLabel("Luogo di nascita");
		bornLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		bornLbl.setBounds(162, 99, 102, 14);
		contentPane.add(bornLbl);
		
		bornField = new JTextField();
		bornField.setColumns(10);
		bornField.setBounds(162, 114, 102, 20);
		contentPane.add(bornField);
		
		JLabel error_4 = new JLabel("*");
		error_4.setForeground(Color.RED);
		error_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_4.setBounds(260, 97, 32, 14);
		contentPane.add(error_4);
		error_4.setVisible(true);
		isEmpty(error_4, bornField);
		
/**********************************************************************************************************************/
		JLabel homeLbl = new JLabel("Indirizzo di residenza");
		homeLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		homeLbl.setBounds(10, 151, 123, 14);
		contentPane.add(homeLbl);
		
		homeField = new JTextField();
		homeField.setColumns(10);
		homeField.setBounds(10, 164, 206, 20);
		contentPane.add(homeField);
		
		JLabel error_5 = new JLabel("*");
		error_5.setForeground(Color.RED);
		error_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_5.setBounds(129, 151, 32, 14);
		contentPane.add(error_5);
		error_5.setVisible(true);
		isEmpty(error_5, homeField);
		
/**********************************************************************************************************************/
		JLabel phoneLbl = new JLabel("Telefono");
		phoneLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneLbl.setBounds(10, 204, 71, 14);
		contentPane.add(phoneLbl);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(10, 217, 123, 20);
		contentPane.add(phoneField);
		
		JLabel error_6 = new JLabel("*");
		error_6.setForeground(Color.RED);
		error_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_6.setBounds(58, 204, 32, 14);
		contentPane.add(error_6);
		error_6.setVisible(false);
		emptyPhoneNumber(error_6);
		
/**********************************************************************************************************************/
		JLabel nationLbl = new JLabel("Nazionalità");
		nationLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		nationLbl.setBounds(209, 204, 71, 14);
		contentPane.add(nationLbl);
		
		nationField = new JTextField();
		nationField.setBounds(209, 217, 86, 20);
		contentPane.add(nationField);
		nationField.setColumns(10);
		
		JLabel error_7 = new JLabel("*");
		error_7.setForeground(Color.RED);
		error_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_7.setBounds(271, 202, 32, 14);
		contentPane.add(error_7);
		error_7.setVisible(true);
		isEmpty(error_7, nationField);
		
/**********************************************************************************************************************/
		JLabel mailLbl = new JLabel("Indirizzo mail");
		mailLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		mailLbl.setBounds(10, 264, 86, 14);
		contentPane.add(mailLbl);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(10, 277, 206, 20);
		contentPane.add(mailField);
		
		JLabel error_8 = new JLabel("*");
		error_8.setForeground(Color.RED);
		error_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_8.setBounds(87, 262, 32, 14);
		contentPane.add(error_8);
		error_8.setVisible(true);
		emptyMail(error_8);
		
/**********************************************************************************************************************/
		JLabel languagesFieldLbl = new JLabel("Lingue parlate");
		languagesFieldLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		languagesFieldLbl.setBounds(10, 319, 102, 14);
		contentPane.add(languagesFieldLbl);
		
		languagesField = new JTextField();
		languagesField.setBounds(10, 334, 372, 20);
		contentPane.add(languagesField);
		languagesField.setColumns(10);
		
		JLabel error_9 = new JLabel("*");
		error_9.setForeground(Color.RED);
		error_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		error_9.setBounds(90, 317, 32, 14);
		contentPane.add(error_9);
		error_9.setVisible(true);
		isEmpty(error_9, languagesField);
		
/**********************************************************************************************************************/
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(220, 220, 220), 1, true), new LineBorder(new Color(220, 220, 220), 1, true)));
		panel.setBounds(356, 99, 92, 213);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox amBox = new JCheckBox("AM");
		amBox.setBackground(new Color(248, 248, 255));
		panel.add(amBox);
		
		JCheckBox a1Box = new JCheckBox("A1");
		a1Box.setBackground(new Color(248, 248, 255));
		panel.add(a1Box);
		
		JCheckBox a2Box = new JCheckBox("A2");
		a2Box.setBackground(new Color(248, 248, 255));
		panel.add(a2Box);
		
		JCheckBox a3Box = new JCheckBox("A");
		a3Box.setBackground(new Color(248, 248, 255));
		panel.add(a3Box);
		
		JCheckBox b1Box = new JCheckBox("B1");
		b1Box.setBackground(new Color(248, 248, 255));
		panel.add(b1Box);
		
		JCheckBox bBox = new JCheckBox("B");
		bBox.setBackground(new Color(248, 248, 255));
		panel.add(bBox);
		
		JCheckBox c1Box = new JCheckBox("C1");
		c1Box.setBackground(new Color(248, 248, 255));
		panel.add(c1Box);
		
		JCheckBox cBox = new JCheckBox("C");
		cBox.setBackground(new Color(248, 248, 255));
		panel.add(cBox);
		
		JCheckBox d1Box = new JCheckBox("D1");
		d1Box.setBackground(new Color(248, 248, 255));
		panel.add(d1Box);
		
		JCheckBox dBox = new JCheckBox("D");
		dBox.setBackground(new Color(248, 248, 255));
		panel.add(dBox);
		
		JCheckBox beBox = new JCheckBox("BE");
		beBox.setBackground(new Color(248, 248, 255));
		panel.add(beBox);
		
		JCheckBox ceBox = new JCheckBox("CE");
		ceBox.setBackground(new Color(248, 248, 255));
		panel.add(ceBox);
		
		JCheckBox deBox = new JCheckBox("DE");
		deBox.setFocusPainted(false);
		deBox.setBackground(new Color(248, 248, 255));
		panel.add(deBox);
		
		contentPane.add(panel);
		
/**********************************************************************************************************************/
		JLabel licenceLbl = new JLabel("Patenti");
		licenceLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		licenceLbl.setBounds(356, 85, 46, 14);
		contentPane.add(licenceLbl);
		
		JLabel carLbl = new JLabel("Automunito");
		carLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		carLbl.setBounds(356, 47, 86, 14);
		contentPane.add(carLbl);
		
		JToggleButton carBtn = new JToggleButton("No");
		carBtn.setBackground(new Color(255, 51, 51));
		carBtn.setBounds(356, 60, 65, 23);
		contentPane.add(carBtn);
		carBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(carBtn.isSelected())
					carBtn.setText("Si");
				else
					carBtn.setText("No");
				
			}
		});
		UIManager.put("ToggleButton.select", Color.decode("#32cd32"));
		SwingUtilities.updateComponentTreeUI(carBtn);
		
/**********************************************************************************************************************/
		JButton avantiBtn = new JButton("Avanti");
		avantiBtn.setBackground(new Color(245, 245, 245));
		avantiBtn.setBounds(385, 385, 89, 23);
		contentPane.add(avantiBtn);
		avantiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!error_1.isVisible() && !error_2.isVisible() && !error_3.isVisible() && !error_4.isVisible() && !error_5.isVisible()
						&& !error_6.isVisible() && !error_7.isVisible() && !error_8.isVisible() && !error_9.isVisible()) {
					AddNewWorkerContact contact = new AddNewWorkerContact();
			    	contact.setAlwaysOnTop(true);
			    	contact.setLocationRelativeTo(null);
			    	contact.setVisible(true);
				}
				else {
					ExitMsg exit = new ExitMsg();
					exit.setBounds(100, 100, 420, 150);
					exit.infoLbl.setText("Qualche campo non è compilato correttamente o è vuoto!");
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
					exit.setAlwaysOnTop(true);
					exit.setLocationRelativeTo(null);
					exit.setVisible(true); 

				}
					
				
			}
		});
		
/**********************************************************************************************************************/
		JButton indietroBtn = new JButton("Indietro");
		indietroBtn.setBackground(new Color(245, 245, 245));
		indietroBtn.setBounds(286, 385, 89, 23);
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
						Home home = new Home();
						exit.dispose();
				    	dispose();
				    	home.setAlwaysOnTop(true);
				    	home.setLocationRelativeTo(null);
				    	home.setVisible(true);
					}
				});
				exit.setAlwaysOnTop(true);
				exit.setLocationRelativeTo(null);
				exit.setVisible(true); 

			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(220, 220, 220));
		separator.setBounds(10, 365, 464, 9);
		contentPane.add(separator);
		
		JLabel lblOpzionale = new JLabel("*se presente");
		lblOpzionale.setForeground(Color.GRAY);
		lblOpzionale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpzionale.setBounds(10, 239, 86, 14);
		contentPane.add(lblOpzionale);
			
	}
/*************************************************FINE DEL FRAME*********************************************************************/
	
	public class EmptyListener implements DocumentListener {		//listener che permette quando si da il focus al campo di controllare se il dato inserito è corretto

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

	
/**********************************************************************************************************************/
	
	public void emptyPhoneNumber(JLabel error) {		//funzione che fa uso di EmptyListener per controllare se il numero di telefono inserito è corretto
		EmptyListener phoneListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = phoneField.getText();
        		String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
        		Pattern phonePat = Pattern.compile(phoneRegex);
        		Matcher matcher = phonePat.matcher(text);
        		if(matcher.find() == false && !text.isEmpty()) {
        			error.setVisible(true);
        		}
        		else {
        			error.setVisible(false);
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(phoneField, phoneListener);
	}
	
/**********************************************************************************************************************/
	
	public void isEmpty(JLabel error, JTextField field) {		//funzione che fa uso di EmptyListener per controllare se il dato inserito è corretto
		EmptyListener emptyListener = new EmptyListener(500, new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent e) {
        		if(field.getText().isEmpty()) { 
        			error.setVisible(true);
        		}
        		else {
        			error.setVisible(false);
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		
		addListener(field, emptyListener);
    }
	
/**********************************************************************************************************************/	
	
	public void emptyMail(JLabel error) {		//funzione che fa uso di EmptyListener per controllare se la mail inserita è corretta
		EmptyListener mailListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = mailField.getText();
    			String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    							+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        		Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
        		Matcher matcher = mailPat.matcher(text);
        		if(matcher.find() == false && !text.isEmpty()) {
        			error.setVisible(true);
        		}
        		else {
        			error.setVisible(false);
        		}
        		
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(mailField, mailListener);
	}
	
/**********************************************************************************************************************/
	
	public void emptyDate(JLabel error) {		//funzione che fa uso di EmptyListener per controllare se la data di nascita inserita è corretta
		EmptyListener dateListener = new EmptyListener(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = dateField.getText();
        		String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        		Pattern datePat = Pattern.compile(dateRegex);
        		Matcher matcher = datePat.matcher(text);
        		if(matcher.find() == false || text.isEmpty()) {
        			error.setVisible(true);
        		}
        		else {
        			error.setVisible(false);
        		}
        		revalidate();
    			repaint();
            }
        }, true);
		
		addListener(dateField, dateListener);
	}
	
/**********************************************************************************************************************/
	
	public void addListener(JTextField field, EmptyListener listener) {		//funzione che fa partire il controllo del dato inserito solo quando lo si sta focalizzando
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
/*Boolean[] errors = {Error_1.isVisible(), Error_2.isVisible(), Error_3.isVisible(), Error_4.isVisible(), Error_5.isVisible(), 
Error_6.isVisible(), Error_7.isVisible(), Error_8.isVisible(), Error_9.isVisible()}; */
