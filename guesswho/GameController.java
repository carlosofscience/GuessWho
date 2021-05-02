package guesswho;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
	
	public GameTheme currentGameTheme;
	public ArrayList<Page> subcriberPages;
	public HashMap<String, ArrayList<Page>> subcriberPagesByTopic;
	public GameSession gameSession;
	
	GameController(){
		subcriberPagesByTopic = new HashMap<String, ArrayList<Page>>();
		subcriberPages = new ArrayList<Page>();
		currentGameTheme = new GameTheme("Classic GuessWho");
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
	
	public void notifySubscribers(String topic) {
		System.out.println("notifySubscribers fired: subscribers("+subcriberPages.size()+")");
		//prevent duplicate updates
		ArrayList<Page> updatedPages = new ArrayList<Page>();
		//check if is a broadcast message
		if(topic.equals("BROADCAST")) {
			for (String key : subcriberPagesByTopic.keySet()) {
				
				for(Page page: subcriberPagesByTopic.get(key)) {
					if(!updatedPages.contains(page)) {
						page.update();
						updatedPages.add(page);
					}
				}
			}
		}else if (subcriberPagesByTopic.get(topic)!=null) {
			//notify subscribers of specific topic
			for(Page page: subcriberPagesByTopic.get(topic)) {
				if(!updatedPages.contains(page)) {
					page.update();
					updatedPages.add(page);
				}
			}			
		}

	}
	
	public void notifySubscribers() {
		notifySubscribers("BROADCAST");
	}
	
	public void addSubscriber(Page page) {
		addSubscriber(page, "DEFAULT");
	}
	
	public void addSubscriber(Page page, String topic) {
		System.out.println("added new Subscriber, subscribers are: "+subcriberPagesByTopic.keySet());
		ArrayList<Page> pages = (subcriberPagesByTopic.get(topic) == null)? new ArrayList<Page>(): subcriberPagesByTopic.get(topic); 
		pages.add(page);
		subcriberPagesByTopic.put(topic, pages);
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
