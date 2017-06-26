package towerDefence;import java.awt.Image;

import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class DinoTower extends Tower{
	
	private final String[] path={"/Tower/Dino/Layer 1.png","/Tower/Dino/Layer 2.png","/Tower/Dino/Layer 3.png","/Tower/Dino/Layer 4.png","/Tower/Dino/Layer 5.png"};
	int originy;
	int originx;
    double angle =0;
	public DinoTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=1;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++){
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		}
		im=m[0];
		this.Hsize=50;
		this.size=25;
		
	}
	@Override
	public void tickHAppend(Tickable t) {
		counter++;
		if(counter==1){
			originx=x;
			originy=y;
		}
		System.out.println(counter);
		im=m[counter%m.length];	
	    angle += 1.0;
	    if(angle==360)
	    	angle=0;
	    double rad=Math.toRadians(angle);
	    y =  (int) (originy + Math.sin(rad)*50);
	    x = (int) (originx + Math.cos(rad)*50);
	  }

		
	
	@Override
	public void visit(Knight k) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Skeleton s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Mike m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Naji n) {
		// TODO Auto-generated method stub
		
	}
	
}
