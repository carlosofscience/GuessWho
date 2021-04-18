package guesswho;

public class GameController {
	
	GameTheme currentGameTheme;
	
	GameController(){
		init();
	}
	
	public void setGameTheme(String themeDirName) {
		System.out.println("Hello fron controller");
	}
	
	public void init() {
		
		//load all themes
		currentGameTheme = new GameTheme("Classic GuessWho");
		
	}
	
}
