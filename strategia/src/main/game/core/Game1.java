package game.core;

import game.*;
import input.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author �cs �d�m
 * @version 2012.08.09
 */
public class Game1 extends Game {
	private AbstractGameState loadingState;
	private AbstractGameState exitState;
	private AbstractGameState menuState;
	private AbstractGameState playingState;
	private AbstractGameState worldMapState;
	private AbstractGameState optionsState;

	private AbstractGameState state;
	
	private static final List<IMouseObserver> mouseObservers = new ArrayList<>();
	
	private static Keyboard keyboard = new Keyboard();
	private static Mouse mouse = new Mouse();

	public Game1(Program program) {
		super(program);
		setIgnoreRepaint(true);
		
		setLayout(null);
		
		optionsState = new OptionsState(this);
		exitState = new ExitState(this);
		loadingState = new LoadingState(this);
		menuState = new MenuState(this);
		playingState = new PlayingState(this);
		worldMapState = new WorldMapState(this);
	
		program.addKeyListener(keyboard);
		addKeyListener(keyboard);
		
		addMouseListener(mouse);
		program.addMouseListener(mouse);
		
		addMouseMotionListener(mouse);
		program.addMouseMotionListener(mouse);
		
	}
	
	/**
	 * ha regisztr�lunk, automatikusan megkapjuk az eg�r �llapot�t
	 * @param obs
	 */
	public static final void registerMouseObserver(IMouseObserver obs) {
		mouseObservers.add(obs);
		obs.updateMouse(mouse.getState());
	}
	
	/**
	 * leregisztr�lunk az eg�r figyel�s�r�l
	 * @param obs
	 */
	public static final void removeMouseObserver(IMouseObserver obs) {
		mouseObservers.remove(obs);
	}
	
	/**
	 * �rtes�ti az observereket a v�ltoz�sr�l
	 */
	private static final void notifyMouseObservers() {
		for (IMouseObserver obs : mouseObservers) {
			obs.updateMouse(mouse.getState());
		}
	}
	
	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getLoadingState() {
		return loadingState;
	}

	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getExitState() {
		return exitState;
	}
	
	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getMenuState() {
		return menuState;
	}
	
	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	public final AbstractGameState getPlayingState() {
		return playingState;
	}
	
	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getWorldMapState() {
		return worldMapState;
	}
	
	/**
	 * package private, mert k�v�lr�l nem szabad h�vnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getOptionsState() {
		return optionsState;
	}
	

	
	public final void setState(AbstractGameState state) {
		this.removeAll(); /* leszedi az �sszes componenst */
		this.state = state;
		state.onSet();
	}
	
	/**
	 * Minden state init-j�t megh�vja, �gy a j�t�k elej�n bet�lt�dik minden. El�sz�r a loading state lesz megjelen�tve
	 * a v�g�n pedig �tadja a vez�rl�st a men� state-nek. Innent�l a statek m�r �n�ll�an tudnak gondoskodni magukr�l.
	 */
	@Override
	public void init() {
		state = loadingState;
		loadingState.init();
		
		menuState.init();
		exitState.init();
		playingState.init();
		worldMapState.init();
		optionsState.init();
		
		setState(worldMapState);
	}

	@Override
	public void update(long gameTime) {
		Keyboard.poll();
		mouse.poll();
		notifyMouseObservers();
		state.update(gameTime);
		
	}

	@Override
	public void draw(Graphics g) {		
		state.draw(g);
		mouse.draw(g);
	}
	
	/**
	 * TODO csak a j�t�k tesztel�s�hez van r� sz�ks�g. az 1, 2, 3, 4 gombok megnyom�s�ra k�l�nb�z� statekbe ker�l a j�t�k
	 * ez term�szetesen nem �gy lesz, de k�nnyebb k�perny�ket v�ltogatni most
	 */
	public void switchScreens() {
		if (Keyboard.keyDown(KeyEvent.VK_2)) {
			setState(getMenuState());
		} 
	else if (Keyboard.keyDown(KeyEvent.VK_3)) {
			setState(getLoadingState());
			System.out.println("loading");
		}  else if (Keyboard.keyDown(KeyEvent.VK_4)) {
			setState(getExitState());
		}  else if (Keyboard.keyDown(KeyEvent.VK_5)) {
			setState(getWorldMapState());
			System.out.println("worldmap");
		}  else if (Keyboard.keyDown(KeyEvent.VK_6)) {
			setState(getOptionsState());
			System.out.println("options");
		} else if (Keyboard.keyDown(KeyEvent.VK_9)) {
			
			stopGame();
		} 
		
		
	}
}
