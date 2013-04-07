package game.screenmanager;

import game.core.Program;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import config.Config;

/**
 * bucky tutorial screenmanagerje
 * 
 * @author Ács Ádám
 * 2012.08.15.
 */
public class ScreenManager {
	private GraphicsDevice vc;
	private Program program;
	
	public ScreenManager(Program program) {
		this.program = program;
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = ge.getDefaultScreenDevice();
		
		DisplayMode dm = findFirstCompatibleDisplayMode(Config.DISPLAY_MODES);
		
		setFullScreen(dm);
	}
	
	public DisplayMode[] getCompatibleDisplayModes() {
		return vc.getDisplayModes();
	}
	
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
		if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
			return false;
		}
		if (m1.getBitDepth() != 32 && m2.getBitDepth() != 32) { /* XXX itt átírtam a 32-õt DisplayMode.BIT_DEp rõl*/
			return false;
		}
		if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN) {
			return false;
		}
		
		return true;
	}
	
	public DisplayMode findFirstCompatibleDisplayMode(DisplayMode modes[]) {
		DisplayMode goodModes[] = vc.getDisplayModes();
		for (int x = 0; x < modes.length; x++) {
			for (int y = 0; y < goodModes.length; y++) {
				if (displayModesMatch(modes[x], goodModes[y])) {
					return modes[x];
				}
			}
		}
		
		return null;
	}
	
	public DisplayMode getCurrentDisplayMode() {
		return vc.getDisplayMode();
	}
	
	/**
	 * Ha meghívjuk teljes képernyõre teszi a játékot.
	 */
	public void setFullScreen(DisplayMode displayMode) {
		program.dispose();
		program.setIgnoreRepaint(true);
		program.setUndecorated(true);
		program.setResizable(false);
		vc.setFullScreenWindow(program);
		
		if (displayMode != null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(displayMode);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			program.createBufferStrategy(2);
		}
		
		program.setVisible(true);
	}
	
	public Graphics2D getGraphics() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			BufferStrategy bs = w.getBufferStrategy();
			return (Graphics2D) bs.getDrawGraphics();
		}
		
		return null;
	}
	
	
	public void update() {
		Window w = vc.getFullScreenWindow();
		
		if (w != null) {
			BufferStrategy bs = w.getBufferStrategy();
			if (!bs.contentsLost()) {
				bs.show();
			}
		}
	}
	
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}
	
	public int getWidth() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			return w.getWidth();
		}
		
		return 0;
	}
	
	public int getHeight() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			return w.getHeight();
		}
		
		return 0;
	}
	
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			w.dispose();
		}
		
		vc.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibleImage(int width, int height, int transparency) {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			GraphicsConfiguration gc = w.getGraphicsConfiguration();
			return gc.createCompatibleImage(width, height, transparency);
		}
		
		return null;
	}
}
