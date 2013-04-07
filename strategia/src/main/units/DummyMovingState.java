package units;

import input.MouseButtonState;
import input.MouseState;

import java.awt.Graphics;
import java.util.List;

import algorithm.astar.PathFinder;

import camera.Camera;

import map.TileMap;
import math.Vector2;

import components.animation.Animation;
import components.animation.AnimationFactory;
import config.Config;

import units.unitstates.Unit;
import units.unitstates.UnitState;

/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public class DummyMovingState extends UnitState {
	private DummyUnit valaminev;
	public Vector2 currentTargetSquare; /* XXX ehelyett kell majd az egér pozíciója */

	
	public DummyMovingState(Unit unit) {
		super(unit);
		valaminev = (DummyUnit)unit;
		currentTargetSquare = TileMap.getSquareAtPixel(valaminev.getWorldPos());
	}
	
	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		anim.update(gameTime);
		
		move();
	}

	@Override
	public void draw(Graphics g) {
		anim.draw(g);
		
		
		
		g.drawRect(TileMap.getTile(2, 1).getScreenPos().getX(), TileMap.getTile(2, 1).getScreenPos().getY(), 40, 40);
	}

	@Override
	protected Animation loadAnimation() {
		return AnimationFactory.createAnimation("animations\\test\\animation.xml");
	}
	
	/**
	 * FIXME ez teljesen szar most :D
	 */
	void move() {
		int speed = 20; /* fontos hogy osztható legyen tilesize-al */
		
		if (!unit.getPath().isEmpty() && unit.getPath().size() == 0) {
			unit.setCurrentState(valaminev.getStandingState());
		}
		
		System.out.println(TileMap.getTile(2, 1).isCollidable());
		
		determineMoveDirection();
		
		Vector2 from = unit.getWorldPos();
		Vector2 to = TileMap.asPixelPos(currentTargetSquare); //unit.getPath().get(unit.getPath().size()-1);
		
		if (from.getX() < to.getX()) {
			unit.addToWorldPos(new Vector2(speed, 0));
		}
		if (from.getX() > to.getX()) {
			unit.addToWorldPos(new Vector2(-speed, 0));
		}
		if (from.getY() < to.getY()) {
			unit.addToWorldPos(new Vector2(0, speed));
		}
		if (from.getY() > to.getY()) {
			unit.addToWorldPos(new Vector2(0, -speed));
		}
		
//		/* ha elértünk valahová, akkor kiszedjük a listából */
//		if (unit.getWorldPos().equals(Camera.screenToWorld(unit.getPath().get(unit.getPath().size()-1)))) {
//			unit.getPath().remove(unit.getPath().size() - 1);
//		}
	}
	
	private Vector2 getNewTargetSquare() {
		List<Vector2> path = PathFinder.findPath(TileMap.getSquareAtPixel(valaminev.getWorldPos()), TileMap.getSquareAtPixel(valaminev.getDest()));

		
		
		
	if (path.size() > 2) {
		return new Vector2(path.get(1).getX(), path.get(1).getY());
	}
	
	
	
		/* XXX ez az if heggesztés */
	if (path.size() == 2) {
		return new Vector2(path.get(0).getX(), path.get(0).getY());
	}


		return TileMap.getSquareAtPixel(valaminev.getWorldPos());
	}
	

	private Vector2 determineMoveDirection() {
		if (reachedTargetSquare()) {
			currentTargetSquare = getNewTargetSquare();
		}
		
		/* XXX ez nincs is használva */
		Vector2 squareCenter = Camera.screenToWorld(currentTargetSquare);

		return squareCenter.subtract(valaminev.getDest());
	}

	private boolean reachedTargetSquare()
	{
		/* csak akkor nézi meg, ha egészen a pixelen van az unit */
		if (valaminev.getScreenPos().getX() % Config.TILE_WIDTH == 0 && valaminev.getScreenPos().getY() % Config.TILE_HEIGHT == 0) {
			return (Vector2.distance(TileMap.getSquareAtPixel(valaminev.getScreenPos()), (currentTargetSquare)) == 0.0f);
		}
		
		return false;
	}

	@Override
	public void onMouseInput(MouseState mouseState) {
		if (mouseState.getRightButtonState().equals(MouseButtonState.PRESSED)) {
			valaminev.setDest(Camera.screenToWorld(mouseState.getPos()));
//			valaminev.setPath(PathFinder.findPath(TileMap.getSquareAtPixel(valaminev.getWorldPos()), TileMap.getSquareAtPixel(valaminev.getDest())));
//			if (!valaminev.getPath().isEmpty()) {
//				System.out.println(valaminev.getPath().toString());
//			}
		}
	}
}
