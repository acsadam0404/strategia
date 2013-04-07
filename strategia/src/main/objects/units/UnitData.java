package objects.units;

import math.Vector2;

public abstract class UnitData {
	protected int maxHealth;
	protected int minDamage;
	protected int maxDamage;
	protected int armor;
	protected int range;
	
	protected Vector2 healthBarSize;
	
	public final Vector2 getHealthBarSize() {
		return healthBarSize;
	}

	public final int getMaxHealth() {
		return maxHealth;
	}

	public final void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
}
