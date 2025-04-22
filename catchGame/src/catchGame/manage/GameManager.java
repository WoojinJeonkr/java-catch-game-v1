package catchGame.manage;

import java.util.Scanner;

public class GameManager {
	Scanner scanner = new Scanner(System.in);

	public void runGame() {
		User user = new User();
		selectMap();
	}

	public void selectMap() {

		System.out.println("[ 맵 선택 ] 맵을 선택하세요.");
		System.out.println("1. 바다 | 2. 산 | 3. 하늘 | 4. 랜덤 맵 ");
		System.out.println(">> ");
		String selectedMap = scanner.nextLine();

		switch (selectedMap) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;

		default:
		}
	}

}
