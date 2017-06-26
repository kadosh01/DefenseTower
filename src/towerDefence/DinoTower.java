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
		this.hitArea=2;
		m=new Image[path.length];
		for(int i=0;i<m.length;i++){
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		}
		im=m[0];
		this.Hsize=50;
		this.size=25;
		this.speed=1;
		
	}
	@Override
	public void tickHAppend(LinkedList<Tickable> creeps) {
		
	
		if(counter==0){
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
	    
	    if(counter%(Game.size)==0){
			for(int i=0; i<creeps.size(); i++){
				Creep c = (Creep)creeps.get(i);
				int creepx = c.y;
				int creepy = c.x;
				int towerx = y;
				int towery = x;
				if(creepx>=towerx-hitArea*Game.size & creepx<=towerx+Game.size+Game.size*hitArea && creepy>=towery-Game.size-Game.size*hitArea & creepy<=towery+hitArea*Game.size){
					c.hit(this);
					System.out.println("hit");
				}
			}
	  }
	    counter++;
	}

		
	
	@Override
	public void visit(Knight k) {
		if(k.poisonTime>0)
			k.life = (int)(k.life-10*k.poison);
		else k.life = k.life-8;
		k.im = null;
		
	}
	@Override
	public void visit(Skeleton s) {
		s.life = s.life-15;
		s.im = null;
		
	}
	@Override
	public void visit(Mike m) {
		m.life = m.life-10;
		m.im = null;
		
	}
	@Override
	public void visit(Naji n) {
		if(n.poison>0)
			n.life = (int)(n.life-11*n.poison);
		else n.life = n.life-11;
		n.im = null;
		
	}
}
