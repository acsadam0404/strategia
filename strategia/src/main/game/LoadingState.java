package game;

import game.core.Game1;
import gui.DrawableString;
import gui.GPanel;

import input.MouseState;

import java.awt.Color;
import java.awt.Graphics;


/**
 * A betöltõ képernyõ a játék elején.
 * @author Ács Ádám 
 * @version 2012.06.28.
 */
public class LoadingState extends AbstractGameState {
	private DrawableString dstr;
	private GPanel testDecor;
	private DrawableString inputTestString = new DrawableString("", 0, 0);
	
	public LoadingState(Game1 game) {
		super(game);
	}

	@Override
	public void init() {
		
		
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();
	}

	@Override
	public void checkMouseInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseState mouseState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSet() {
		System.out.println("LoadingState");
	}
}
