package catchGame.map;

import java.util.Random;
import java.util.Scanner;

public class MapExploring {
	String[] map = { "하늘", "바다", "산", "랜덤" };
	Scanner scanner = new Scanner(System.in);
	String answerMap;
	int mapIndex = 1;

	public void mapInput() {
		while (this.mapIndex == 1) {
			System.out.println("맵을 선택하세요 (하늘|바다|산|랜덤)");
			this.answerMap = scanner.nextLine();

			this.mapIndex = mapSelect(this.answerMap);

			if (this.mapIndex == 0) {
				break;
			}
		}
	}

	int mapReturn;

	public int mapSelect(String answerMap) {
			if (answerMap.equals("하늘")) {
				System.out.println("하늘 맵 페이지로 이동합니다");
				this.mapReturn = 0;
			} else if (answerMap.equals("바다")) {
				System.out.println("바다 맵 페이지로 이동합니다");
				mapReturn = 0;
			} else if (answerMap.equals("산")) {
				System.out.println("산 맵 페이지로 이동합니다");
				mapReturn = 0;
			} else if (answerMap.equals("랜덤")) {
				System.out.println("랜덤 맵 페이지로 이동합니다");
				String mapProbabilityAnswer = mapProbability();
				System.out.println(mapProbabilityAnswer + " 맵 페이지가 선택되었습니다");
				mapReturn = 0;
			} else {
				System.out.println("잘못 입력하셨습니다");
				mapReturn = 1;
			}
		
		return mapReturn;
	}

	// 히든 맵 나올 확률 1/100로 확률 조작
	public String mapProbability() {
		Random random = new Random();
		int index = random.nextInt(100);
		System.out.println(index);
		if (index < 32) {
			return "하늘";
		} else if (index < 65) {
			return "바다";
		} else if (index < 98) {
			return "산";
		} else {
			return "히든";
		}
	}

}
