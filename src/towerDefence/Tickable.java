package towerDefence;

import java.awt.Graphics;
import java.util.LinkedList;

public interface Tickable {
	
	public void tickHAppend(LinkedList<Tickable> creeps);

}
