package game.options;

import game.OptionsState;
import gui.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;

import math.Vector2;
import config.Config;

/**
 * 
 * @author Varga Péter
 * 2012.08.21.
 */
public class DisplayState extends AbstractOptionsState {
	private GRadioButton resolution768p;
	private GRadioButton resolution1080p;
	private ButtonGroup resolutions;
	
	private GRadioButton window;
	private GRadioButton fullScreen;
	private ButtonGroup modes;
	
	GButton test;
	
	public DisplayState(OptionsState optionsState) {
		super(optionsState);
	}
	
	@Override
	public void init(){
		resolution768p = new GRadioButton("768p", new Vector2(100, 300), GRadioButtonSize.SMALL, setSelectedResolutionTo768p);
		resolution1080p = new GRadioButton("1080p", new Vector2(100, 350), GRadioButtonSize.SMALL, setSelectedResolutionTo1080p);
		resolutions = new ButtonGroup();
		resolutions.add(resolution768p);
		resolutions.add(resolution1080p);
		resolutions.setSelected(resolution768p, true);
		test = new GButton("asd", new Vector2(200, 200), GButtonSize.MEDIUM, null);
		
		window = new GRadioButton("Window mode", new Vector2(100, 500), GRadioButtonSize.SMALL, setSelectedModeToWindow);
		fullScreen = new GRadioButton("Full screen", new Vector2(100, 550), GRadioButtonSize.SMALL, setSelectedModeToFullScreen);
		modes = new ButtonGroup();
		modes.add(window);
		modes.add(fullScreen);
		modes.setSelected(window, true);
		
	}
	
	private AbstractAction setSelectedResolutionTo768p = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resolution768p.setSelected(true);
		}
	};
	
	private AbstractAction setSelectedResolutionTo1080p = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resolution1080p.setSelected(true);
		}
	};
	
	private AbstractAction setSelectedModeToWindow = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			window.setSelected(true);
		}
	};
	
	private AbstractAction setSelectedModeToFullScreen = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			fullScreen.setSelected(true);
		}
	};

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.drawString("Options menu - Display", 10, 10);
		
		g.drawString("Resolutions", 100, 250);
		resolution768p.draw(g);
		g.drawString("1366 x 768", resolution768p.getX()+50, resolution768p.getY()+(resolution768p.getHeight()/2));
		resolution1080p.draw(g);
		g.drawString("1920 x 1080", resolution1080p.getX()+50, resolution1080p.getY()+(resolution1080p.getHeight()/2));
		
		g.drawString("Modes", 100, 450);
		window.draw(g);
		g.drawString("Window mode", window.getX()+50, window.getY()+(window.getHeight()/2));
		fullScreen.draw(g);
		g.drawString("Full screen", fullScreen.getX()+50, fullScreen.getY()+(fullScreen.getHeight()/2));
		
		g.drawString("Brightness", Config.SCREEN_WIDTH/2, 250);
		g.drawString("Ide jönne egy JSlider", Config.SCREEN_WIDTH/2, 300);
		
		test.draw(g);
		
	}
	
	@Override
	public void onSet() {
		options.add(resolution768p);
		options.add(resolution1080p);
		options.add(window);
		options.add(fullScreen);
		
		options.add(test);
		
	}

	@Override
	public void update(long gameTime) {
		// TODO Auto-generated method stub
	}

}
