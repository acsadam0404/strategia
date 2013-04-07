package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.Config;

import objects.IDrawable;

/**
 * egy h�tteret �ll�t be �s rajzol ki a megadott f�jlb�l. Az eg�sz k�perny�t betakarja, t�k�letes men�kh�z
 * @author �cs �d�m
 * 2012.07.14.
 */
public class Background implements IDrawable {
	private Image background;
	
	public Background(String imageFileName) {
		init(imageFileName);
	}
	
	private void init(String imageFileName) {
		background = new ImageIcon(imageFileName).getImage();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT, null);
	}
}
