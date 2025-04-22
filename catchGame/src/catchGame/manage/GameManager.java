package catchGame.manage;

import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.user.User;

public class GameManager {
	Scanner scanner = new Scanner(System.in);

	public void runGame() {
		User user = new User();
		selectMap();

	}

	public void selectMap() {

		MapExploring map = new MapExploring();
		map.mapInput();

	}
}
