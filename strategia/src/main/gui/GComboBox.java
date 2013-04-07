package gui;

import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import objects.IDrawable;

import math.Vector2;


/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class GComboBox extends JRadioButton implements IDrawable {

	
	private String resolutions[] = {"1366 x 768", "1920 x 1080"};	
	private Vector2 pos;
	private static final Data data = new Data();	
	
	public GComboBox(Vector2 pos, GButtonSize gbSize, Action action) {
		super();
		setSize(gbSize.getSize().getX(), gbSize.getSize().getY());
		this.pos = pos;
		if (action != null) {
			setAction(action);
		}
		initialize();
		
	}

	private void initialize() {
		
	}
	
	@Override
	public void draw(Graphics g) {
		
	}
	
	private static class Data {
		public final Icon pressedIcon;
		public final Icon selectedIcon;
		public final Icon rolloverIcon;
		public final Icon icon;
		
		public Data() {
			pressedIcon = new ImageIcon("images\\gui\\button200x40_pressed.png");
			rolloverIcon =new ImageIcon("images\\gui\\button200x40_hover.png");
			selectedIcon = new ImageIcon("images\\gui\\button200x40.png");
			icon = new ImageIcon("images\\gui\\button200x40.png");
		}
	}

}
