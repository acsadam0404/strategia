package game;

import game.core.Game1;
import input.IMouseObserver;
import objects.IGameLoop;

/**
 * IGameObject interfészbõl származik, a GameStatek interfésze.
 * @author Ács Ádám
 * 2012.06.28.
 */
public abstract class AbstractGameState implements IGameLoop, IMouseObserver {
	protected abstract void checkKeyBoardInput();
	
	protected Game1 game;
	public AbstractGameState(Game1 game) {
		this.game = game;
	}
	
	@Override
	public void update(long gameTime) {
		checkKeyBoardInput();
	}
	
	@Override
	public void init() {
		Game1.registerMouseObserver(this);
	}
	
	public abstract void onSet();
}
