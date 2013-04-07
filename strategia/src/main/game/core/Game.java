package game.core;


import java.awt.*;

import javax.swing.JPanel;

import config.Config;

import objects.IGameLoop;

/**
 * A j�t�kciklust implement�lja az oszt�ly, fixed length timestamp alapj�n. Az ebb�l sz�rmaz� oszt�lyoknak k�telez� implement�lni az
 * update(), draw() �s init() f�ggv�nyeket. Legjobb esetben csak egy oszt�ly sz�rmazik bel�le, az lesz a j�t�k alaposzt�lya.
 * 
 * @author �cs �d�m
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

		/* j�t�kciklus */
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
	 * Ez felel a j�t�k inicializ�l�s��rt. A j�t�kciklus el�tt h�v�dik meg. Itt lehet rescourceket bet�lteni, 
	 * oszt�lyok be�ll�tani, alap�rtelmez�seket megadni.
	 */
	@Override
	public abstract void init();

	/**
	 * A j�t�kciklus friss�t� f�ggv�nye, ide lehet a logik�t illeszteni 
	 */
	@Override
	public abstract void update(long gameTime);

	/**
	 * A j�t�kciklus rajzol� f�ggv�nye, itt lehet rajzolni. 
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
