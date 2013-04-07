package game;

import game.core.Game1;
import gui.*;

import input.MouseState;

import java.awt.Graphics;

import components.audio.AudioData;
import components.audio.AudioHandler;


/**
 * a menü screeneket kezeli
 * 
 * @author Ács Ádám
 * @version 2012.08. 09
 */
public class MenuState extends AbstractGameState {
	private Background background;
	private AudioHandler audioHandler;
	
	
	public MenuState(Game1 game) {
		super(game);
	}
	
	@Override
	public void init() {
		AudioData audioData = new AudioData("sounddata\\test\\menu.txt");
	
        audioHandler = new AudioHandler(audioData);
//        audioHandler.playSound("main");
	        
		background = new Background("images\\menu\\main.png");
		
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		
	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();
		
	}

	@Override
	public void checkMouseInput() {

	}

	@Override
	public void updateMouse(MouseState mouseState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSet() {
		System.out.println("MenuState");
	}
}
