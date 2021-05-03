package guesswho;

public class GameSession {
	
	private int correctGuesses;
	private int incorrectGuesses;
	private GameCharacter misteryCharacter;
	private GameCharacter suspectCharacter;
	public Boolean playerWins;
	GameSession(GameCharacter misteryCharacter){
		//choose a random character
		this.misteryCharacter = misteryCharacter;
		correctGuesses=0;
		incorrectGuesses=0;
		suspectCharacter = null;
		playerWins = null;
	}
	
	public boolean isCharacterFeature(String feature) {
		boolean hasFeature = misteryCharacter.hasFeature(feature);
		if(misteryCharacter.hasFeature(feature)) {
			correctGuesses++;
		}else {
			incorrectGuesses++;
		}
		return hasFeature;
	}
	public int getCorrectGuesses() {
		return correctGuesses;
	}

	public void setCorrectGuesses(int correctGuesses) {
		this.correctGuesses = correctGuesses;
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

	public GameCharacter getSuspectCharacter() {
		return suspectCharacter;
	}

	public void setSuspectCharacter(GameCharacter suspectCharacter) {
		this.suspectCharacter = suspectCharacter;
	}	
	
	public boolean evalMatch() {
		return misteryCharacter.getName().equals(suspectCharacter.getName());
	}
}
