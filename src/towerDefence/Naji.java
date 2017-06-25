package towerDefence;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Naji extends Creep{
	//private final String[] path;
	
	public Naji(int x,int y, Cell cell, Cell[][] board) throws IOException{
		super(cell, board);
		this.speed=1;
		this.x=x;
		this.y=y;
		//this.im=new Image[2];
		
	}

	@Override
	public void tickHAppend(Tickable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
