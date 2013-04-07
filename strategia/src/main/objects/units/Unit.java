package objects.units;


import java.awt.Graphics;
import java.util.*;

import components.Icon;
import components.abilities.AbilityManager;
import components.healthbar.HealthBar;

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
	protected int health;
    protected HealthBar healthBar;
    protected UnitData unitData;
    protected Icon icon;
    protected AbilityManager abilityManager = new AbilityManager();
    
	public Unit(Vector2 worldPos) {
		this.worldPos = worldPos;
		screenPos = Camera.worldToScreen(worldPos);
		dest = worldPos;
        health = 6;
        healthBar = new HealthBar(this);
	}
	
	public final void setState(UnitState currentState) {
		this.currentState = currentState;
		currentState.onSet();
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
	
	@Override
	public void update(long gameTime) {
		super.update(gameTime);
		currentState.update(gameTime);
	}
	
	@Override
	public void init() {
		super.init();
		selectionBox = loadSelectionBox();
		icon = initIcon();
		unitData = initUnitData();
	}
	
	protected abstract Icon initIcon();
	protected abstract UnitData initUnitData();
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		abilityManager.draw(g);
		
		if (Camera.isObjectVisible(getWorldRect())) {
			currentState.draw(g);
			if (isSelected()) {
				icon.draw(g);
			}
		}
		
		healthBar.draw(g);
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
	
    public int getMaxHealth() {
        return unitData.getMaxHealth();
    }

    public void setMaxHealth(int maxHealth) {
        this.setMaxHealth(maxHealth);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

	public UnitData getUnitData() {
		return unitData;
	}

	public boolean isDead() {
		if (health < 0) {
			return true;
		}
		
		return false;
	}
}
