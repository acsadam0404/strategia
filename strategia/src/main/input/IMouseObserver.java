package input;

/**
 * Ha ezt implement�lja egy oszt�ly, akkor tud regisztr�lni az eg�rre, 
 * �gy automatikusan megkapja az eg�r �llapot�t, ha az v�ltozott 
 * @author �cs �d�m
 * 2012.07.20.
 */
public interface IMouseObserver {

	public void updateMouse(MouseState mouseState);
	public void checkMouseInput();

}
