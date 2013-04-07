package components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import math.Vector2;

import objects.IDrawable;


/**
 * egyszer� ikon amit �p�letek vagy unitok haszn�lhatnak, meg lehet jelen�teni �s buttonk�nt m�k�dik
 * @author �cs �d�m
 * 2012.07.19.
 */
public class Icon extends JButton implements IDrawable {
	protected final Image image;
	
	protected Vector2 pos;
	
	public Icon(String imageFileName, Vector2 pos) {
		this.pos = pos;
		setSize(40, 40);
		setFocusable(false);

		ImageIcon icon = new ImageIcon(imageFileName);
		
		/*XXX  valamelyik f�l�sleges */
		setIcon(icon); 
		image = icon.getImage();
		
		setLocation(pos.getX(), pos.getY());
		setBorderPainted(false);
	}

	@Override
	public void draw(Graphics g) {
		if (image != null) {
			g.drawImage(image, pos.getX(), pos.getY(), null);
		}
	}
	
	public void setPosition(Vector2 pos) {
		this.pos = pos;
	}
}
