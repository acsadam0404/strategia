package objects.buildings.house;

import java.awt.Graphics;
import java.awt.Image;

import components.SelectBox;

import math.Vector2;
import objects.buildings.Building;

/**
 * 
 * @author Ács Ádám
 * 2012.08.27.
 */
public class House extends Building {
	public House(Vector2 worldPos) {
		super(worldPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector2[] getGrid() {
		return new Vector2[] { worldPos };
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

	@Override
	protected Image initImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SelectBox loadSelectionBox() {
		// TODO Auto-generated method stub
		return null;
	}

}
