package game;

import game.core.Game1;
import game.options.*;
import gui.*;
import input.Keyboard;
import input.MouseState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

import math.Vector2;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class OptionsState extends AbstractGameState {

	private AbstractOptionsState audioState;
	private AbstractOptionsState controlsState;
	private AbstractOptionsState displayState;
	private AbstractOptionsState gameplayState;

	private AbstractOptionsState state;
	
	private GButton audioButton;
	private GButton controlsButton;
	private GButton displayButton;
	private GButton gameplayButton;

	private Background background;

	public OptionsState(Game1 game) {
		super(game);
	}
	
	public void setState(AbstractOptionsState state) {
//		game.removeAll(); /* leszedi az összes componenst */
		this.state = state;
		state.onSet();
	}

	public final AbstractOptionsState getAudioState() {
		return audioState;
	}
	
	public final AbstractOptionsState getControlsState() {
		return controlsState;
	}
	
	public final AbstractOptionsState getDisplayState() {
		return displayState;
	}
	
	public final AbstractOptionsState getGameplayState() {
		return gameplayState;
	}
	
	@Override
	public void init() {
		audioState = new AudioState(this);
		controlsState = new ControlsState(this);
		displayState = new DisplayState(this);
		gameplayState = new GameplayState(this);
		
		background = new Background("images\\optionsMenu\\LeatherHoles-Plain.png");
		audioButton = new GButton("Audio", new Vector2(50, 100), GButtonSize.SMALL, goToAudioOptions);
		controlsButton = new GButton("Controls", new Vector2(250, 100), GButtonSize.SMALL, goToControlsOptions);
		displayButton = new GButton("Display", new Vector2(450, 100), GButtonSize.SMALL, goToDisplayOptions);
		gameplayButton = new GButton("Gameplay", new Vector2(650, 100), GButtonSize.SMALL, goToGameplayOptions);
		

		audioState.init();
		controlsState.init();
		displayState.init();
		gameplayState.init();
		
		setState(displayState);
	}

	private AbstractAction goToAudioOptions = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setState(audioState);
		}
	};
	
	private AbstractAction goToControlsOptions = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setState(controlsState);
		}
	};
	
	private AbstractAction goToDisplayOptions = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setState(displayState);
		}
	};
	
	private AbstractAction goToGameplayOptions = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setState(gameplayState);
		}
	};

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		g.setColor(new Color(255, 0, 0));
		g.drawString("Options menu", 10, 10);
		
		audioButton.draw(g);
		controlsButton.draw(g);
		displayButton.draw(g);
		gameplayButton.draw(g);
		
		state.draw(g);

	}

	@Override
	public void update(long gameTime) {
		super.update(gameTime);
	}
	
	@Override
	public void updateMouse(MouseState mouseState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkMouseInput() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void checkKeyBoardInput() {
		game.switchScreens();
				if (Keyboard.keyDown(KeyEvent.VK_DOWN)) {
					System.out.println("yee");
				}
	}

	@Override
	public void onSet() {
		System.out.println("OptionsState");
		
		game.add(audioButton);
		game.add(controlsButton);
		game.add(displayButton);
		game.add(gameplayButton);
		
		state.onSet();

	}

	public void add(JComponent test) {
		game.add(test);
	}
}
