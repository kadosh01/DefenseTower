package towerDefence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PosionTower extends Tower{
	private final String[] path={"/Tower/Posion/Layer 1.png","/Tower/Posion/Layer 2.png","/Tower/Posion/Layer 3.png","/Tower/Posion/Layer 4.png","/Tower/Posion/Layer 5.png","/Tower/Posion/Layer 6.png","/Tower/Posion/Layer 7.png","/Tower/Posion/Layer 8.png","/Tower/Posion/Layer 9.png"};
	
	
	public PosionTower(int x, int y) throws IOException {
		super(x, y);
		m=new Image[path.length];
		hitArea=2;
		for(int i=0;i<m.length;i++)
			m[i]=ImageIO.read(getClass().getResourceAsStream(path[i]));
		im=m[0];
	}
	
	@Override
	public void tickHAppend(Tickable t) {
		Creep c = (Creep)t;
		int creepx = c.x;
		int creepy = c.y;
		//System.out.println(c+" life: "+c.life);
		System.out.println("tower: "+x+"  "+y);
		System.out.println(c+"  "+creepx+"  "+creepy);
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
		k.poison = 2;
		k.poisonTime = 5;
		k.im = null;
	}

	@Override
	public void visit(Skeleton s) {
		s.life = s.life-20;
		s.im = null;
		
	}

	@Override
	public void visit(Mike m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Naji n) {
		n.poison = 1.5;
		n.poisonTime = 5;	
		n.im = null;
	}

	
}
