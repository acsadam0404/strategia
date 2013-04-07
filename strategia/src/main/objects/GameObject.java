package objects;

import java.awt.Graphics;

import camera.Camera;

import components.SelectBox;

import game.core.Game1;
import input.*;

/**
 * Egy objektum, ami rajzolható, kijelölhetõ, létezhet hang hozzá, különbözõ animációk
 * @author Ács Ádám
 * 2012.07.31.
 */
public abstract class GameObject extends Sprite implements IGameLoop, ISelectable, IMouseObserver {
	protected boolean selectable = true;
	protected boolean selected = false;
	protected SelectBox selectionBox;

	/**
	 * current mouse state
	 */
	protected MouseState mouseState;

	@Override
	public final void select() {
		selected = true;
	}

	@Override
	public final void deselect() {
		selected = false;
	}

	@Override
	public final boolean isSelected() {
		if (!selectable) {
			return false;
		}
		return selected;
	}

	@Override
	public final void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	/**
	 * regisztrál mouseobserverként, 
	 */
	@Override
	public void init() {
		Game1.registerMouseObserver(this);
	}

	/**
	 * checks for selection
	 */
	@Override
	public void update(long gameTime) {
		checkMouseInput();
	
	}

	@Override
	public void checkMouseInput() {
		checkForSelection();
	}

	@Override
	public void checkForSelection() {
		if (mouseState.getLeftButtonState().equals(MouseButtonState.PRESSED)) {
			if (mouseState.getRectangle().intersects(Camera.worldToScreen(getBoundingRect()))) {
				//System.out.println("if: select()");
				select();
			} 
			/*lehet, h hülyeség lesz utólag és törölni kellhet*/
			/*
			if (!mouseState.getLeftButtonState().equals(MouseButtonState.RELEASED) && mouseState.getRectangle().intersects(Camera.worldToScreen(getBoundingRect()))) {
				System.out.println("if: select()");
				select();
			}
			else if (mouseState.getLeftButtonState().equals(MouseButtonState.RELEASED) && mouseState.getRectangle().intersects(Camera.worldToScreen(getBoundingRect()))){
				System.out.println("else if: select()");
				select();
			}
			*/
			else {
				//System.out.println("else: deselect()");
				deselect();
			}
		}
	}

	@Override
	public final void updateMouse(MouseState state) {
		this.mouseState = state;
	}
	
	@Override
	public void draw(Graphics g) {
		if (isSelected()) {
			selectionBox.draw(g);
		}
	}
	
	protected abstract SelectBox loadSelectionBox();
}
