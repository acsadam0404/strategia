package objects.units;

import input.MouseState;

import java.awt.Graphics;


import objects.IGameLoop;

/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public abstract class UnitState implements IGameLoop {
	protected Unit unit;
	
	public UnitState(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public void init() {
		loadAnimation();
	}
	
	@Override
	public abstract void update(long gameTime);
	
	@Override
	public abstract void draw(Graphics g);
	
	protected abstract void loadAnimation();
	public abstract void onMouseInput(MouseState mouseState);

	public abstract void onSet();
}
