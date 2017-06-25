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
		Creep c = (Creep)t;
		int creepx = c.x;
		int creepy = c.y;
		System.out.println(c+" life: "+c.life);
		if((creepx>=(x/Game.size)-hitArea*Game.size & creepx<=(x/Game.size)*Game.size+hitArea*Game.size) & (creepy>=(y/Game.size)-hitArea*Game.size & creepy<=(y/Game.size)*Game.size+hitArea*Game.size)){
			if(counter%(1000/Game.delay)==0)
				c.hit(this);
			System.out.println("hit");
		}
		counter++;
		im=m[counter%m.length];
		
	}
	@Override
	public void visit(Knight k) {
		if(k.poison>0)
			k.life = (int)(k.life-10*k.poison);
		else k.life = k.life-10;
		k.im = null;
		
	}
	@Override
	public void visit(Skeleton s) {
		s.life = s.life-15;
		s.im = null;
		
	}
	@Override
	public void visit(Mike m) {
		m.life = m.life-15;
		m.im = null;
		
	}
	@Override
	public void visit(Naji n) {
		if(n.poison>0)
			n.life = (int)(n.life-15*n.poison);
		else n.life = n.life-15;
		n.im = null;
		
	}
}
