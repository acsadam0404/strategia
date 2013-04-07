package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.Config;

import objects.IDrawable;

/**
 * egy hátteret állít be és rajzol ki a megadott fájlból. Az egész képernyõt betakarja, tökéletes menükhöz
 * @author Ács Ádám
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
