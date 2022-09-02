package it.univr.lavoratoriStagionali;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 659);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton searchBtn = new JButton("");
		searchBtn.setBackground(new Color(245, 245, 245));
		searchBtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		searchBtn.setBounds(new Rectangle(60, 60, 400, 500));
		Image search = new ImageIcon(this.getClass().getResource("/Search_Icon.png")).getImage();
		searchBtn.setIcon(new ImageIcon(search));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMenu menu = new SearchMenu();
				menu.setAlwaysOnTop(true);
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
			}
		});
		menuBar.add(searchBtn);
		
		JButton newWorkerBtn = new JButton("Inserisci nuovo lavoratore");
		newWorkerBtn.setBackground(new Color(245, 245, 245));
		newWorkerBtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		newWorkerBtn.setBounds(new Rectangle(60,60,60,60));
		menuBar.add(newWorkerBtn);
		newWorkerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewWorker worker = new AddNewWorker();
		    	dispose();
		    	worker.setAlwaysOnTop(true);
		    	worker.setLocationRelativeTo(null);
		    	worker.setVisible(true);
				
			}
		});
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBackground(new Color(245, 245, 245));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				setVisible(false);
				dispose();
				login.setAlwaysOnTop(true);
				login.setLocationRelativeTo(null);
				login.setVisible(true);
			}
		});
		menuBar.add(logoutBtn);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 618, 917, -20);
		contentPane.add(scrollPane_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(5, 111, 410, -25);
		contentPane.add(horizontalStrut);
		
		table = new JTable();
		table.setBounds(100, 426, 617, -366);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(248, 248, 255));
		scrollPane.setBounds(5, 11, 946, 571);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
}
