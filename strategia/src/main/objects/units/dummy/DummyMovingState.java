package objects.units.dummy;

import input.MouseButtonState;
import input.MouseState;

import java.awt.Graphics;
import java.util.List;


import objects.Direction;
import objects.units.Unit;
import objects.units.UnitState;

import algorithm.astar.PathFinder;

import camera.Camera;

import map.TileMap;
import math.Vector2;

import components.animation.Animation;
import components.animation.AnimationFactory;
import config.Config;


/**
 * 
 * @author Ács Ádám
 * 2012.07.31.
 */
public class DummyMovingState extends UnitState {
	private DummyUnit valaminev;
	public Vector2 currentTargetSquare; 
	
	private Animation north;
	private Animation west;
	private Animation south;
	private Animation east;
	private Animation northwest;
	private Animation southwest;
	private Animation northeast;
	private Animation southeast;
	
	public DummyMovingState(Unit unit) {
		super(unit);
		valaminev = (DummyUnit) unit;
		currentTargetSquare = TileMap.getSquareAtPixel(valaminev.getWorldPos());
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void update(long gameTime) {
		valaminev.getAnimation().update(gameTime);

		move();
	}

	private void determineAnimation() {
		if (valaminev.getDirection().equals(Direction.NORTH)) {
			valaminev.setAnimation(north);
		}
		else if (valaminev.getDirection().equals(Direction.SOUTH)) {
			valaminev.setAnimation(south);
		}
		else if (valaminev.getDirection().equals(Direction.SOUTHWEST)) {
			valaminev.setAnimation(southwest);
		}
		else if (valaminev.getDirection().equals(Direction.SOUTHEAST)) {
			valaminev.setAnimation(southeast);
		}
		else if (valaminev.getDirection().equals(Direction.EAST)) {
			valaminev.setAnimation(east);
		}
		else if (valaminev.getDirection().equals(Direction.WEST)) {
			valaminev.setAnimation(west);
		}
		else if (valaminev.getDirection().equals(Direction.NORTHEAST)) {
			valaminev.setAnimation(northeast);
		}
		else if (valaminev.getDirection().equals(Direction.NORTHWEST)) {
			valaminev.setAnimation(northwest);
		}
	}

	@Override
	public void draw(Graphics g) {
		valaminev.getAnimation().draw(g);
	}

	@Override
	protected void loadAnimation() {
		south = AnimationFactory.createAnimation("animations\\test\\south.xml");
		south.setContainer(valaminev);
		
		north = AnimationFactory.createAnimation("animations\\test\\north.xml");
		north.setContainer(valaminev);
		
		west = AnimationFactory.createAnimation("animations\\test\\west.xml");
		west.setContainer(valaminev);
		
		east = AnimationFactory.createAnimation("animations\\test\\east.xml");
		east.setContainer(valaminev);
		
		northeast = AnimationFactory.createAnimation("animations\\test\\northeast.xml");
		northeast.setContainer(valaminev);
		
		northwest = AnimationFactory.createAnimation("animations\\test\\northwest.xml");
		northwest.setContainer(valaminev);
		
		southwest = AnimationFactory.createAnimation("animations\\test\\southwest.xml");
		southwest.setContainer(valaminev);
		
		southeast = AnimationFactory.createAnimation("animations\\test\\southeast.xml");
		southeast.setContainer(valaminev);
	}

	void move() {
		int speed = 2; /* fontos hogy osztható legyen tilesize-al */

		determineMoveDirection();

		Vector2 from = unit.getWorldPos();
		Vector2 to = TileMap.asPixelPos(currentTargetSquare); 

		Vector2 vec = new Vector2(0, 0);
		if (from.getX() < to.getX()) {
//			unit.addToWorldPos(new Vector2(speed, 0));
			vec = vec.add(new Vector2(speed, 0));
		}
		else if (from.getX() > to.getX()) {
//			unit.addToWorldPos(new Vector2(-speed, 0));
			vec = vec.add(new Vector2(-speed, 0));
		}
		if (from.getY() < to.getY()) {
//			unit.addToWorldPos(new Vector2(0, speed));
			vec = vec.add(new Vector2(0, speed));
		}
		else if (from.getY() > to.getY()) {
//			unit.addToWorldPos(new Vector2(0, -speed));
			vec = vec.add(new Vector2(0, -speed));
		}
		unit.addToWorldPos(vec);
		
		if (from.equals(to)) {
			unit.setState(valaminev.getStandingState());
		}
		
		
		vec = vec.normalize();
		

		
		valaminev.setDirection(Direction.getDirectionByVector(vec));
		determineAnimation();
	}

	private Vector2 getNewTargetSquare() {
		List<Vector2> path = PathFinder.findPath(TileMap.getSquareAtPixel(valaminev.getWorldPos()), TileMap.getSquareAtPixel(valaminev.getDest()));

		if (path.size() > 1) {
			return new Vector2(path.get(path.size()-2).getX(), path.get(path.size()-2).getY()); /* az utolsó elõttit adja vissza */
		}

		if (path.size() == 1) {
			return new Vector2(path.get(0).getX(), path.get(0).getY());
		}

		return TileMap.getSquareAtPixel(valaminev.getWorldPos());
	}

	private void determineMoveDirection() {
		if (reachedTargetSquare()) {
			currentTargetSquare = getNewTargetSquare();
		}
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
//			valaminev.setDest(Camera.screenToWorld(mouseState.getPos()));
			valaminev.setDest(Camera.worldToScreen(mouseState.getPos().add(Camera.getPosition()))); /* XXX tesztelni */
			System.out.println(mouseState.getPos());
		}
	}

	@Override
	public void onSet() {
		valaminev.setAnimation(south);
	}
}
