package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

import config.Config;

import objects.IDrawable;

/**
 * a background fölött levõ dekorációt kezeli, mint pl az olyan paletta amire rátehetjük az ikonokat
 * @author Ács Ádám
 * 2012.07.12.
 */
public class Palette implements IDrawable {
	private Image base;
	
	private int basePosX;
	private int basePosY;
	private int baseWidth;
	private int baseHeight;
	
	/* TODO kell nekem egyáltalán ez? nem lenne jobb ha majd a Decoration-öket tárolnám egy List-ben valahol? */
	private List<Image> images = new ArrayList<>();
	private Map<Integer, List<Integer>> imageData = new HashMap<>(); /* pos, méret tárolására a hozzáadott imageknél, egyelõre jó ez így */

	/**
	 * háttér nélküli paletta, csak tárolónak
	 */
	public Palette() {
		this(null, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT); 
	}
	
	/**
	 * a meghatározott paraméterekkel, mint háttérrel, hozza létre a palettát, ami utána ugyanúgy viselkedik mint egy normális konténer,
	 * de ki fogja rajzolni a hátteret is
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
			base = null; /* XXX üres image? null object? és akkor nem kéne ellenõrzés a draw-ba*/
		}
	}
	
	private Integer generateId() {
		return Integer.valueOf(imageData.size());
	}

	private final void init(String fileName) {
		base = new ImageIcon(fileName).getImage();
	}

	/**
	 * hozzáad egy képet, ami automatikusan kilesz rajzolva
	 * @param imageName
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 */
	public void addImage(String imageName, int posX, int posY, int width, int height) {
		/* fontos a sorrend, mert az images-bõl generálja az id-t */
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
