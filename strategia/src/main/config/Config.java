package config;

import java.awt.DisplayMode;
import java.io.IOException;

/**
 * itt van minden kívülrõl jövõ config nyilvántartva TODO fájlból beolvasni
 * @author Ács Ádám
 * 2012.07.18.
 */
public final class Config {
	/* resolution */

	public static int SCREEN_WIDTH = 1366;
	public static int SCREEN_HEIGHT = 768;

	/* az alap egység a tilemaphoz */
	public static int TILE_WIDTH = 40;
	public static int TILE_HEIGHT = 40;
	
	/* a játéktér amit a kamera lát */

	public static int PLAYAREA_WIDTH = 1366; 
	public static int PLAYAREA_HEIGHT = 570;

	
	public static int COLOR_DEPTH = 32;
	
	public static final DisplayMode[] DISPLAY_MODES = {
		new DisplayMode(1366, 768, 32, 0),
		new DisplayMode(1366, 768, 24, 0),
		new DisplayMode(1366, 768, 16, 0),
		new DisplayMode(800, 600, 32, 0),
		new DisplayMode(800, 600, 24, 0),
		new DisplayMode(800, 600, 16, 0),
	};
	
	private Config() {
		/* private constructor */
	}

	/**
	 * fájlból beolvassa a konfigurációt, ezzel az adatok a memóriába kerülnek
	 * @param fileName
	 */
	public static void loadConfig(String fileName) throws IOException {
		/* TODO még nincs megírva, de már megvan hívva a Program osztályban*/
	}
}
