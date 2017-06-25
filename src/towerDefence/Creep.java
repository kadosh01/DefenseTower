package towerDefence;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Creep implements Tickable{

	public int x; // location in pixels
	public int y; //
	public Cell location;
	public double speed;
	public int life;
	protected Cell[][] board;
	public static final int size=30;
	public Image[] m;
	public Image im;
	public int counter;
	
	public Creep(Cell first, Cell[][] board){
		this.life=100;
		location= first;
		this.board = board;
	}
	
	


}
