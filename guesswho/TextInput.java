package guesswho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class TextInput extends JTextField{
	boolean hasBeenCleared;
	
	TextInput(String placeHolder){
		super(placeHolder);
		init();
	}
	TextInput(String placeHolder, int n){
		super(placeHolder, n);
		init();
	}
	
	private void init() {
		hasBeenCleared = false;
		this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	if (hasBeenCleared == false) {
	        		clear();
	        		hasBeenCleared = true;
	        	}
            }
        });
	}
	
	public void setPlaceHolder(String placeholder) {
		clear();
		this.setText(placeholder);
		hasBeenCleared = false;
	}
	
	private void clear(){
		this.setText("");
	}
	
	
}
