package towerDefence;import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
public class DinoTower extends Tower{
	private final String[] path={"/Tower/Dino/Layer 1.png","/Tower/Dino/Layer 2.png","/Tower/Dino/Layer 3.png","/Tower/Dino/Layer 4.png","/Tower/Dino/Layer 5.png","/Tower/Dino/Layer 6.png","/Tower/Dino/Layer 7.png"};
	public DinoTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=1;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
	}
	@Override
	public void tickHAppend(int count) {
		// TODO Auto-generated method stub
		
	}
	
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
