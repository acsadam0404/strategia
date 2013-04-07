package objects;

import java.awt.Graphics;

/**
 * olyan dolgokhoz, amik csak rajzolhat�k, de nem kell friss�teni meg ilyenek
 * @author �cs �d�m
 * 2012.07.12.
 */
public interface IDrawable {
	public void draw(Graphics g);
}
