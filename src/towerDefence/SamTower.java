package towerDefence;import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
public class SamTower extends Tower{
	private final String[] path={"/Tower/Sam/Layer 1.png","/Tower/Sam/Layer 2.png","/Tower/Sam/Layer 3.png","/Tower/Sam/Layer 4.png","/Tower/Sam/Layer 5.png","/Tower/Sam/Layer 6.png","/Tower/Sam/Layer 7.png","/Tower/Sam/Layer 8.png","/Tower/Sam/Layer 9.png"};
	public SamTower(int x, int y) throws IOException {
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
		counter++;
		im=m[counter%m.length];		
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
