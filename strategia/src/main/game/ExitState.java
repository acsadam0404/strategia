package game;


import game.core.Game1;
import input.MouseState;

import java.awt.Graphics;

/**
 * A kil�p� k�perny� a j�t�k v�g�n.
 * @author �cs �d�m
 * 2012.06.28.
 */
public class ExitState extends AbstractGameState {	
	public ExitState(Game1 game) {
		super(game);
	} 

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();
		
	}

	@Override
	public void checkMouseInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseState mouseState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSet() {
		System.out.println("ExitState");
	}
}
