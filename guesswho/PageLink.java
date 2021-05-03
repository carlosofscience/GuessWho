package guesswho;

import java.awt.Cursor;

import javax.swing.JButton;

public class PageLink extends JButton {
	
	private String pageLink;
	
	//add default styling
	
	PageLink(String name){
		super(name);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	void setLink(String link){
		pageLink = link;
	}
	
	String getLink(){
		return pageLink;
	}
}
