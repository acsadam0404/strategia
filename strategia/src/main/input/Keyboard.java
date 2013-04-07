package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * XXX EZ NEM KIPRÓBÁLT, lehet tök szar
 * http://www.gamedev.net/page/resources/_/technical/general-programming/java-games-keyboard-and-mouse-r2439
 * @author Ács Ádám
 * 2012.07.15.
 */
public class Keyboard implements KeyListener {

	private static final int KEY_COUNT = 256;

	private enum KeyState {
		RELEASED, // Not down
		PRESSED, // Down, but not the first time
		ONCE // Down for the first time
	}

	// Current state of the keyboard
	private static boolean[] currentKeys = null;

	// Polled keyboard state
	private static KeyState[] keys = null;

	public Keyboard() {
		currentKeys = new boolean[KEY_COUNT];
		keys = new KeyState[KEY_COUNT];
		for (int i = 0; i < KEY_COUNT; ++i) {
			keys[i] = KeyState.RELEASED;
		}
	}

	public static synchronized void poll() {
		for (int i = 0; i < KEY_COUNT; ++i) {
			// Set the key state 
			if (currentKeys[i]) {
				// If the key is down now, but was not
				// down last frame, set it to ONCE,
				// otherwise, set it to PRESSED
				if (keys[i] == KeyState.RELEASED)
					keys[i] = KeyState.ONCE;
				else
					keys[i] = KeyState.PRESSED;
			} else {
				keys[i] = KeyState.RELEASED;
			}
		}
	}

	/**
	 * a legegyszerûbb billentyûzet kezelés. legtöbbször ezt kell használni
	 * @param keyCode
	 * @return
	 */
	public static  boolean keyDown(int keyCode) {
		return keys[keyCode] == KeyState.ONCE ||
				keys[keyCode] == KeyState.PRESSED;
	}

	/* XXX ez nem tudom hogy jó e valamire */
	public static boolean keyDownOnce(int keyCode) {
		return keys[keyCode] == KeyState.ONCE;
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode >= 0 && keyCode < KEY_COUNT) {
			currentKeys[keyCode] = true;
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode >= 0 && keyCode < KEY_COUNT) {
			currentKeys[keyCode] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Not needed
	}
}
