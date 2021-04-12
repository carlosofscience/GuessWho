package guesswho;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Page extends JPanel{
	protected ArrayList<PageLink> links;//keeps tracks of links within the box
	
	Page(){
		super();
		links = new ArrayList<PageLink>();
	}
	
	public void addLink(PageLink link) {
		add(link, null);
	}
	
	public void addLink(PageLink link, Object component) {
		links.add(link);
		if(component != null) {
			add(link, component);
		}else {
			add(link);
		}
	}
	
	ArrayList<PageLink> getLinks(){
		return links;
	}
}
