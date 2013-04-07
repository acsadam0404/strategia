package objects.units.dummy;

import input.MouseState;

import java.awt.Graphics;

import objects.units.Unit;
import objects.units.UnitState;



import components.animation.Animation;
import components.animation.AnimationFactory;


/**
 * 
 * @author Ács Ádám
 * 2012.08.06.
 */
public class DummyAttackingState extends UnitState {
	private DummyUnit baseUnit;
	public DummyAttackingState(Unit unit) {
		super(unit);
		baseUnit = (DummyUnit)unit;
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		baseUnit.getAnimation().update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		baseUnit.getAnimation().draw(g);
	}

	@Override
	protected void loadAnimation() {
	}

	@Override
	public void onMouseInput(MouseState mouseState) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSet() {
	}
}
