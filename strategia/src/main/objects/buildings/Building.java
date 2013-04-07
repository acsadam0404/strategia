package objects.buildings;

import java.awt.Graphics;
import java.awt.Image;

import math.Vector2;

import objects.GameObject;
import objects.IGameLoop;

/**
 * XXX dummy 
 * @author Ács Ádám
 * 2012.08.26.
 */
public abstract class Building extends GameObject {
	protected Image image;
	public Building(Vector2 worldPos) {
		this.worldPos = worldPos;
	}
	
	@Override
	public void init() {
		initImage();
	}

	@Override
	public void update(long gameTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image, worldPos.getX(), worldPos.getY(), null);
	}

	public boolean isDead() {
		return false;
	}

	public abstract Vector2[] getGrid();

	protected abstract Image initImage();
}
