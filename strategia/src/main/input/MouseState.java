package input;

import java.awt.Graphics;
import java.awt.Rectangle;

import objects.IDrawable;

import math.Vector2;

/**
 * @author �cs �d�m
 * 2012.07.20.
 */
public class MouseState implements IDrawable {
	/*package-private hogy ne ny�ljanak hozz� k�v�lr�l*/
	Vector2 currentPos = new Vector2(0, 0);
	/* Current state of mouse buttons, package-private hogy ne ny�ljanak hozz� k�v�lr�l */
	boolean[] state;
	/* Polled mouse buttons, package-private hogy ne ny�ljanak hozz� k�v�lr�l*/
	MouseButtonState[] poll;
	
	private Mouse mouse;
	private SelectionBox selectionBox;
	
	/**
	 * be�ll�tja az alap �rt�keket, package-private hogy ne ny�ljanak hozz� k�v�lr�l
	 * @param newState
	 * @param newPoll
	 */
	 MouseState(Mouse mouse, boolean[] newState, MouseButtonState[] newPoll) {
		state = newState;
		poll = newPoll;
		this.mouse = mouse;
		selectionBox = new SelectionBox(this);
	}
	 
	/**
	 * �tk�z�svizsg�lathoz t�glalap
	 * @return rect : posx, posy, 1, 1
	 */
	public synchronized Rectangle getRectangle() {
		if (mouse.isBoxSelection()) {
			//System.out.println("getRectangle() : if");
			return selectionBox.getRectangle();
		}
		//System.out.println("getRectangle() : !if");
		return new Rectangle(currentPos.getX(), currentPos.getY(), 1, 1); 
		
	}
	
	public synchronized  Vector2 getPos() {
		return currentPos;
	}
	
	public synchronized  MouseButtonState getLeftButtonState() {
		return poll[MouseButtons.LEFT.getNum() - 1];
	}
	
	public synchronized  MouseButtonState getRightButtonState() {
		return poll[MouseButtons.RIGHT.getNum() - 1];
	}

	@Override
	public void draw(Graphics g) {
		selectionBox.draw(g);
	}
	
	void updatePos(int x, int y) {
		selectionBox.updatePos(x, y);
	}
	
	boolean isBoxSelection() {
		return mouse.isBoxSelection();
	}
}
