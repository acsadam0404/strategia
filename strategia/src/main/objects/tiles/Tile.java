package objects.tiles;

import java.awt.*;

import objects.Sprite;

import math.Vector2;

import camera.Camera;


/**
 * 
 * @author �cs �d�m
 * 2012.07.22.
 */
public class Tile extends Sprite {
	Image image = null; 
	boolean collidable = true;
	
	Tile(Image image, int posX, int posY) {
		this.image = image;
		worldPos = new Vector2(posX, posY);
		
		if (image == null) {
			collidable = false;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		if (Camera.isObjectVisible(getWorldRect())) {
			g.drawImage(image, getScreenPos().getX(), getScreenPos().getY(), null);
		}
	}
	
	/**
	 * meglehet n�zni, hogy �res-e, azaz �tj�rhat�-e
	 * @return
	 */
	public boolean isCollidable() {
		return collidable;
	}
	
	@Override
	public String toString() {
		return getWorldPos().toString();
	}
}
