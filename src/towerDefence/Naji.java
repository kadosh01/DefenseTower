package towerDefence;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Naji extends Creep{
	//private final String[] path;
	protected double poison;
	protected double poisonTime;
	
	public Naji(int x,int y, Cell cell, Cell[][] board) throws IOException{
		super(cell, board);
		this.speed=1;
		this.x=x;
		this.y=y;
		//this.im=new Image[2];
		
	}

	@Override
	public void tickHAppend(Tickable t) {
		Cell curr= location;
		counter++;
		Cell[][] board= this.board;
		if(curr._x+curr.next_x<board.length & curr._y+curr.next_y<board.length){
			x = x + location.next_x;
			y = y + location.next_y;
			im=m[counter%m.length];
			if(counter%(1000/Game.delay)==0){
				location = board[curr._x+curr.next_x][curr._y+curr.next_y];
				poisonTime--;
			}
		}	
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
