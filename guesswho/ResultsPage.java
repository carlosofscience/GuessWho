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
	
	ResultsPage(GameController controller){
		super(controller);
		setName("ResultsPage");
		pageContainer = new JPanel();
		pageContainer.setBackground(Color.blue);
//		pageContainer.setPreferredSize(this.getParent().size()); 
		add(pageContainer);
		
	}
	
	private JPanel getScoreContainer(){
		return new JPanel();
	}
	
	private void loadPage(){
		remove(pageContainer);
		pageContainer = new JPanel();
		pageContainer.setBackground(Color.blue);
		JLabel infoMsg = new JLabel();
		if (controller.gameSession.playerWins == true) {
			infoMsg.setText("you guessed right, you won the match!!!");
		}else {
			infoMsg.setText("you guessed wrong, you LOST the match...");
		}
		
		add(pageContainer);
	}
	
	@Override
	public void update() {
		System.out.println("udpating from results page");
		if (controller != null && controller.gameSession != null) {
			System.out.println("calling loadPage() ");
			loadPage();

		}
	}
}
