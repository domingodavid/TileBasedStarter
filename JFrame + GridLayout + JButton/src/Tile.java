import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Tile extends JButton{
	private Color color;
	ImageIcon img1, img2; //add any other images
	int r, c; //possible location variables
	
	public Tile(String fileName) {
		super(); //call parent Constructor
		color = Color.white;
		
		//setup icon image
		img1 = new ImageIcon(Tile.class.getResource(fileName));
		//you can setup additional images here
		//if you're switch images when you click
		
		//call parent helper methods
		//I'm explicity using super below to 
		//emphasize using methods from parent class
		super.setIcon(img1); 
		super.setBackground(color);
	}
	
	public Tile(int r, int c) {
		super(); //call parent Constructor
		this.r = r;
		this.c = c;
		color = Color.white;
		super.setBackground(color);
	}
	
	public Tile(String fileName, int row, int col) {
		this(fileName);		
		r = row;
		c = col;
	}
	
	
	public void setRowCol(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	/* swap two Tile Objects by passing around the object's instance
	 * variables from one tile to the other and vice versa
	 * 
	 * you will need to add code here if you add additional instance variable
	 * for a Tile
	 */
	public void swap(Tile second) {
		int prevR = r;
		int prevC = c;
		Color prevColor = color;
		ImageIcon prevImg1 = img1;
		this.r = second.r;
		this.c = second.c;
		this.color = second.color;
		img1 = second.img1;
		this.setEnabled(true);
		
		second.r = prevR;
		second.c = prevC;
		second.img1 = prevImg1;
		second.color = prevColor;
		second.refreshIcon();
		second.setEnabled(true);
		refreshIcon();
		
	}

	
	public void refreshIcon() {
		System.out.println(img1);
		super.setIcon(img1); 
	}
	
	public void setImage(String fileName) {
		img1 = new ImageIcon(Tile.class.getResource(fileName));
		super.setIcon(img1);
	}
	
}
