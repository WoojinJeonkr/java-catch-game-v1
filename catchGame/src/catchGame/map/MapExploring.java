package catchGame.map;

import java.util.Random;
import java.util.Scanner;

public class MapExploring {
	String[] map = { "하늘", "바다", "산", "랜덤" };
	Scanner scanner2 = new Scanner(System.in);
	public String answerMap;
	public int SelectGameAnswer; // selectGame 번호 누르기
	public int mapIterationCount; // 맵 선택하기 반복 횟수
	public int answerGame; // SelectGame 번호 고르기
	private int mapIndex = 1;
	private int mapReturn;
	
	public int mapIterationCheck() {
		while (SelectGameAnswer == 0) {
			this.SelectGameAnswer = selectGame();
			if (this.SelectGameAnswer > 0) {
				break;
			}
			System.out.println("잘못 입력하셨습니다");
		}		
		return SelectGameAnswer;
	}
	
	public void mapInput(int mapCount) {
		this.mapIterationCount = mapCount;

		while (this.mapIndex == 1) {
			Scanner scanner1 = new Scanner(System.in);
			if (this.mapIterationCount > 0) {	
				if(mapIterationCheck() == 1) {
					mapIterationCount++;
					break;
				}else if(mapIterationCheck() == 3) {
					break;
				}else {					
				}
			}
			System.out.println("\n+++ 몬스터 잡기 게임 +++");
			System.out.println("🗺️ 맵을 선택하세요 (하늘☁️ |바다🌊 |산🏔️ |랜덤🎲 )");
			this.answerMap = scanner1.nextLine();
			this.mapIndex = mapSelect(this.answerMap);
			if (this.mapIndex == 0) {
				System.out.println("\n>> 맵 이동중입니다...");
				this.mapIterationCount++; // 반복횟수 증가
				break;
			}
		}
	}

	public int mapSelect(String answerMap) {
		if (answerMap.equals("하늘")) {
			System.out.println("하늘☁️ 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("바다")) {
			System.out.println("바다🌊 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("산")) {
			System.out.println("산🏔️ 맵 페이지로 이동합니다");
			this.mapReturn = 0;
		} else if (answerMap.equals("랜덤")) {
			System.out.println("랜덤🎲 맵 페이지로 이동합니다");
			String mapProbabilityAnswer = mapProbability();
			System.out.println(mapProbabilityAnswer + " 맵 페이지가 선택되었습니다");
			this.mapReturn = 0;
		} else {
			System.out.println("잘못 입력하셨습니다");
			this.mapReturn = 1;
		}
		return this.mapReturn;
	}

	// 히든 맵 나올 확률 0.718% => 718/100000로 확률 조작
	public String mapProbability() {
		Random random = new Random();
		int index = random.nextInt(100000);
		if (index < 33093) {
			return "하늘";
		} else if (index < 66187) {
			return "바다";
		} else if (index < 99281) {
			return "산";
		} else {
			return "👏👏👏 히든";
		}
	}

	public int selectGame() {
		System.out.println();
		System.out.println("#####################");
		System.out.println("1.현재 맵을 유지하겠습니까? "); // System.out.println("현재 맵을 유지하겠습니다") -> 몬스터 잡기로 이동
		System.out.println("2.다른 맵을 유지하겠습니까? "); // mapInput 실행 -> mapSelect -> mapProbability
		System.out.println("3. 종료하시겠습니까"); // 종료 하시면 될 것 같아요
		System.out.print("메뉴를 선택하세요 (1-3): ");
		this.answerGame = scanner2.nextInt();
		return this.answerGame;
	}
}
