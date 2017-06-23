

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Skeleton extends Creep{
	private final String[] path={"/skeleton/Layer 1.png","/skeleton/Layer 2.png","/skeleton/Layer 3.png"};

	public Skeleton(int x, int y, Cell cell, Cell[][] board) throws IOException {
		super(cell, board);
		this.speed=1;
		this.x=x;
		this.y=y;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		
	}

	@Override
	public void tickHAppend(int count) {
		Cell curr= location;
		counter++;
		Cell[][] board= this.board;
		if(curr._x+curr.next_x<board.length & curr._y+curr.next_y<board.length){
			x = x + location.next_x;
			y = y + location.next_y;
			if(counter%2==0)
			im=m[counter%m.length];
			if(counter%(1000/Game.delay)==0){
				location = board[curr._x+curr.next_x][curr._y+curr.next_y];
				//x=location._x*5;
				//y=location._y*5;
				
				
			}
		}
		
		
		
	}

}
