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
	
	JPanel characterGridContainer;
	JPanel charactersContainer;
	PageLink hiddenConfirmationPageLink;
	
	PlayPage(){
		charactersContainer = new JPanel();
		setName("PlayPage");

        JPanel headerContainer = new JPanel();
        headerContainer.setBackground(Color.blue);
        headerContainer.setPreferredSize(new Dimension(900, 30));        
        characterGridContainer = new JPanel();
        characterGridContainer.setBackground(Color.blue);
        characterGridContainer.setPreferredSize(new Dimension(900, 600));
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
		exitGameSessionBtn.setLink("MainMenuPage");
		this.registerLink(exitGameSessionBtn);
        JLabel gameStatus = new JLabel("Guess a feature");
        JLabel rightGuesses = new JLabel("Right: 0");
        JLabel wrongGuesses = new JLabel("Wrong: 0");
		
        JTextField guessInput = new JTextField("Enter character name (1 try only)", 40);  
        guessInput.setBounds(20,0, 600,60); 
        JTextField askInput = new JTextField("Enter feature to guess...", 40);  
        askInput.setBounds(20,60, 600,60); 
        
        
		JButton askBtn = new JButton("Ask Feature");
		JButton guessBtn = new JButton("Final Guess");
		JButton[] featureSuggestionBtns = new JButton[4];
		JButton[] namesSuggestionBtns = new JButton[4];
		
		for(int i=0; i < featureSuggestionBtns.length; i++ ) {
			final int index = i;
			featureSuggestionBtns[i] = new JButton("");
			featureSuggestionBtns[i].setVisible(false);
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
			namesSuggestionBtns[i] = new JButton("");
			namesSuggestionBtns[i].setVisible(false);
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
        		controller.endGameSession();
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
		
		int imageWidth = Math.round(WIDTH/bigSide)-50, imageHeight= Math.round(HEIGHT/smallSide);

		
		//remove container if is added
		characterGridContainer.remove(charactersContainer);
		
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
		characterGridContainer.add(charactersContainer);
//		return new Icon[bigSide][smallSide];
	} 
	
	public void update() {
		displayThemeIcons();
	}
}
