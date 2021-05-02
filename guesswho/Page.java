package guesswho;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Page extends JPanel{
	protected ArrayList<PageLink> links;//keeps tracks of links within the box
	protected GameController controller;
	
	Page(GameController _controller ){
		super();
		controller = _controller;
		links = new ArrayList<PageLink>();
	}
	
	public void addLink(PageLink link) {
		addLink(link, null);
	}
	
	public void addLink(PageLink link, Object component) {
		links.add(link);
		if(component != null) {
			add(link, component);
		}else {
			add(link);
		}
	}
	public void setGameController(GameController controller) {
		this.controller = controller;
	}
	
	ArrayList<PageLink> getLinks(){
		return links;
	}
	
	@Override
	public void setName(String name) {
		controller.addSubscriber(this, name);
		super.setName(name);
		System.out.println("added Subscriber page: "+name+" to :" +name);
	}
	
	//to be updated by publisher controller
	public void update() {
		
	}
}
