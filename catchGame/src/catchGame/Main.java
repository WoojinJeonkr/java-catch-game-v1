package catchGame;

import catchGame.manage.GameManager;
import catchGame.map.MapExploring;

public class Main {

	public static void main(String[] args) {
		GameManager manager = new GameManager();
		MapExploring map = new MapExploring();
		manager.runGame();
	}

}
