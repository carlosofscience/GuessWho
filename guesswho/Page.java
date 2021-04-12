package guesswho;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Page extends JPanel{
	protected ArrayList<JButton> linkComponents;
	
	Page(){
		super();
		linkComponents = new ArrayList<JButton>();
	}
	
	ArrayList<JButton> getLinks(){
		return linkComponents;
	}
}
