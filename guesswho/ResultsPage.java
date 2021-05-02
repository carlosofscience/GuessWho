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

public class ResultsPage extends Page
{
	JPanel pageContainer;
	
	ResultsPage(){
		setName("ResultsPage");
		pageContainer = new JPanel();
		pageContainer.setBackground(Color.blue);
		pageContainer.setPreferredSize(new Dimension(900, 600)); 

		add(pageContainer);
		pageContainer.setPreferredSize(new Dimension(900, 600)); 
		
	}
	
	private JPanel getScoreContainer(){
		return new JPanel();
	}
	
	private void loadPage(){
		remove(pageContainer);
		pageContainer = new JPanel();
		pageContainer.setBackground(Color.yellow);
		JLabel infoMsg = new JLabel("message display here");
		if (controller.gameSession.playerWins == true) {
			infoMsg.setText("you guessed right, you won the match!!!");
		}else {
			infoMsg.setText("you guessed wrong, you LOST the match...");
		}
		//fill page container
		pageContainer.add(infoMsg);
		//add updated container
		add(pageContainer);
		pageContainer.setPreferredSize(new Dimension(900, 600)); 

	}
	
	@Override
	public void update() {
		System.out.println("udpating from results page");
		if (controller.gameSession != null && controller.gameSession.playerWins != null) {
			System.out.println("calling loadPage() ");
			loadPage();
		}
	}
}
