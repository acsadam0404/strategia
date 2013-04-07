package input;

import java.awt.Graphics;
import java.awt.Rectangle;

import objects.IDrawable;

/**
 * 
 * @author �cs �d�m
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
		//d�lkelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			g.drawRect(x, y, mouseState.getPos().getX() - x, mouseState.getPos().getY() - y);
		}
		//�szakkelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(x, mouseState.getPos().getY(), mouseState.getPos().getX() - x, y - mouseState.getPos().getY());
		}
		//d�lnyugat
		else if(mouseState.isBoxSelection() && x > mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), y, x - mouseState.getPos().getX(), mouseState.getPos().getY() - y);
		}
		//�szaknyugat
		else if(mouseState.isBoxSelection() && x > mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), y - mouseState.getPos().getY());
		}
		//�szak
		else if(mouseState.isBoxSelection() && x == mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			g.drawRect(mouseState.getPos().getX(), mouseState.getPos().getY(), 1, y - mouseState.getPos().getY());
		}
		//kelet
		else if(mouseState.isBoxSelection() && x < mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			g.drawRect(x, y, mouseState.getPos().getX() - x, 1);
		}
		//d�l
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
		//d�lkelet
		else if(x < mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			rectangle = new Rectangle(x, y, mouseState.getPos().getX() - x, mouseState.getPos().getY() - y);
		}
		//�szakkelet
		else if(x < mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(x, mouseState.getPos().getY(), mouseState.getPos().getX() - x, y - mouseState.getPos().getY());
		}
		//d�lnyugat
		else if(x > mouseState.getPos().getX() && y < mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), y, x - mouseState.getPos().getX(), mouseState.getPos().getY() - y);
		}
		//�szaknyugat
		else if(x > mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), mouseState.getPos().getY(), x - mouseState.getPos().getX(), y - mouseState.getPos().getY());
		}
		//�szak
		else if(x == mouseState.getPos().getX() && y > mouseState.getPos().getY()){
			rectangle = new Rectangle(mouseState.getPos().getX(), mouseState.getPos().getY(), 1, y - mouseState.getPos().getY());
		}
		//kelet
		else if(x < mouseState.getPos().getX() && y == mouseState.getPos().getY()){
			rectangle = new Rectangle(x, y, mouseState.getPos().getX() - x, 1);
		}
		//d�l
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
