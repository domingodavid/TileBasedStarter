import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel implements MouseListener  {
	//change the size of the board if you need to
	int gridRows =  8, gridCols = 8;
	Tile[][] tiles = new Tile[gridRows][gridCols];
	
	/* constructor for MainPain class */
	public MainPanel() {
		
		//Create a JFrame Object with a title bar text
		JFrame f = new JFrame("JButtons and GridLayout");
		
		//Set the size of the window
		f.setSize(800,800); //width and height
		
		//set default action for x button
		//without this, your code will run behind the scenes until
		//you force exit
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(gridRows,gridCols));
		
		
		//setup the board
		for(int r = 0; r < tiles.length; r++) {
			for(int c = 0; c < tiles[r].length; c++) {
				
				if(r<=1 || r>=6)
					tiles[r][c] = new Tile("queen.png", r, c);				
				else
					tiles[r][c] = new Tile( r, c);
				//add the title to the jFrame
				f.add(tiles[r][c]);
				
				//add mouse listener for each tile
				tiles[r][c].addMouseListener(this);
			}
		}
		
		tiles[0][0].setImage("carpic.png");
		
		
		
		
		
		f.setVisible(true);
	}

	Tile prev = null;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		//On a click, figure out what tile was clicked
		Tile theTile = (Tile) arg0.getComponent();
		if(prev == null) { //fiirst click, sets prev
			prev = theTile;
			prev.setEnabled(false);
		}
		else {
			//check if this is a valid move?
			//check row
			if(Math.abs(prev.r-theTile.r)>2) {
				prev.setEnabled(true);
				prev = null;
				return; //illeegal move!!!
			}
			
			
			
			//second click means user is trying to swap
			theTile.swap(prev);
			prev = null;
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}