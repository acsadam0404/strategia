package game.state;

import game.core.Game1;
import gui.*;

import input.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import algorithm.astar.PathFinder;

import map.TileMap;
import map.MapData;
import math.Vector2;
import objects.GameObject;
import objects.tiles.ENoSuchTileException;
import units.DummyUnit;
import camera.Camera;


/**
 * 
 * @author �cs �d�m
 * 2012.07.22.
 */
public class PlayingState extends GameState implements IMouseObserver {
	private GameObject dummy;
	private Background background;
	private MouseState mouseState;
	private Vector2 mousePos;
	private MapData testMapData;
	private TileMap testMap;

	private Rectangle testCameraRect = new Rectangle(0, 0, 0, 0);
	
	public PlayingState(Game1 game) {
		super(game);
	}

	@Override
	public void init() {
		try {
			Game1.registerMouseObserver(this);
			background = new Background("images\\test\\backgro.png");

			dummy = new DummyUnit(new Vector2(0, 40));
			dummy.init();

			testMapData = new MapData("maps\\test\\1.txt");
			TileMap.setData(testMapData);
			
		} catch (ENoSuchTileException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		checkMouseInput();
		checkKeyBoardInput();
		dummy.update(gameTime);
	}

//	boolean found = false;
//	java.util.List<Vector2> path = null;
	@Override
	public void draw(Graphics g) {
		
		background.draw(g);
		TileMap.draw(g);
		dummy.draw(g);
		
//		/* test */
//		
//		if (!found) {
//			path = PathFinder.findPath(new Vector2(0, 1)/*TileMap.getSquareAtPixel(mousePos)*/, new Vector2(10,8));
//		}
//		if (path != null) {
//			g.setColor(Color.YELLOW);
//			found = true;
//			for (Vector2 node : path) {
//				g.drawRect(node.getX() * 40, node.getY() * 40, 40, 40);
//			}
//		}
		
	}

	@Override
	public void checkKeyBoardInput() {
		int cameraSpeed = 1;
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
}
