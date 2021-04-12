package guesswho;

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
	
	MainMenuPage(){
		setName("MainMenuPage");
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
		
		JButton PlayPageBtn = new JButton("Play");
		PlayPageBtn.setName("PlayPage");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		add(PlayPageBtn, gbc_btnNewButton);
		
		JButton ChooseThemePageBtn = new JButton("Choose Theme");
		ChooseThemePageBtn.setName("ChooseThemePage");

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		add(ChooseThemePageBtn, gbc_btnNewButton_1);
		
		JButton HowToPlayPageBtn = new JButton("How to play");
		HowToPlayPageBtn.setName("HowToPlayPage");

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 5;
		add(HowToPlayPageBtn, gbc_btnNewButton_2);
		
		JButton ScoreBoardPageBtn = new JButton("Scoreboard");
		ScoreBoardPageBtn.setName("ScoreboardPage");
		GridBagConstraints gbc_showScoreBoardBtn = new GridBagConstraints();
		gbc_showScoreBoardBtn.anchor = GridBagConstraints.NORTH;
		gbc_showScoreBoardBtn.gridx = 1;
		gbc_showScoreBoardBtn.gridy = 6;
		add(ScoreBoardPageBtn, gbc_showScoreBoardBtn);
		
		//add buttons with the name of the window is targeting to
		linkComponents.add(PlayPageBtn);
		linkComponents.add(ChooseThemePageBtn);
		linkComponents.add(HowToPlayPageBtn);
		linkComponents.add(ScoreBoardPageBtn);
		
	}
}
