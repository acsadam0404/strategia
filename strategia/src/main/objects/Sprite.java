package objects;

import java.awt.Rectangle;

import config.Config;

import math.Vector2;

import camera.Camera;

/**
 * 
 * @author Ács Ádám
 * 2012.07.22.
 */
public abstract class Sprite implements IDrawable {
	protected Vector2 worldPos;
	protected Vector2 size = new Vector2(Config.TILE_WIDTH, Config.TILE_HEIGHT);
	protected Vector2 screenPos;

	public Rectangle getBoundingRect() {
		return new Rectangle(worldPos.getX(), worldPos.getY(), size.getX(), size.getY());
	}
	
	public Vector2 getScreenPos() {
		return Camera.worldToScreen(worldPos);
	}
	
	public Vector2 getWorldPos() {
		return worldPos;
	}
	
	public Rectangle getWorldRect() {
		return new Rectangle(worldPos.getX(), worldPos.getY(), size.getX(), size.getY());
	}
}
