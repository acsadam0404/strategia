package objects.units.dummy;

import objects.units.UnitData;
import math.Vector2;

public class DummyUnitData extends UnitData {
	public DummyUnitData() {
		maxHealth = 6;
		healthBarSize = new Vector2(40, 10);
	}
}
