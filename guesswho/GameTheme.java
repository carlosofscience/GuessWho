package guesswho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameTheme {

	private ArrayList<GameCharacter> characters;
	private Icon themeIcon;
	public String themeName;
	public boolean isAvaliable;
	
	GameTheme(String _themeName){
		themeName = _themeName;
		characters = new ArrayList<GameCharacter>();
		loadTheme(_themeName);
	}
	
	public void loadTheme(String _themeName) {
		themeName = _themeName;

		System.out.println("loading theme: "+ _themeName);
		//get theme icon
		themeIcon = new Icon("./src/themes/"+themeName+"/imgs/THEME_ICON.PNG", 40, 40);
		//get theme characters preferences, read from profiles.txt
		  try {
		      File profiles = new File("./src/themes/"+themeName+"/profiles.txt");
		      Scanner profilesData = new Scanner(profiles);
		      int lineNum = 0, numOfCharactes = 0;
		      String features = "", name = "", data;
		      Icon image = null;//TODO: point to default
		      characters.clear();
		      while (profilesData.hasNextLine()) {
		    	  
			    data = profilesData.nextLine();

			    if(lineNum == 0) {
		    		numOfCharactes = Integer.parseInt(data);
		    	}else if (lineNum  <= (numOfCharactes * 3)){
		    		switch(lineNum % 3) {
		    			case 1:
		    				name = data;
		    				break;
		    			case 2:
		    				image =  new Icon("./src/themes/"+themeName+"/imgs/"+data);
		    				break;
		    			case 0:
		    				{
		    					features = data;
			    				characters.add(new GameCharacter(name, image, features));
			    				System.out.println("adding characters: "+characters.size());
		    				}
		    				break;		    				
		    		}
				    System.out.println("line "+lineNum+", code: "+(lineNum % 3)+", data: "+data+", characters: "+characters.size());		    		
		    	}
			    
			    lineNum++;
			    
		      }
		      profilesData.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	      	
		  System.out.println("Finished importing theme, and "+characters.size()+" characters");

		  
	}
	
	public String getThemePath(String themeName) {
		return "./src/themes/"+themeName+"/imgs/icon.PNG";
	}
	
	
	
}
