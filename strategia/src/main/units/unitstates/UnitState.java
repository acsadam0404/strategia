package units.unitstates;

import input.MouseState;

import java.awt.Graphics;

import components.animation.Animation;

import objects.InGameLoop;

/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public abstract class UnitState implements InGameLoop {
	protected Unit unit;
	protected Animation anim;
	
	public UnitState(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public void init() {
		anim = loadAnimation();
		anim.setContainer(unit);
	}
	
	@Override
	public void update(long gameTime) {
		
	}
	
	@Override
	public void draw(Graphics g) {
		
	}
	
	protected abstract Animation loadAnimation();
	public abstract void onMouseInput(MouseState mouseState);
}
