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
import java.lang.Math;

public class PlayPage extends Page{
	
	private GameController gameController;
	
	PlayPage(GameController controller){
		super(controller);
		this.gameController = controller;
		getGridLayout(24);
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
		
		PageLink PlayPageLink = new PageLink("Back");
		PlayPageLink.setLink("MainMenuPage");
        GridBagConstraints gbc_mainMenuBtn = new GridBagConstraints();
        gbc_mainMenuBtn.anchor = GridBagConstraints.NORTH;
        gbc_mainMenuBtn.gridx = 1;
        gbc_mainMenuBtn.gridy = 6;
        addLink(PlayPageLink, gbc_mainMenuBtn);
        
        //Display grid of characters
        //get number of columns and rows of characters according to number of character
        //such if is 24, find the 2 numbers which multiply by themselves gives 24
        /*
         *  1) Take the square root of the number X; we'll call it N.
			2) Set N equal to the ceiling of N (round up to the nearest integer).
			3) Test for (X % N). If N divides evenly into X, we found our first number.
			  if 0, divide X by N to get M. M and N are our numbers
			  if not 0, increment N by 1 and start step 3 over.
        */
	}
	//return 2d array of the grid containing integers with the size. row, column
	
	private int[][] getGridLayout(int numOfCharacters){
		
		int squareRoot = (int) Math.ceil(Math.sqrt(numOfCharacters));
		int m = 0;
		
		while(numOfCharacters % squareRoot == 0) {
			numOfCharacters++;
		}
		int temp;
		int smallSide = numOfCharacters / squareRoot;
		int bigSide = (int)(numOfCharacters / smallSide);
		
		temp = (smallSide > bigSide)? smallSide: bigSide;//check for the biggest
		smallSide = (bigSide < smallSide)? bigSide: smallSide;//check for smallest
		bigSide = temp;//set biggest to biggest
		

		return new int[bigSide][smallSide];
	} 
	
	public void update() {
		
	}
}
