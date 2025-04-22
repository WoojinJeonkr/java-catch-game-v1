package catchGame;

import catchGame.manage.GameManager;
import catchGame.map.mapExploring;

public class Main {

	public static void main(String[] args) {
		GameManager manager = new GameManager();
		mapExploring map = new mapExploring();
		manager.runGame();
	}

}
