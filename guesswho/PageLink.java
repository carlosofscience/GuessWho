package guesswho;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;

public class PageLink extends JButton {
	
	private String pageLink;
	
	//add default styling
	
	PageLink(String name){
		super(name);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		defaultStyle();
	}

	void setLink(String link){
		pageLink = link;
	}
	
	String getLink(){
		return pageLink;
	}
	
	private void defaultStyle() {

		setBackground(new Color(50,50,50));
		setForeground(Color.WHITE);
		setPreferredSize(new Dimension(300, 40)); 
	}
}
