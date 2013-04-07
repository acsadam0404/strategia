package algorithm.astar;

import java.util.*;

import map.TileMap;
import math.Vector2;

/**
 * A* algoritmus implementációja
 * 
 * @author Ács Ádám
 * 2012.07.22.
 */
public class PathFinder {
	private static enum NodeStatus {
		OPEN, CLOSED;
	}

	private static Map<Vector2, NodeStatus> nodeStatus = new HashMap<>();

	private static final int COST_STRAIGHT = 10;
	private static final int COST_DIAGONAL = 15;

	private static List<PathNode> openList = new ArrayList<>();
	private static Map<Vector2, Float> nodeCosts = new HashMap<>();

	private static void addNodeToOpenList(PathNode node) {
		int index = 0;
		float cost = node.totalCost;

		while ((openList.size() > index) && (cost < openList.get(index).totalCost)) {
			index++;
		}

		openList.add(index, node);
		nodeCosts.put(node.getGridLocation(), Float.valueOf(node.totalCost));
		nodeStatus.put(node.getGridLocation(), NodeStatus.OPEN);
	}


	/**
	 * XXX ezt át kell majd nézni, (240. oldaltól kb XNA example könyvben)
	 * @param startTile
	 * @param endTile
	 * @return
	 */
	public static List<Vector2> findPath(Vector2 startTile, Vector2 endTile) {
		/* ha a falra megyünk akkor nincs megfelelõ út. a kérdés, hogy mivan ha pl fát vágni megyünk? */
		if (/*TileMap.isCollidable(startTile) || *//*XXX kivettem, mert nem tudom mért tér vissza true-val mindig*/TileMap.isCollidable(endTile)) {
			return Collections.EMPTY_LIST;
		}
		
		openList.clear();
		nodeCosts.clear();
		nodeStatus.clear();
		
		PathNode endNode = new PathNode(null, null, endTile, 0);
		PathNode startNode = new PathNode(null, endNode, startTile, 0);
		addNodeToOpenList(startNode);
		
		while (openList.size() > 0) {
			PathNode currentNode = openList.get(openList.size() - 1);
			
			if (currentNode.equals(endNode)) {
				List<Vector2> bestPath = new ArrayList<>();
				while (currentNode != null) {
					bestPath.add(currentNode.getGridLocation());
					currentNode = currentNode.parentNode;
				}
				return bestPath;
			}
			
			openList.remove(currentNode);
			nodeCosts.remove(currentNode.getGridLocation());
			
			for (PathNode possibleNode : findAdjacentNodes(currentNode, endNode)) {
				if (nodeStatus.containsKey(possibleNode.getGridLocation())) {
					if (nodeStatus.get(possibleNode.getGridLocation()).equals(NodeStatus.CLOSED)) {
						continue;
					}
					if (nodeStatus.get(possibleNode.getGridLocation()).equals(NodeStatus.OPEN)) { 
						if (possibleNode.totalCost >=(nodeCosts.get(possibleNode.getGridLocation())).floatValue()) {
							continue;
						}
					}
				}
		
				addNodeToOpenList(possibleNode);
			}
			
			nodeStatus.put(currentNode.getGridLocation(), NodeStatus.CLOSED);
		}
		return Collections.EMPTY_LIST;
	}
	
	private static List<PathNode> findAdjacentNodes(PathNode currentNode, PathNode endNode) {
		List<PathNode> adjacentNodes = new ArrayList<>();
		
		int x = currentNode.getGridX();
		int y = currentNode.getGridY();
		
		boolean upLeft = true;
		boolean upRight = true;
		boolean downLeft = true;
		boolean downRight = true;
		
		if ((x > 0) && (!TileMap.isCollidable(new Vector2(x-1, y)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x-1, y), COST_STRAIGHT + currentNode.directCost));
		} else {
			upLeft = false;
			downLeft = false;
		}
		
		if ((x < TileMap.getWidth() - 1) && (!TileMap.isCollidable(new Vector2(x + 1, y)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x+1, y), COST_STRAIGHT + currentNode.directCost));
		} else {
			upRight = false;
			downRight = false;
		}
		
		if ((y > 0) && (!TileMap.isCollidable(new Vector2(x, y-1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x, y-1), COST_STRAIGHT + currentNode.directCost));
		} else {
			upLeft = false;
			upRight = false;
		}
		
		if ((y < TileMap.getHeight() - 1) && (!TileMap.isCollidable(new Vector2(x, y+1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x, y+1), COST_STRAIGHT + currentNode.directCost));
		} else {
			downLeft = false;
			downRight = false;
		}
		
		if (upLeft && (!TileMap.isCollidable(new Vector2(x-1, y-1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x-1, y-1), COST_DIAGONAL + currentNode.directCost));
		}
		
		if (upRight && (!TileMap.isCollidable(new Vector2(x+1, y-1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x+1, y-1), COST_DIAGONAL + currentNode.directCost));
		}
		
		if (downLeft && (!TileMap.isCollidable(new Vector2(x-1, y+1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x-1, y+1), COST_DIAGONAL + currentNode.directCost));
		}
		
		if (downRight && (!TileMap.isCollidable(new Vector2(x+1, y+1)))) {
			adjacentNodes.add(new PathNode(currentNode, endNode, new Vector2(x+1, y+1), COST_DIAGONAL + currentNode.directCost));
		}
		
		return adjacentNodes;
	}
}
