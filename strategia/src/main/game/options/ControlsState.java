package game.options;

import game.OptionsState;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class ControlsState extends AbstractOptionsState {
	public ControlsState(OptionsState optionsState) {
		super(optionsState);
	}
	
	@Override
	public void init(){
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.drawString("Options menu - Controls", 10, 10);
	}

	@Override
	public void update(long gameTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSet() {
	}
}
