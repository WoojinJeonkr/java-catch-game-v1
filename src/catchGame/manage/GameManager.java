package catchGame.manage;

import java.util.Scanner;

import catchGame.monster.MonsterHandler;
import catchGame.user.RankingSystem;
import catchGame.user.User;

/**
 * 게임 진행을 관리하는 클래스
 * 
 * <p>
 * 게임의 메인 루프를 실행하며, 로그인, 메뉴 표시, 사용자 입력 처리,
 * 몬스터 관리, 저장 및 불러오기, 랭킹 표시 등의 기능을 제공합니다.
 * </p>
 * 
 * @author yooncount
 * @author Woojinjeonkr
 */
public class GameManager {
	/** 게임 실행 상태 플래그 */
	private boolean isRunning;
	/** 사용자 입력을 처리하는 Scanner 객체 */
    private Scanner scanner;
    /** 이전 위치 정보 */
    private String previousLocation;
    /** 몬스터 관련 기능을 담당하는 MonsterHandler 객체 */
    private MonsterHandler monsterHandler;
    /** 게임 저장 및 불러오기 기능을 담당하는 GameSaveManager 객체 */
    private GameSaveManager saveManager;
    /** 플레이어 계정 관리를 담당하는 PlayerManager 객체 */
    private PlayerManager playerManager;
    /** 랭킹 시스템을 담당하는 RankingSystem 객체 */
    private RankingSystem rankingSystem;

    /**
     * GameManager 생성자
     * 
     * <p>게임 실행 상태를 true로 설정하고, 필요한 객체들을 초기화합니다.</p>
     */
    public GameManager() {
        this.isRunning = true;
        this.scanner = new Scanner(System.in);
        this.monsterHandler = new MonsterHandler(this.scanner);
        this.saveManager = new GameSaveManager();
        this.playerManager = new PlayerManager(3);
        this.rankingSystem = new RankingSystem();
    }
    
    /**
     * 게임 실행 메서드
     * 
     * <p>게임의 메인 루프를 실행하며, 로그인 상태에 따라 로그인 메뉴 또는 메인 메뉴를 표시합니다.</p>
     *
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    public void runGame() throws InterruptedException {
    	while (this.isRunning) {
            if (playerManager.isLoggedIn()) {
                displayMainMenu();
            } else {
                displayLoginMenu();
            }
        }
    }

    /**
     * 로그인 메뉴를 표시하고 사용자 입력을 처리하는 메서드
     * 
     * <p>로그인, 계정 등록, 랭킹 보기, 게임 종료 옵션을 제공합니다.</p>
     */
    private void displayLoginMenu() {
        System.out.println("\n=== 몬스터 잡기 게임 - 로그인 ===");
        System.out.println("1. 로그인");
        System.out.println("2. 계정 등록");
        System.out.println("3. 랭킹 보기");
        System.out.println("4. 게임 종료");
        System.out.print("메뉴를 선택하세요 (1-4): ");
        
        String choice = scanner.nextLine().replace(" ", "");
        
        switch (choice) {
            case "1":
                handleLogin();
                break;
            case "2":
                handleRegistration();
                break;
            case "3":
                handleRankingView();
                break;
            case "4":
                System.out.println("\n>> 게임을 종료합니다. 감사합니다!");
                this.isRunning = false;
                break;
            default:
                System.out.println("잘못된 입력입니다. 1 ~ 4 사이의 숫자를 입력하세요.");
                break;
        }
    }
    
    /**
     * 로그인 처리 메서드
     * 
     * <p>사용자로부터 플레이어 ID를 입력받아 로그인을 시도합니다.</p>
     */
    private void handleLogin() {
        System.out.print("\n플레이어 ID를 입력하세요: ");
        String playerId = scanner.nextLine();
        
        if (playerManager.loginPlayer(playerId)) {
            System.out.println("\n>> " + playerId + "님, 환영합니다!");
        } else {
            System.out.println("\n>> 존재하지 않는 플레이어 ID입니다.");
        }
    }
    
