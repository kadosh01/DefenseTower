package towerDefence;

import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Mike extends Creep{
	private final String[] path={"/Mike/Layer 1.png","/Mike/Layer 2.png","/Mike/Layer 3.png","/Mike/Layer 4.png","/Mike/Layer 5.png","/Mike/Layer 6.png","/Mike/Layer 7.png","/Mike/Layer 8.png","/Mike/Layer 9.png","/Mike/Layer 10.png","/Mike/Layer 11.png","/Mike/Layer 12.png","/Mike/Layer 13.png","/Mike/Layer 14.png"};
	
			
	public Mike(int x,int y, Cell cell, Cell[][] board) throws IOException{
		super(cell, board);
		this.speed=1;
		this.x=x;
		this.y=y;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		
	}

	@Override
	public void tickHAppend(LinkedList<Tickable> towers) {
		Cell curr= location;
		counter++;
		Cell[][] board= this.board;
		if(curr._x+curr.next_x<board.length & curr._y+curr.next_y<board.length){
			x = x + location.next_x;
			y = y + location.next_y;
		if(counter%(Game.size)==0){
			if(counter%2==0)
				im=m[counter%m.length];
			if(slowTime<=0)
				speed = 1;
			if(counter%(Game.size)==0){
				location = board[curr._x+curr.next_x][curr._y+curr.next_y];
				slowTime = slowTime-2;
			}
		}
		
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

}
