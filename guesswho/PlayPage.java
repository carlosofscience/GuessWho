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

public class PlayPage extends Page{
	
	PlayPage(){
		setName("PlayPage");
		GridBagLayout gbl_PlayPage = new GridBagLayout();
		gbl_PlayPage.columnWidths = new int[]{180, 105, 0};
		gbl_PlayPage.rowHeights = new int[]{30, 14, 35, 23, 23, 23, 23, 0};
		gbl_PlayPage.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_PlayPage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_PlayPage);
		
		JLabel lblNewLabel = new JLabel("Play window");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton PlayPageBtn = new JButton("Back");
        PlayPageBtn.setName("MainMenuPage");
        GridBagConstraints gbc_mainMenuBtn = new GridBagConstraints();
        gbc_mainMenuBtn.anchor = GridBagConstraints.NORTH;
        gbc_mainMenuBtn.gridx = 1;
        gbc_mainMenuBtn.gridy = 6;
        add(PlayPageBtn, gbc_mainMenuBtn);

        //add buttons with the name of the window is targeting to
        linkComponents.add(PlayPageBtn);
		
	}
}
