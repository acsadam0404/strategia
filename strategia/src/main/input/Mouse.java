package input;

import math.Vector2;

import java.awt.Graphics;
import java.awt.event.*;

import objects.IDrawable;

/**
 * XXX EZ NEM KIPRÓBÁLT, lehet tök szar
 * http://www.gamedev.net/page/resources/_/technical/general-programming/java-games-keyboard-and-mouse-r2439
 * 
 * @author Ács Ádám
 * 2012.07.15.
 */
public class Mouse implements MouseListener, MouseMotionListener, IDrawable {
	private MouseState mouseState;
	private boolean boxSelection = false;
	
	public Mouse() {
		MouseButtonState[] poll = new MouseButtonState[MouseButtons.getCount()];
		for (int i = 0; i < MouseButtons.getCount(); ++i) {
			poll[i] = MouseButtonState.RELEASED;
		}
		mouseState = new MouseState(this, new boolean[MouseButtons.getCount()], poll);
	}
	
	public MouseState getState() {
		return mouseState;
	}

	public synchronized  void poll() {
		// Check each mouse button
		for (int i = 0; i < MouseButtons.getCount(); i++) {
			// If the button is down for the first
			// time, it is ONCE, otherwise it is
			// PRESSED.  
			if (mouseState.state[i]) {
				if (mouseState.poll[i] == MouseButtonState.RELEASED) {
					mouseState.poll[i] = MouseButtonState.ONCE;
				} else {
					mouseState.poll[i] = MouseButtonState.PRESSED;
				}
			} else {
				// button is not down
				mouseState.poll[i] = MouseButtonState.RELEASED;
			}
		}
	}

	public boolean buttonDownOnce(MouseButtons button) {
		return mouseState.poll[button.getNum() - 1] == MouseButtonState.ONCE;
	}

	public boolean buttonDown(MouseButtons button) {
		return mouseState.poll[button.getNum() - 1] == MouseButtonState.ONCE ||
				mouseState.poll[button.getNum() - 1] == MouseButtonState.PRESSED;
	}

	@Override
	public synchronized void mousePressed(MouseEvent e) {
		mouseState.state[e.getButton() - 1] = true;
		mouseState.updatePos(e.getX(), e.getY());
		boxSelection = true;
	}

	@Override
	public synchronized void mouseReleased(MouseEvent e) {
		mouseState.state[e.getButton() - 1] = false;
		boxSelection = false;
	}

	@Override
	public synchronized void mouseEntered(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public synchronized void mouseExited(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public synchronized void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	/* FIXME emiatt nem mûködik az unit move, ha a camera mozog, ez Túl nagy értéket ad vissza */
	@Override
	public synchronized void mouseMoved(MouseEvent e) {
		mouseState.currentPos = new Vector2(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Not needed
	}
	
	boolean isBoxSelection() {
		return boxSelection;
	}

	@Override
	public void draw(Graphics g) {
		mouseState.draw(g);
	}
}
