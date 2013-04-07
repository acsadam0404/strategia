package game.core;


import java.awt.*;

import javax.swing.JPanel;

import config.Config;

import objects.IGameLoop;

/**
 * A játékciklust implementálja az osztály, fixed length timestamp alapján. Az ebbõl származó osztályoknak kötelezõ implementálni az
 * update(), draw() és init() függvényeket. Legjobb esetben csak egy osztály származik belõle, az lesz a játék alaposztálya.
 * 
 * @author Ács Ádám
 * @version 2012.08.09
 */
public abstract class Game extends JPanel implements Runnable, IGameLoop {
	private volatile boolean running = false; /* stops the animation*/
	private volatile boolean gameOver = false;/* for game termination*/
	protected Program program;

	protected Game(Program program) {
		this.program = program;
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
		setSize(new Dimension(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));

	}

	/**
	 *  called by the user to stop execution
	 */
	public void stopGame() {
		program.exitGame();
		running = false;
	}

	/**
	 *  Repeatedly update, render, sleep 
	 */
	@Override
	public void run() {
		running = true;
		DisplayMode dm = program.getScreenManager().findFirstCompatibleDisplayMode(Config.DISPLAY_MODES);
		program.getScreenManager().setFullScreen(dm);
		startGame();

		long startingTime = System.currentTimeMillis();
		long currentTime = startingTime;
		long gameTime = 0;

		/* játékciklus */
		while (running) {
			gameTime = System.currentTimeMillis() - currentTime;
			currentTime += gameTime;

			gameUpdate(gameTime); /*game state is updated*/
			gameRender();/*render to a buffer*/

			try {
				Thread.sleep(20); // sleep a bit
			} catch (InterruptedException ex) { /* empty block */
			}
		}
		System.exit(0); // so enclosing JFrame/JApplet exits
	}

	/**
	 * Ez felel a játék inicializálásáért. A játékciklus elõtt hívódik meg. Itt lehet rescourceket betölteni, 
	 * osztályok beállítani, alapértelmezéseket megadni.
	 */
	@Override
	public abstract void init();

	/**
	 * A játékciklus frissítõ függvénye, ide lehet a logikát illeszteni 
	 */
	@Override
	public abstract void update(long gameTime);

	/**
	 * A játékciklus rajzoló függvénye, itt lehet rajzolni. 
	 */
	@Override
	public abstract void draw(Graphics g);

	private void gameUpdate(long gameTime) {
		update(gameTime);
	}

	private void gameRender() /* draw the current frame to an image buffer */{
		Graphics2D g = program.getScreenManager().getGraphics();
		draw(g);
		
		program.getScreenManager().update();
		g.dispose();
	}

	/* initialise and start the thread*/
	private void startGame() {
		init();
	}

	public boolean isGameEnd() {
		return !running;
	}
}
