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
	public void catchMonster() {
		// 몬스터 배열 객체 선언
		MonsterArrays monsterArrays = new MonsterArrays();

		boolean isCatch = false; // 포획 여부
		String catchMonsterName = "";

		// 맵 정보 배열로 정의 ("하늘", "바다", "산", "랜덤", "취소")
		String[] gameMap = this.mapExploring.map;

		// 현재 지역에 맞는 몬스터 배열 가져옴
		if (this.location.equals(gameMap[0])) {
			System.out.println("💥 몬스터를 만났다! 💥");
			MonsterBase skyMonster = monsterArrays.skyMonsters();
			skyMonster.appearanceComment();
			isCatch = skyMonster.catchMonster();
			catchMonsterName = skyMonster.name;
		} else if (this.location.equals(gameMap[1])) {
			MonsterBase seaMonster = monsterArrays.seaMonsters();
			seaMonster.appearanceComment();
			isCatch = seaMonster.catchMonster();
			catchMonsterName = seaMonster.name;
		} else if (this.location.equals(gameMap[2])) {
			MonsterBase earthMonster = monsterArrays.earthMonsters();
			earthMonster.appearanceComment();
			isCatch = earthMonster.catchMonster();
			catchMonsterName = earthMonster.name;
		} else if (this.location.equals(gameMap[3])) {
			MonsterBase randomMonster = monsterArrays.universeMonsters();
			randomMonster.appearanceComment();
			isCatch = randomMonster.catchMonster();
			catchMonsterName = randomMonster.name;
		}

		// 포획했다면 도감에 등록
		if (isCatch) {
			System.out.println("2. 등록");
			System.out.println("포획: " + catchMonsterName);
			this.updateMyPokeDex(catchMonsterName);
			System.out.println("3. 등록 완료");
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
	public void selectMap() {
		this.mapExploring.mapInput(this.mapExploring.mapIterationCount);
		this.location = this.mapExploring.answerMap;
	}

	// 유저 정보 출력
	public void printUserInfo() {
		System.out.println("사용자명: " + this.userName);
		System.out.println("사용자 위치: " + this.location);
	}
}