package guesswho;

import java.util.ArrayList;

public class GameCharacter {
	
	private ArrayList<String> features;
	private Icon image;
	
	public GameCharacter(ArrayList<String> features, Icon image) {
		super();
		this.features = features;
		this.image = image;
	}

	public ArrayList<String> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<String> features) {
		this.features = features;
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}
}
