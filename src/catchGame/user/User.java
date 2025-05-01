package catchGame.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.map.MapType;
import catchGame.monster.MonsterBase;
import catchGame.monster.MonsterFactory;
import catchGame.monster.MonsterType;

public class User {
	private String userName;                	// 사용자 이름
    private String location;                	// 사용자 위치
    private PokeDex pokeDex;           			// 사용자의 포켓몬 도감
    private MapExploring mapExploring;      	// 맵 탐험 관련 정보
    private MonsterBase[] caughtMonsters;   	// 잡은 몬스터 배열
    private int caughtMonsterCount;         	// 잡은 몬스터 수
    private LocalDateTime startTime;        	// 게임 시작 시간
    private long playTime; 						// 플레이 시간 (초 단위)
    private static int defaultNameCounter = 1; 	// 기본 플레이어 이름 중복 방지를 위한 카운터
    private Scanner scanner;                	// 사용자 입력 스캐너
    
    private String playerId; 					// 플레이어 ID
    private int level = 1; 						// 플레이어 레벨

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
        return this.caughtMonsterCount;
    }
    
    public void incrementCaughtMonsterCount() {
        this.caughtMonsterCount++;
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
    
    public void startGame() {
        this.startTime = LocalDateTime.now();
        this.playTime = 0;
    }
    
    public long getPlayTime() {
        return this.playTime;
    }
    
    public void setPlayTime(long playTime) {
        this.playTime = playTime;
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
                this.userName = "트레이너" + defaultNameCounter++;
            }
        } catch (Exception e) {
            System.out.println("⚠️ 입력 도중 오류가 발생했습니다. 기본 이름으로 설정합니다.");
            this.userName = "트레이너" + defaultNameCounter++;
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
    
    // 도감 검색
    public void searchTotalPokeDex() {
        this.pokeDex.searchPokeDex();
    }

    // 맵 선택
    public void selectMap() throws InterruptedException {
        MapExploring newMap = new MapExploring();
        newMap.selectMap(this.mapExploring.getSelectionCount());
        this.mapExploring = newMap;
        
        if (newMap.getFinalMap() == MapType.CANCEL) {
            this.location = "집";
        } else {
            this.location = newMap.getFinalMap().getAreaName();
        }
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
        
        if (this.caughtMonsterCount == 0) {
            System.out.println("현재 잡은 몬스터: 없음");
        } else {
            System.out.println("현재 잡은 몬스터:");
            for (int i = 0; i < this.caughtMonsterCount; i++) {
                if (this.caughtMonsters[i] != null) {
                    System.out.println((i + 1) + ". 🎯" + this.caughtMonsters[i].getName() +
                                      " (Lv." + this.caughtMonsters[i].getLevel() + ")");
                }
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
    
    public void updatePlayTime() {
        if (startTime != null) {
            Duration sessionDuration = Duration.between(startTime, LocalDateTime.now());
            this.playTime += sessionDuration.getSeconds();
            this.startTime = LocalDateTime.now(); // 다시 측정 시작
        }
    }
    
    public void resumePlayTime() {
        this.startTime = LocalDateTime.now().minusSeconds(this.playTime);
    }
    
    // 플레이 시간을 사용자 친화적으로 포맷팅
    public String getFormattedPlayTime() {
    	long totalSeconds = this.playTime;
    	
    	if (this.startTime != null) {
            Duration duration = Duration.between(this.startTime, LocalDateTime.now());
            totalSeconds += duration.getSeconds();
        }
    	
    	long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        
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
    
    public PokeDex getPokeDex() {
        return this.pokeDex;
    }
}