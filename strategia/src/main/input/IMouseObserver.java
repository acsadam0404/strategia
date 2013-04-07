package input;

/**
 * Ha ezt implementálja egy osztály, akkor tud regisztrálni az egérre, 
 * így automatikusan megkapja az egér állapotát, ha az változott 
 * @author Ács Ádám
 * 2012.07.20.
 */
public interface IMouseObserver {

	public void updateMouse(MouseState mouseState);
	public void checkMouseInput();

}
