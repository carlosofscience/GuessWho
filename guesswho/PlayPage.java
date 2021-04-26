package guesswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.lang.Math;

public class PlayPage extends Page{
	private GameController controller;
	JPanel charactersContainer;

	PlayPage(GameController controller){
		super(controller);
		this.controller = controller;
		charactersContainer = new JPanel();
		add(charactersContainer);
		setName("PlayPage");

        JPanel headerContainer = new JPanel();
        headerContainer.setBackground(Color.blue);
        headerContainer.setPreferredSize(new Dimension(900, 30));
        JPanel suggestionContainer = new JPanel();
        suggestionContainer.setBackground(Color.yellow);
        suggestionContainer.setPreferredSize(new Dimension(900, 30));
        JPanel askFeatureContainer = new JPanel();
        askFeatureContainer.setBackground(Color.white);
        askFeatureContainer.setPreferredSize(new Dimension(900, 30));
        JPanel guessContainer = new JPanel();
        guessContainer.setBackground(Color.red);
        guessContainer.setPreferredSize(new Dimension(900, 30));

        
        add(headerContainer);
        displayThemeIcons();
        //adding containers
        add(suggestionContainer);
        add(askFeatureContainer);
        add(guessContainer);
//		PageLink PlayPageLink = new PageLink("Back");
//		PlayPageLink.setLink("MainMenuPage");

		JButton askBtn = new JButton("Ask Feature");
		JButton guessBtn = new JButton("Final Guess");
		JButton suggestionBtn = new JButton("");
	
		
		suggestionBtn.setVisible(false);
		
        JTextField guessInput = new JTextField("Enter character name (1 try only)", 40);  
        
        guessInput.setBounds(20,0, 600,60); 
        JTextField askInput = new JTextField("Enter feature to guess...", 40);  
        guessInput.setBounds(20,60, 600,60); 
        
        suggestionContainer.add(suggestionBtn);
        
        askFeatureContainer.add(askInput);
        askFeatureContainer.add(askBtn);
        
        guessContainer.add(guessInput);
        guessContainer.add(guessBtn);
//        addLink(PlayPageLink);
               
        
        //game logic
        controller.startGameSession();
        
        askInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The entered text is: " + askInput.getText());
//                controller.guess()
                askInput.setText("");
            }
        });
        askInput.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	}

			@Override
			public void insertUpdate(DocumentEvent e) {
        		String suggestion = controller.getSuggestion(askInput.getText());
        		suggestionBtn.setText(suggestion);
        		suggestionBtn.setVisible(suggestion.length() > 0);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}
        });
        askBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The entered text is: " + askInput.getText());
                askInput.setText("");
            }
        });
        suggestionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                askInput.setText(suggestionBtn.getText());
            }
        });
        
	}
	//return 2d array of the grid containing integers with the size. row, column

	private int[] getArray(int size, int value) {
		int[] arr = new int[size];
		java.util.Arrays.fill(arr, value);
		return arr;
	}
	private double[] getArray(int size, double value) {
		double[] arr = new double[size];
		java.util.Arrays.fill(arr, value);
		return arr;
	}
	
	//called from uptate()
	private void displayThemeIcons(){
		//this code calculates best rectangle grid
		int numOfCharacters = controller.currentGameTheme.getCharacters().size();
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
		
		int imageWidth = Math.round(WIDTH/bigSide)-50, imageHeight= Math.round(HEIGHT/smallSide);

		
		//remove container if is added
		remove(charactersContainer);
		
		//create new container, new layout
		charactersContainer = new JPanel();
		charactersContainer.setBackground(Color.red);
		charactersContainer.setPreferredSize(new Dimension(900, 600));
		//add images
		//creates new grid and adds it to the charactersContainer
		for(int y=0; y < smallSide; y++) {
			for(int x=0; x < bigSide; x++) {
				int index = y * bigSide + x;
				JLabel imageContainer = new JLabel();
//				imageContainer.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
				Icon image = controller.currentGameTheme.getCharacters().get(y * bigSide + x).getImage();
				//set size in this current line (if needed)
				image.resize(imageWidth, (int)(imageWidth * 1.8));
				imageContainer.setIcon(image);
				imageContainer.setBounds(x*imageWidth, y*imageHeight, imageWidth, imageHeight);
				charactersContainer.add(imageContainer);
			}
		}

		//add container
		add(charactersContainer);
//		return new Icon[bigSide][smallSide];
	} 
	
	public void update() {
		displayThemeIcons();
	}
}
