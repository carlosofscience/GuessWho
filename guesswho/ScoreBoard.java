package guesswho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard {

	private ArrayList<GameScore> scores;
	
	ScoreBoard(){
		scores = new ArrayList<GameScore>();
		loadScores();
	}
	
	//load characters with all images and features
	public void loadScores() {

		System.out.println("loading game scores ");
		//get theme characters preferences, read from profiles.txt
		  try {
		      File userScoresFile = new File("./src/data/scores.txt");
		      Scanner userScoresData = new Scanner(userScoresFile);
		      int lineNum = 0, maxNumOfScores = 5, scoreLines = 4;
		      String playerName = "", data="";
		      int right=0, wrong = 0;
		      Boolean playerWon = null;
		      Icon image = null;//TODO: point to default
		      scores.clear();

		      while (userScoresData.hasNextLine()) {
			    data = userScoresData.nextLine();
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
		    				playerWon = data.equals("won");
		    				scores.add(new GameScore(playerName, right, wrong, playerWon));
		    				
		    				}
		    				break;		    				
		    		}
//				    System.out.println("line "+lineNum+", code: "+(lineNum % 3)+", data: "+data+", characters: "+characters.size());		    		
		    	}
			    
			    lineNum++;
			    
		      }
		      userScoresData.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  System.out.println("Finished importing scores");		  
	}
	
	
}
