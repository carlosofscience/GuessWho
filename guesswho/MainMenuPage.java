package guesswho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPage extends Page{
	
	JLabel themeLabel;
	JPanel pageContainer;
	
	MainMenuPage(){
		setName("MainMenuPage");
		pageContainer = new JPanel();
		
		ArrayList<PageLink> links = new ArrayList<PageLink>();
		JPanel padding = new JPanel();
		padding.setBackground(Color.WHITE);
		padding.setPreferredSize(new Dimension(900, 150)); 
		
		JLabel lblNewLabel = new JLabel("Guess Who", SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(300, 100)); 
		lblNewLabel.setBackground(new Color(50,50,50));
		lblNewLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 24));
		
		PageLink PlayPageLink = new PageLink("Play");
		PlayPageLink.setLink("PlayPage");
		PlayPageLink.setBackground(new Color(50,50,50));
		PlayPageLink.setForeground(Color.WHITE);
		PlayPageLink.setPreferredSize(new Dimension(300, 40)); 
		links.add(PlayPageLink);
		
		PageLink ChooseThemePageLink = new PageLink("Choose Theme");
		ChooseThemePageLink.setLink("ChooseThemePage");
		ChooseThemePageLink.setBackground(new Color(50,50,50));
		ChooseThemePageLink.setForeground(Color.WHITE);
		ChooseThemePageLink.setPreferredSize(new Dimension(300, 40)); 
		links.add(ChooseThemePageLink);
		
		PageLink HowToPlayPageLink = new PageLink("How to play");
		HowToPlayPageLink.setLink("HowToPlayPage");
		HowToPlayPageLink.setBackground(new Color(50,50,50));
		HowToPlayPageLink.setForeground(Color.WHITE);
		HowToPlayPageLink.setPreferredSize(new Dimension(300, 40)); 
		links.add(HowToPlayPageLink);
		
		PageLink ScoreBoardPageLink = new PageLink("Scoreboard");
		ScoreBoardPageLink.setLink("ScoreboardPage");
		ScoreBoardPageLink.setBackground(new Color(50,50,50));
		ScoreBoardPageLink.setForeground(Color.WHITE);
		ScoreBoardPageLink.setPreferredSize(new Dimension(300, 40)); 
		links.add(ScoreBoardPageLink);

		themeLabel = new JLabel("Current Theme: ", SwingConstants.CENTER);
		themeLabel.setPreferredSize(new Dimension(300, 100)); 
		themeLabel.setBackground(new Color(50,50,50));

		add(padding);
		add(lblNewLabel);
		for(PageLink link: links) {
			JPanel container = new JPanel();
			registerLink(link);
			container.add(link);
			container.setBackground(Color.WHITE);
			container.setPreferredSize(new Dimension(900, 45)); 
			add(container);
		}
		add(themeLabel);
		
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
