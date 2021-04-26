package guesswho;

import java.util.ArrayList;

public class GameController {
	
	public GameTheme currentGameTheme;
	public ArrayList<Page> subcriberPages;
	public GameSession gameSession;
	
	GameController(){
		currentGameTheme = new GameTheme("Classic GuessWho");
		subcriberPages = new ArrayList<Page>();
		//load all themes
	}
	
	public void startGameSession() {
		gameSession = new GameSession(currentGameTheme.getCharacters().get(0));
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

	public String getSuggestion(String text) {
//		ArrayList<String> charactersFeatures = currentGameTheme.charactersFeatures;
//		System.out.print("charactersFeatures size =>: "+currentGameTheme.charactersFeatures.size());
		for(String feature: currentGameTheme.charactersFeatures) {
			if(feature.indexOf(text) >= 0) return feature;
		}	
		return "";
	}
	
}
