package game.core;

import game.screenmanager.ScreenManager;

import java.io.IOException;

import javax.swing.JFrame;

import config.Config;

/**
 * A main met�dust tartalmaz� oszt�ly. Ez a program kiindul�si pontja. 
 * Be�ll�tja az parancssori param�tereket, elind�tja a j�t�kot �s l�that�v� teszi.
 * JFrame-b�l sz�rmazik, teh�t a f� container is ez az oszt�ly.
 * 
 * @author �cs �d�m
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
	 * A program bel�p�si pontja. Egyel�re nem t�mogatja a parancssori param�tereket.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Config.loadConfig("config.xml");
			
			Program program = new Program();
			new Thread(game).start();
			System.err.println("config f�jl beolvas�sa sikeres"); /* TODO logba */
		} catch (IOException ioEx) {
			System.err.println("config f�jl beolvas�sa sikertelen"); /* TODO logba */
		}
	}

	public void exitGame() {
		screen.restoreScreen();
	}
}
