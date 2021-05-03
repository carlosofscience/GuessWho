package guesswho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HowToPlayPage extends Page
{	
	HowToPlayPage(){
		setName("HowToPlayPage");
		
		

		JPanel paddingTop = new JPanel();
		paddingTop.setPreferredSize(new Dimension(900,50));
		paddingTop.setBackground(Color.WHITE);

		JLabel title = new JLabel("How To Play", SwingConstants.CENTER);
		title.setFont(new Font("MS Sans Serif", Font.PLAIN, 24));
		title.setPreferredSize(new Dimension(900,30));
		title.setBackground(Color.WHITE);
		
		JPanel textContainer = new JPanel();
		textContainer.setPreferredSize(new Dimension(600,500));
		textContainer.setBackground(Color.WHITE);
		
		
		String text = "<html><center>This game works like the famous table top game called \"Guess Who\". The ultimate goal of this game is to guess the computer's chosen character."+
		"The computer will choose a random character from the chosen theme. <br><br> You will then ask the computer some questions about their chosen character, and the computer will determinate whether this are correct or not."+
		"You will try to guess the computer's chosen character in the least amount of <br> turns. You can also guess the character at any time, just make sure you are confident and sure about the character."+
		"If you guess the wrong character, you lose. If you guess the right character, you win! <br><br> You can check the scoreboard to see your best scores.<br><br>"+
		"Good Luck!</center></html>";
		JLabel instructions = new JLabel(text);
		instructions.setPreferredSize(new Dimension(600,500));
		instructions.setFont(new Font("MS Sans Serif", Font.PLAIN, 18));
		
		PageLink MainMenuPageLink = new PageLink("Back");
		MainMenuPageLink.setLink("MainMenuPage");
		MainMenuPageLink.setBackground(new Color(50,50,50));
		MainMenuPageLink.setForeground(Color.WHITE);
		textContainer.add(instructions);
		
		add(paddingTop);
		add(title);
		add(textContainer);
		
		addLink(MainMenuPageLink);
				
	}
}
