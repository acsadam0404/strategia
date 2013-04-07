package algorithm.astar;

import map.TileMap;
import math.MathHelper;
import math.Vector2;

/**
 * 
 * @author Ács Ádám
 * 2012.07.22.
 */
public class PathNode {
	PathNode parentNode;
	PathNode endNode;
	private Vector2 gridLocation;
	float totalCost;
	float directCost;

	public PathNode(PathNode parentNode, PathNode endNode, Vector2 gridLocation, float cost) {
		this.parentNode = parentNode;
		this.gridLocation = gridLocation;
		this.endNode = endNode;
		this.directCost = cost;

		if (endNode != null) {
			totalCost = directCost + linearCost();
		}

	}

	private float linearCost() {
		return Vector2.distance(endNode.getGridLocation(), gridLocation);
	}

	public Vector2 getGridLocation() {
		return gridLocation;
	}

	public void setGridLocation(Vector2 pos) {

		gridLocation = new Vector2(
				MathHelper.clamp(pos.getX(), 0, TileMap.getWidth()),
				MathHelper.clamp(pos.getY(), 0, TileMap.getHeight()));
	}

	public int getGridX() {
		return gridLocation.getX();
	}

	public int getGridY() {
		return gridLocation.getY();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gridLocation == null) ? 0 : gridLocation.hashCode());

		return result;
	}

	/**
	 * két PathNode-ot összehasonlít a gridLocation szerint
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		PathNode other = (PathNode) obj;
		if (gridLocation == null) {
			if (other.gridLocation != null) {
				return false;
			}
		} else if (!gridLocation.equals(other.gridLocation)) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return getGridLocation().toString();
	}

}