    /**
     * 계정 등록 처리 메서드
     * 
     * <p>사용자로부터 새 플레이어 ID를 입력받아 계정을 등록합니다.</p>
     */
    private void handleRegistration() {
        System.out.print("\n새 플레이어 ID를 입력하세요: ");
        String playerId = scanner.nextLine();
        
        // ID 형식 검사
        if (playerId.isEmpty()) {
            System.out.println("\n>> ID는 비어있을 수 없습니다.");
            return;
        }
        
        if (playerManager.registerPlayer(playerId)) {
            System.out.println("\n>> 새 계정이 등록되었습니다. " + playerId + "님, 환영합니다!");
        } else {
            System.out.println("\n>> 이미 존재하는 ID이거나 등록에 실패했습니다.");
        }
    }
    
    /**
     * 랭킹 보기 처리 메서드
     * 
     * <p>플레이어 레벨 랭킹 또는 몬스터 평균 레벨 랭킹을 표시합니다.</p>
     */
    private void handleRankingView() {
        if (playerManager.getPlayerCount() == 0) {
            System.out.println("\n>> 등록된 플레이어가 없습니다.");
            return;
        }
        
        System.out.println("\n=== 랭킹 메뉴 ===");
        System.out.println("1. 플레이어 레벨 랭킹");
        System.out.println("2. 몬스터 평균 레벨 랭킹");
        System.out.println("3. 뒤로 가기");
        System.out.print("메뉴를 선택하세요 (1-3): ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                User[] levelRankedPlayers = rankingSystem.calculateLevelRanking(
                    playerManager.getAllPlayers(), playerManager.getPlayerCount());
                rankingSystem.displayRanking(levelRankedPlayers, "플레이어 레벨");
                break;
            case "2":
                User[] monsterLevelRankedPlayers = rankingSystem.calculateMonsterLevelRanking(
                    playerManager.getAllPlayers(), playerManager.getPlayerCount());
                rankingSystem.displayRanking(monsterLevelRankedPlayers, "몬스터 평균 레벨");
                break;
            case "3":
                return;
            default:
                System.out.println("잘못된 입력입니다. 1 ~ 3 사이의 숫자를 입력하세요.");
                break;
        }
    }

    /**
     * 메인 메뉴를 표시하고 사용자 입력을 처리하는 메서드
     * 
     * <p>맵 선택, 도감 보기, 몬스터 검색, 내 정보 확인, 로그아웃 옵션을 제공합니다.</p>
     *
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    private void displayMainMenu() throws InterruptedException {
    	User currentUser = playerManager.getCurrentPlayer();
        
        System.out.println("\n=== 몬스터 잡기 게임 ===");
        System.out.println("플레이어: " + currentUser.getUserName() + " (레벨: " + currentUser.getLevel() + ")");
        System.out.println("1. 맵 선택하기");
        System.out.println("2. 몬스터 도감 보기");
        System.out.println("3. 몬스터 검색하기");
        System.out.println("4. 내 정보 확인");
        System.out.println("5. 로그아웃");
        System.out.print("메뉴를 선택하세요 (1-5): ");
        
        String choice = scanner.nextLine().replace(" ", "");
        
        switch (choice) {
            case "1":
                handleMapSelection();
                break;
            case "2":
                System.out.println("\n>> 나의 몬스터 도감을 확인합니다.");
                playerManager.getCurrentPlayer().printMyPokeDex();
                break;
            case "3":
                playerManager.getCurrentPlayer().searchTotalPokeDex();
                break;
            case "4":
                handleUserInfoMenu(currentUser);
                break;
            case "5":
                System.out.println("\n>> 로그아웃합니다.");
                playerManager.logoutPlayer();
                break;
            default:
                System.out.println("잘못된 입력입니다. 1 ~ 6 사이의 숫자를 입력하세요.");
                break;
        }
    }
    
    /**
     * 사용자 정보 메뉴를 표시하고 처리하는 메서드
     * 
     * <p>사용자 정보 보기, 저장, 불러오기, 랭킹 보기, 메인 메뉴로 돌아가기 옵션을 제공합니다.</p>
     *
     * @param user 현재 플레이어
     */
    private void handleUserInfoMenu(User user) throws InterruptedException {
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

    /**
     * 맵 선택 처리 메서드
     * 
     * <p>맵을 선택하고, 선택한 맵에 따라 몬스터를 탐색합니다.</p>
     *
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    private void handleMapSelection() throws InterruptedException {
    	User currentUser = playerManager.getCurrentPlayer();
        currentUser.selectMap();
        previousLocation = currentUser.getLocation();
        
        // 맵 선택이 취소되었거나 집으로 이동한 경우
        if (currentUser.getLocation().equals("취소")) {
            System.out.println("\n>> 맵 선택이 취소되었습니다. 집으로 돌아갑니다.");
            return;
        }
        
        // 집으로 이동한 경우
        if (currentUser.getLocation().equals("집")) {
            System.out.println("\n>> 집으로 이동했습니다.");
            return; // 몬스터 탐색 없이 메인 메뉴로 돌아감
        }
        
        System.out.println();
        Thread.sleep(500);
        System.out.println("--" + currentUser.getLocation() + "맵에 소환되었습니다--");
        Thread.sleep(500);
        System.out.println("(..두리번...두리번..)");
        Thread.sleep(500);
        System.out.println("\n>> 몬스터를 탐색 중입니다.");
        Thread.sleep(500);
        System.out.println("\n>> ...");
        Thread.sleep(500);
        System.out.println("\n>> ...");
        monsterHandler.catchMonster(currentUser);
        
        // 몬스터를 성공적으로 잡았을 때 레벨 증가
        if (currentUser.getCaughtMonsterCount() > 0) {
            int lastIndex = currentUser.getCaughtMonsterCount() - 1;
            if (currentUser.getCaughtMonsters()[lastIndex] != null && 
                currentUser.getCaughtMonsters()[lastIndex].isCaught()) {
                currentUser.increaseLevel();
                System.out.println("\n🎉 축하합니다! 레벨이 증가했습니다. 현재 레벨: " + currentUser.getLevel());
            }
        }
        
        displayUserAction(currentUser);
    }

    /**
     * 사용자 액션 메뉴를 표시하고 처리하는 메서드
     *
     * <p>몬스터 탐색, 맵 변경, 도감 보기, 몬스터 검색, 집으로 가기 옵션을 제공합니다.</p>
     *
     * @param user 현재 플레이어
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    private void displayUserAction(User user) throws InterruptedException {
        while (true) {
            System.out.println("\n1. 계속 탐색하기 2. 다른 맵 이동 3. 도감 보기 4. 몬스터 검색 5. 집으로 가기");
            String choice = scanner.nextLine().replace(" ", "");
            
            switch (choice) {
                case "1":
                    System.out.println("\n>> 몬스터를 탐색 중입니다.");
                    Thread.sleep(500);
                    System.out.println("\n>> ...");
                    Thread.sleep(500);
                    System.out.println("\n>> ...");
                    monsterHandler.catchMonster(user);
                    break;
                case "2":
                    handleMapChange(user);
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
    
    /**
     * 맵 변경 처리 메서드
     *
     * <p>
     * 현재 위치를 저장하고, 맵을 변경합니다.
     * "취소" 선택 시 맵 변경을 취소하고 이전 위치로 돌아갑니다.
     * </p>
     *
     * @param user 현재 플레이어
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    private void handleMapChange(User user) throws InterruptedException {
        user.selectMap();
        
        // 사용자가 "취소"를 선택했을 경우
        if (user.getLocation().equals("취소")) {
            System.out.println("\n>> 맵 이동이 취소되었습니다. 현재 맵에서 계속 진행합니다.");
            user.setLocation(previousLocation);
            monsterHandler.catchMonster(user);
            return;
        }
        
        System.out.println("\n--" + user.getLocation() + "맵에 소환되었습니다--");
        monsterHandler.catchMonster(user);
    }
}