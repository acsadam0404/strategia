package components.abilities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import objects.IDrawable;

/**
 * 
 * @author Ács Ádám
 * 2012.08.27.
 */
public class AbilityManager implements IDrawable {
	private List<Ability> abilities = new ArrayList<>();
	
	public AbilityManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(Ability ability) {
		abilities.add(ability);
	}

	@Override
	public void draw(Graphics g) {
		for (Ability ability : abilities) {
			ability.draw(g);
		}
	}
}
