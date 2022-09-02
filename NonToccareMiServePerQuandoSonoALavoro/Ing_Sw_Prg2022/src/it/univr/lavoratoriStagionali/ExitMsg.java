package it.univr.lavoratoriStagionali;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

public class ExitMsg extends JFrame {

	private JPanel contentPane;
	protected JLabel infoLbl = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitMsg frame = new ExitMsg();
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
	public ExitMsg() {		//frame usato per la creazione dei vari messaggi di avvertimento
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel infoLbl = this.infoLbl;
		infoLbl.setText("Tornando indietro tutti i progressi andranno persi.");
		infoLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		infoLbl.setBounds(60, 28, 322, 14);
		contentPane.add(infoLbl);
		
		JLabel image = new JLabel("");
		image.setBounds(10, 11, 40, 46);
		Image help = new ImageIcon(this.getClass().getResource("/Help_Icon.png")).getImage();
		image.setIcon(new ImageIcon(help));
		contentPane.add(image);
		
	}
}
