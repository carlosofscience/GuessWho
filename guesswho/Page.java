package guesswho;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Page extends JPanel{
	protected ArrayList<PageLink> links;//keeps tracks of links within the box
	protected GameController controller;
	protected String pageName;
	
	Page(){
		super();
		links = new ArrayList<PageLink>();
	}
	
	public void addLink(PageLink link) {
		addLink(link, null);
	}
	
	public void addLink(PageLink link, Object component) {
		registerLink(link);
		if(component != null) {
			add(link, component);
		}else {
			add(link);
		}
	}
	public void registerLink(PageLink link) {
		links.add(link);
	}
	public void setGameController(GameController controller) {
		this.controller = controller;
		controller.addSubscriber(this, this.getName());
		System.out.println("added Subscriber page: "+this.getName()+" to :" +this.getName());

	}
	
	ArrayList<PageLink> getLinks(){
		return links;
	}

	//to be updated by publisher controller
	public void update() {
		
	}
}
