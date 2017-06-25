package towerDefence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class LevelLoader {
	
    private static final char CHAR_FLOOR             = '0';
    private static final char RIGHT                  = 'R';
    private static final char LEFT                   = 'L';
    private static final char DOWN                   = 'D';
    private static final char UP                     = 'U';

    /** contains the initial board state of all the levels  */
    private Vector<Cell[][]> _levels;
    
    public LevelLoader() {
    	_levels = new Vector<>();
	}

    /**
     * Loads all the levels to the internal levels buffer
     * @param levelsFile the name of the file contains the levels
     * @return true if success
     * @throws IOException if there is any error with the file
     */
    public boolean load(String levelsFile) throws IOException {
    	_levels.clear();

    	BufferedReader br = new BufferedReader(new FileReader(levelsFile));
    	String line = null;
    	Cell level[][] = null;
    	int w=0;
    	int h=0;
    	int row = 0;
    	while ((line = br.readLine()) != null) {

    		// end of level
    		if (line.trim().isEmpty()) {
    			if (null != level){
    				_levels.add(level);
    				level = null;
    			}
    			continue;
    		}
    		
    		// board size
    		if (line.trim().startsWith("w")){
    			w = Integer.valueOf(line.trim().substring(1));
    			continue;
    		}    		
    		if (line.trim().startsWith("h")){
    			h = Integer.valueOf(line.trim().substring(1));
    			continue;
    		}
    		

    		// comment
    		if (line.startsWith(";")) {
    			continue;
    		}

    		// start of level definition
    		if (null == level && h>0 && w>0){
    			level = new Cell[h][w];
    			row = 0;
    		}

    		// regular board line
    		for (int col=0 ; col< line.length(); col++){
    			Cell cell = parseCell(row, col, line.charAt(col));
    			if (null != cell){
    				level[row][col] = cell;
    			} else {
    				br.close();
    				return false;
    			}
    		}
    		row++;
    	}
		if (null != level){
			_levels.add(level);
			level = null;
		}
    	br.close();
    	return true;
    }
    
    /**
     * @return the number of levels available
     */
    public int getLevelsCount() {
		return _levels.size();
	}
    
    /**
     * @param index - the level number
     * @return the initial state of level number {@code index}
     *  
     * TODO - is recommended to create a deep copy of the array.
     */
    public Cell[][] get(int index) {
    	return _levels.get(index);
    }

    /**
     * create {@code Cell} instance from {@code char} representation
     * 
     * @return the {@code Cell} object 
     */
    private Cell parseCell(int col, int row, char cell) {
		switch (cell) {
		case CHAR_FLOOR:
			return new Cell(col, row);
		case RIGHT:
			return new Cell(col, row, 0, 1);
		case LEFT:
			return new Cell(col, row, 0, -1);
		case DOWN:
			return new Cell(col, row, 1, 0);
		case UP:
			return new Cell(col, row, -1, 0);
		default:
			return null;
		}
	}
    
}
