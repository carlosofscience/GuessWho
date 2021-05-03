package guesswho;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreBoard {

	protected ArrayList<GameScore> scores;
	protected int maxNumOfScores;
	
	public ArrayList<GameScore> getScores() {
		return scores;
	}

	public void setScores(ArrayList<GameScore> scores) {
		this.scores = scores;
	}

	ScoreBoard(){
		scores = new ArrayList<GameScore>();
		maxNumOfScores = 10;
		loadScores();
	}
	
	public void saveScores() {
			try {
		      FileWriter userScoresFile = new FileWriter("./src/data/scores.txt");
		      String ScoreData = "";
		      Collections.sort(scores);
		      for(GameScore score: scores) {
		    	  //only save winners
		    	  if(score.playerWon)
		    		  ScoreData += score;
		      }
		      System.out.println("ScoreData");
		      System.out.println(ScoreData);
		      userScoresFile.write(ScoreData);
		      userScoresFile.close();
		      System.out.println("Successfully stored scores to scores.txt");
		    } catch (IOException e) {
		      System.out.println("An error occurred while writing scores to score.txt.");
		      e.printStackTrace();
		    }
	}
	
	//load characters with all images and features
	public void loadScores() {

		System.out.println("loading game scores ");
	      int lineNum = 0, scoreLines = 4;

		//get theme characters preferences, read from profiles.txt
		  try {
		      File userScoresFile = new File("./src/data/scores.txt");
		      Scanner userScoresData = new Scanner(userScoresFile);
		      String playerName = "", data="";
		      int right=0, wrong = 0;
		      Boolean playerWon = null;
		      Icon image = null;//TODO: point to default
		      scores.clear();
		      while (userScoresData.hasNextLine()) {
			    data = userScoresData.nextLine();
			    if (data.length() == 0 ) break;
			    if(lineNum  <= (maxNumOfScores * scoreLines)){
		    		switch(lineNum % scoreLines) {
		    			case 0:
		    				playerName = data;
		    				break;
		    			case 1:
		    				right = Integer.parseInt(data);
		    				break;
		    			case 2:
		    				wrong = Integer.parseInt(data);
		    				break;
		    			case 3:
		    			{
		    				playerWon = data.equals("true");
		    				scores.add(new GameScore(playerName, right, wrong, playerWon));
		    				
		    				}
		    				break;		    				
		    		}
//				    System.out.println("line "+lineNum+", code: "+(lineNum % 3)+", data: "+data+", characters: "+characters.size());		    		
		    	}else {
		    		break;
		    	}
			    
			    lineNum++;
			    
		      }
		      userScoresData.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  Collections.sort(scores);
		  System.out.println("Finished importing scores("+scores.size()+") and sorted, lines read: "+lineNum);		  
		  System.out.println(scores);
	}
	
	
}
