package objects.tiles;

/**
 * Ha nincs olyan Tile amit k�r�nk, akkor dob�dik. 
 * @author �cs �d�m
 * 2012.07.15.
 */
public class ENoSuchTileException extends Exception {
	@Override
	public String toString() {
		return "Nincs ilyen Tile regisztr�lva.";
	}
}
