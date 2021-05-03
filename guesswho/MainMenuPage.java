package guesswho;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPage extends Page{
	
	JLabel themeLabel;
	JPanel pageContainer;
	
	MainMenuPage(){
		setName("MainMenuPage");
		pageContainer = new JPanel();
		GridBagLayout gbl_MainMenuPanel = new GridBagLayout();
		gbl_MainMenuPanel.columnWidths = new int[]{180, 105, 0};
		gbl_MainMenuPanel.rowHeights = new int[]{30, 14, 35, 23, 23, 23, 23, 0};
		gbl_MainMenuPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_MainMenuPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_MainMenuPanel);
		
		JLabel lblNewLabel = new JLabel("Guess Who");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		PageLink PlayPageLink = new PageLink("Play");
		PlayPageLink.setLink("PlayPage");
		PlayPageLink.setBackground(new Color(50,50,50));
		PlayPageLink.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		addLink(PlayPageLink, gbc_btnNewButton);
		
		PageLink ChooseThemePageLink = new PageLink("Choose Theme");
		ChooseThemePageLink.setLink("ChooseThemePage");
		ChooseThemePageLink.setBackground(new Color(50,50,50));
		ChooseThemePageLink.setForeground(Color.WHITE);

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		addLink(ChooseThemePageLink, gbc_btnNewButton_1);
		
		PageLink HowToPlayPageLink = new PageLink("How to play");
		HowToPlayPageLink.setLink("HowToPlayPage");
		HowToPlayPageLink.setBackground(new Color(50,50,50));
		HowToPlayPageLink.setForeground(Color.WHITE);

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 5;
		addLink(HowToPlayPageLink, gbc_btnNewButton_2);
		
		PageLink ScoreBoardPageLink = new PageLink("Scoreboard");
		ScoreBoardPageLink.setLink("ScoreboardPage");
		ScoreBoardPageLink.setBackground(new Color(50,50,50));
		ScoreBoardPageLink.setForeground(Color.WHITE);
		GridBagConstraints gbc_showScoreBoardBtn = new GridBagConstraints();
		gbc_showScoreBoardBtn.anchor = GridBagConstraints.NORTH;
		gbc_showScoreBoardBtn.gridx = 1;
		gbc_showScoreBoardBtn.gridy = 6;
		addLink(ScoreBoardPageLink, gbc_showScoreBoardBtn);

		themeLabel = new JLabel("Current Theme: ");
		GridBagConstraints gbc_themeLabel = new GridBagConstraints();
		gbc_themeLabel.anchor = GridBagConstraints.NORTH;
		gbc_themeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_themeLabel.gridx = 1;
		gbc_themeLabel.gridy = 7;
		add(themeLabel, gbc_themeLabel);
		
		PlayPageLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	//start game session on play
       	     	controller.startGameSession();
       	     	controller.notifySubscribers("PlayPage");
       	     	System.out.println("game session started");
            }
        });
		

		ScoreBoardPageLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	//start game session on play
       	     	controller.scoreboard.loadScores();
       	     	controller.notifySubscribers("ScoreboardPage");
            }
        });

	
	}
	
	@Override
	public void update() {

		if(themeLabel != null) {
			themeLabel.setText("Current Theme: "+controller.currentGameTheme.themeName);			
		}
	}
	
}
