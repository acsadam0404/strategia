package config;

import java.awt.DisplayMode;
import java.io.IOException;

/**
 * itt van minden k�v�lr�l j�v� config nyilv�ntartva TODO f�jlb�l beolvasni
 * @author �cs �d�m
 * 2012.07.18.
 */
public final class Config {
	/* resolution */

	public static int SCREEN_WIDTH = 1366;
	public static int SCREEN_HEIGHT = 768;

	/* az alap egys�g a tilemaphoz */
	public static int TILE_WIDTH = 40;
	public static int TILE_HEIGHT = 40;
	
	/* a j�t�kt�r amit a kamera l�t */

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
	 * f�jlb�l beolvassa a konfigur�ci�t, ezzel az adatok a mem�ri�ba ker�lnek
	 * @param fileName
	 */
	public static void loadConfig(String fileName) throws IOException {
		/* TODO m�g nincs meg�rva, de m�r megvan h�vva a Program oszt�lyban*/
	}
}
