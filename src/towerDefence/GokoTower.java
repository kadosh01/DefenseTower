package towerDefence;import java.awt.Image;

import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class GokoTower extends Tower{
	
	private final String[] path={"/Tower/Goko/Layer 1.png","/Tower/Goko/Layer 2.png","/Tower/Goko/Layer 3.png","/Tower/Goko/Layer 4.png","/Tower/Goko/Layer 5.png","/Tower/Goko/Layer 6.png","/Tower/Goko/Layer 7.png","/Tower/Goko/Layer 8.png","/Tower/Goko/Layer 9.png"};
	
	public GokoTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=2;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
		this.Hsize=50;
		this.size=25;
		this.speed =1;
	}
	@Override
	public void tickHAppend(LinkedList<Tickable> creeps) {		
		Creep c=null;
		for(int i=0; i<creeps.size(); i++){
			Creep t = (Creep)creeps.get(i);
			int creepx = t.y;
			int creepy = t.x;
			int towerx = y;
			int towery = x;
			if(creepx>=towerx-hitArea*Game.size & creepx<=towerx+Game.size+Game.size*hitArea && creepy>=towery-Game.size-Game.size*hitArea & creepy<=towery+hitArea*Game.size){
				c = t;
			}
		}
		
		if(c!=null && counter%(Game.size)==0){
			c.hit(this);
			System.out.println("hit");
		}		
		counter++;
		im=m[counter%m.length];		
			
	}
	
	public void visit(Knight k) {
		k.im = null;
		k.K = 7;
		k.gokuHit++;
		if(k.gokuHit>=10)
			k.H = k.H*2;
		k.life = k.life-(k.H*k.K);		
	}
	@Override
	public void visit(Skeleton s) {
		s.im = null;
		s.K = 10;
		s.gokuHit++;
		if(s.gokuHit>=10)
			s.H = s.H*2;
		s.life = s.life-(s.H*s.K);
		
	}
	@Override
	public void visit(Mike m) {
		m.im = null;
		m.K = 5;
		m.gokuHit++;
		if(m.gokuHit>=10)
			m.H = m.H*2;
		m.life = m.life-(m.H*m.K);
		
	}
	@Override
	public void visit(Naji n) {
		n.im = null;
		n.K = 5;
		n.gokuHit++;
		if(n.gokuHit>=10)
			n.H = n.H*2;
		n.life = n.life-(n.H*n.K);		
	}
}
