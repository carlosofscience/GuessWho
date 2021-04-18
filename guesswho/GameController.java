package guesswho;

import java.util.ArrayList;

public class GameController {
	
	public GameTheme currentGameTheme;
	public ArrayList<Page> subcriberPages;
	
	GameController(){
		currentGameTheme = new GameTheme("Classic GuessWho");
		subcriberPages = new ArrayList<Page>();
		//load all themes
	}
	
	public void setGameTheme(String themeDirName) {
		currentGameTheme.loadTheme(themeDirName);
		System.out.println("loaded theme: "+currentGameTheme.themeName);
		notifySubscribers();
	}
	
	public void notifySubscribers() {
		System.out.println("notifySubscribers fired: subscribers("+subcriberPages.size()+")");
		for(Page page: subcriberPages) {
			page.update();
		}
	}
	
	public void addSubscriber(Page page) {
		subcriberPages.add(page);
	}
	
}
