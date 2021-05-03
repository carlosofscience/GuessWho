package guesswho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ResultsPage extends Page
{	
	private JPanel MainContainer, pageContainer;
	
	ResultsPage(){
		setName("ResultsPage");
		MainContainer = new JPanel();
		MainContainer.setBackground(Color.WHITE);
		MainContainer.setPreferredSize(new Dimension(900, 500)); 

		pageContainer = new JPanel();
		pageContainer.setBackground(Color.WHITE);
		pageContainer.setPreferredSize(new Dimension(900, 500)); 
	
		PageLink mainMenuLink = new PageLink("Main Page");
		mainMenuLink.setBackground(new Color(50,50,50));
		mainMenuLink.setForeground(Color.WHITE);
		mainMenuLink.setLink("MainMenuPage");
		
		JPanel paddinTop = new JPanel();
		paddinTop.setBackground(Color.WHITE);
		paddinTop.setPreferredSize(new Dimension(900, 80)); 
		
		MainContainer.add(pageContainer);
		
		add(paddinTop);		
		add(MainContainer);
		addLink(mainMenuLink);
		
		
		mainMenuLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	controller.endGameSession(false);//ends session and adds scores

            	System.out.println("detroying game session, going back to menu (save score here if any)");
            	//reloading theme to fix image size
            	controller.setGameTheme(controller.currentGameTheme.themeName);
            }
        });
		
	}
	
	private JPanel getWinnerPanel(){
		JPanel panel =new JPanel();
		JLabel infoMsg = new JLabel("you guessed right, you won the match!!!");
		panel.add(infoMsg);
		return panel;
	}
	
	private JPanel getLooserPanel(){
		JPanel panel =new JPanel();
		JLabel infoMsg = new JLabel("you guessed wrong, you LOST the match...", SwingConstants.CENTER);
		
		JPanel titlesPanel = new JPanel(), ImagesPanel = new JPanel(), namesPanel = new JPanel();
		titlesPanel.setBackground(Color.WHITE);
		ImagesPanel.setBackground(Color.WHITE);
		namesPanel.setBackground(Color.WHITE);

		titlesPanel.setPreferredSize(new Dimension(900, 40));
		ImagesPanel.setPreferredSize(new Dimension(900, 274));
		namesPanel.setPreferredSize(new Dimension(900, 40));
		JLabel mysteryImage = new JLabel(),  suspectImage = new JLabel();
		JLabel misteryName = new JLabel(controller.gameSession.getMisteryCharacter().getName(),  SwingConstants.CENTER);
		JLabel suspectName = new JLabel(controller.gameSession.getSuspectCharacter().getName(),  SwingConstants.CENTER);
		misteryName.setBackground(Color.WHITE);
		suspectName.setBackground(Color.WHITE);
		JLabel misteryTitle = new JLabel("Mystery Character",  SwingConstants.CENTER);
		JLabel suspectTitle = new JLabel("Suspect Character",  SwingConstants.CENTER);
		misteryTitle.setBackground(Color.WHITE);
		suspectTitle.setBackground(Color.WHITE);

		infoMsg.setPreferredSize(new Dimension(900, 40));
		misteryTitle.setPreferredSize(new Dimension(150, 30));
		suspectTitle.setPreferredSize(new Dimension(150, 30));
		misteryName.setPreferredSize(new Dimension(150, 30));
		suspectName.setPreferredSize(new Dimension(150, 30));
		suspectName.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

		Icon misteryIcon = controller.gameSession.getMisteryCharacter().getImage();
		Icon suspectIcon = controller.gameSession.getSuspectCharacter().getImage();
		
		//set size in this current line (if needed)
		misteryIcon.resize(150, 270);
		suspectIcon.resize(150, 270);
		mysteryImage.setIcon(misteryIcon);
		suspectImage.setIcon(suspectIcon);
		titlesPanel.add(misteryTitle);
		titlesPanel.add(suspectTitle);
		ImagesPanel.add(mysteryImage);
		ImagesPanel.add(suspectImage);
		namesPanel.add(misteryName);
		namesPanel.add(suspectName);
		panel.add(titlesPanel);
		panel.add(ImagesPanel);
		panel.add(namesPanel);
		panel.add(infoMsg);
		panel.add(new JLabel("you guessed: "+controller.gameSession.getCorrectGuesses()+" features right, and  "+controller.gameSession.getIncorrectGuesses()+" features wrong"));
		
		return panel;
	}
	
	private void loadPage(){
		MainContainer.remove(pageContainer);

		if (controller.gameSession.playerWins == true) {
			pageContainer = getWinnerPanel();
		}else {
			pageContainer = getLooserPanel();
		}
		pageContainer.setBackground(Color.WHITE);
		//add link to page the bottom of page container here
		
		MainContainer.add(pageContainer);
		pageContainer.setPreferredSize(new Dimension(900, 500)); 
		MainContainer.setPreferredSize(new Dimension(900, 500)); 

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
