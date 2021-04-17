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

public class ChooseThemePage extends Page{
	
	ChooseThemePage(){
		setName("ChooseThemePage");
		GridBagLayout gbl_PlayPage = new GridBagLayout();
		gbl_PlayPage.columnWidths = new int[]{180, 105, 0};
		gbl_PlayPage.rowHeights = new int[]{30, 14, 35, 23, 23, 23, 23, 0};
		gbl_PlayPage.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_PlayPage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_PlayPage);
		
		JLabel lblNewLabel = new JLabel("Choose Theme");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		PageLink PlayPageLink = new PageLink("Back");
		PlayPageLink.setLink("MainMenuPage");
        GridBagConstraints gbc_mainMenuBtn = new GridBagConstraints();
        gbc_mainMenuBtn.anchor = GridBagConstraints.NORTH;
        gbc_mainMenuBtn.gridx = 1;
        gbc_mainMenuBtn.gridy = 6;
        addLink(PlayPageLink, gbc_mainMenuBtn);
	}
}
