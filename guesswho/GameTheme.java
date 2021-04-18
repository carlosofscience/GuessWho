package guesswho;

import java.util.ArrayList;

public class GameTheme {

	private ArrayList<GameCharacter> characters;
	private Icon themeIcon;
	private String themeName;
	public boolean isAvaliable;
	
	GameTheme(String themeName){
		loadTheme(themeName);
	}
	
	public void loadTheme(String themeName) {
		//get theme icon
		themeIcon = new Icon("./src/themes/"+themeName+"/imgs/icon.PNG", 40, 40);
		//get theme characters preferences
		//get theme icons
	}
	
	public String getThemePath(String themeName) {
		return "./src/themes/"+themeName+"/imgs/icon.PNG";
	}
	
	
	
}
