package objects.units.dummy;

import input.MouseButtonState;
import input.MouseState;

import java.awt.Graphics;

import objects.units.Unit;
import objects.units.UnitState;



import camera.Camera;

import components.animation.Animation;
import components.animation.AnimationFactory;

/**
 * 
 * @author Ács Ádám
 * 2012.08.06.
 */
public class DummyStandingState extends UnitState {
	private DummyUnit valaminev;
	private Animation standing;

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
		valaminev.getAnimation().update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		valaminev.getAnimation().draw(g);
	}

	@Override
	protected void loadAnimation() {
		standing = AnimationFactory.createAnimation("animations\\test\\animation.xml");
		standing.setContainer(valaminev);
	}

	@Override
	public void onMouseInput(MouseState mouseState) {
		if (valaminev.isSelected() && mouseState.getRightButtonState().equals(MouseButtonState.PRESSED)) {
			valaminev.setDest(Camera.screenToWorld(mouseState.getPos()));
			valaminev.setState(valaminev.getMovingState());
		}
	
	}
	@Override
	public void onSet() {
		valaminev.setAnimation(standing);
	}
}
