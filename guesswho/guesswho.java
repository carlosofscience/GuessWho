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

public class GuessWho {

	private JFrame frame;
	private PageContainer container;
	private GameController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessWho window = new GuessWho();
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
	public GuessWho() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controller = new GameController();
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1000, 600);

		container = new PageContainer();
		
		//add pages here
		MainMenuPage mainMenu = new MainMenuPage(controller);
		ScoreboardPage scoreboard = new ScoreboardPage(controller);
		PlayPage playPage = new PlayPage(controller);	
		ChooseThemePage ChooseThemePage = new ChooseThemePage(controller);	

		container.addPage(scoreboard);
		container.addPage(playPage);
		container.addPage(mainMenu);
		container.addPage(ChooseThemePage);
		
		frame.getContentPane().add(container, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
