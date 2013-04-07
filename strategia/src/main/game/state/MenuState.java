package game.state;

import game.core.Game1;
import gui.*;

import java.awt.*;

import javax.swing.ImageIcon;

import components.audio.AudioData;
import components.audio.AudioHandler;

import math.Vector2;


/**
 * a men� screeneket kezeli
 * @author �cs �d�m
 * 2012.07.01.
 */
public class MenuState extends GameState {
	private Palette testPalette = new Palette();
	private GameButton testButton;
	private Background testBackground;
	private AudioHandler audioHandler;
	public MenuState(Game1 game) {
		super(game);
	}
	
	@Override
	public void init() {
		  AudioData audioData = new AudioData("sounddata\\test\\menu.txt");
	        //System.out.println("Main(): " + audioData.getSounds().keySet() + " " + audioData.getSounds().values());
	        //audioData.playSound("scream");
		
	        audioHandler = new AudioHandler(audioData);
//	        audioHandler.playSound("main");
	        
		testBackground = new Background("images\\test\\backgro.png");
		testButton = new GameButton("test");
//		testButton = new GameButton("button", new ImageIcon("images\\test\\uto25x70.png"));
//		testButton.setPosition(new Vector2(50, 50));
//		testButton.setSize(new Vector2(200, 50));
	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}

	@Override
	public void draw(Graphics g) {
		testBackground.draw(g);
		testPalette.draw(g);
		testButton.draw(g);
	}

	@Override
	public void checkKeyBoardInput() {
		game.switchScreens();
		
	}

	@Override
	protected void checkMouseInput() {

	}
}
