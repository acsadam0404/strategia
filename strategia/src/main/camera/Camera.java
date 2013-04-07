package camera;

import java.awt.Rectangle;

import map.TileMap;
import math.MathHelper;
import math.Vector2;

import config.Config;

/**
 * @author Ács Ádám
 * 2012.07.22.
 */
public class Camera {
	private static Vector2 position = Vector2.ZERO;
	private static Vector2 viewPortSize = new Vector2(Config.PLAYAREA_WIDTH, Config.PLAYAREA_HEIGHT);
	private static Rectangle worldRectangle = new Rectangle();
	//private static Vector2 cameraOffset = new Vector2(0, 24); //kamera távolsága 0,0 tól
	private static Vector2 cameraOffset = new Vector2(0, 0); //kamera távolsága 0,0 tól

	public static void setPosition(Vector2 pos) {
		position = new Vector2(
				MathHelper.clamp(pos.getX(), worldRectangle.x, worldRectangle.width - getViewPortWidth()),
				MathHelper.clamp(pos.getY(), worldRectangle.y, worldRectangle.height - getViewPortHeight()));
	}

	public static Vector2 getPosition() {
		return position;
	}

	public static Rectangle getWorldRectangle() {
		return worldRectangle;
	}

	public static void setWorldRectangle(Rectangle rect) {
		worldRectangle = rect;
	}

	public static int getViewPortWidth() {
		return viewPortSize.getX();
	}

	public static int getViewPortHeight() {
		return viewPortSize.getY();
	}

	public static Rectangle getViewPort() {
		return new Rectangle(position.getX(), position.getY(), getViewPortWidth(), getViewPortHeight());
	}

	public static void move(Vector2 offset) {
		/* a képernyõ szélein ne menjen túl */ /* FIXME ez nem ugyanaz mint a setPosition ellenõrzése? */
		if (position.getX() >= cameraOffset.getX() || position.getY() >= cameraOffset.getY() || 
				position.getX() <= TileMap.getWidth() * Config.TILE_WIDTH|| position.getY() <= TileMap.getHeight() * Config.TILE_HEIGHT) {
			setPosition(position.add(offset));
		}
	}

	public static boolean isObjectVisible(Rectangle bounds) {
		return getViewPort().intersects(bounds);

	}

	public static Vector2 worldToScreen(Vector2 point) {
		return point.subtract(position).add(cameraOffset);
	}

	public static Rectangle worldToScreen(Rectangle rectangle) {
		return new Rectangle(rectangle.x - position.getX() + cameraOffset.getX(), rectangle.y - position.getY() + cameraOffset.getY(), rectangle.width, rectangle.height);
	}

	public static Vector2 screenToWorld(Vector2 point) {
		return point.add(position).subtract(cameraOffset);
	}

	public static Rectangle screenToWorld(Rectangle rectangle) {
		return new Rectangle(rectangle.x + position.getX() - cameraOffset.getX(), rectangle.y - position.getY() + cameraOffset.getY(), rectangle.width, rectangle.height);
	}
}
