package towerDefence;

import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Naji extends Creep{
	private final String[] path={"/Ninja/Layer 4.png","/Ninja/Layer 5.png","/Ninja/Layer 6.png","/Ninja/Layer 7.png","/Ninja/Layer 8.png","/Ninja/Layer 9.png","/Ninja/Layer 10.png","/Ninja/Layer 11.png","/Ninja/Layer 12.png","/Ninja/Layer 13.png"};
	protected double poison;
	protected double poisonTime;
	
	public Naji(int x,int y, Cell cell, Cell[][] board) throws IOException{
			super(cell, board);
			this.speed=2;
			this.x=x;
			this.y=y;
			this.poison = 1;
			this.poisonTime = 0;
			m=new Image[path.length];
			for(int i=0;i<m.length;i++)
				m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
	}

	@Override
	public void tickHAppend(LinkedList<Tickable> towers) {
		Cell curr= location;
		counter++;
		Cell[][] board= this.board;
		System.out.println("x"+x+"y "+y);
		if(curr._x+curr.next_x<board.length & curr._y+curr.next_y<board.length){
			x = x + location.next_x;
			y = y + location.next_y;
			im=m[counter%m.length];
			
			if(slowTime<=0)
				speed = 2;
			if(counter%Game.size==0){
				location = board[curr._x+curr.next_x][curr._y+curr.next_y];
				poisonTime--;
				slowTime = slowTime-2;
			}
		}	
		
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
