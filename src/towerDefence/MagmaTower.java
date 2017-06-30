package towerDefence;
import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class MagmaTower extends Tower {
	
	private final String[] path={"/Tower/Magma/Layer 1.png","/Tower/Magma/Layer 2.png","/Tower/Magma/Layer 3.png","/Tower/Magma/Layer 4.png","/Tower/Magma/Layer 5.png","/Tower/Magma/Layer 6.png","/Tower/Magma/Layer 7.png"};
	public Image hitim=ImageIO.read(getClass().getResourceAsStream("/Tower/Magma/hit.png"));
	public MagmaTower(int x, int y) throws IOException {
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
		if(counter%(Game.size)==0){
			for(int i=0; i<creeps.size(); i++){
				Creep c = (Creep)creeps.get(i);
				int creepx = c.y;
				int creepy = c.x;
				int towerx = y;
				int towery = x;
				if(creepx>=towerx-hitArea*Game.size & creepx<=towerx+Game.size+Game.size*hitArea && creepy>=towery-Game.size-Game.size*hitArea & creepy<=towery+hitArea*Game.size){
					c.hit(this);
					//System.out.println("hit");
				}
			}
				
		}
				
		counter++;
		im=m[counter%m.length];		
	}
	
	@Override
	public void visit(Knight k) {
		if(k.poisonTime>0)
			k.life = (int)(k.life-10*k.poison);
		else k.life = k.life-10;
		k.im = k.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Skeleton s) {
		s.life = s.life-15;
		s.im = s.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Mike m) {
		m.life = m.life-15;
		m.im = m.hitim;
		im=hitim;
		
	}
	@Override
	public void visit(Naji n) {
		if(n.poison>0)
			n.life = (int)(n.life-15*n.poison);
		else n.life = n.life-15;
		n.im = n.hitim;
		im=hitim;
		
	}
}
