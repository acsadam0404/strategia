package units;

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
public class DummyAttackingState extends UnitState{

	public DummyAttackingState(Unit unit) {
		super(unit);
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		anim.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		anim.draw(g);
	}

	@Override
	protected Animation loadAnimation() {
		return AnimationFactory.createAnimation("animations\\test\\animation.xml");
	}

	@Override
	public void onMouseInput(MouseState mouseState) {
		// TODO Auto-generated method stub
		
	}
}
