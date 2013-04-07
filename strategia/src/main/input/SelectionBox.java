package input;

import java.awt.Graphics;
import java.awt.Rectangle;

import objects.IDrawable;

/**
 * 
 * @author Ács Ádám
 * 2012.08.27.
 */
public class SelectionBox implements IDrawable {
	private int x;
	private int y;
	
	private MouseState mouseState;
	
	public SelectionBox(MouseState mouseState) {
		this.mouseState = mouseState;
	}
	
	@Override
	public void draw(Graphics g) {
		if(mouseState.isBoxSelection() && x == mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			g.drawRect(x, y, 1, 1);
		}
		//délkelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			g.drawRect(x, y, mouseState.getPos().getX() - x, mouseState.getPos().getY() - y);
		}
		//északkelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(x, mouseState.getPos().getY(), mouseState.getPos().getX() - x, y - mouseState.getPos().getY());
		}
		//délnyugat
		else if(mouseState.isBoxSelection() && x > mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), y, x - mouseState.getPos().getX(), mouseState.getPos().getY() - y);
		}
		//északnyugat
		else if(mouseState.isBoxSelection() && x > mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), y - mouseState.getPos().getY());
		}
		//észak
		else if(mouseState.isBoxSelection() && x == mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), mouseState.getPos().getY(), 1, y - mouseState.getPos().getY());
		}
		//kelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			g.drawRect(x, y, mouseState.getPos().getX() - x, 1);
		}
		//dél
		else if(mouseState.isBoxSelection() && x == mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			g.drawRect(x, y, 1, mouseState.getPos().getY() - y);
		}
		//nyugat
		else if(mouseState.isBoxSelection() && x > mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), 1);
		}
	}

	public Rectangle getRectangle() {
		Rectangle rectangle = new Rectangle();
		if(x == mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			//System.out.println("getRectangle() - elseif : " + x + ", " + y + ", " + mouseState.getPos().getX() + ", " + mouseState.getPos().getY());
			rectangle = new Rectangle(x, y, 1, 1);
		}
		//délkelet
		else if(x < mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			rectangle = new Rectangle(x, y, mouseState.getPos().getX() - x, mouseState.getPos().getY() - y);
		}
		//északkelet
		else if(x < mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(x, mouseState.getPos().getY(), mouseState.getPos().getX() - x, y - mouseState.getPos().getY());
		}
		//délnyugat
		else if(x > mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), y, x - mouseState.getPos().getX(), mouseState.getPos().getY() - y);
		}
		//északnyugat
		else if(x > mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), y - mouseState.getPos().getY());
		}
		//észak
		else if(x == mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), mouseState.getPos().getY(), 1, y - mouseState.getPos().getY());
		}
		//kelet
		else if(x < mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			rectangle = new Rectangle(x, y, mouseState.getPos().getX() - x, 1);
		}
		//dél
		else if(x == mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			rectangle = new Rectangle(x, y, 1, mouseState.getPos().getY() - y);
		}
		//nyugat
		else if(x > mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), 1);
		}
		return rectangle; 
	}
	
	public void updatePos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
