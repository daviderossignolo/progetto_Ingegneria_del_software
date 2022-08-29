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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JToggleButton;

public class AddNewWorker extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField SurnameField;
	private JTextField DateField;
	private JTextField PlaceField;
	private JTextField HomeField;
	private JTextField PhoneField;
	private JTextField MailField;
	private JTextField NationField;
	private JTextField LanguagesField;

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
	public AddNewWorker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new LineBorder(new Color(171, 173, 179))));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Registrazione lavoratore: Dati");
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setBounds(90, 11, 304, 30);
		contentPane.add(title);
		
		NameField = new JTextField();
		NameField.setBounds(10, 61, 86, 20);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		JLabel Error_1 = new JLabel("*");
		Error_1.setForeground(Color.RED);
		Error_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_1.setBounds(42, 47, 32, 14);
		contentPane.add(Error_1);
		Error_1.setVisible(false);
		
		DeferredDocumentListener nameListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(NameField.getText().isEmpty()) 
        			Error_1.setVisible(true);
        		else
        			Error_1.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		NameField.getDocument().addDocumentListener(nameListener);
		NameField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	nameListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	nameListener.stop();
            }
        });
		
		
		SurnameField = new JTextField();
		SurnameField.setColumns(10);
		SurnameField.setBounds(162, 61, 86, 20);
		contentPane.add(SurnameField);
		
		JLabel Error_2 = new JLabel("*");
		Error_2.setForeground(Color.RED);
		Error_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_2.setBounds(216, 47, 32, 14);
		contentPane.add(Error_2);
		Error_2.setVisible(false);
		
		DeferredDocumentListener surnameListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(SurnameField.getText().isEmpty()) 
        			Error_1.setVisible(true);
        		else
        			Error_1.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		SurnameField.getDocument().addDocumentListener(surnameListener);
		SurnameField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	surnameListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	surnameListener.stop();
            }
        });
		
		DateField = new JTextField();
		DateField.setColumns(10);
		DateField.setBounds(10, 114, 102, 20);
		contentPane.add(DateField);
		
		JLabel Error_3 = new JLabel("*");
		Error_3.setForeground(Color.RED);
		Error_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_3.setBounds(94, 99, 32, 14);
		contentPane.add(Error_3);
		Error_3.setVisible(false);
		
		
		DeferredDocumentListener dateListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = DateField.getText();
        		String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        		Pattern datePat = Pattern.compile(dateRegex);
        		Matcher matcher = datePat.matcher(text);
        		if(matcher.find() == false && !text.isEmpty()) 
        			Error_3.setVisible(true);
        		else
        			Error_3.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		DateField.getDocument().addDocumentListener(dateListener);
		DateField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	dateListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	dateListener.stop();
            }
        });
		
		PlaceField = new JTextField();
		PlaceField.setColumns(10);
		PlaceField.setBounds(162, 114, 102, 20);
		contentPane.add(PlaceField);
		
		JLabel Error_4 = new JLabel("*");
		Error_4.setForeground(Color.RED);
		Error_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_4.setBounds(260, 97, 32, 14);
		contentPane.add(Error_4);
		Error_4.setVisible(false);
		
		DeferredDocumentListener placeListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(PlaceField.getText().isEmpty()) 
        			Error_4.setVisible(true);
        		else
        			Error_4.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		PlaceField.getDocument().addDocumentListener(placeListener);
		PlaceField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	placeListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	placeListener.stop();
            }
        });
		
		HomeField = new JTextField();
		HomeField.setColumns(10);
		HomeField.setBounds(10, 164, 206, 20);
		contentPane.add(HomeField);
		
		JLabel Error_5 = new JLabel("*");
		Error_5.setForeground(Color.RED);
		Error_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_5.setBounds(129, 151, 32, 14);
		contentPane.add(Error_5);
		Error_5.setVisible(false);
		
		DeferredDocumentListener homeListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(HomeField.getText().isEmpty()) 
        			Error_5.setVisible(true);
        		else
        			Error_5.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		HomeField.getDocument().addDocumentListener(homeListener);
		HomeField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	homeListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	homeListener.stop();
            }
        });
		
		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(10, 217, 123, 20);
		contentPane.add(PhoneField);
		
		JLabel Error_6 = new JLabel("*");
		Error_6.setForeground(Color.RED);
		Error_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_6.setBounds(58, 204, 32, 14);
		contentPane.add(Error_6);
		Error_6.setVisible(false);
		
		DeferredDocumentListener phoneListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = PhoneField.getText();
        		String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
        		Pattern phonePat = Pattern.compile(phoneRegex);
        		Matcher matcher = phonePat.matcher(text);
        		if(matcher.find() == false && !text.isEmpty()) 
        			Error_6.setVisible(true);
        		else
        			Error_6.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		PhoneField.getDocument().addDocumentListener(phoneListener);
		PhoneField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	phoneListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	phoneListener.stop();
            }
        });
		
		MailField = new JTextField();
		MailField.setColumns(10);
		MailField.setBounds(10, 277, 206, 20);
		contentPane.add(MailField);
		
		JLabel Error_8 = new JLabel("*");
		Error_8.setForeground(Color.RED);
		Error_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_8.setBounds(87, 262, 32, 14);
		contentPane.add(Error_8);
		Error_8.setVisible(false);
		
		DeferredDocumentListener mailListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = MailField.getText();
    			String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    							+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        		Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
        		Matcher matcher = mailPat.matcher(text);
        		if(matcher.find() == false && !text.isEmpty())
        			Error_8.setVisible(true);
        		else
        			Error_8.setVisible(false);
        		
        		revalidate();
    			repaint();
            }
        }, true);
		
		MailField.getDocument().addDocumentListener(mailListener);
		MailField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	mailListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	mailListener.stop();
            }
        });
		
		
		JLabel NameLbl = new JLabel("Nome");
		NameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameLbl.setBounds(10, 47, 46, 14);
		contentPane.add(NameLbl);
		
		JLabel SurnameLbl = new JLabel("Cognome\r\n");
		SurnameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		SurnameLbl.setBounds(162, 47, 65, 14);
		contentPane.add(SurnameLbl);
		
		JLabel DateLbl = new JLabel("Data di nascita");
		DateLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateLbl.setBounds(10, 99, 86, 14);
		contentPane.add(DateLbl);
		
		JLabel BornLbl = new JLabel("Luogo di nascita");
		BornLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		BornLbl.setBounds(162, 99, 102, 14);
		contentPane.add(BornLbl);
		
		JLabel HomeLbl = new JLabel("Indirizzo di residenza");
		HomeLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		HomeLbl.setBounds(10, 151, 123, 14);
		contentPane.add(HomeLbl);
		
		JLabel PhoneLbl = new JLabel("Telefono");
		PhoneLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		PhoneLbl.setBounds(10, 204, 71, 14);
		contentPane.add(PhoneLbl);
		
		JLabel MailLbl = new JLabel("Indirizzo mail");
		MailLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		MailLbl.setBounds(10, 264, 86, 14);
		contentPane.add(MailLbl);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(220, 220, 220), 1, true), new LineBorder(new Color(220, 220, 220), 1, true)));
		panel.setBounds(356, 99, 92, 213);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox AmBox = new JCheckBox("AM");
		AmBox.setBackground(new Color(248, 248, 255));
		panel.add(AmBox);
		
		JCheckBox A1Box = new JCheckBox("A1");
		A1Box.setBackground(new Color(248, 248, 255));
		panel.add(A1Box);
		
		JCheckBox A2Box = new JCheckBox("A2");
		A2Box.setBackground(new Color(248, 248, 255));
		panel.add(A2Box);
		
		JCheckBox A3Box = new JCheckBox("A");
		A3Box.setBackground(new Color(248, 248, 255));
		panel.add(A3Box);
		
		JCheckBox B1Box = new JCheckBox("B1");
		B1Box.setBackground(new Color(248, 248, 255));
		panel.add(B1Box);
		
		JCheckBox BBox = new JCheckBox("B");
		BBox.setBackground(new Color(248, 248, 255));
		panel.add(BBox);
		
		JCheckBox C1Box = new JCheckBox("C1");
		C1Box.setBackground(new Color(248, 248, 255));
		panel.add(C1Box);
		
		JCheckBox CBox = new JCheckBox("C");
		CBox.setBackground(new Color(248, 248, 255));
		panel.add(CBox);
		
		JCheckBox D1Box = new JCheckBox("D1");
		D1Box.setBackground(new Color(248, 248, 255));
		panel.add(D1Box);
		
		JCheckBox DBox = new JCheckBox("D");
		DBox.setBackground(new Color(248, 248, 255));
		panel.add(DBox);
		
		JCheckBox BeBox = new JCheckBox("BE");
		BeBox.setBackground(new Color(248, 248, 255));
		panel.add(BeBox);
		
		JCheckBox CeBox = new JCheckBox("CE");
		CeBox.setBackground(new Color(248, 248, 255));
		panel.add(CeBox);
		
		JCheckBox DeBox = new JCheckBox("DE");
		DeBox.setFocusPainted(false);
		DeBox.setBackground(new Color(248, 248, 255));
		panel.add(DeBox);
		
		JLabel LicenceText = new JLabel("Patenti");
		LicenceText.setFont(new Font("Tahoma", Font.BOLD, 11));
		LicenceText.setBounds(356, 85, 46, 14);
		contentPane.add(LicenceText);
		
		JLabel VehicleLbl = new JLabel("Automunito");
		VehicleLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		VehicleLbl.setBounds(356, 47, 86, 14);
		contentPane.add(VehicleLbl);
		//contentPane.add(NoBtn);
		
		contentPane.add(panel);
		
		JCheckBox NoBox = new JCheckBox("No");
		NoBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		NoBox.setBackground(new Color(248, 248, 255));
		panel.add(NoBox);
		contentPane.add(LicenceText);
		
		
		
		PhoneField.getDocument().addDocumentListener(phoneListener);
		PhoneField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	phoneListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	phoneListener.stop();
            }
        });
		
		NationField = new JTextField();
		NationField.setBounds(209, 217, 86, 20);
		contentPane.add(NationField);
		NationField.setColumns(10);
		
		JLabel Error_7 = new JLabel("*");
		Error_7.setForeground(Color.RED);
		Error_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_7.setBounds(271, 202, 32, 14);
		contentPane.add(Error_7);
		Error_7.setVisible(false);
		
		DeferredDocumentListener nationListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(NationField.getText().isEmpty()) 
        			Error_7.setVisible(true);
        		else
        			Error_7.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		NationField.getDocument().addDocumentListener(nationListener);
		NationField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	nationListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	nationListener.stop();
            }
        });
		
		
		JLabel NationLbl = new JLabel("Nazionalità");
		NationLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		NationLbl.setBounds(209, 204, 71, 14);
		contentPane.add(NationLbl);
		
		JLabel LanguagesFieldLbl = new JLabel("Lingue parlate");
		LanguagesFieldLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		LanguagesFieldLbl.setBounds(10, 319, 102, 14);
		contentPane.add(LanguagesFieldLbl);
		
		JLabel Error_11 = new JLabel("*");
		Error_11.setForeground(Color.RED);
		Error_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_11.setBounds(398, 85, 32, 14);
		contentPane.add(Error_11);
		
		LanguagesField = new JTextField();
		LanguagesField.setBounds(10, 334, 372, 20);
		contentPane.add(LanguagesField);
		LanguagesField.setColumns(10);
		
		JLabel Error_9 = new JLabel("*");
		Error_9.setForeground(Color.RED);
		Error_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		Error_9.setBounds(90, 317, 32, 14);
		contentPane.add(Error_9);
		Error_9.setVisible(false);
		
		DeferredDocumentListener languagesListener = new DeferredDocumentListener(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(LanguagesField.getText().isEmpty()) 
        			Error_9.setVisible(true);
        		else
        			Error_9.setVisible(false);
        		revalidate();
    			repaint();
            }
        }, true);
		
		
		LanguagesField.getDocument().addDocumentListener(languagesListener);
		LanguagesField.addFocusListener(new FocusListener() {
            @Override	
            public void focusGained(FocusEvent e) {
            	languagesListener.start();
            }

            @Override
            public void focusLost(FocusEvent e) {
            	languagesListener.stop();
            }
        });
		
		JToggleButton CarBtn = new JToggleButton("Si");
		CarBtn.setBackground(new Color(245, 245, 245));
		CarBtn.setBounds(356, 60, 65, 23);
		contentPane.add(CarBtn);
		CarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton AvantiBtn = new JButton("Avanti");
		AvantiBtn.setBackground(new Color(245, 245, 245));
		AvantiBtn.setBounds(385, 385, 89, 23);
		contentPane.add(AvantiBtn);
		AvantiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//if()
					
				
			}
		});
		
		JButton IndietroBtn = new JButton("Indietro");
		IndietroBtn.setBackground(new Color(245, 245, 245));
		IndietroBtn.setBounds(286, 385, 89, 23);
		contentPane.add(IndietroBtn);
		IndietroBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(220, 220, 220));
		separator.setBounds(10, 365, 464, 9);
		contentPane.add(separator);
		
		JLabel NotValidLbl = new JLabel("* -> campo non valido");
		NotValidLbl.setVisible(false);
		NotValidLbl.setForeground(new Color(255, 0, 0));
		NotValidLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		NotValidLbl.setBounds(10, 394, 174, 14);
		contentPane.add(NotValidLbl);
			
	}
	
	public class DeferredDocumentListener implements DocumentListener {

        private final Timer timer;

        public DeferredDocumentListener(int timeOut, ActionListener listener, boolean repeats) {
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
}
