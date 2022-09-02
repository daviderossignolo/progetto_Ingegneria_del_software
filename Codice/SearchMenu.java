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
	private JTextField nameField;
	private JTextField startField;
	private JTextField workField;
	private JTextField homeField;
	private JTextField lenguageField;
	private JTextField endField;
	private JTextField surnameField;
	private JLabel endLbl;

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
	public SearchMenu() {		//frame usato per la ricerca di lavoratori date specifiche richieste
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("Nome:");
		nameLbl.setBounds(10, 56, 61, 14);
		contentPane.add(nameLbl);
		
		JLabel startLbl = new JLabel("Inizio lavoro:");
		startLbl.setBounds(118, 11, 96, 14);
		contentPane.add(startLbl);
		
		JLabel workLbl = new JLabel("Lavoro\r\n");
		workLbl.setBounds(118, 102, 46, 14);
		contentPane.add(workLbl);
		
		JLabel homeLbl = new JLabel("Residenza:");
		homeLbl.setBounds(10, 101, 61, 14);
		contentPane.add(homeLbl);
		
		JLabel licenseLbl = new JLabel("Patente\r\n");
		licenseLbl.setBounds(118, 56, 46, 14);
		contentPane.add(licenseLbl);
		
		nameField = new JTextField();
		nameField.setBounds(10, 70, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		startField = new JTextField();
		startField.setBounds(118, 25, 96, 20);
		contentPane.add(startField);
		startField.setColumns(10);
		
		workField = new JTextField();
		workField.setBounds(118, 116, 96, 20);
		contentPane.add(workField);
		workField.setColumns(10);
		
		homeField = new JTextField();
		homeField.setBounds(10, 116, 86, 20);
		contentPane.add(homeField);
		homeField.setColumns(10);
		
		JLabel lenguageLbl = new JLabel("Lingua:");
		lenguageLbl.setBounds(240, 102, 46, 14);
		contentPane.add(lenguageLbl);
		
		lenguageField = new JTextField();
		lenguageField.setBounds(240, 116, 96, 20);
		contentPane.add(lenguageField);
		lenguageField.setColumns(10);
		
		JLabel carLbl = new JLabel("Veicolo");
		carLbl.setBounds(240, 56, 46, 14);
		contentPane.add(carLbl);
		
		JButton searchBtn = new JButton("Cerca");
		searchBtn.setBackground(new Color(245, 245, 245));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchBtn.setBounds(360, 69, 89, 23);
		contentPane.add(searchBtn);
		
		endField = new JTextField();
		endField.setColumns(10);
		endField.setBounds(240, 25, 96, 20);
		contentPane.add(endField);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(10, 25, 86, 20);
		contentPane.add(surnameField);
		
		JLabel surnameLbl = new JLabel("Cognome:");
		surnameLbl.setBounds(10, 11, 61, 14);
		contentPane.add(surnameLbl);
		
		endLbl = new JLabel("Fine lavoro:");
		endLbl.setBounds(240, 11, 69, 14);
		contentPane.add(endLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(499, 49, -509, 9);
		contentPane.add(separator);
		
		JComboBox<String> licenceBox = new JComboBox<String>();
		licenceBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		licenceBox.setBackground(new Color(245, 245, 245));
		licenceBox.setEditable(true);
		licenceBox.setBounds(118, 71, 96, 20);
		licenceBox.addItem("");
		licenceBox.addItem("AM");
		licenceBox.addItem("A1");
		licenceBox.addItem("A2");
		licenceBox.addItem("A");
		licenceBox.addItem("B1");
		licenceBox.addItem("B");
		licenceBox.addItem("C1");
		licenceBox.addItem("C");
		licenceBox.addItem("D1");
		licenceBox.addItem("D");
		licenceBox.addItem("BE");
		licenceBox.addItem("CE");
		licenceBox.addItem("DE");
		
		contentPane.add(licenceBox);
		
		JComboBox<String> vehicleBox = new JComboBox<String>();
		vehicleBox.setForeground(new Color(0, 0, 0));
		vehicleBox.setBackground(new Color(245, 245, 245));
		vehicleBox.setBounds(240, 69, 96, 22);
		vehicleBox.addItem("");
		vehicleBox.addItem("SI");
		vehicleBox.addItem("NO");
		contentPane.add(vehicleBox);
		
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
