package guesswho;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PageContainer extends JPanel {
	
	private CardLayout layout;
	private ArrayList<String> pages;
	private ArrayList<String> links;
	
	PageContainer(){
		super();
		pages = new ArrayList<String>();
		links = new ArrayList<String>();
		layout = new CardLayout();
		setLayout(layout);
	}
	
	void focus(String pageName){ 
		if(pages.contains(pageName)) {
			System.out.println("focusing page: "+pageName );
			layout.show(this, pageName);			
		}

	}
	
	public void addPage(Page page) {
		
		pages.add(page.getName());
		System.out.println("Adding page: "+page.getName() );

		for(JButton link: page.getLinks()) 
		{
			//verify this is a button for a page
			if (link.getName().contains("Page")) {
				links.add(link.getName());
				link.addActionListener(new ActionListener(){
			        public void actionPerformed(ActionEvent e){
			        	focus(link.getName());  	
			        }
			    });

				System.out.println("Adding link to : "+link.getName() );

			}
		}
		add(page, page.getName());
		
		//display whatever last page was added
		focus(page.getName());
	}

}
