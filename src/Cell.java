

public class Cell {

	public int _x , _y;
	public int next_x;
	public int next_y;
	private Boolean isRoad;
	public Boolean isTower;
	

	/**
	 * construct a floor cell
	 */
	public Cell(int x,int y) {
		_x = x;
		_y = y;
		next_x = 0;
		next_y = 0;
		isRoad = false;
	}
	
	/**
	 * construct a road cell
	 */
	public Cell(int x,int y, int nextx, int nexty) {
		_x = x;
		_y = y;
		next_x = nextx;
		next_y = nexty;
		isRoad= true;
		isTower=false;
	}

	public boolean isRoad(){
		return isRoad;
	}
	
	@Override
	public Cell clone() {
		Cell c = new Cell(_x, _y);
		c.next_x = next_x;
		c.next_y = next_y;
		c.isRoad = isRoad;
		return c;
	}
	
}
