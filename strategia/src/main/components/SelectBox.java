package components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import objects.GameObject;
import objects.IDrawable;

/**
 * ha valaki kivan v�lasztva, megjelnik alatta egy kis n�gyzet, hogy ezt l�ssuk, ez az oszt�ly erre hivatott
 * @author �cs �d�m
 * 2012.07.19.
 */
public class SelectBox implements IDrawable {
	private Image image;
	private Size size;
	private GameObject container;
	
	/* TODO XXX  a GameObject helyett csin�ljunk egy flyweight patternt size + pos-ra �s azt adjuk �t, ugyan�gy az animationra ios igaz ez*/
	public SelectBox(GameObject container, SelectBox.Size size) {
		this.size = size;
		this.container = container;
		
		/* ez �gy pont j�, mert nullpointer lesz ha nem j�l hozz�k l�tre a selectiont */
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
