package guesswho;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage extends Page
{
	HowToPlayPage(){
		super();
		setName("HowToPlayPage");
		GridBagLayout gbl_ScoreboardPanel = new GridBagLayout();

		gbl_ScoreboardPanel.columnWidths = new int[]{180, 105, 0};
		gbl_ScoreboardPanel.rowHeights = new int[]{20, 0, 23, 23, 23, 23, 23, 23, 23};
		gbl_ScoreboardPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_ScoreboardPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_ScoreboardPanel);
		
		JLabel lblNewLabel_1 = new JLabel("How To Play");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>This game works like the famous table top game called \"Guess Who\". <br> The ultimate goal of this game is to guess the computer's chosen character.</html>");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>The computer will choose a random character from the chosen theme. <br> You will then ask the computer some questions about their chosen character, <br> and the computer will respond yes or no. </html>");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html>You will try to guess the computer's chosen character in the least amount of <br> turns. You can also guess the character at any time, just make sure you are <br> confident and sure about the character. </html>");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>If you guess the wrong character, you lose. If you guess the right character, you win! <br><br> You can check the scoreboard to see your best scores.</html>");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("<html>Good Luck!</html>");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		PageLink MainMenuPageLink = new PageLink("Back");
		MainMenuPageLink.setLink("MainMenuPage");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 9;
		addLink(MainMenuPageLink, gbc_btnNewButton_4);
				
	}
}
