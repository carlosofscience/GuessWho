package guesswho;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PageContainer extends JPanel {
	
	public GameController gameController;
	private CardLayout layout;
	private ArrayList<String> pages;
	private ArrayList<String> links;
	
	PageContainer(){
		super();
		gameController = new GameController();
		pages = new ArrayList<String>();
		links = new ArrayList<String>();
		layout = new CardLayout();
		setLayout(layout);
	}
	
	void show(String pageName){ 
//		System.out.println("size: "+this.getParent().getSize());
		
//		setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

		if(pages.contains(pageName)) {
			System.out.println("focusing page: "+pageName );
			layout.show(this, pageName);			
		}else {
			System.out.println("can't display page: "+pageName+", is not a page.");
		}

	}
	
	public void addPage(Page page) {
		
		pages.add(page.getName());
		page.setGameController(gameController);
		System.out.println("Adding page: "+page.getName() );

		for(PageLink link: page.getLinks()) 
		{
			//verify this is a button for a page
			links.add(link.getLink());
			link.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					show(link.getLink());  		}
			});
			
			System.out.println("Adding link to : "+link.getLink() );
		}
		add(page, page.getName());
		page.pageAdded();//notify page is added
		page.setPreferredSize(getPreferredSize());
		
		//display whatever last page was added
		show(page.getName());
	}

}
