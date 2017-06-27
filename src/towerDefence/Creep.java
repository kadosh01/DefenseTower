package towerDefence;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Creep implements Tickable, Visited{

	public int x; // 
	public int y; // location in pixels
	public Cell location;
	public double speed;
	public int life;
	protected Cell[][] board;
	public static final int size=30;
	public Image[] m;
	public Image im;
	public int counter;
	public int slowTime;// Sam Tower
	public int gokuHit;// 
	public int H;      //
	public int K;      // Goku Tower
	
	public Creep(Cell first, Cell[][] board){
		this.life=100;
		location= first;
		this.board = board;
		this.slowTime = 0;
		this.H = 1;
	}
	
	public void hit(Tower t){
		this.accept(t);
	}


}
