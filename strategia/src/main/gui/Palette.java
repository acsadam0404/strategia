package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

import config.Config;

import objects.IDrawable;

/**
 * a background f�l�tt lev� dekor�ci�t kezeli, mint pl az olyan paletta amire r�tehetj�k az ikonokat
 * @author �cs �d�m
 * 2012.07.12.
 */
public class Palette implements IDrawable {
	private Image base;
	
	private int basePosX;
	private int basePosY;
	private int baseWidth;
	private int baseHeight;
	
	/* TODO kell nekem egy�ltal�n ez? nem lenne jobb ha majd a Decoration-�ket t�roln�m egy List-ben valahol? */
	private List<Image> images = new ArrayList<>();
	private Map<Integer, List<Integer>> imageData = new HashMap<>(); /* pos, m�ret t�rol�s�ra a hozz�adott imagekn�l, egyel�re j� ez �gy */

	/**
	 * h�tt�r n�lk�li paletta, csak t�rol�nak
	 */
	public Palette() {
		this(null, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT); 
	}
	
	/**
	 * a meghat�rozott param�terekkel, mint h�tt�rrel, hozza l�tre a palett�t, ami ut�na ugyan�gy viselkedik mint egy norm�lis kont�ner,
	 * de ki fogja rajzolni a h�tteret is
	 * @param imageName
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 */
	public Palette(String imageName, int posX, int posY, int width, int height) {
		basePosX = posX;
		basePosY = posY;
		baseWidth = width;
		baseHeight = height;
		
		if (imageName != null) {
			init(imageName);
		} else {
			base = null; /* XXX �res image? null object? �s akkor nem k�ne ellen�rz�s a draw-ba*/
		}
	}
	
	private Integer generateId() {
		return Integer.valueOf(imageData.size());
	}

	private final void init(String fileName) {
		base = new ImageIcon(fileName).getImage();
	}

	/**
	 * hozz�ad egy k�pet, ami automatikusan kilesz rajzolva
	 * @param imageName
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 */
	public void addImage(String imageName, int posX, int posY, int width, int height) {
		/* fontos a sorrend, mert az images-b�l gener�lja az id-t */
		images.add(new ImageIcon(imageName).getImage());

		imageData.put(generateId(), Arrays.asList(Integer.valueOf(posX), Integer.valueOf(posY), Integer.valueOf(width), Integer.valueOf(height)));
	}
	
	@Override
	public void draw(Graphics g) {
		if (base != null) {
			g.drawImage(base, basePosX, basePosY, baseWidth, baseHeight, null); 
		}
		
		for (int i = 0; i < images.size(); i++) {
			g.drawImage(images.get(i), 
					imageData.get(Integer.valueOf(i)).get(0).intValue(),
					imageData.get(Integer.valueOf(i)).get(1).intValue(), 
					imageData.get(Integer.valueOf(i)).get(2).intValue(), 
					imageData.get(Integer.valueOf(i)).get(3).intValue(),
					null);
		}
	}
}
