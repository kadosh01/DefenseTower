

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tower implements Tickable{
	public int x;
	public int y;
	public Cell location;
	public double speed;
	protected Cell[][] board;
	public static final int size=35;
	public static final int Hsize=75;
	public Image[] m;
	public Image im;
	public int counter;
	
	
	public Tower(int x,int y) throws IOException{
		this.x=x;
		this.y=y;
		System.out.println("tower x: "+x+" y: "+y);
		counter=0;
		
	}

	@Override
	public void tickHAppend(int count) {
		counter++;
		im=m[counter%m.length];
		
	}

}
