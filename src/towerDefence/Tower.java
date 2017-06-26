package towerDefence;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Tower implements Tickable, Visitor{
	public int x;
	public int y;
	public Cell location;
	public double speed;
	protected Cell[][] board;
	protected int size;
	protected int Hsize;
	public Image[] m;
	public Image im;
	public int counter;
	public int hitArea;
	
	
	
	public Tower(int x,int y) throws IOException{
		this.x=x;
		this.y=y;
		System.out.println("tower x: "+x+" y: "+y);
		counter=0;
		board= Game.board;
		
	}

	public void setLocation(int x,int y){
		this.x=x;
		this.y=y;
	}

}
