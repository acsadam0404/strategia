package objects;

import math.Vector2;

/**
 * 
 * @author Ács Ádám
 * 2012.08.06.
 */
public enum Direction {
	NORTH(new Vector2(0, -1)), 
	SOUTH(new Vector2(0, 1)),
	EAST(new Vector2(1, 0)),
	WEST(new Vector2(-1, 0)),
	NORTHEAST(new Vector2(1, -1)),
	NORTHWEST(new Vector2(-1, -1)),
	SOUTHEAST(new Vector2(1, 1)),
	SOUTHWEST(new Vector2(-1, 1)),;
	
	private Vector2 dir;
	private Direction(Vector2 dir) {
		this.dir = dir;
	}
	
	public static  Direction getDirectionByVector(Vector2 vec) {
		Direction[] dirs = Direction.values();
		for (int i = 0; i < dirs.length; i++) {
			if (dirs[i].dir.equals(vec)) {
				return dirs[i];
			}
		}
		
		return SOUTH;
	}
}
