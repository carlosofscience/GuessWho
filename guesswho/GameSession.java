package guesswho;

public class GameSession {
	
	private int totalGuesses;
	private int incorrectGuesses;
	private GameCharacter misteryCharacter;
	
	public int getTotalGuesses() {
		return totalGuesses;
	}

	public void setTotalGuesses(int totalGuesses) {
		this.totalGuesses = totalGuesses;
	}

	public int getIncorrectGuesses() {
		return incorrectGuesses;
	}

	public void setIncorrectGuesses(int incorrectGuesses) {
		this.incorrectGuesses = incorrectGuesses;
	}

	public GameCharacter getMisteryCharacter() {
		return misteryCharacter;
	}

	public void setMisteryCharacter(GameCharacter misteryCharacter) {
		this.misteryCharacter = misteryCharacter;
	}

	GameSession(GameCharacter misteryCharacter){
		//choose a random character
		this.misteryCharacter = misteryCharacter;
	}
	
	
}
