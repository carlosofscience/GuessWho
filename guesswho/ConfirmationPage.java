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

public class ConfirmationPage extends Page{
	
	JPanel characterGridContainer;//holds removable container
	JPanel chosenCharacterContainer;
	JLabel confirmationMsg; 
	
	ConfirmationPage(){
		characterGridContainer = new JPanel();
		characterGridContainer.setBackground(Color.blue);
		characterGridContainer.setPreferredSize(new Dimension(900, 300));       
		
		chosenCharacterContainer =  new JPanel();
		setName("ConfirmationPage");    

        JPanel confirmationMsgContainer = new JPanel();
        confirmationMsgContainer.setBackground(Color.red);
        confirmationMsgContainer.setPreferredSize(new Dimension(900, 100));
      


        //adding containers
        add(characterGridContainer);
        add(confirmationMsgContainer);
        
        confirmationMsg = new JLabel("Are you sure this is the right character? (you only have 1 try)");
        
		PageLink playPageLink = new PageLink("Discard");
		playPageLink.setLink("PlayPage");
		PageLink confirmationBtn= new PageLink("Confirm");	
		confirmationBtn.setLink("ResultsPage");
        
		//adding components to layout containers
		characterGridContainer.add(chosenCharacterContainer);
		confirmationMsgContainer.add(confirmationMsg);
		addLink(playPageLink);
		addLink(confirmationBtn);
		
               
        
		confirmationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	controller.gameSession.playerWins = controller.gameSession.getMisteryCharacter().getName().equals(controller.gameSession.getSuspectCharacter().getName());
            	controller.notifySubscribers("ResultsPage");

            	System.out.println("eval winner and going to ResultsPage");
            }
        });
		
	}
	
	private void loadSuspectCharacter(){
		//remove container
		characterGridContainer.remove(chosenCharacterContainer);
		
        //get image
        JLabel characterImg = new JLabel();
        characterImg.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		Icon image = controller.gameSession.getSuspectCharacter().getImage();
		//set size in this current line (if needed)
		image.resize(100, 180);
		characterImg.setIcon(image);
		
		//create new updated container 
		chosenCharacterContainer = new JPanel();
        chosenCharacterContainer.setBackground(Color.yellow);
        chosenCharacterContainer.setPreferredSize(new Dimension(600, 250));    
		chosenCharacterContainer.add(characterImg);
		confirmationMsg.setText("Are you sure \""+controller.gameSession.getSuspectCharacter().getName()+"\" is the right character? (you only have 1 try)");
		//add the new updated container
		characterGridContainer.add(chosenCharacterContainer);
	}
	
	public void update(){
		System.out.println("update from confirmation page");
		if (controller.gameSession.getSuspectCharacter() != null) {
			System.out.println("loadSuspectCharacter :0");
			loadSuspectCharacter();

		}
				
	}
	
}
