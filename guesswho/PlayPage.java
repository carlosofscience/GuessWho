package guesswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	JPanel characterGridContainer;
	JPanel charactersContainer;
	PageLink hiddenConfirmationPageLink;
    JLabel gameStatus, rightGuesses, wrongGuesses;
    TextInput guessInput, askInput;
	PlayPage(){
		charactersContainer = new JPanel();
		setName("PlayPage");

        JPanel headerContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        headerContainer.setBackground(Color.white);
        headerContainer.setPreferredSize(new Dimension(900, 35));        
        characterGridContainer = new JPanel();
        characterGridContainer.setBackground(Color.white);
        characterGridContainer.setPreferredSize(new Dimension(900, 600));
        JPanel suggestionContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        suggestionContainer.setBackground(Color.white);
        suggestionContainer.setPreferredSize(new Dimension(900, 30));
        JPanel askFeatureContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        askFeatureContainer.setBackground(Color.white);
        askFeatureContainer.setPreferredSize(new Dimension(900, 30));
        JPanel guessContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        guessContainer.setBackground(Color.white);
        guessContainer.setPreferredSize(new Dimension(900, 30));

        
        add(headerContainer);
        add(characterGridContainer);
        //adding containers
        add(suggestionContainer);
        add(askFeatureContainer);
        add(guessContainer);
        hiddenConfirmationPageLink = new PageLink("confirm");
		hiddenConfirmationPageLink.setLink("ConfirmationPage");
		hiddenConfirmationPageLink.setVisible(false);
		addLink(hiddenConfirmationPageLink);
		
		PageLink exitGameSessionBtn= new PageLink("Exit Match");
		exitGameSessionBtn.setBackground(new Color(50,50,50));
		exitGameSessionBtn.setPreferredSize(new Dimension(100,40));
		exitGameSessionBtn.setForeground(Color.WHITE);
		exitGameSessionBtn.setLink("MainMenuPage");
		
		this.registerLink(exitGameSessionBtn);
        gameStatus = new JLabel("Guess a feature", SwingConstants.CENTER);
        gameStatus.setPreferredSize(new Dimension(500,40));
        rightGuesses = new JLabel("Right: 0", SwingConstants.CENTER);
        rightGuesses.setPreferredSize(new Dimension(100,40));
        wrongGuesses = new JLabel("Wrong: 0", SwingConstants.CENTER);
        wrongGuesses.setPreferredSize(new Dimension(100,40));
		
        guessInput = new TextInput("Enter character name", 40);  
        guessInput.setPreferredSize(new Dimension(600, 30));
        askInput = new TextInput("Enter feature to guess...", 40);  
        askInput.setPreferredSize(new Dimension(600, 30));
        
        
		JButton askBtn = new JButton("Ask Feature");
		askBtn.setBackground(new Color(50,50,50));
		askBtn.setForeground(Color.WHITE); 
		askBtn.setPreferredSize(new Dimension(150, 30));
		JButton guessBtn = new JButton("Final Guess");
		guessBtn.setBackground(new Color(50,50,50));
		guessBtn.setForeground(Color.WHITE); 
		guessBtn.setPreferredSize(new Dimension(150, 30));
		JButton[] featureSuggestionBtns = new JButton[4];
		JButton[] namesSuggestionBtns = new JButton[4];
		
		for(int i=0; i < featureSuggestionBtns.length; i++ ) {
			final int index = i;
			featureSuggestionBtns[i] = new PageLink("");
			featureSuggestionBtns[i].setVisible(false);
			featureSuggestionBtns[i].setBorder(new LineBorder(Color.WHITE, 5));
			featureSuggestionBtns[i].setPreferredSize(new Dimension(150, 34));
			featureSuggestionBtns[i].setBackground(new Color(80,80,80));
			featureSuggestionBtns[i].setForeground(Color.WHITE);
	        suggestionContainer.add(featureSuggestionBtns[i]);
	        featureSuggestionBtns[i].addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent event) {    	
	        		askInput.setText(featureSuggestionBtns[index].getText());
	        		featureSuggestionBtns[index].setVisible(false);
	        	}
	        });
		}
		for(int i=0; i < namesSuggestionBtns.length; i++ ) {
			final int index = i;
			namesSuggestionBtns[i] = new PageLink("");
			namesSuggestionBtns[i].setVisible(false);
			namesSuggestionBtns[i].setBorder(new LineBorder(Color.WHITE, 5));
			namesSuggestionBtns[i].setPreferredSize(new Dimension(150, 34));
			namesSuggestionBtns[i].setBackground(new Color(80,80,80));
			namesSuggestionBtns[i].setForeground(Color.WHITE);
	        suggestionContainer.add(namesSuggestionBtns[i]);
	        namesSuggestionBtns[i].addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent event) {    	
	        		guessInput.setText(namesSuggestionBtns[index].getText());
	        		namesSuggestionBtns[index].setVisible(false);
	        	}
	        });
		}
		//adding components to layout containers
		headerContainer.add(exitGameSessionBtn);
		headerContainer.add(gameStatus);
		headerContainer.add(rightGuesses);
		headerContainer.add(wrongGuesses);
		characterGridContainer.add(charactersContainer);
        askFeatureContainer.add(askInput);
        askFeatureContainer.add(askBtn);
        guessContainer.add(guessInput);
        guessContainer.add(guessBtn);
