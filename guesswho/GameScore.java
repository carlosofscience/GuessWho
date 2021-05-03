package guesswho;

public class GameScore  implements Comparable<GameScore>{
	protected String playerName;
	protected int rightGuesses;
	protected int wrongGuesses;
	protected Boolean playerWon;
	
	public GameScore(String playerName, int rightGuesses, int wrongGuesses, Boolean playerWon) {
		super();
		this.playerName = playerName;
		this.rightGuesses = rightGuesses;
		this.wrongGuesses = wrongGuesses;
		this.playerWon = playerWon;
	}

	private int getTotalGuesses() {
		return rightGuesses + wrongGuesses;
	}
	
	@Override
	public int compareTo(GameScore score) {
		// TODO Auto-generated method stub
		if(getTotalGuesses() > score.getTotalGuesses())
			return 1;
		else if (getTotalGuesses() < score.getTotalGuesses())
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return playerName + "\n" + rightGuesses + "\n" + wrongGuesses + "\n" + playerWon + "\n";
	}
}
