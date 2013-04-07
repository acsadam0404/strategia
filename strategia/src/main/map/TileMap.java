package map;

import java.awt.Graphics;
import java.awt.Rectangle;

import camera.Camera;

import config.Config;

import math.Vector2;

import objects.buildings.Building;
import objects.tiles.Tile;

/**
 * 
 * @author Ács Ádám
 * @version 2012.07.22.
 */
public class TileMap {
	private static MapData data;
	
	public static void setData(MapData mapData) {
		data = mapData;
		Camera.setWorldRectangle(new Rectangle(0, 0, TileMap.getWidth() * Config.TILE_WIDTH, TileMap.getHeight() * Config.TILE_HEIGHT));
	}

	/**
	 * static draw
	 * @param g
	 */
	public static void draw(Graphics g) {

		for (int j = 0; j < data.getMapWidth(); j++) {
			for (int i = 0; i < data.getMapHeight(); i++) {
				data.getTerrain(j, i).draw(g);
			}
		}
		
		for (int j = 0; j < data.getMapWidth(); j++) {
			for (int i = 0; i < data.getMapHeight(); i++) {
				data.getTile(j, i).draw(g);
			}
		}
	}
	
	/* FIXME innen lefelé nem tesztelt */
	public static Tile getTile(int i, int j) {
		return data.getTile(i, j);
	}
	
	public static Vector2 getSquareAtPixel(Vector2 pixelPos) {
		return new Vector2(pixelPos.getX() / Config.TILE_WIDTH, pixelPos.getY() / Config.TILE_HEIGHT);
	}
	
	public static Tile getTileAtPixel(Vector2 pixelPos) {
		Vector2 square = getSquareAtPixel(pixelPos);
		return getTile(square.getX(), square.getY());
	}
	
	public static int getWidth() {
		return data.getMapWidth();
	}
	
	public static int getHeight() {
		return data.getMapHeight();
	}
	
	public static boolean isCollidable(Vector2 pos) {
		return getTile(pos.getX(), pos.getY()).isCollidable();
	}
	
	public static boolean isCollidableByPixel(Vector2 pixelPos) {
		Vector2 pos = getSquareAtPixel(pixelPos);
		return isCollidable(pos);
	}

	public static Vector2 asPixelPos(Vector2 square) {
		return new Vector2(square.getX() * Config.TILE_WIDTH, square.getY() * Config.TILE_HEIGHT);
	}
	
	public static void add(Building building) {
//		data.add(building);
	}

}
