package guesswho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreboardPage extends Page{
	
	JPanel staticContainer, dynamicContainer;
	
	ScoreboardPage(){
		setName("ScoreboardPage");
		staticContainer = new JPanel();
		staticContainer.setBackground(Color.white);
		staticContainer.setPreferredSize(new Dimension(900, 600)); 

		dynamicContainer = new JPanel();
		
		PageLink MainMenuPageLink = new PageLink("Back");
		
		staticContainer.add(dynamicContainer);
		add(staticContainer);
		
		MainMenuPageLink.setLink("MainMenuPage");
		addLink(MainMenuPageLink);
		MainMenuPageLink.setBackground(new Color(50,50,50));
		MainMenuPageLink.setForeground(Color.WHITE);
				
	}
	
	public void displayScores() {
		staticContainer.remove(dynamicContainer);
		
		dynamicContainer = new JPanel();
		dynamicContainer.setBackground(Color.white);
		dynamicContainer.setPreferredSize(new Dimension(900, 600)); 
		JLabel title = new JLabel("Leader board", SwingConstants.CENTER);
		dynamicContainer.add(title);

		title.setPreferredSize(new Dimension(900, 60));
		for(GameScore score : controller.scoreboard.getScores()) {
			JLabel entry = new JLabel("User: "+score.playerName+", rights guesses: "+score.rightGuesses+", wrong guesses: "+score.wrongGuesses,  SwingConstants.CENTER);
			entry.setPreferredSize(new Dimension(900, 30));
			dynamicContainer.add(entry);
		}
		staticContainer.add(dynamicContainer);
	}
	
	@Override
	public void update() {
		if (controller.scoreboard != null)
			displayScores();
	}
	
}
