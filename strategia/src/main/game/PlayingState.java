package game;

import game.core.Game1;
import game.core.MapLoader;
import gui.Background;
import gui.GPanel;
import input.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import map.MapData;
import map.TileMap;
import math.Vector2;
import player.managers.PlayerManager;
import camera.Camera;
import config.Config;

/**
 * 
 * @author Ács Ádám
 * 2012.07.22.
 */
public class PlayingState extends AbstractGameState {
	private Background background;
	private MouseState mouseState;
	private Vector2 mousePos;
	private MapData testMapData;
	private TileMap tileMap;
	private GPanel bottomPalette;
	private GPanel topPalette;
	private PlayerManager playerManager = new PlayerManager();
	private MapLoader mapLoader;

	public PlayingState(Game1 game) {
		super(game);
		mapLoader = new MapLoader(this);
	}
	
	@Override
	public void init() {
		Game1.registerMouseObserver(this);
		
		background = new Background("images\\test\\backgro.png");
		bottomPalette = new GPanel("images\\palettes\\pal.png", 0, 572, Config.PLAYAREA_WIDTH, 210);
		topPalette = new GPanel("images\\palettes\\top.png", 0, 0, Config.PLAYAREA_WIDTH, 24);

		playerManager.init();
		
		/* TODO ez nem itt lesz majd */
		mapLoader.loadMap();
		
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		checkMouseInput();
		checkKeyBoardInput();
		playerManager.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		TileMap.draw(g);
		playerManager.draw(g);
		bottomPalette.draw(g);
		topPalette.draw(g);
	}

	@Override
	public void checkKeyBoardInput() {
		int cameraSpeed = 2;
		game.switchScreens();

		if (Keyboard.keyDown(KeyEvent.VK_DOWN)) {
			Camera.move(new Vector2(0, cameraSpeed));
		}

		if (Keyboard.keyDown(KeyEvent.VK_UP)) {
			Camera.move(new Vector2(0, -cameraSpeed));
		}
		if (Keyboard.keyDown(KeyEvent.VK_LEFT)) {
			Camera.move(new Vector2(-cameraSpeed, 0));
		}

		if (Keyboard.keyDown(KeyEvent.VK_RIGHT)) {
			Camera.move(new Vector2(cameraSpeed, 0));
		}
	}

	@Override
	public void checkMouseInput() {

	}

	@Override
	public final void updateMouse(MouseState state) {
		this.mouseState = state;
		mousePos = mouseState.getPos();
	}

	@Override
	public void onSet() {
		System.out.println("PlayingState");
	}

	public final TileMap getTileMap() {
		return tileMap;
	}

	public final PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	
}
