package catchGame.map;

import java.util.Random;
import java.util.Scanner;

public class MapExploring {
	public String[] map = { "하늘", "바다", "땅", "랜덤", "취소" };
	Scanner scanner = new Scanner(System.in);
	public String answerMap;
	public int mapIterationCount; // 맵 선택하기 반복 횟수
	private int mapIndex = 2;
	private int mapReturn;

	public void mapInput(int mapCount) throws InterruptedException {
		this.mapIterationCount = mapCount;

		while (this.mapIndex == 2) {
			if (this.mapIterationCount < 1) {
				System.out.println("\n+++ 몬스터 잡기 게임 +++");
			}
			System.out.println("🗺️ 맵을 선택하세요 (하늘☁️ |바다🌊 |땅🌴 |랜덤🎲 |취소⚠️)");
			this.answerMap = scanner.nextLine();
			this.mapIndex = mapSelect(this.answerMap);
			if (this.mapIndex == 0) {
				Thread.sleep(1500);
				System.out.println("\n>> 맵 이동중입니다...");
				this.mapIterationCount++;
				break;
			}
			if (this.mapIndex == 1) {
				break;
			}

		}
	}

	public int mapSelect(String answerMap) throws InterruptedException {
		Thread.sleep(1500);
		if (answerMap.equals("하늘")) {
			System.out.println("하늘☁️ 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("바다")) {
			System.out.println("바다🌊 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("땅")) {
			System.out.println("땅🌴 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("랜덤")) {
			System.out.println("랜덤🎲 맵 페이지로 이동합니다");
			String mapProbabilityAnswer = mapProbability();
			System.out.println(mapProbabilityAnswer + " 맵 페이지가 선택되었습니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("취소")) {
			System.out.println("홈 페이지로 이동합니다");
			this.mapReturn = 1;
		} else {
			System.out.println("잘못 입력하셨습니다");
			this.mapReturn = 2;
		}
		return this.mapReturn;
	}

	// 히든 맵 나올 확률 20%로 확률 조작
	public String mapProbability() {
		Random random = new Random();
		int index = random.nextInt(15);
		if (index < 4) {
			return "하늘";
		} else if (index < 8) {
			return "바다";
		} else if (index < 12) {
			return "땅";
		} else {
			return "👏👏👏 히든 우주";
		}
	}
}