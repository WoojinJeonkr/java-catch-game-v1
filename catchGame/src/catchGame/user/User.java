package catchGame.user;

import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.monster.MonsterArrays;
import catchGame.monster.MonsterBase;

public class User {
	public String userName; // 사용자 이름
	public String location; // 사용자 위치
	public PokeDex pokeDex; // 사용자 도감
	public MapExploring mapExploring; // 맵 정보

	Scanner scanner = new Scanner(System.in);

	// User 객체 생성 시 이름 입력받고, 새로운 도감 불러옴
	public User() {
		System.out.print("당신의 이름은? ");
		this.userName = scanner.nextLine();
		this.pokeDex = new PokeDex();
		this.pokeDex.insertPokeDex();
		this.mapExploring = new MapExploring();
		this.location = "집";
	}

	// 사용자의 도감 출력
	public void printMyPokeDex() {
		this.pokeDex.printPokeDex();
	}

	// 몬스터 포획 메소드
	public void catchMonster() throws InterruptedException {
		// 몬스터 배열 객체 선언
		MonsterArrays monsterArrays = new MonsterArrays();

		boolean isCatch = false; // 포획 여부
		String catchMonsterName = "";

		// 맵 정보 배열로 정의 ("하늘", "바다", "산", "우주")
		String[] gameMap = this.mapExploring.map;

		// 현재 지역에 맞는 몬스터 정보 가져와서 몬스터 등장 및 포획
		this.loadFightMonster(monsterArrays, gameMap, isCatch);

		// 포획했다면 도감에 등록
		if (isCatch) {
			if (!catchMonsterName.equals("기본")) {
				System.out.println(catchMonsterName + " 포획 완료!");
				this.updateMyPokeDex(catchMonsterName);
				System.out.println(catchMonsterName + "(이)가 도감에 등록되었습니다.");
			}
		}
	}

	// 현재 지역에 맞는 몬스터 정보 가져와서 몬스터 등장 및 포획
	private void loadFightMonster(MonsterArrays monsterArrays, String[] map, boolean isCatch)
			throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			String nowLocation = map[i];
			if (this.location.equals(nowLocation)) {
				MonsterBase monster = null;
				switch (nowLocation) {
				case "하늘":
					monster = monsterArrays.skyMonsters();
					break;
				case "바다":
					monster = monsterArrays.skyMonsters();
					break;
				case "땅":
					monster = monsterArrays.skyMonsters();
					break;
				case "우주":
					monster = monsterArrays.universeMonsters();
					break;
				}
				if (monster.isMet == 1) {
					System.out.println("\n💥 몬스터를 만났다! 💥\n");
				} else {
					System.out.println("\n😢 몬스터가 만나지 못했다... 😢\n");
				}
				this.checkMonster(monster); // 몬스터 조우 및 등장 문구 출력
				Thread.sleep(1500);
				this.catchFightMonster(monster, isCatch); // 몬스터 포획
			}
		}
	}

	// 몬스터와의 조우 이벤트를 처리하고, 해당 몬스터의 등장 메시지를 출력
	private void checkMonster(MonsterBase monster) {
		monster.appearanceComment();
	}

	// 몬스터 포획
	private void catchFightMonster(MonsterBase monster, boolean isCatch) throws InterruptedException {
		if (!monster.name.equals("기본")) {
			String userChoice = this.checkUserChoice(monster); // 유저 선택
			String catchMonsterName = monster.name;
			if (userChoice.equalsIgnoreCase("Y")) {
				// 몬스터가 기본이 아닐 경우 포획 로직
				System.out.println("\n>> 싸우는 중");
				Thread.sleep(1500);
				System.out.println(">> ...");
				Thread.sleep(1500);
				System.out.println(">> ...\n");
				Thread.sleep(1500);
				this.fightMonster(monster, isCatch, catchMonsterName);
			}
			return;
		}
	}

	// 몬스터 조우 시 유저에게 싸울지 여부를 입력받아 반환
	private String checkUserChoice(MonsterBase monster) {
		System.out.print("\n>> 싸우시겠습니까?(Y/N) ");
		String userChoice = scanner.nextLine();
		return userChoice;
	}

	// 유저가 싸우기를 선택했을 경우 포획 로직을 수행
	private void fightMonster(MonsterBase monster, boolean isCatch, String catchMonsterName)
			throws InterruptedException {
		this.catchMonster(monster, isCatch, catchMonsterName);
		return;
	}

	// 몬스터 포획 시 실행
	private void catchMonster(MonsterBase monster, boolean isCatch, String catchMonsterName)
			throws InterruptedException {
		if (monster.runMonster()) {
			isCatch = monster.catchMonster();
			catchMonsterName = monster.name;
		}
	}

	// 몬스터를 잡았을 때 잡은 몬스터의 이름을 기준으로 도감 정보 최신화
	private void updateMyPokeDex(String monsterName) {
		this.pokeDex.updatePokeDex(monsterName);
	}

	// 도감 검색
	public void searchTotalPokeDex() {
		this.pokeDex.searchPokeDex();
	}

	// 맵 선택
	public void selectMap() throws InterruptedException {
		MapExploring newMap = new MapExploring();
		newMap.mapInput(this.mapExploring.mapIterationCount);
		this.mapExploring = newMap;
		this.location = newMap.answerMap;
	}

	// 유저 정보 출력
	public void printUserInfo() {
		System.out.println("사용자명: " + this.userName);
		System.out.println("사용자 위치: " + this.location);
	}
}