package towerDefence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.LinkedList;

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
	
		if(creepx>=towerx-hitArea*Game.size & creepx<=towerx+Game.size+Game.size*hitArea && creepy>=towery-Game.size-Game.size*hitArea & creepy<=towery+hitArea*Game.size){
			if(counter%(Game.size)==0){
				c.hit(this);
			System.out.println("hit");
		}
		
		if(c!=null && counter%(Game.size)==0){
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
