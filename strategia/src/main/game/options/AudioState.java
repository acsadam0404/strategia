package game.options;

import game.OptionsState;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class AudioState extends AbstractOptionsState {

	public AudioState(OptionsState game) {
		super(game);
	}

	@Override
	public void init() {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.drawString("Options menu - Audio", 10, 10);
		g.drawString("Music volume", 10, 200);
		g.drawString("UI volume", 10, 400);
		g.drawString("... volume", 10, 600);

	}

	@Override
	public void update(long gameTime) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSet() {
	}
}
