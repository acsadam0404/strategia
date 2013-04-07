package components.abilities;

import java.awt.Graphics;

import math.Vector2;

import components.Icon;

/**
 * 
 * 
 * a peonok képessége, hogy épületeket építsenek, ez az ability erre használható
 * @author Ács Ádám
 * 2012.08.26.
 */
public class BuildAbility extends Ability {
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void update(long gameTime) {
		
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

	@Override
	protected Icon initIcon() {
		return new Icon("images\\abilityicons\\build.png", new Vector2(800, 500));
	}

}
