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

}
