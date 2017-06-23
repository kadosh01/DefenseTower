

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mike extends Creep{
	//private final String[] path;
			
	public Mike(int x,int y, Cell cell, Cell[][] board) throws IOException{
		super(cell, board);
		this.speed=1;
		this.x=x;
		this.y=y;
		this.m=new Image[2];
		
	}

	@Override
	public void tickHAppend(int count) {
		// TODO Auto-generated method stub
		
	}

}
