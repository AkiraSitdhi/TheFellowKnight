package logic;

import gui.GamePane;
import gui.GameScreen;
import gui.StatPane;

public class GameSystem {

	public static GameSystem instance = new GameSystem();
	
	public GamePane gamePane;
	public GameScreen gameScreen;
	public StatPane statPane;
	
	
	public static GameSystem getInstance() {
		return instance;
	}
	
}
