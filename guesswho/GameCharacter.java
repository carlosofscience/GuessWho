package guesswho;

public class GameCharacter {

	private String name;
	private Icon image;
	private String features;
	
	public GameCharacter(String name, Icon image, String features) {
		super();
		this.name = name;
		this.features = features;
		this.image = image;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}
	
	public boolean hasFeature(String feature) {
		return this.features.indexOf(feature) >= 0; 
	}
	
	public String toString() {
		return "{ name: "+name+", features: "+features+" }";
	}
}
