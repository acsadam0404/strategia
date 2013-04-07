package units.unitstates;

import java.awt.Graphics;
import java.util.*;

import objects.GameObject;

import camera.Camera;

import math.Vector2;


/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public abstract class Unit extends GameObject {
	protected UnitState currentState;

	protected Vector2 dest;
	protected List<Vector2> path = new LinkedList<>();
	
	public final void setCurrentState(UnitState currentState) {
		this.currentState = currentState;
	}

	public final void setDest(Vector2 dest) {
		this.dest = dest;
	}

	public final void setPath(List<Vector2> path) {
		this.path = path;
	}

	public List<Vector2> getPath() {
		return path;
	}
	
	public final Vector2 getDest() {
		return dest;
	}

	public Unit(Vector2 worldPos) {
		this.worldPos = worldPos;
		screenPos = Camera.worldToScreen(worldPos);
		dest = worldPos;
	}
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		currentState.update(gameTime);
	}
	
	@Override
	public void init() {
		super.init();
		selectionBox = loadSelectionBox();
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		if (Camera.isObjectVisible(getWorldRect())) {
			currentState.draw(g);
		}
	}
	
	@Override
	public void checkMouseInput() {
		super.checkMouseInput();
		if (isSelected()) {
			currentState.onMouseInput(mouseState);
		}
	}
	
	/**
	 * hozzáad egy értéket a worldPos-hoz
	 */
	public void addToWorldPos(Vector2 toAdd) {
		worldPos = worldPos.add(toAdd);
	}
}
