package components.abilities;

import java.awt.Graphics;

import objects.IGameLoop;
import components.Icon;

/**
 * amit egy unit tudni fog, támadás, építés, varázslat stb.
 * @author Ács Ádám
 * 2012.08.26.
 */
public abstract class Ability implements IGameLoop {
	protected Icon icon;

	protected abstract Icon initIcon();
	
	@Override
	public void init() {
		icon = initIcon();
	}
	
	@Override
	public void draw(Graphics g) {
		icon.draw(g);
	}
}
