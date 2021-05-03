package guesswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	JLabel chooseThemeLabel;
	JPanel mainContainer, dynamicContainer;
	
	ChooseThemePage(){

		/*
		 TODO:
			1- create a directory for themes (each theme is a directory)
			2- read directory names display the window as buttons
		*/
		setName("ChooseThemePage");
		JPanel paddingTop =  new JPanel();
		paddingTop.setPreferredSize(new Dimension(900, 150)); 
		paddingTop.setBackground(Color.white);
		chooseThemeLabel = new JLabel("Choose a game theme", SwingConstants.CENTER);
		chooseThemeLabel.setPreferredSize(new Dimension(900,40));
		chooseThemeLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 24));
		mainContainer = new JPanel();
		dynamicContainer = new JPanel();
		mainContainer.setPreferredSize(new Dimension(900, 400)); 
		mainContainer.setBackground(Color.white);
		mainContainer.add(dynamicContainer);

		loadThemes();
        
		PageLink MainMenuPageLink = new PageLink("Back");
		MainMenuPageLink.setLink("MainMenuPage");
		
		
		add(paddingTop);
		add(chooseThemeLabel);
		add(mainContainer);
        addLink(MainMenuPageLink );
	}
	
	public void loadThemes() {
		
		int containerHeight = 400;
		mainContainer.remove(dynamicContainer);

		dynamicContainer = new JPanel();

		//theme options
		File f = new File("./src/themes");
		int index = 2;
		for (String themeDirName : f.list()) {
			
			JButton themeBtn = new PageLink(themeDirName);
			JLabel btn_label = new JLabel();
			JPanel item = new JPanel();
			item.setPreferredSize(new Dimension(900, 80)); 
			item.setBackground(Color.WHITE);
			btn_label.setIcon(new Icon("./src/themes/"+themeDirName+"/imgs/THEME_ICON.PNG", 100, 80));
			btn_label.setFont(new Font("MS Sans Serif", Font.PLAIN, 20));

			themeBtn.setPreferredSize(new Dimension(400, 80));
			themeBtn.setBorder(new LineBorder(Color.GRAY, 1));
			themeBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
			themeBtn.add(btn_label);
			themeBtn.setBackground(new Color(50,50,50));
			themeBtn.setForeground(Color.WHITE);
			
			themeBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					controller.setGameTheme(themeDirName);
				}
			});
			item.add(themeBtn);
			dynamicContainer.add(item);
        }

		mainContainer.setPreferredSize(new Dimension(900, containerHeight)); 
		dynamicContainer.setPreferredSize(new Dimension(900, containerHeight)); 
		dynamicContainer.setBackground(Color.white);
		mainContainer.add(dynamicContainer);
	}
	
	public void update() {
		if(chooseThemeLabel != null)
		{
			chooseThemeLabel.setText("Using game theme: \""+controller.currentGameTheme.themeName+"\"");
			loadThemes();
		}
	}
	
	private Icon getIconByThemeName(String themeDirName) {
		return new Icon("./src/themes/"+themeDirName+"/imgs/THEME_ICON.PNG", 40, 40);
	}
}
