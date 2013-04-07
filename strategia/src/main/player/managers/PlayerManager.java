package player.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import objects.IGameLoop;

import player.Player;

/**
 * 
 * @author Ács Ádám
 * 2012.08.26.
 */
public class PlayerManager implements IGameLoop {
	private final static int MAX_PLAYERS = 8;
	
	private List<Player> players = new ArrayList<>();

	public PlayerManager() {
	}

	@Override
	public void init() {
		for (Player player : players) {
			player.init();
		}
	}

	@Override
	public void update(long gameTime) {
		for (Player player : players) {
			player.update(gameTime);
		}
	}

	@Override
	public void draw(Graphics g) {
		for (Player player : players) {
			player.draw(g);
		}
	}

	public Player get(int i) {
		return players.get(i);
	}

	public final void add(Player player) {
		if (players.size() <= MAX_PLAYERS) {
			players.add(player);
		}
	}
}
