package towerDefence;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;


public class Board {
	public Cell[][] board;
	private LinkedList<Cell> creepsRoad;
	private LinkedList<Tower> towers;
	private Cell start;
	private int size = 25;
	private int wave;
	private final int creepsize=Creep.size;
	public int life=20;
	
	public Board(Cell[][] board,int size) {
		this.board=board;
		this.size = size;
		towers=new LinkedList<>();
		for(int i=0;i<board.length;i++)
			if(board[i][0].isRoad())
				start = board[i][0];
			
	}
	
	public LinkedList<Tickable> wave(int num) throws IOException{
		LinkedList<Tickable> creeps = new LinkedList<Tickable>();
		int amount;
		switch(num){
		case 1:
			amount = 1;
			break;
		case 2:
			amount = 2;
			break;
		case 3:
			amount = 4;
			break;
		case 4:
			amount = 8;
			break;
		case 5:
			amount = 16;
			break;
		default:
			amount = 0;
				
		}
		for(int i=0; i<amount; i++){
			int numOfCreeps = creeps.size();
			int startx=(start._x*size)-(creepsize-(size));
			int index = ThreadLocalRandom.current().nextInt(0, numOfCreeps+1);
			creeps.add(index, new Knight(startx, (start._y*size), start, board));
			index = ThreadLocalRandom.current().nextInt(0, numOfCreeps+1);
			creeps.add(index, new Skeleton(startx, (start._y*size), start, board));
			index = ThreadLocalRandom.current().nextInt(0, numOfCreeps+1);
			creeps.add(index, new Mike(startx, (start._y*size), start, board));
			index = ThreadLocalRandom.current().nextInt(0, numOfCreeps+1);
			creeps.add(index, new Naji(startx, (start._y*size), start, board));
			
		}
		return creeps;
		
	}
	
}

