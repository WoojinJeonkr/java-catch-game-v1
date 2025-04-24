package catchGame.manage;

import java.util.Scanner;

import catchGame.user.User;

public class GameManager {
	private boolean isRunning; // 게임 상태
	User user;

	Scanner scanner = new Scanner(System.in);

	// 객체 생성 시 user 객체 생성, 게임 상태 true로 설정
	public GameManager() {
		user = new User();
		this.isRunning = true;
	}

	// 게임 메뉴 출력 메소드
	public void printGameMenu() throws InterruptedException {
		System.out.println("\n=== 몬스터 잡기 게임 ===");
		System.out.println("1. 맵 선택하기");
		System.out.println("2. 몬스터 도감 보기");
		System.out.println("3. 몬스터 검색하기");
		System.out.println("4. 내 정보 보기");
		System.out.println("5. 게임 종료");
		System.out.print("메뉴를 선택하세요 (1-4): ");
		int inputChoice = scanner.nextInt();

		switch (inputChoice) {
		case 1:
			this.user.selectMap();
			if (this.user.location.equals("취소")) {
				return;
			}
			System.out.println();
			Thread.sleep(1500);
			System.out.println("--" + user.location + "맵에 소환되었습니다" + "--");
			Thread.sleep(1500);
			System.out.println("(..두리번...두리번..)");
			Thread.sleep(1500);
			System.out.println("\n>> 몬스터를 탐색 중입니다.");
			Thread.sleep(1500);
			System.out.println("\n>> ...");
			Thread.sleep(1500);
			System.out.println("\n>> ...");

			user.catchMonster();
			printUserAction();
			break;
		case 2:
			System.out.println("\n>> 나의 몬스터 도감을 확인합니다.");
			// 도감 출력 메서드 호출
			user.printMyPokeDex();
			printUserAction();
			break;
		case 3:
			user.searchTotalPokeDex();
			break;
		case 4:
			System.out.println("\n>> 내 정보를 확인합니다.");
			// 사용자 정보 출력
			user.printUserInfo();
			break;
		case 5:
			System.out.println("\n>> 게임을 종료합니다. 감사합니다!");
			this.isRunning = false;
			break;
		default:
			System.out.println("잘못된 입력입니다. 1 ~ 5 사이의 숫자를 입력하세요.");
		}
	}

	public void printUserAction() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. 계속 탐색하기 2. 다른 맵 이동 3. 도감 보기 4. 몬스터 검색 5. 홈으로 가기");
			String ans = scanner.nextLine();

			switch (ans) {
			case "1":
				System.out.println("\n>> 몬스터를 탐색 중입니다.");
				Thread.sleep(1500);
				System.out.println("\n>> ...");
				Thread.sleep(1500);
				System.out.println("\n>> ...");
				user.catchMonster();
				break;
			case "2":
				String prevLocation = this.user.location;
				user.selectMap();
				if (this.user.location.equals(prevLocation)) {
					System.out.println("\n--" + user.location + "맵에 소환되었습니다--");
					user.catchMonster();
					break;
				}
				System.out.println("\n--" + user.location + "맵에 소환되었습니다--");
				user.catchMonster();
				break;
			case "3":
				user.printMyPokeDex();
				break;
			case "4":
				user.searchTotalPokeDex();
				break;
			case "5":
				return;
			default:
				System.out.println("잘못된 입력입니다. 1 ~ 5 사이의 숫자를 입력하세요.");
				printUserAction();
				break;
			}
		}
	}

	// 게임 실행 메소드
	public void runGame() throws InterruptedException {
		while (this.isRunning) {
			this.printGameMenu();
		}
	}
}