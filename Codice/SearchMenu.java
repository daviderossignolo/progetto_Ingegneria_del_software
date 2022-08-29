package it.univr.lavoratoriStagionali;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Label;

public class SearchMenu extends JFrame {

	private JPanel contentPane;
	private JTextField NameText;
	private JTextField DispText;
	private JTextField WorkField;
	private JTextField ResText;
	private JTextField LinguaText;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblAl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMenu frame = new SearchMenu();
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
	public SearchMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameLbl = new JLabel("Nome:");
		NameLbl.setBounds(10, 56, 61, 14);
		contentPane.add(NameLbl);
		
		JLabel DispLbl = new JLabel("Inizio lavoro:");
		DispLbl.setBounds(118, 11, 96, 14);
		contentPane.add(DispLbl);
		
		JLabel WorkLbl = new JLabel("Lavoro\r\n");
		WorkLbl.setBounds(118, 102, 46, 14);
		contentPane.add(WorkLbl);
		
		JLabel ResLbl = new JLabel("Residenza:");
		ResLbl.setBounds(10, 101, 61, 14);
		contentPane.add(ResLbl);
		
		JLabel LicenseLbl = new JLabel("Patente\r\n");
		LicenseLbl.setBounds(118, 56, 46, 14);
		contentPane.add(LicenseLbl);
		
		NameText = new JTextField();
		NameText.setBounds(10, 70, 86, 20);
		contentPane.add(NameText);
		NameText.setColumns(10);
		
		DispText = new JTextField();
		DispText.setBounds(118, 25, 96, 20);
		contentPane.add(DispText);
		DispText.setColumns(10);
		
		WorkField = new JTextField();
		WorkField.setBounds(118, 116, 96, 20);
		contentPane.add(WorkField);
		WorkField.setColumns(10);
		
		ResText = new JTextField();
		ResText.setBounds(10, 116, 86, 20);
		contentPane.add(ResText);
		ResText.setColumns(10);
		
		JLabel LinguaLbl = new JLabel("Lingua:");
		LinguaLbl.setBounds(240, 102, 46, 14);
		contentPane.add(LinguaLbl);
		
		LinguaText = new JTextField();
		LinguaText.setBounds(240, 116, 96, 20);
		contentPane.add(LinguaText);
		LinguaText.setColumns(10);
		
		JLabel VeicoloLbl = new JLabel("Veicolo");
		VeicoloLbl.setBounds(240, 56, 46, 14);
		contentPane.add(VeicoloLbl);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(360, 69, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(240, 25, 96, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 25, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(10, 11, 61, 14);
		contentPane.add(lblCognome);
		
		lblAl = new JLabel("Fine lavoro:");
		lblAl.setBounds(240, 11, 69, 14);
		contentPane.add(lblAl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(499, 49, -509, 9);
		contentPane.add(separator);
		
		JComboBox<String> LicenceBox = new JComboBox<String>();
		LicenceBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		LicenceBox.setBackground(new Color(245, 245, 245));
		LicenceBox.setEditable(true);
		LicenceBox.setBounds(118, 71, 96, 20);
		LicenceBox.addItem("");
		LicenceBox.addItem("AM");
		LicenceBox.addItem("A1");
		LicenceBox.addItem("A2");
		LicenceBox.addItem("A");
		LicenceBox.addItem("B1");
		LicenceBox.addItem("B");
		LicenceBox.addItem("C1");
		LicenceBox.addItem("C");
		LicenceBox.addItem("D1");
		LicenceBox.addItem("D");
		LicenceBox.addItem("BE");
		LicenceBox.addItem("CE");
		LicenceBox.addItem("DE");
		
		contentPane.add(LicenceBox);
		
		JComboBox<String> VehicleBox = new JComboBox<String>();
		VehicleBox.setForeground(new Color(0, 0, 0));
		VehicleBox.setBackground(new Color(245, 245, 245));
		VehicleBox.setBounds(240, 69, 96, 22);
		VehicleBox.addItem("");
		VehicleBox.addItem("SI");
		VehicleBox.addItem("NO");
		contentPane.add(VehicleBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(245, 245, 245));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(107, 0, 13, 151);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(245, 245, 245));
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(343, 0, 13, 151);
		contentPane.add(separator_1_1);
	}
}
