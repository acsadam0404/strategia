package math;

import java.awt.geom.Point2D;

/**
 * TODO test int és int konstruktor jól mûködik e összhangban
 * TODO Pointal implementálni nem lenne jobb?
 * 
 * immutable Vector2 osztály
 * 
 * @author Ács Ádám
 * 2012.07.15.
 */
public class Vector2 {
	private int x;
	private int y;
	
	public static final Vector2 ZERO = new Vector2(0, 0);
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Vector2 subtract(Vector2 other) {
		int newX = x - other.getX();
		int newY = y - other.getY();
		
		return new Vector2(newX, newY);
	}
	
	/**
	 * összeadja ezt a vektor-t egy másikkal és visszatér egy új értékkel.
	 * Az eredetit nem változtatja.
	 * @param other
	 * @return
	 */
	public Vector2 add(Vector2 other) {
		int newX = x + other.getX();
		int newY = y + other.getY();
		
		return new Vector2(newX, newY);
	}
	
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static float distance(Vector2 gridLocation, Vector2 gridLocation2) {
		return (float)Point2D.distance(gridLocation.getX(), gridLocation.getY(), gridLocation2.getX(), gridLocation2.getY());
	}

	/**
	 *  FIXME dummy 
	 */
	public Vector2 normalize() {
		double length = Math.sqrt((double)x * x + y * y);
		double newX = x / length;
		double newY = y / length;
		
		int returnX = 0;
		int returnY = 0;
		if (newX < 0d) {
			returnX = -1;
		}
		else if (newX > 0d) {
			returnX = 1;
		}
		if (newY < 0d) {
			returnY = -1;
		}
		else if (newY > 0d) {
			returnY = 1;
		}
		
		return new Vector2(returnX, returnY);

	}	
}
