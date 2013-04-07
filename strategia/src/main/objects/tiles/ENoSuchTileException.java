package objects.tiles;

/**
 * Ha nincs olyan Tile amit kérünk, akkor dobódik. 
 * @author Ács Ádám
 * 2012.07.15.
 */
public class ENoSuchTileException extends Exception {
	@Override
	public String toString() {
		return "Nincs ilyen Tile regisztrálva.";
	}
}
