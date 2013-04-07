package input;

/**
 * a mouse állapota (lenyomva, felengedve, stb)
 * @author Ács Ádám
 * 2012.07.19.
 */
public enum MouseButtonState {
	RELEASED, // Not down
	PRESSED, // Down, but not the first time
	ONCE // Down for the first time
}
