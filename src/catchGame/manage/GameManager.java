package catchGame.manage;

import java.util.Scanner;

import catchGame.user.User;

public class GameManager {
	private boolean isRunning;  // 게임 실행 상태
    private User user;          // 사용자 정보
    private Scanner scanner;    // 사용자 입력 스캐너
    private String previousLocation;  // 이전 위치
    private GameSaveManager saveManager;

	// 객체 생성 시 user 객체 생성, 게임 상태 true로 설정
    public GameManager() {
        this.user = new User();
        this.isRunning = true;
        this.scanner = new Scanner(System.in);
        this.saveManager = new GameSaveManager();
    }
    
    // 게임 실행 메서드
    public void runGame() throws InterruptedException {
        while (this.isRunning) {
            displayMainMenu();
        }
    }

    // 메인 메뉴 표시 및 처리
    private void displayMainMenu() throws InterruptedException {
        System.out.println("\n=== 몬스터 잡기 게임 ===");
        System.out.println("1. 맵 선택하기");
        System.out.println("2. 몬스터 도감 보기");
        System.out.println("3. 몬스터 검색하기");
        System.out.println("4. 내 정보 확인");
        System.out.println("5. 게임 종료");
        System.out.print("메뉴를 선택하세요 (1-5): ");
        
        String choice = scanner.nextLine().replace(" ", "");
        
        switch (choice) {
            case "1":
                handleMapSelection();
                break;
            case "2":
                System.out.println("\n>> 나의 몬스터 도감을 확인합니다.");
                user.printMyPokeDex();
                displayUserAction();
                break;
            case "3":
                user.searchTotalPokeDex();
                break;
            case "4":
            	handleUserInfoMenu();
                break;
            case "5":
                System.out.println("\n>> 게임을 종료합니다. 감사합니다!");
                this.isRunning = false;
                break;
            default:
                System.out.println("잘못된 입력입니다. 1 ~ 5 사이의 숫자를 입력하세요.");
                break;
        }
    }
    
    // 새로운 사용자 정보 관리 서브메뉴
    private void handleUserInfoMenu() throws InterruptedException {
        while (true) {
            System.out.println("\n=== 내 정보 관리 ===");
            System.out.println("1. 기본 정보 보기");
            System.out.println("2. 게임 저장하기");
            System.out.println("3. 게임 불러오기");
            System.out.println("4. 뒤로 가기");
            System.out.print("메뉴를 선택하세요 (1-4): ");
            
            String inputChoice = scanner.nextLine();
            switch (inputChoice) {
                case "1":
                    System.out.println("\n>> 내 정보를 확인합니다.");
                    user.printUserInfo();
                    break;
                case "2":
                    System.out.println("\n>> 게임을 저장합니다.");
                    saveManager.saveGame(user);
                    break;
                case "3":
                    System.out.println("\n>> 저장된 게임을 불러옵니다.");
                    saveManager.loadGame(user);
                    break;
                case "4":
                    return; // 메인 메뉴로 복귀
                default:
                    System.out.println("잘못된 입력입니다. 1 ~ 4 사이의 숫자를 입력하세요.");
                    break;
            }
        }
    }

    // 맵 선택 처리
    private void handleMapSelection() throws InterruptedException {
        user.selectMap();
        previousLocation = user.getLocation();
        
        // 맵 선택이 취소되었거나 집으로 이동한 경우
        if (user.getLocation().equals("취소")) {
            System.out.println("\n>> 맵 선택이 취소되었습니다. 홈으로 돌아갑니다.");
            return;
        }
        
        System.out.println();
        Thread.sleep(500);
        System.out.println("--" + user.getLocation() + "맵에 소환되었습니다--");
        Thread.sleep(500);
        System.out.println("(..두리번...두리번..)");
        Thread.sleep(500);
        System.out.println("\n>> 몬스터를 탐색 중입니다.");
        Thread.sleep(500);
        System.out.println("\n>> ...");
        Thread.sleep(500);
        System.out.println("\n>> ...");
        
        user.catchMonster();
        displayUserAction();
    }

    // 사용자 액션 메뉴 표시 및 처리
    private void displayUserAction() throws InterruptedException {
        while (true) {
            System.out.println("\n1. 계속 탐색하기 2. 다른 맵 이동 3. 도감 보기 4. 몬스터 검색 5. 홈으로 가기");
            String choice = scanner.nextLine().replace(" ", "");
            
            switch (choice) {
                case "1":
                    System.out.println("\n>> 몬스터를 탐색 중입니다.");
                    Thread.sleep(500);
                    System.out.println("\n>> ...");
                    Thread.sleep(500);
                    System.out.println("\n>> ...");
                    user.catchMonster();
                    break;
                case "2":
                    handleMapChange();
                    break;
                case "3":
                    user.printMyPokeDex();
                    break;
                case "4":
                    user.searchTotalPokeDex();
                    break;
                case "5":
                    user.setLocation("집");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 1 ~ 5 사이의 숫자를 입력하세요.");
                    break;
            }
        }
    }
    
    // 맵 변경 처리
    private void handleMapChange() throws InterruptedException {
        user.selectMap();
        
        // 사용자가 "취소"를 선택했을 경우
        if (user.getLocation().equals("취소")) {
            System.out.println("\n>> 맵 이동이 취소되었습니다. 현재 맵에서 계속 진행합니다.");
            user.setLocation(previousLocation);
            user.catchMonster();
            return;
        }
        
        System.out.println("\n--" + user.getLocation() + "맵에 소환되었습니다--");
        user.catchMonster();
    }
}