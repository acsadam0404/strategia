package player.managers;

import java.awt.Graphics;
import java.util.*;


import objects.IGameLoop;
import objects.units.Unit;


/**
 * 
 * @author Ács Ádám
 * 2012.08.26.
 */
public class UnitManager implements IGameLoop {
	private List<Unit> units = new ArrayList<>();
	
	public UnitManager() {
		
	}
	
	public void add(Unit unit) {
		units.add(unit);
	}

	@Override
	public void init() {
		for (Unit unit : units) {
			unit.init();
		}
	}

	@Override
	public void update(long gameTime) {
		for (Unit unit : units) {
			unit.update(gameTime);
			
			if (unit.isDead()) {
				units.remove(unit);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (Unit unit : units) {
			unit.draw(g);
		}
	}
}
