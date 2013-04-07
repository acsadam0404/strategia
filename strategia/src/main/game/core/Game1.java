package game.core;

import game.*;
import input.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ács Ádám
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
	 * ha regisztrálunk, automatikusan megkapjuk az egér állapotát
	 * @param obs
	 */
	public static final void registerMouseObserver(IMouseObserver obs) {
		mouseObservers.add(obs);
		obs.updateMouse(mouse.getState());
	}
	
	/**
	 * leregisztrálunk az egér figyelésérõl
	 * @param obs
	 */
	public static final void removeMouseObserver(IMouseObserver obs) {
		mouseObservers.remove(obs);
	}
	
	/**
	 * értesíti az observereket a változásról
	 */
	private static final void notifyMouseObservers() {
		for (IMouseObserver obs : mouseObservers) {
			obs.updateMouse(mouse.getState());
		}
	}
	
	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getLoadingState() {
		return loadingState;
	}

	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getExitState() {
		return exitState;
	}
	
	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getMenuState() {
		return menuState;
	}
	
	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	public final AbstractGameState getPlayingState() {
		return playingState;
	}
	
	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getWorldMapState() {
		return worldMapState;
	}
	
	/**
	 * package private, mert kívülrõl nem szabad hívnunk, a statek kezelik magukat
	 * @return state
	 */
	final AbstractGameState getOptionsState() {
		return optionsState;
	}
	

	
	public final void setState(AbstractGameState state) {
		this.removeAll(); /* leszedi az összes componenst */
		this.state = state;
		state.onSet();
	}
	
	/**
	 * Minden state init-jét meghívja, így a játék elején betöltõdik minden. Elõször a loading state lesz megjelenítve
	 * a végén pedig átadja a vezérlést a menü state-nek. Innentõl a statek már önállóan tudnak gondoskodni magukról.
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
	 * TODO csak a játék teszteléséhez van rá szükség. az 1, 2, 3, 4 gombok megnyomására különbözõ statekbe kerül a játék
	 * ez természetesen nem így lesz, de könnyebb képernyõket váltogatni most
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
