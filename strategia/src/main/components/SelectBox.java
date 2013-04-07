package components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import objects.GameObject;
import objects.IDrawable;

/**
 * ha valaki kivan választva, megjelnik alatta egy kis négyzet, hogy ezt lássuk, ez az osztály erre hivatott
 * @author Ács Ádám
 * 2012.07.19.
 */
public class SelectBox implements IDrawable {
	private Image image;
	private Size size;
	private GameObject container;
	
	/* TODO XXX  a GameObject helyett csináljunk egy flyweight patternt size + pos-ra és azt adjuk át, ugyanúgy az animationra ios igaz ez*/
	public SelectBox(GameObject container, SelectBox.Size size) {
		this.size = size;
		this.container = container;
		
		/* ez így pont jó, mert nullpointer lesz ha nem jól hozzák létre a selectiont */
		if (size.equals(Size.SMALL)) {
			image = new ImageIcon("images\\test\\selection.png").getImage();
		}
	}
	
	public static enum Size {
		SMALL;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, container.getScreenPos().getX(), container.getScreenPos().getY(), null);
		
	}

}
