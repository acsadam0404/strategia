package units;

import java.awt.Graphics;

import math.Vector2;
import units.unitstates.Unit;
import units.unitstates.UnitState;

import components.SelectBox;
import components.SelectBox.Size;

/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public class DummyUnit extends Unit {
	private UnitState movingState;
	private UnitState standingState;
	private UnitState attackingState;

	public DummyUnit(Vector2 worldPos) {
		super(worldPos);
		currentState = standingState;
	}
	
	@Override
	public void init() {
		super.init();

		movingState = new DummyMovingState(this);
		standingState = new DummyStandingState(this);
		attackingState = new DummyAttackingState(this);
		
		movingState.init();
		standingState.init();
		attackingState.init();
		
		currentState = standingState;
	}
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

	@Override
	public void checkMouseInput() {
		super.checkMouseInput();
	}
	
	@Override
	protected SelectBox loadSelectionBox() {
		return new SelectBox(this, Size.SMALL);
	}

	public UnitState getStandingState() {
		return standingState;
	}
	
	public UnitState getMovingState() {
		return movingState;
	}
	
	public UnitState getAttackingState() {
		return attackingState;
	}
}
