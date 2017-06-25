package towerDefence;

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
		System.out.println("tower: "+x+"  "+y);
		System.out.println("creep: "+c.x+" "+c.y);
		System.out.println((creepx>=x-hitArea*Game.size & creepx<=x+hitArea*Game.size));
		System.out.println((creepy>=y-hitArea*Game.size & creepy<=y+hitArea*Game.size));
		
		if((creepx>=x-hitArea*Game.size & creepx<=x+hitArea*Game.size) | (creepy>=y-hitArea*Game.size & creepy<=y+hitArea*Game.size)){
			
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
		s.life = s.life-20;
		s.im = null;
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
