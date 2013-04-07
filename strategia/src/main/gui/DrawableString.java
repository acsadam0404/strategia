package gui;

import java.awt.*;

import math.Vector2;

import objects.IDrawable;

/**
 * ezzel kilehet rajzolni egy stringet a k�perny�re
 * @author �cs �d�m
 * 2012.07.12.
 */
public class DrawableString implements IDrawable {
	private Graphics graphics; /* ez csak a draw-ban van inicializ�lva, ez�rt dobhat nullpointert, ha el�bb hivatkozunk r� */
	private String text;
	private Vector2 pos;
	private Color color = Color.BLACK; /* alap�rtelmezett sz�n a fekete */
	private Font font = new Font("Arial Bold", Font.PLAIN, 10); /* alap�rtelmezett font */
	
	public DrawableString(String str, int posX, int posY) {
		this(str, new Vector2(posX, posY));
	}
	
	public DrawableString(String text) {
		this(text, Vector2.ZERO);
	}
	
	public DrawableString(String str, Vector2 pos) {
		this.text = str;
		this.pos = pos;
	}

	public void setPosition(Vector2 pos) {
		this.pos = pos;
	}
	
	public void setPosition(int x, int y) {
		setPosition(new Vector2(x, y));
	}
	
	public void setString(String str) {
		this.text = str;
	}
	
	public void append(String toAppend) {
		text += toAppend;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setFont(Font font) {
		this.font  = font;
	}
	
	public void setFontSize(int size) {
		String currentName = font.getName();
		int currentStyle = font.getStyle();
		
		font = new Font(currentName, currentStyle, size);
	}
	
	@Override
	public void draw(Graphics g) {
		/* ne az �tadottat haszn�lja, csak egy m�solat�t, �gy a v�ltoztat�sok nem maradnak meg */
		if (graphics == null) {
			graphics = g.create(); 
		}

		graphics.setColor(color);
		graphics.setFont(font);
		
		graphics.drawString(text, pos.getX(), pos.getY());
	}	
}
