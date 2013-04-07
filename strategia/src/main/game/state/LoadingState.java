package game.state;

import game.core.Game1;
import gui.DrawableString;
import gui.Palette;

import java.awt.Color;
import java.awt.Graphics;


/**
 * A bet�lt� k�perny� a j�t�k elej�n.
 * @author �cs �d�m 
 * 2012.06.28.
 */
public class LoadingState extends GameState {
	private DrawableString dstr;
	private Palette testDecor;
	private DrawableString inputTestString = new DrawableString("", 0, 0);
	
	public LoadingState(Game1 game) {
		super(game);
	}

	@Override
	public void init() {
		
		dstr = new DrawableString("kirajzolja", 300, 200);
		dstr.setColor(Color.BLUE);
		dstr.setFontSize(30);
		
		testDecor = new Palette("images\\test\\lightcavalry.png", 300, 300, 200, 200);
		testDecor.addImage("images\\test\\grass2.png", 100,100, 50, 50);
		testDecor.addImage("images\\test\\grass3.png", 200, 200, 50, 50);
		
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		testDecor.draw(g);
		dstr.draw(g);
		inputTestString.draw(g);
		
		
	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();
	}

	@Override
	protected void checkMouseInput() {
		// TODO Auto-generated method stub
		
	}
}
