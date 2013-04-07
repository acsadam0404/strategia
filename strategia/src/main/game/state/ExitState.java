package game.state;

import game.core.Game1;

import java.awt.Graphics;

/**
 * A kil�p� k�perny� a j�t�k v�g�n.
 * @author �cs �d�m
 * 2012.06.28.
 */
public class ExitState extends GameState {	
	public ExitState(Game1 game) {
		super(game);
	}

	@Override
	public void init() {
		
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
	protected void checkMouseInput() {
		// TODO Auto-generated method stub
		
	}
}
