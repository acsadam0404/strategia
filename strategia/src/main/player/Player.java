package player;

import java.awt.Graphics;

import objects.IGameLoop;
import objects.buildings.Building;
import objects.units.Unit;
import player.managers.BuildingManager;
import player.managers.UnitManager;

/**
 * 
 * @author Ács Ádám
 * 2012.08.26.
 */
public abstract class Player implements IGameLoop {
	private UnitManager unitManager = new UnitManager();
	private BuildingManager buildingManager = new BuildingManager();
	
	public Player() {

	}
	
	@Override
	public void update(long gameTime) {
		unitManager.update(gameTime);
		buildingManager.update(gameTime);
	}
	
	@Override
	public void init() {
		unitManager.init();
		buildingManager.init();
	}
	
	@Override
	public void draw(Graphics g) {
		unitManager.draw(g);
		buildingManager.draw(g);
	}

	public final void add(Unit unit) {
		unitManager.add(unit);
	}
	
	public final void add(Building building) {
		buildingManager.add(building);
	}
}