//        addLink(PlayPageLink);
               
        
        askInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	System.out.println("heloo");
            }
        });
        askInput.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	}

			@Override
			public void insertUpdate(DocumentEvent e) {
        		ArrayList<String> suggestions = controller.getFeatureSuggestion(askInput.getText());
        		
        		//hide all names suggestions
    			for(JButton nameSuggestions: namesSuggestionBtns) {
    				nameSuggestions.setVisible(false);
    			}

        		for(int i=0; i < featureSuggestionBtns.length; i++ ){
        			featureSuggestionBtns[i].setText("");
        			featureSuggestionBtns[i].setVisible(false);	

        			if(i < suggestions.size()) {
        				featureSuggestionBtns[i].setText(suggestions.get(i));
        				featureSuggestionBtns[i].setVisible(suggestions.get(i).length() > 0);	
        			}
        		}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}
        });
        
        exitGameSessionBtn.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event) {
        		controller.endGameSession(true);
        	}
        });
        
        askBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String feature = askInput.getText();
                System.out.println("The entered text is: " + feature);
                //check if feature is valid
                if(controller.isValidFeature(feature)) {
                	if(controller.gameSession.isCharacterFeature(feature)) {
                		gameStatus.setText("You guessed right!");
                	}else{
                		gameStatus.setText("Wrong feature try again...");
                	}
                	//update score
                	rightGuesses.setText("Rigth: "+controller.gameSession.getCorrectGuesses());
                	wrongGuesses.setText("Wrong: "+controller.gameSession.getIncorrectGuesses());
                }else {
                	gameStatus.setText("That's not a valid feature!");
                }
                //ask controller if is a right feature
                askInput.setText("");
            }
        });
        
        guessInput.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	}

			@Override
			public void insertUpdate(DocumentEvent e) {
        		ArrayList<String> suggestions = controller.getNameSuggestion(guessInput.getText());
        		
        		//hide all features suggestions
    			for(JButton featureSuggestions: featureSuggestionBtns) {
    				featureSuggestions.setVisible(false);
    			}

        		for(int i=0; i < namesSuggestionBtns.length; i++ ){
        			namesSuggestionBtns[i].setText("");
        			namesSuggestionBtns[i].setVisible(false);	

        			if(i < suggestions.size()) {
        				namesSuggestionBtns[i].setText(suggestions.get(i));
        				namesSuggestionBtns[i].setVisible(suggestions.get(i).length() > 0);	
        			}
        		}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}
        });
        
        guessBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String name = guessInput.getText();
                System.out.println("The guessBtn entered text is: " + name);
                //check if feature is valid
                if(controller.isValidName(name)) {
                	//got to confirmation page. save character with this name as suspect
                	GameCharacter suspect = controller.currentGameTheme.getCharacterByName(name);
                	if (suspect != null) {
                		//set suspect
                		controller.gameSession.setSuspectCharacter(suspect);
                    	//update confirmationPage
                		controller.notifySubscribers("ConfirmationPage");
                		//send user to confirmation page
            			hiddenConfirmationPageLink.doClick();
            			System.out.println("Moving to confirmation page");
                	}else {
                    	gameStatus.setText("did not find a character named \""+name+"\"");
                	}

                }else {
                	gameStatus.setText("\""+name+"\" is not a valid name!");
                }
                //ask controller if is a right feature
                guessInput.setText("");
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
	
	//called from update()
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
		
		int imageWidth = Math.round(WIDTH/bigSide)-80;
		int imageHeight= Math.round((int)(imageWidth * 1.8));//Math.round(HEIGHT/smallSide)-60;

		
		//remove container if is added
		characterGridContainer.remove(charactersContainer);
		
		//create new container, new layout
		charactersContainer = new JPanel();
		charactersContainer.setBackground(Color.WHITE);
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
		characterGridContainer.add(charactersContainer);
//		return new Icon[bigSide][smallSide];
	} 
	
	
	public void update() {
		System.out.println("PLayPage Updated with update()");
		//update labels
        gameStatus.setText("Guess a feature");
        rightGuesses.setText("Right: 0");
        wrongGuesses.setText("Wrong: 0");
        guessInput.setPlaceHolder("Enter character name");
        askInput.setPlaceHolder("Enter feature to guess...");
		displayThemeIcons();
	}
}
