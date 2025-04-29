package catchGame;

import catchGame.manage.GameManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GameManager manager = new GameManager();
		manager.runGame();
	}
}
