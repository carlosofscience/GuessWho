package guesswho;

import javax.swing.JButton;

public class PageLink extends JButton {
	
	private String pageLink;
	
	//add default styling
	
	PageLink(String name){
		super(name);
	}

	void setLink(String link){
		pageLink = link;
	}
	
	String getLink(){
		return pageLink;
	}
}
