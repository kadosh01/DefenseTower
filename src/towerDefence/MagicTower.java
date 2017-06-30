package towerDefence;import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class MagicTower extends Tower{
	
	private final String[] path={"/Tower/Magic/Layer 1.png","/Tower/Magic/Layer 2.png","/Tower/Magic/Layer 3.png","/Tower/Magic/Layer 4.png","/Tower/Magic/Layer 5.png","/Tower/Magic/Layer 6.png","/Tower/Magic/Layer 7.png","/Tower/Magic/Layer 8.png","/Tower/Magic/Layer 9.png","/Tower/Magic/Layer 10.png","/Tower/Magic/Layer 11.png"};
	public Image hitim=ImageIO.read(getClass().getResourceAsStream("/Tower/Magic/hit.png"));
	public MagicTower(int x, int y) throws IOException {
		super(x, y);
		this.hitArea=1;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
		this.Hsize=50;
		this.size=25;
		this.speed = 1;
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
			//System.out.println(c.life);
			//System.out.println("hit");
		}		
		counter++;
		im=m[counter%m.length];
	}
	
	public void visit(Knight k) {
		if(k.poisonTime>0)
			k.life = (int)(k.life-30*k.poison);
		else k.life = k.life-30;
		k.im = k.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Skeleton s) {
		s.life = s.life-25;
		s.im = s.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Mike m) {
		m.life = m.life-10;
		m.im = m.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Naji n) {
		if(n.poisonTime>0)
			n.life = (int)(n.life-10*n.poison);
		else n.life = n.life-10;
		n.im = n.hitim;
		im=hitim;	
	}
}
