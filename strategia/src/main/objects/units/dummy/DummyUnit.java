package objects.units.dummy;


import java.awt.Graphics;


import objects.Direction;
import objects.units.*;

import math.Vector2;

import components.*;
import components.SelectBox.Size;
import components.abilities.Ability;
import components.abilities.BuildAbility;
import components.animation.Animation;

/**
 * 
 * @author Ács Ádám
 * 2012.08.06.
 */
public class DummyUnit extends Unit {
	private UnitState movingState;
	private UnitState standingState;
	private UnitState attackingState;
	private Animation anim;
	
	public DummyUnit(Vector2 worldPos) {
		super(worldPos);
		currentState = standingState;
		
	}
	
	public void setAnimation(Animation anim) {
		this.anim = anim;
	}
	
	public final Animation getAnimation() {
		return anim;
	}

	private Direction direction = Direction.SOUTH;

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}
	

	
	@Override
	public void init() {
		super.init();

		movingState = new DummyMovingState(this);
		standingState = new DummyStandingState(this);
		attackingState = new DummyAttackingState(this);
		
		
		standingState.init();
		attackingState.init();
		movingState.init();
		
		Ability build = new BuildAbility();
		build.init();
		
		abilityManager.add(build);
		
		setState(standingState);
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

	@Override
	protected Icon initIcon() {
		return new Icon("images\\peon\\peon_icon.png", new Vector2(600, 400));
	}

	@Override
	protected UnitData initUnitData() {
		return new DummyUnitData();
	}
}
