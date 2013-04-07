package units;

import input.MouseButtonState;
import input.MouseState;

import java.awt.Graphics;

import components.animation.Animation;
import components.animation.AnimationFactory;

import units.unitstates.Unit;
import units.unitstates.UnitState;

/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public class DummyStandingState extends UnitState {
	private DummyUnit valaminev;

	public DummyStandingState(Unit unit) {
		super(unit);
		valaminev = (DummyUnit) unit;
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		anim.update(gameTime);

	}

	@Override
	public void draw(Graphics g) {
		anim.draw(g);
	}

	@Override
	protected Animation loadAnimation() {
		return AnimationFactory.createAnimation("animations\\test\\animation.xml");
	}

	@Override
	public void onMouseInput(MouseState mouseState) {
		if (valaminev.isSelected() && mouseState.getRightButtonState().equals(MouseButtonState.PRESSED)) {
			valaminev.setCurrentState(valaminev.getMovingState());
		}
	}
}
