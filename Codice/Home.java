package it.univr.lavoratoriStagionali;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.Color;

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
		
		JButton Search = new JButton("");
		Search.setBackground(new Color(192, 192, 192));
		Search.setForeground(UIManager.getColor("Button.disabledShadow"));
		Search.setBounds(new Rectangle(60, 60, 400, 500));
		Image search = new ImageIcon(this.getClass().getResource("/Search_Icon.png")).getImage();
		Search.setIcon(new ImageIcon(search));
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(Search);
		
		JButton NewWorker = new JButton("Inserisci nuovo lavoratore");
		NewWorker.setBackground(new Color(192, 192, 192));
		NewWorker.setForeground(UIManager.getColor("Button.disabledShadow"));
		NewWorker.setBounds(new Rectangle(60,60,60,60));
		menuBar.add(NewWorker);
		
		JButton Logout = new JButton("Logout");
		Logout.setBackground(new Color(192, 192, 192));
		Logout.setForeground(UIManager.getColor("Button.disabledShadow"));
		menuBar.add(Logout);
		contentPane = new JPanel();
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
		scrollPane.setBounds(5, 11, 946, 539);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
}
