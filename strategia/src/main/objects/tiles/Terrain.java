package objects.tiles;

import java.awt.*;

import objects.Sprite;

import math.Vector2;

import camera.Camera;


/**
 * 
 * @author Ács Ádám
 * 2012.07.23.
 */
public class Terrain extends Sprite {
	Image image = null; 
	
	Terrain(Image image, int posX, int posY) {
		this.image = image;
		worldPos = new Vector2(posX, posY);
	}
	
	@Override
	public void draw(Graphics g) {		
		if (Camera.isObjectVisible(getWorldRect())) {
			g.drawImage(image, getScreenPos().getX(), getScreenPos().getY(), null);
		}
	}

	@Override
	public String toString() {
		return getWorldPos().toString();
	}
}
