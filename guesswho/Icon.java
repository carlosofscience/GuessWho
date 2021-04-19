package guesswho;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Icon extends ImageIcon{
	
	private BufferedImage img;
	private String path;
	private int width, height;
	
	Icon(String path){
		this(path, 40, 40);
	}
	
	Icon(String path, int width, int height){
		this.img = null;
		this.width = width;
		this.height = width;
		this.path = path;
		init();
	}
	
	public void resize(int w, int h) {
		
		Image dimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		setImage(dimg);
	}
	public void setPath(String path) {
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	private void init(){
		
		setPath(path);
		resize(width, height);
	}

}
