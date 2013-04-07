package gui;

import math.Vector2;

/**
 * 
 * @author Ács Ádám
 * 2012.08.09.
 */
public enum GButtonSize {
	SMALL(80, 40), MEDIUM(200, 40), SMALL_SQUARE(40, 40);
	
	private Vector2 size;
	
	GButtonSize(int width, int height) {
		size = new Vector2(width, height);
	}
	
	public Vector2 getSize() {
		return size;
	}
}
