package gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import objects.IDrawable;

import math.Vector2;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class GRadioButton extends JRadioButton implements ButtonModel, IDrawable {
	
	private Vector2 pos;
	private String text;
	private static final Data data = new Data();
	
	
	public GRadioButton(String text, Vector2 pos, GRadioButtonSize grbSize, Action action) {
		super();
		setSize(grbSize.getSize().getX(), grbSize.getSize().getY());
		this.pos = pos;
		this.text = text;
		if (action != null) {
			setAction(action);
		}
		setFocusable(false);
		initialize();
	}

	private void initialize() {
		setSelectedIcon(data.selectedIcon);
		setIcon(data.icon);

		setLocation(pos.getX(), pos.getY());

		setFont(Font.getFont(Font.SERIF));
		setBorderPainted(false);
		setHorizontalTextPosition(CENTER);

	}

	@Override
	public void draw(Graphics g) {
		if (getModel().isSelected()) {
			g.drawImage(((ImageIcon)getSelectedIcon()).getImage(), pos.getX(), pos.getY(), getWidth(), getHeight(), null);
		}
		else if (!getModel().isSelected()) {
			g.drawImage(((ImageIcon)getIcon()).getImage(), pos.getX(), pos.getY(),getWidth(), getHeight(), null);
		}
	}
	
	private static class Data {
		public final Icon selectedIcon;
		public final Icon icon;
		
		public Data() {
			selectedIcon = new ImageIcon("images\\gui\\radioButton_red.png");
			icon = new ImageIcon("images\\gui\\radioButton_empty.png");
		}
	}

	@Override
	public boolean isArmed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRollover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setArmed(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGroup(ButtonGroup arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPressed(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRollover(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

}
