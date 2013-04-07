package game.core;

import game.screenmanager.ScreenManager;

import java.io.IOException;

import javax.swing.JFrame;

import config.Config;

/**
 * A main metódust tartalmazó osztály. Ez a program kiindulási pontja. 
 * Beállítja az parancssori paramétereket, elindítja a játékot és láthatóvá teszi.
 * JFrame-bõl származik, tehát a fõ container is ez az osztály.
 * 
 * @author Ács Ádám
 * @version 2012.08.09
 */
public final class Program extends JFrame {
	private ScreenManager screen;
	
	static Game game;
	
	private Program() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		screen = new ScreenManager(this);
		try {
			game = new Game1(this);
			getContentPane().add(game);
			setIgnoreRepaint(true);
		} finally {
			screen.restoreScreen();
		}
	}

	public final ScreenManager getScreenManager() {
		return screen;
	}

	/**
	 * A program belépési pontja. Egyelõre nem támogatja a parancssori paramétereket.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Config.loadConfig("config.xml");
			
			Program program = new Program();
			new Thread(game).start();
			System.err.println("config fájl beolvasása sikeres"); /* TODO logba */
		} catch (IOException ioEx) {
			System.err.println("config fájl beolvasása sikertelen"); /* TODO logba */
		}
	}

	public void exitGame() {
		screen.restoreScreen();
	}
}
