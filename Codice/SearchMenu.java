package it.univr.lavoratoriStagionali;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchMenu extends JFrame {

	private JPanel contentPane;
	private JTextField NameText;
	private JTextField DispText;
	private JTextField WorkField;
	private JTextField ResText;
	private JTextField LicenseText;
	private JTextField LinguaText;
	private JTextField VeicoloText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMenu frame = new SearchMenu();
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
	public SearchMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameLbl = new JLabel("Nome");
		NameLbl.setBounds(10, 10, 46, 14);
		contentPane.add(NameLbl);
		
		JLabel DispLbl = new JLabel("Disponibilità");
		DispLbl.setBounds(10, 50, 61, 14);
		contentPane.add(DispLbl);
		
		JLabel WorkLbl = new JLabel("Lavoro\r\n");
		WorkLbl.setBounds(10, 90, 46, 14);
		contentPane.add(WorkLbl);
		
		JLabel ResLbl = new JLabel("Residenza");
		ResLbl.setBounds(10, 130, 61, 14);
		contentPane.add(ResLbl);
		
		JLabel LicenseLbl = new JLabel("Patente\r\n");
		LicenseLbl.setBounds(205, 93, 46, 14);
		contentPane.add(LicenseLbl);
		
		NameText = new JTextField();
		NameText.setBounds(76, 7, 86, 20);
		contentPane.add(NameText);
		NameText.setColumns(10);
		
		DispText = new JTextField();
		DispText.setBounds(76, 47, 86, 20);
		contentPane.add(DispText);
		DispText.setColumns(10);
		
		WorkField = new JTextField();
		WorkField.setBounds(76, 87, 86, 20);
		contentPane.add(WorkField);
		WorkField.setColumns(10);
		
		ResText = new JTextField();
		ResText.setBounds(76, 127, 86, 20);
		contentPane.add(ResText);
		ResText.setColumns(10);
		
		LicenseText = new JTextField();
		LicenseText.setBounds(271, 90, 86, 20);
		contentPane.add(LicenseText);
		LicenseText.setColumns(10);
		
		JLabel LinguaLbl = new JLabel("Lingua");
		LinguaLbl.setBounds(205, 10, 46, 14);
		contentPane.add(LinguaLbl);
		
		LinguaText = new JTextField();
		LinguaText.setBounds(267, 7, 86, 20);
		contentPane.add(LinguaText);
		LinguaText.setColumns(10);
		
		JLabel VeicoloLbl = new JLabel("Veicolo");
		VeicoloLbl.setBounds(205, 50, 46, 14);
		contentPane.add(VeicoloLbl);
		
		VeicoloText = new JTextField();
		VeicoloText.setBounds(267, 47, 86, 20);
		contentPane.add(VeicoloText);
		VeicoloText.setColumns(10);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(162, 186, 89, 23);
		contentPane.add(btnNewButton);
	}

}
