package input;

/**
 * a mouse �llapota (lenyomva, felengedve, stb)
 * @author �cs �d�m
 * 2012.07.19.
 */
public enum MouseButtonState {
	RELEASED, // Not down
	PRESSED, // Down, but not the first time
	ONCE // Down for the first time
}
