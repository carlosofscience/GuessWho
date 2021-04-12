package guesswho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import java.awt.CardLayout;

public class guesswho {

	private JFrame frame;
	private PageContainer container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guesswho window = new guesswho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guesswho() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);

		
		container = new PageContainer();
		
		//add pages here
		MainMenuPage mainMenu = new MainMenuPage();
		ScoreboardPage scoreboard = new ScoreboardPage();
		PlayPage playPage = new PlayPage();	

		container.addPage(mainMenu);
		container.addPage(scoreboard);
		container.addPage(playPage);
	
	
		
		frame.getContentPane().add(container, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
