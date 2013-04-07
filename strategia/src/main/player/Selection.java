package player;

import java.util.ArrayList;
import java.util.List;

import objects.GameObject;

/**
 * Lekezeli, hogy épp milyen gameobject-ek vannak kijelölve.
 * Ezeknek aztán ki lehet rajzoln az infojukat, illetve lehet mozgatni õket.
 * Több selection is lehetséges, így hotkeyekkel váltogatni lehet közöttük majd.
 * 
 * @author Ács Ádám
 * 2012.07.20.
 */
public final class Selection {
	private static int MAX = 12;
	private List<GameObject> objects = new ArrayList<>(MAX);

	public Selection() {
		super();
	}

	public void addObject(GameObject object) {
		if (objects.size() < MAX) {
			objects.add(object);
		}
	}
}
