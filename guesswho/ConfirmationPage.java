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
	private GameController controller;
	
	JPanel characterGridContainer;
	JPanel charactersContainer;

	ConfirmationPage(GameController controller){
		super(controller);
		this.controller = controller;
		charactersContainer = new JPanel();
		setName("ConfirmationPage");

        JPanel chosenCharacterContainer = new JPanel();
        chosenCharacterContainer.setBackground(Color.blue);
        chosenCharacterContainer.setPreferredSize(new Dimension(900, 300));        

        JPanel confirmationMsgContainer = new JPanel();
        confirmationMsgContainer.setBackground(Color.red);
        confirmationMsgContainer.setPreferredSize(new Dimension(900, 100));
      
        JPanel optionsContainer = new JPanel();
        optionsContainer.setBackground(Color.yellow);
        optionsContainer.setPreferredSize(new Dimension(900, 100));
        

        //adding containers
        add(chosenCharacterContainer);
        add(confirmationMsgContainer);
        add(optionsContainer);
        
        JLabel confirmationMsg = new JLabel("Are you sure this is the right character? (you only have 1 try)");
        
		PageLink PlayPageLink = new PageLink("Discard");
		PlayPageLink.setLink("PlayPage");
		
		JButton confirmationBtn= new JButton("Confirm");
	
        JLabel characterImg = new JLabel();
		
        
		//adding components to layout containers
		chosenCharacterContainer.add(characterImg);
		confirmationMsgContainer.add(confirmationMsg);
		optionsContainer.add(PlayPageLink);
		optionsContainer.add(confirmationBtn);
		
               
        
		confirmationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	System.out.println("here make sure controller knows that is a confirm on the selected character..");
            }
        });
		
	}
	
}
