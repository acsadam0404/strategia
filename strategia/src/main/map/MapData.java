package map;

import java.io.File;
import java.io.IOException;
import java.util.*;

import math.Vector2;

import objects.buildings.Building;
import objects.tiles.*;
import config.Config;

/**
 * beolvas egy tilemapot egy adott txt fájlból, hogy aztán átadhassuk a map konstruktorának
 * @version 2012.07.18
 * @author Peter Varga
 */
public class MapData {
	private Tile[][] tileMap;
	private Terrain[][] terrainMap;
	private Map<Vector2, Building> buildings = new HashMap<>();
	
	private int mapWidth;
	private int mapHeight;

	public MapData(String fileName) throws ENoSuchTileException {
		readFromFile(fileName);
	}

	private void readFromFile(String fileName) throws ENoSuchTileException {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));

			mapWidth = sc.nextInt();
			mapHeight = sc.nextInt();
			
			tileMap = new Tile[mapWidth][mapHeight];
			terrainMap = new Terrain[mapWidth][mapHeight];
			
			/* elsõ layer */
			for (int j = 0; j < mapHeight; j++) {
			for (int i = 0; i < mapWidth && sc.hasNextInt(); i++) {

					int tileNum = sc.nextInt();
					terrainMap[i][j] = TileFactory.getTerrain(tileNum, i * Config.TILE_WIDTH, j * Config.TILE_HEIGHT);

				}
			}
		
			/* masodik layer */
			for (int j = 0; j < mapHeight; j++) {
			for (int i = 0; i < mapWidth && sc.hasNextInt(); i++) {

					int tileNum = sc.nextInt();
					tileMap[i][j] = TileFactory.getTile(tileNum, i * Config.TILE_WIDTH, j * Config.TILE_HEIGHT);
					
				}
			}
			
			
		} catch (IOException ioEx) {
			throw new ENoSuchTileException();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	void add(Building building) {
		for (int i = 0; i < building.getGrid().length; i++) {
			buildings.put(building.getGrid()[i], building);
		}
	}
	
	Tile getTile(int i, int j) {
		return tileMap[i][j];
	}
	
	Terrain getTerrain(int i, int j) {
		return terrainMap[i][j];
	}

	int getMapHeight() {
		return mapHeight;
	}
	
	int getMapWidth() {
		return mapWidth;
	}
}
