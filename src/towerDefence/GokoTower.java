package towerDefence;import java.awt.Image;

import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class GokoTower extends Tower{
	
	private final String[] path={"/Tower/Goko/Layer 1.png","/Tower/Goko/Layer 2.png","/Tower/Goko/Layer 3.png","/Tower/Goko/Layer 4.png","/Tower/Goko/Layer 5.png","/Tower/Goko/Layer 6.png","/Tower/Goko/Layer 7.png","/Tower/Goko/Layer 8.png","/Tower/Goko/Layer 9.png"};
	
	public GokoTower(int x, int y) throws IOException {
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
	public void tickHAppend(LinkedList<Tickable> creeps) {
		
		if(counter%(1000/Game.delay)==0){
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
