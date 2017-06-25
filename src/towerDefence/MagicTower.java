package towerDefence;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
public class MagicTower extends Tower{
	private final String[] path={"/Tower/Magic/Layer 1.png","/Tower/Magic/Layer 2.png","/Tower/Magic/Layer 3.png","/Tower/Magic/Layer 4.png","/Tower/Magic/Layer 5.png","/Tower/Magic/Layer 6.png","/Tower/Magic/Layer 7.png","/Tower/Magic/Layer 8.png","/Tower/Magic/Layer 9.png","/Tower/Magic/Layer 10.png","/Tower/Magic/Layer 11.png"};
	public MagicTower(int x, int y) throws IOException {
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
