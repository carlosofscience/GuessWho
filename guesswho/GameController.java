package guesswho;

import java.util.ArrayList;

public class GameController {
	
	public GameTheme currentGameTheme;
	public ArrayList<Page> subcriberPages;
	public GameSession gameSession;
	
	GameController(){
		currentGameTheme = new GameTheme("Classic GuessWho");
		subcriberPages = new ArrayList<Page>();
		gameSession = new GameSession(currentGameTheme.getCharacters().get(1));
		//load all themes
	}
	
	public boolean isCharacterFeature(String feature) {
		return gameSession.getMisteryCharacter().hasFeature(feature);
	}
	
	public void startGameSession() {
		System.out.println("mistery character: "+gameSession.getMisteryCharacter());
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

	public ArrayList<String> getNameSuggestion(String text) {
//		returns up to 4 suggestions for names
		ArrayList<String> suggestions = new ArrayList<String>();
		for(String name: currentGameTheme.charactersNames) {
			if(name.indexOf(text) >= 0 && suggestions.size() < 4 && !suggestions.contains(name)) {
				suggestions.add(name);
			}
		}	
		return suggestions;
	}
	
	public ArrayList<String> getFeatureSuggestion(String text) {

		ArrayList<String> suggestions = new ArrayList<String>();
		for(String feature: currentGameTheme.charactersFeatures) {
			if(feature.indexOf(text) >= 0 && suggestions.size() < 4 && !suggestions.contains(feature)) {
				suggestions.add(feature);
			}
		}	
		return suggestions;
	}
	
	public boolean isValidName(String userInput) {
		for(String name: currentGameTheme.charactersNames)
			if(name.equals(userInput))
				return true;
		return false;		
	}
	
	public boolean isValidFeature(String userInput) {
		for(String feature: currentGameTheme.charactersFeatures)
			if(feature.equals(userInput))
				return true;
		return false;		
	}
}
