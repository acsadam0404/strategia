package objects.tiles;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import objects.Sprite;

/**
 * Ez fog tile-okat csinálni egy szám alapján, amikkel a Map-et reprezentáljuk.
 * @author Ács Ádám
 * 2012.07.15.
 */
public final class TileFactory {
	private static final Map<Integer, Image> TILES = new HashMap<>();
	private static final Map<Integer, Image> TERRAINS = new HashMap<>();
	
	static { //TODO ehelyette egy txt-ben lehetne párosítani a tile-t a számával
		TILES.put(Integer.valueOf(0), null);
		TILES.put(Integer.valueOf(1), new ImageIcon("images\\fa_01.png").getImage());
		TILES.put(Integer.valueOf(2), new ImageIcon("images\\fa_02.png").getImage());
		
		TERRAINS.put(Integer.valueOf(0), new ImageIcon("images\\fu_01.png").getImage());
		TERRAINS.put(Integer.valueOf(1), new ImageIcon("images\\fu_02.png").getImage());
		TERRAINS.put(Integer.valueOf(2), new ImageIcon("images\\sivatag_01.png").getImage());
		TERRAINS.put(Integer.valueOf(3), new ImageIcon("images\\sivatag_02.png").getImage());
	}
	
	private TileFactory() {
		/* private constructor */
	}
	
	public static Tile getTile(int tileNumber, int posX, int posY) throws ENoSuchTileException {
		Integer key = Integer.valueOf(tileNumber);
		
		if (!TILES.containsKey(key)) {
			throw new ENoSuchTileException();
		}
		
		return new Tile(TILES.get(key), posX, posY);
	}
	
	public static Terrain getTerrain(int terrainNumber, int posX, int posY) throws ENoSuchTileException {
		Integer key = Integer.valueOf(terrainNumber);
		
		if (!TERRAINS.containsKey(key)) {
			throw new ENoSuchTileException();
		}
		
		return new Terrain(TERRAINS.get(key), posX, posY);
	}
}
