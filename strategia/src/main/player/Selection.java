package player;

import java.util.ArrayList;
import java.util.List;

import objects.GameObject;

/**
 * Lekezeli, hogy �pp milyen gameobject-ek vannak kijel�lve.
 * Ezeknek azt�n ki lehet rajzoln az infojukat, illetve lehet mozgatni �ket.
 * T�bb selection is lehets�ges, �gy hotkeyekkel v�ltogatni lehet k�z�tt�k majd.
 * 
 * @author �cs �d�m
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
