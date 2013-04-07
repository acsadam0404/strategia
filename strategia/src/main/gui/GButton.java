package gui;

import java.awt.*;

import javax.swing.*;

import math.Vector2;

/**
 * 
 * @author Ács Ádám
 * 2012.08.09.
 */
public class GButton extends JButton {

	protected Vector2 pos;
	private static final Data data = new Data();
	private String text;

	public GButton(String text, Vector2 pos, GButtonSize gbSize, Action action) {
		super();
		setSize(gbSize.getSize().getX(), gbSize.getSize().getY());
		this.pos = pos;
		this.text = text;
		if (action != null) {
			setAction(action);
		}
		setFocusable(false);
		initialize();
	}

	private void initialize() {
		setPressedIcon(data.pressedIcon);
		setRolloverIcon(data.rolloverIcon);
		setSelectedIcon(data.selectedIcon);
		setIcon(data.icon);

		setLocation(pos.getX(), pos.getY());

		setFont(Font.getFont(Font.SERIF));
		setBorderPainted(false);
		setHorizontalTextPosition(CENTER);

	}

	public void draw(Graphics g) {
		if (getModel().isPressed()) {
			g.drawImage(((ImageIcon) getSelectedIcon()).getImage(), pos.getX(), pos.getY(), getWidth(), getHeight(), null);
		}
		else if (getModel().isRollover()) {
			g.drawImage(((ImageIcon) getRolloverIcon()).getImage(), pos.getX(), pos.getY(), getWidth(), getHeight(), null);
		}
		else if (getModel().isEnabled()) {
			g.drawImage(((ImageIcon) getIcon()).getImage(), pos.getX(), pos.getY(), getWidth(), getHeight(), null);
		}

		/* a text mérése és kirajzolása a gomb közepére */
		FontMetrics metrics = g.getFontMetrics();
		int hgt = metrics.getHeight();
		int adv = metrics.stringWidth(text);
		int relPosX = (getSize().width - adv) / 2;
		int relPosY = (getSize().height - hgt) / 2;
		Vector2 textPos = new Vector2(pos.getX() + relPosX, pos.getY() + relPosY);
		
		if (text != null) {
			g.drawString(text, textPos.getX(), textPos.getY());
		}
	}

	private static class Data {
		public final Icon pressedIcon;
		public final Icon selectedIcon;
		public final Icon rolloverIcon;
		public final Icon icon;

		public Data() {
			pressedIcon = new ImageIcon("images\\gui\\button200x40_pressed.png");
			rolloverIcon = new ImageIcon("images\\gui\\button200x40_hover.png");
			selectedIcon = new ImageIcon("images\\gui\\button200x40.png");
			icon = new ImageIcon("images\\gui\\button200x40.png");
		}
	}
}
