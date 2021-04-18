package guesswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ChooseThemePage extends Page{
		
	private String currentTheme;
	
	ChooseThemePage(){
		
		/*
		 TODO:
			1- create a directory for themes (each theme is a directory)
			2- read directory names display the window as buttons
		*/
		
		setName("ChooseThemePage");
		currentTheme = "Classic GuessWho";
		GridBagLayout gbl_PlayPage = new GridBagLayout();
		gbl_PlayPage.columnWidths = new int[]{180, 105, 0};
		gbl_PlayPage.rowHeights = new int[]{30, 30,40,40,40,40,40,0, 0};
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
		

		//theme options
		File f = new File("./src/themes");
		int index = 2;
		for (String themeDirName : f.list()) {
			
			JButton themeBtn = new PageLink(themeDirName);
			JLabel btn_label = new JLabel();
			btn_label.setIcon(getIconByThemeName(themeDirName));

			themeBtn.setPreferredSize(new Dimension(300, 40));
			themeBtn.setBorder(new LineBorder(Color.GRAY, 1));
			themeBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
			themeBtn.add(btn_label);
			
			themeBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					setGameTheme(themeDirName);	
				}
			});
			
			GridBagConstraints gbc_themeBtn = new GridBagConstraints();
			gbc_themeBtn.anchor = GridBagConstraints.NORTH;
			gbc_themeBtn.gridx = 1;
			gbc_themeBtn.gridy =  index;
			index+=1;
			
	        add(themeBtn, gbc_themeBtn);
        }

        
		PageLink MainMenuPageLink = new PageLink("Back");
		MainMenuPageLink.setLink("MainMenuPage");
        GridBagConstraints gbc_MainMenuPageLink = new GridBagConstraints();
        gbc_MainMenuPageLink.anchor = GridBagConstraints.NORTH;
        gbc_MainMenuPageLink.gridx = 1;
        gbc_MainMenuPageLink.gridy = ++index;
        addLink(MainMenuPageLink, gbc_MainMenuPageLink);
	}
	
	private void setGameTheme(String themeDirName) {
		System.out.println("Theme clicked: "+themeDirName);
		this.currentTheme = themeDirName;
	}
	
	private Icon getIconByThemeName(String themeDirName) {
		return new Icon("./src/themes/"+themeDirName+"/imgs/icon.PNG", 40, 40);
	}
}
