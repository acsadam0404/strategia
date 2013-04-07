package gui;

import math.Vector2;

public enum GRadioButtonSize {
SMALL(40, 40), MEDIUM(80, 80);
	
	private Vector2 size;
	
	GRadioButtonSize(int width, int height) {
		size = new Vector2(width, height);
	}
	
	public Vector2 getSize() {
		return size;
	}

}
