package catchGame.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.map.MapType;
import catchGame.monster.MonsterArrays;
import catchGame.monster.MonsterBase;
import catchGame.monster.MonsterFactory;
import catchGame.monster.MonsterType;

public class User {
	private String userName;                // 사용자 이름
    private String location;                // 사용자 위치
    private PokeDex pokeDex;           		// 사용자의 포켓몬 도감
    private MapExploring mapExploring;      // 맵 탐험 관련 정보
    private MonsterBase[] caughtMonsters;   // 잡은 몬스터 배열
    private int caughtMonsterCount;         // 잡은 몬스터 수
    private LocalDateTime startTime;        // 게임 시작 시간
    private Scanner scanner;                // 사용자 입력 스캐너
    
    private String playerId; // 플레이어 ID
    private int level = 1; // 플레이어 레벨

	// User 객체 생성 시 이름 입력받고, 새로운 도감 불러옴
    public User() {
        scanner = new Scanner(System.in);
        this.playerId = "";
        initializeUser();
    }
    
    // user 이름 가져오기
    public String getUserName() {
    	return this.userName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MonsterBase[] getCaughtMonsters() {
        return this.caughtMonsters;
    }

    public int getCaughtMonsterCount() {
        return this.caughtMonsters.length;
    }
    
    public String getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        }
    }
    
    // 레벨 증가 메서드
    public void increaseLevel() {
        this.level++;
    }
    
    // 소지 몬스터 평균 레벨 계산
    public double calculateAverageMonsterLevel() {
        double totalLevel = 0.0;
        int count = 0;
        
        for (int i = 0; i < caughtMonsterCount; i++) {
            if (caughtMonsters[i] != null) {
                totalLevel += caughtMonsters[i].getLevel();
                count++;
            }
        }
        
        return count > 0 ? totalLevel / count : 0.0;
    }
    
    // 사용자 초기화
    private void initializeUser() {
        try {
            System.out.print("당신의 이름은? ");
            String input = scanner.nextLine();
            this.userName = trimInput(input);
            
            if (isEmptyInput(this.userName)) {
                System.out.println("⚠️ 이름은 공백일 수 없습니다. 기본 이름으로 설정합니다.");
                this.userName = "트레이너";
            }
        } catch (Exception e) {
            System.out.println("⚠️ 입력 도중 오류가 발생했습니다. 기본 이름으로 설정합니다.");
            this.userName = "트레이너";
        }
        
        this.pokeDex = new PokeDex();
        this.mapExploring = new MapExploring();
        this.location = "집";
        this.startTime = LocalDateTime.now();
        this.caughtMonsters = new MonsterBase[6];
        this.caughtMonsterCount = 0;
    }

    // 사용자의 도감 출력
    public void printMyPokeDex() {
        this.pokeDex.printPokeDex();
    }

    // 몬스터 포획 시도
    public void catchMonster() throws InterruptedException {
        MonsterArrays monsterArrays = new MonsterArrays();
        MonsterBase monster = getMonsterForCurrentLocation(monsterArrays);
        
        // 몬스터와 조우
        if (monster.getIsMet() == 1) {
            System.out.println("\n💥 몬스터를 만났다! 💥\n");
            monster.displayAppearanceMessage();
        } else {
            System.out.println("\n😢 몬스터가 만나지 못했다... 😢\n");
            monster.displayAppearanceMessage();
        }
        
        Thread.sleep(500);
        
        // 기본 몬스터(아무것도 만나지 않음)이 아닌 경우에만 전투 진행
        if (!monster.getName().equals("기본")) {
            if (this.askUserToFight()) {
                System.out.println("\n>> 싸우는 중");
                Thread.sleep(500);
                System.out.println(">> ...");
                Thread.sleep(500);
                System.out.println(">> ...\n");
                Thread.sleep(500);
                
                // 몬스터가 도망가지 않는 경우에만 포획 시도
                if (monster.attemptEscape()) {
                    boolean caught = monster.attemptCatch();
                    if (caught) {
                    	// 몬스터 레벨 설정 (5~100 사이 랜덤)
                        int monsterLevel = new java.util.Random().nextInt(96) + 5;
                        monster.setLevel(monsterLevel);
                        
                        // 몬스터 소지 수량 제한 처리
                        if (caughtMonsterCount >= 6) {
                        	this.ReplaceMonster(monster);
                        } else {
                            this.caughtMonsters[caughtMonsterCount] = monster;
                            caughtMonsterCount++;
                            System.out.println("✨ 띠링! " + monster.getName() + "(Lv." + monster.getLevel() + ")이(가) 포켓몬 도감에 등록되었습니다!");
                            this.pokeDex.updatePokeDex(monster.getName());
                        }
                    }
                }
            }
        } else {
            // 기본 몬스터(아무것도 만나지 않음)의 경우
            monster.attemptEscape();
        }
    }
    
    private void ReplaceMonster(MonsterBase newMonster) {
    	System.out.println("⚠️ 이미 6마리를 소지 중입니다. 처리 방식을 선택하세요:");
        System.out.println("1. 기존 몬스터 교체하기");
        System.out.println("2. 새 몬스터 놓아주기");
        System.out.print("선택 (1-2): ");
        
        try {
            int actionChoice = Integer.parseInt(scanner.nextLine());
            if (actionChoice == 1) {
                showMonsterListForReplacement(newMonster);
            } else if (actionChoice == 2) {
                releaseNewMonster(newMonster);
            } else {
                System.out.println("잘못된 선택입니다. 새 몬스터를 놓아줍니다.");
                releaseNewMonster(newMonster);
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요. 새 몬스터를 놓아줍니다.");
            releaseNewMonster(newMonster);
        }
    }
    
    // 교체 대상 몬스터 목록 표시
    private void showMonsterListForReplacement(MonsterBase newMonster) {
        System.out.println("\n교체할 몬스터 번호 선택:");
        for (int i = 0; i < caughtMonsterCount; i++) {
        	System.out.println((i + 1) + ". " + caughtMonsters[i].getName() 
        			+ " (Lv." + caughtMonsters[i].getLevel() + ")");
        	System.out.println("7. 취소하고 새 몬스터 놓아주기");

	        try {
	            int slotChoice = Integer.parseInt(scanner.nextLine());
	            if (slotChoice >= 1 && slotChoice <= 6) {
	                replaceMonster(slotChoice, newMonster);
	            } else if (slotChoice == 7) {
	                releaseNewMonster(newMonster);
	            } else {
	                System.out.println("잘못된 선택입니다. 새 몬스터를 놓아줍니다.");
	                releaseNewMonster(newMonster);
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("숫자를 입력해주세요. 새 몬스터를 놓아줍니다.");
	            releaseNewMonster(newMonster);
	        }
        }
    }
    
    // 기존 몬스터 교체 처리
    private void replaceMonster(int slot, MonsterBase newMonster) {
        MonsterBase oldMonster = caughtMonsters[slot-1];
        System.out.println("\n【" + oldMonster.getName() + " (Lv." + oldMonster.getLevel() +
				    	    ")】을(를) 풀어주고 【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
				    	    ")】을(를) 획득했습니다!");
        caughtMonsters[slot-1] = newMonster;
        pokeDex.updatePokeDex(newMonster.getName());
    }
    
    // 새 몬스터 풀어주기 처리
    private void releaseNewMonster(MonsterBase newMonster) {
    	System.out.println("\n【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
			    		    ")】을(를) 야생으로 돌려보냈습니다...");
    }

    // 현재 위치에 맞는 몬스터 가져오기
    private MonsterBase getMonsterForCurrentLocation(MonsterArrays monsterArrays) {
        switch (this.location) {
            case "하늘":
                return monsterArrays.createSkyMonster();
            case "바다":
                return monsterArrays.createSeaMonster();
            case "땅":
                return monsterArrays.createEarthMonster();
            case "우주":
                return monsterArrays.createUniverseMonster();
            default:
                return monsterArrays.createEarthMonster();  // 기본값
        }
    }

    // 사용자에게 전투 여부 물어보기
    private boolean askUserToFight() {
        System.out.print("\n>> 싸우시겠습니까?(Y/N) ");
        
        while (true) {
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("Y")) {
                return true;
            } else if (userChoice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("⚠️ 잘못된 입력입니다. 'Y' 또는 'N'을 입력해주세요.");
            }
        }
    }

    // 도감 검색
    public void searchTotalPokeDex() {
        this.pokeDex.searchPokeDex();
    }

    // 맵 선택
    public void selectMap() throws InterruptedException {
        MapExploring newMap = new MapExploring();
        newMap.selectMap(this.mapExploring.getSelectionCount());
        this.mapExploring = newMap;
        
        // MapType에서 한글 이름 추출
        this.location = newMap.getFinalMap() == MapType.CANCEL ? 
                      "집" : 
                      newMap.getFinalMap().getAreaName();
    }

    // 사용자 정보 출력
    public void printUserInfo() {
    	System.out.println("=== 기본 정보 ===");
        System.out.println("사용자명: " + this.userName);
        System.out.println("사용자 위치: " + (this.location.equals("취소") ? "집" : this.location));
        System.out.println("플레이 시간: " + getFormattedPlayTime());
        System.out.println("잡은 몬스터 수: " + caughtMonsterCount + "마리");
        
        if (caughtMonsterCount > 0) {
            double avgLevel = calculateAverageMonsterLevel();
            System.out.printf("몬스터 평균 레벨: %.2f\n", avgLevel);
        }
        
        System.out.println("현재 잡은 몬스터:");
        
        for (int i = 0; i < this.caughtMonsterCount; i++) {
            if (this.caughtMonsters[i] != null) {
                System.out.println((i + 1) + ". 🎯" + this.caughtMonsters[i].getName() + 
                                  " (Lv." + this.caughtMonsters[i].getLevel() + ")");
            }
        }
    }

	// 문자열 앞뒤 공백 제거
    private String trimInput(String input) {
        if (input == null) return "";
        
        int start = 0;
        int end = input.length() - 1;
        
        while (start <= end && Character.isWhitespace(input.charAt(start))) {
            start++;
        }
        
        while (end >= start && Character.isWhitespace(input.charAt(end))) {
            end--;
        }
        
        return input.substring(start, end + 1);
    }
    
    // 문자열이 비었는지 확인
    private boolean isEmptyInput(String input) {
        return input == null || input.length() == 0;
    }
    
    // 플레이 시간을 사용자 친화적으로 포맷팅
    public String getFormattedPlayTime() {
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        
        return String.format("%02d시간 %02d분 %02d초", hours, minutes, seconds);
    }
    
    public void resetCaughtMonsters() {
        this.caughtMonsters = new MonsterBase[6]; // 최대 6마리로 변경
        this.caughtMonsterCount = 0;
    }
    
    public void addLoadedMonster(String monsterName, int level) {
        if (caughtMonsterCount < 6) {
            // 몬스터 타입 찾기
            MonsterType type = null;
            for (MonsterType t : MonsterType.values()) {
                if (t.getName().equals(monsterName)) {
                    type = t;
                    break;
                }
            }
            
            if (type != null) {
                MonsterBase monster = MonsterFactory.createMonster(type);
                monster.setCaught(true);
                monster.setLevel(level);
                caughtMonsters[caughtMonsterCount] = monster;
                caughtMonsterCount++;
                this.pokeDex.updatePokeDex(monsterName);
            }
        }
    }
}