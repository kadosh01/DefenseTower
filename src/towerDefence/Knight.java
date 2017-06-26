package towerDefence;

import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Knight extends Creep{
	
	private final String[] path={"/Knight/Layer 1.png","/Knight/Layer 2.png","/Knight/Layer 3.png","/Knight/Layer 4.png","/Knight/Layer 5.png","/Knight/Layer 6.png","/Knight/Layer 7.png","/Knight/Layer 8.png"};
	protected double poison;
	protected double poisonTime;
	private int j=0;
	
	public Knight(int x,int y, Cell cell, Cell[][] board) throws IOException{
		super(cell, board);
		this.speed=1;
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
		j++;
		counter+=1;
		Cell[][] board= this.board;
		
		if(curr._x+curr.next_x<board.length & curr._y+curr.next_y<board.length){
			x = (int)(x + location.next_x*speed);
			y = (int)(y + location.next_y*speed);
			im=m[counter%m.length];
			if(counter%(Game.size)==0){
				location = board[curr._x+curr.next_x][curr._y+curr.next_y];
				poisonTime--;
				slowTime= slowTime-2;
			}
		}		
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

}
