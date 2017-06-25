package towerDefence;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArrowTower extends Tower{
	private final String[] path={"/Tower/Arrow/Layer 1.gif","/Tower/Arrow/Layer 2.gif","/Tower/Arrow/Layer 3.gif","/Tower/Arrow/Layer 4.gif","/Tower/Arrow/Layer 5.gif","/Tower/Arrow/Layer 6.gif","/Tower/Arrow/Layer 7.gif","/Tower/Arrow/Layer 8.gif","/Tower/Arrow/Layer 9.gif","/Tower/Arrow/Layer 10.gif","/Tower/Arrow/Layer 11.gif","/Tower/Arrow/Layer 12.gif"};
	
	public ArrowTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=1;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
		this.Hsize=50;
		this.size=25;
	}

	@Override
	public void tickHAppend(Tickable t) {
		// TODO Auto-generated method stub
		
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
