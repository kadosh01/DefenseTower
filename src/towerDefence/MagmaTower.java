package towerDefence;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MagmaTower extends Tower {
	private final String[] path={"/Tower/Magma/Layer 1.png","/Tower/Magma/Layer 2.png","/Tower/Magma/Layer 3.png","/Tower/Magma/Layer 4.png","/Tower/Magma/Layer 5.png","/Tower/Magma/Layer 6.png","/Tower/Magma/Layer 7.png"};
	public MagmaTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=1;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
	}
	@Override
	public void tickHAppend(Tickable t) {
		counter++;
		im=m[counter%m.length];
		
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
