package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.swing.AbstractAction;


import objects.tiles.ENoSuchTileException;
import objects.units.Unit;

import map.MapData;
import map.TileMap;
import math.Vector2;

import worldmap.WorldMap;

import game.core.Game1;
import gui.GButton;
import gui.GButtonSize;
import input.MouseButtonState;
import input.MouseState;

/**
 * 
 * @author Ács Ádám
 * 2012.08.21.
 */
public class WorldMapState extends AbstractGameState {
	private WorldMap wm = new WorldMap();
	private GButton goButton;
	Color currentColor;

	private Unit unit;
	private List<Unit> unitList = new ArrayList<>();

	/**
	 * ez tartalmazza a mapokat, így a szín alapján tudjuk, hogy melyiket kell
	 * létrehozni
	 */
	Map<Color, String> maps = new HashMap<>();

	private void setImagesByColorsMap() {
		maps.put(new Color(186, 242, 211), "1.txt");
		maps.put(new Color(148, 0, 0), "2.txt");
		maps.put(new Color(30, 52, 17), "");
		maps.put(new Color(137, 0, 243), "");
		maps.put(new Color(200, 243, 0), "");
		maps.put(new Color(243, 86, 0), "");
		maps.put(new Color(243, 0, 154), "");
		maps.put(new Color(204, 98, 148), "");
		maps.put(new Color(49, 209, 173), "");
		maps.put(new Color(147, 209, 49), "");

	}

	public WorldMapState(Game1 game) {
		super(game);
		setImagesByColorsMap();
	}

	@Override
	public void init() {
		Game1.registerMouseObserver(this);
		goButton = new GButton("go-go-go", new Vector2(50, 100),
		GButtonSize.SMALL, makeMapAction);

	}

	@Override
	public void draw(Graphics g) {
		wm.draw(g);
		goButton.draw(g);

	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();

	}

	@Override
	public void updateMouse(MouseState mouseState) {
		if (mouseState.getLeftButtonState().equals(MouseButtonState.PRESSED)) {
			Color color = wm.getColorOnPos(mouseState.getPos());
			wm.setCurrentColor(color);
			currentColor = color;
		}

	}

	@Override
	public void checkMouseInput() {

	}

	@Override
	public void onSet() {
		game.add(goButton);
	}

	private AbstractAction makeMapAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (currentColor != null) {
				String mapName = maps.get(currentColor);
				if (mapName != null && !mapName.isEmpty()) {
					try {
						MapData mapData = new MapData("maps\\test\\" + mapName);
						TileMap.setData(mapData);
						game.setState(game.getPlayingState());
					} catch (ENoSuchTileException e) {
						e.printStackTrace();
					}
				}
			}
		}
	};
}
