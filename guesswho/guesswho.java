package guesswho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;

public class GuessWho {

	private final int WIDHT = 900, HEIGHT = 800, NAV_BAR_HEIGHT = 39;
	private JFrame frame;
	private PageContainer container;

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
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(400, 150, WIDHT, HEIGHT);
		container = new PageContainer();
		container.setPreferredSize(new Dimension(WIDHT, HEIGHT-NAV_BAR_HEIGHT));

		//add pages here TODO: remove passing controller, this is passed implicitly when added to container
		MainMenuPage mainMenu = new MainMenuPage();
		ScoreboardPage scoreboard = new ScoreboardPage();
		PlayPage playPage = new PlayPage();	
		ChooseThemePage ChooseThemePage = new ChooseThemePage();	
		HowToPlayPage howToPlayPage = new HowToPlayPage();
		ConfirmationPage confirmationPage = new ConfirmationPage();
		ResultsPage resultsPage = new ResultsPage();
		
		playPage.setBackground(Color.green);
	
		container.addPage(scoreboard);
		container.addPage(ChooseThemePage);
		container.addPage(howToPlayPage);
		container.addPage(resultsPage);
		container.addPage(confirmationPage);
		container.addPage(playPage);
		container.addPage(mainMenu);

		
		frame.getContentPane().add(container, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//loading default theme
		container.gameController.setGameTheme("Classic GuessWho");
	}
}
