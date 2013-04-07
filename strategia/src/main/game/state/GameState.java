package game.state;

import game.core.Game1;
import objects.InGameLoop;

/**
 * IGameObject interf�szb�l sz�rmazik, a GameStatek interf�sze.
 * @author �cs �d�m
 * 2012.06.28.
 */
public abstract class GameState implements InGameLoop {
	protected abstract void checkKeyBoardInput();
	protected abstract void checkMouseInput();
	
	protected Game1 game;
	public GameState(Game1 game) {
		this.game = game;
	}
	
	@Override
	public void update(long gameTime) {
		checkKeyBoardInput();
	}
}
