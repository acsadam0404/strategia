package objects;

import java.awt.Graphics;

/**
 * A j�t�kban r�sztvev� Objectek interf�sze, az init f�ggv�nyt �s a j�t�kciklust deklar�lja.
 * 
 * @author �cs �d�m
 * 2012.06.28.
 */
public interface IGameLoop extends IDrawable {
	public void init();
	public void update(long gameTime);
	
	@Override
	public void draw(Graphics g);
}
