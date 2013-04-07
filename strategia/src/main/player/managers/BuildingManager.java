package player.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


import objects.IGameLoop;
import objects.buildings.Building;


/**
 * 
 * @author Ács Ádám
 * 2012.08.26.
 */
public class BuildingManager implements IGameLoop {
	private List<Building> buildings = new ArrayList<>();
	
	public BuildingManager() {
		
	}
	
	public void add(Building building) {
		buildings.add(building);
	}

	@Override
	public void init() {
		for (Building building : buildings) {
			building.init();
		}
	}

	@Override
	public void update(long gameTime) {
		for (Building building : buildings) {
			building.update(gameTime);
			
			if (building.isDead()) {
				buildings.remove(building);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (Building building : buildings) {
			building.draw(g);
		}
	}
}
