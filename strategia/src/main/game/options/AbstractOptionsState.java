package game.options;

import objects.IGameLoop;
import game.OptionsState;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public abstract class AbstractOptionsState implements IGameLoop {
	protected OptionsState options;
	
	public AbstractOptionsState(OptionsState options) {
		this.options = options;
	}
	
	public abstract void onSet();
}
