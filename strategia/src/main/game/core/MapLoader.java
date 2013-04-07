package game.core;

import objects.buildings.Building;
import objects.buildings.house.House;
import objects.units.Unit;
import objects.units.dummy.DummyUnit;
import map.TileMap;
import math.Vector2;
import player.LocalPlayer;
import player.managers.PlayerManager;
import game.PlayingState;

/**
 * Bet�lti egy k�ls� map f�jlb�l a tartalmat, elhelyezi a j�t�kosokat, hozz�juk rendeli az egys�geket, �p�leteket.
 * Kb akkor kell lefutnia, amikor egy map f�jl-t kiolvasunk �s a t�rk�pen megnyomjuk az ind�t� gombot.
 * 
 * @author �cs �d�m
 * 2012.08.26.
 */
public class MapLoader {
	private PlayingState playingState;
	private PlayerManager playerManager;
	private TileMap tileMap;
	
	public MapLoader(PlayingState playingState) {
		this.playingState = playingState;
		playerManager = playingState.getPlayerManager();
		tileMap = playingState.getTileMap();
		
	}

	/**
	 * XXX dummy
	 */
	public void loadMap() {
		playerManager.add(new LocalPlayer());
		Unit dummy1 = new DummyUnit(new Vector2(0, 40));
		dummy1.init();
		
		playerManager.get(0).add(dummy1);
		Unit dummy2 = new DummyUnit(new Vector2(80, 80));
		dummy2.init();
		playerManager.get(0).add(dummy2);
		
		Unit dummy3 = new DummyUnit(new Vector2(160, 80));
		dummy3.init();
		playerManager.get(0).add(dummy3);
		
		Building house = new House(new Vector2(3, 4));
		TileMap.add(house);
	}
}
