package guesswho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginPage extends Page{
	
	
	LoginPage(){
		setName("LoginPage");
		
		PageLink loginBtn = new PageLink("Login");
		loginBtn.setLink("MainMenuPage");
		loginBtn.setEnabled(false);
		loginBtn.setPreferredSize(new Dimension(100,40));

		JLabel title = new JLabel("Login", SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(900,40));
		JPanel paddingTop = new JPanel();
		paddingTop.setPreferredSize(new Dimension(900,250));
		JPanel logiBtnContainer = new JPanel();
		logiBtnContainer.setPreferredSize(new Dimension(900,50));

		TextInput userNameInput = new TextInput("Enter your user name...");
		userNameInput.setHorizontalAlignment(TextInput.CENTER);
//		userNameInput.setBounds(0, 0, 900,60); 
		userNameInput.setPreferredSize(new Dimension(600,40));


		
		registerLink(loginBtn);
		logiBtnContainer.add(loginBtn);
		
		add(paddingTop);
		add(title);
		add(userNameInput);		
		add(logiBtnContainer);
		
		userNameInput.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	}

			@Override
			public void insertUpdate(DocumentEvent e) {
        		if(userNameInput.getText().length() > 3) {
        			loginBtn.setEnabled(true);
        		}else {
        			loginBtn.setEnabled(false);
        		}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(userNameInput.getText().length() >= 3) {
					loginBtn.setEnabled(true);
        		}else {
        			loginBtn.setEnabled(false);
        		}
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	controller.userName = userNameInput.getText();
            }
        });
	}
	
	@Override
	public void update() {
		
	}
	
}
