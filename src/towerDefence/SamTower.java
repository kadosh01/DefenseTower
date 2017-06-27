package towerDefence;import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

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
		this.speed = 2;
	}
	@Override
	public void tickHAppend(LinkedList<Tickable> creeps) {
		Creep c=null;
		boolean found= false;
		for(int i=0; i<creeps.size() & !found; i++){
			Creep t = (Creep)creeps.get(i);
			int creepx = t.y;
			int creepy = t.x;
			int towerx = y;
			int towery = x;
			if(creepx>=towerx-hitArea*Game.size & creepx<=towerx+Game.size+Game.size*hitArea && creepy>=towery-Game.size-Game.size*hitArea & creepy<=towery+hitArea*Game.size){
				c = t;
				found = true;
				//System.out.println(c+"  "+c.slowTime+"  "+c.speed);
			}
		}	
		if(c!=null && counter%(Game.size)==0){
			c.hit(this);
			
		}		
		counter++;
		im=m[counter%m.length];		
	}
	
	public void visit(Knight k) {
		System.out.println("knight");
		k.slowTime = 6;
		k.speed = k.speed/2;
		k.im = null;
		
	}
	@Override
	public void visit(Skeleton s) {
		s.slowTime = 3;
		s.speed = s.speed/2;
		s.im = null;		
	}
	@Override
	public void visit(Mike m) {
		m.slowTime = 3;
		m.speed = m.speed/2;
		m.life = m.life-10;
		m.im = null;		
	}
	@Override
	public void visit(Naji n) {
		n.slowTime = 3;
		n.speed = n.speed/2;
		n.im = null;
		
	}
}
