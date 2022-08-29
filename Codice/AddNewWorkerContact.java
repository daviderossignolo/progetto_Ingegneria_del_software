package it.univr.lavoratoriStagionali;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class AddNewWorkerContact extends JFrame {

	private JPanel contentPane;
	private JTextField NameField_1;
	private JTextField SurnameField_1;
	private JTextField PhoneFiled_1;
	private JTextField MailField_1;
	private JTextField NameFiled_2;
	private JTextField SurnameField_2;
	private JTextField PhoneFiled_2;
	private JTextField MailField_2;
	private JTextField NameFiled_3;
	private JTextField SurnameField_3;
	private JTextField PhoneFiled_3;
	private JTextField MailField_3;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EmergencyLbl = new JLabel("Registrazione lavoratore: Contatti di emergenza");
		EmergencyLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		EmergencyLbl.setBounds(10, 0, 474, 30);
		contentPane.add(EmergencyLbl);
		
		NameField_1 = new JTextField();
		NameField_1.setColumns(10);
		NameField_1.setBounds(10, 97, 86, 20);
		contentPane.add(NameField_1);
		
		SurnameField_1 = new JTextField();
		SurnameField_1.setColumns(10);
		SurnameField_1.setBounds(162, 97, 86, 20);
		contentPane.add(SurnameField_1);
		
		PhoneFiled_1 = new JTextField();
		PhoneFiled_1.setColumns(10);
		PhoneFiled_1.setBounds(10, 141, 123, 20);
		contentPane.add(PhoneFiled_1);
		
		MailField_1 = new JTextField();
		MailField_1.setColumns(10);
		MailField_1.setBounds(160, 141, 206, 20);
		contentPane.add(MailField_1);
		
		JLabel NameLbl_1 = new JLabel("Nome");
		NameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameLbl_1.setBounds(10, 83, 46, 14);
		contentPane.add(NameLbl_1);
		
		JLabel SurnameLbl_1 = new JLabel("Cognome\r\n");
		SurnameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		SurnameLbl_1.setBounds(162, 83, 65, 14);
		contentPane.add(SurnameLbl_1);
		
		JLabel PhoneLbl_1 = new JLabel("Telefono");
		PhoneLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		PhoneLbl_1.setBounds(10, 128, 71, 14);
		contentPane.add(PhoneLbl_1);
		
		JLabel MailLbl_1 = new JLabel("Indirizzo mail");
		MailLbl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		MailLbl_1.setBounds(160, 128, 86, 14);
		contentPane.add(MailLbl_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(220, 220, 220));
		separator.setBounds(10, 172, 439, 2);
		contentPane.add(separator);
		
		JLabel FirstLbl = new JLabel("Primo contatto");
		FirstLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		FirstLbl.setBounds(10, 52, 107, 14);
		contentPane.add(FirstLbl);
		
		NameFiled_2 = new JTextField();
		NameFiled_2.setColumns(10);
		NameFiled_2.setBounds(10, 230, 86, 20);
		contentPane.add(NameFiled_2);
		
		SurnameField_2 = new JTextField();
		SurnameField_2.setColumns(10);
		SurnameField_2.setBounds(162, 230, 86, 20);
		contentPane.add(SurnameField_2);
		
		PhoneFiled_2 = new JTextField();
		PhoneFiled_2.setColumns(10);
		PhoneFiled_2.setBounds(10, 274, 123, 20);
		contentPane.add(PhoneFiled_2);
		
		MailField_2 = new JTextField();
		MailField_2.setColumns(10);
		MailField_2.setBounds(160, 274, 206, 20);
		contentPane.add(MailField_2);
		
		JLabel NameLbl_2 = new JLabel("Nome");
		NameLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameLbl_2.setBounds(10, 216, 46, 14);
		contentPane.add(NameLbl_2);
		
		JLabel SurnameLbl_2 = new JLabel("Cognome\r\n");
		SurnameLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		SurnameLbl_2.setBounds(162, 216, 65, 14);
		contentPane.add(SurnameLbl_2);
		
		JLabel PhoneLbl_2 = new JLabel("Telefono");
		PhoneLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		PhoneLbl_2.setBounds(10, 261, 71, 14);
		contentPane.add(PhoneLbl_2);
		
		JLabel MailLbl_2 = new JLabel("Indirizzo mail");
		MailLbl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		MailLbl_2.setBounds(160, 261, 86, 14);
		contentPane.add(MailLbl_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(220, 220, 220));
		separator_1.setBounds(10, 305, 439, 2);
		contentPane.add(separator_1);
		
		JLabel SecondLbl = new JLabel("Secondo contatto");
		SecondLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		SecondLbl.setBounds(10, 185, 137, 14);
		contentPane.add(SecondLbl);
		
		NameFiled_3 = new JTextField();
		NameFiled_3.setColumns(10);
		NameFiled_3.setBounds(10, 363, 86, 20);
		contentPane.add(NameFiled_3);
		
		SurnameField_3 = new JTextField();
		SurnameField_3.setColumns(10);
		SurnameField_3.setBounds(162, 363, 86, 20);
		contentPane.add(SurnameField_3);
		
		PhoneFiled_3 = new JTextField();
		PhoneFiled_3.setColumns(10);
		PhoneFiled_3.setBounds(10, 407, 123, 20);
		contentPane.add(PhoneFiled_3);
		
		MailField_3 = new JTextField();
		MailField_3.setColumns(10);
		MailField_3.setBounds(160, 407, 206, 20);
		contentPane.add(MailField_3);
		
		JLabel NameLbl_3 = new JLabel("Nome");
		NameLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameLbl_3.setBounds(10, 349, 46, 14);
		contentPane.add(NameLbl_3);
		
		JLabel SurnameLbl_3 = new JLabel("Cognome\r\n");
		SurnameLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		SurnameLbl_3.setBounds(162, 349, 65, 14);
		contentPane.add(SurnameLbl_3);
		
		JLabel PhoneLbl_3 = new JLabel("Telefono");
		PhoneLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		PhoneLbl_3.setBounds(10, 394, 71, 14);
		contentPane.add(PhoneLbl_3);
		
		JLabel MailLbl_3 = new JLabel("Indirizzo mail");
		MailLbl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		MailLbl_3.setBounds(160, 394, 86, 14);
		contentPane.add(MailLbl_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(220, 220, 220));
		separator_2.setBounds(10, 438, 439, 2);
		contentPane.add(separator_2);
		
		JLabel ThirdLbl = new JLabel("Terzo contatto");
		ThirdLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		ThirdLbl.setBounds(10, 318, 107, 14);
		contentPane.add(ThirdLbl);
		
		JLabel lblNewLabel = new JLabel("*Nota: almeno un contatto deve esser obbligatoriamente compilato");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 27, 344, 14);
		contentPane.add(lblNewLabel);
		
		JButton AvantiBtn = new JButton("Avanti");
		AvantiBtn.setBackground(new Color(245, 245, 245));
		AvantiBtn.setBounds(360, 451, 89, 23);
		contentPane.add(AvantiBtn);
		
		JButton IndietroBtn = new JButton("Indietro");
		IndietroBtn.setBackground(new Color(245, 245, 245));
		IndietroBtn.setBounds(261, 451, 89, 23);
		contentPane.add(IndietroBtn);
	}
}
