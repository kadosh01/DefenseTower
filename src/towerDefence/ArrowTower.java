package towerDefence;

import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

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
		this.speed = 2;
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
		//System.out.println(c+" life: "+c.life);		
	
		if(c!=null && counter%(1000/Game.delay)==0){
			c.hit(this);
			System.out.println("hit");
		}		
		counter++;
		im=m[counter%m.length];	
	}

	@Override
	public void visit(Knight k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Skeleton s) {
		s.life = s.life-15;
		s.im = null;
		
	}

	@Override
	public void visit(Mike m) {
		m.life = m.life-30;
		m.im = null;
	}

	@Override
	public void visit(Naji n) {
		n.life = (int)(n.life-(30*n.poison));
		n.im = null;
		
	}

}
