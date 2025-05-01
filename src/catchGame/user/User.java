package catchGame.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.map.MapType;
import catchGame.monster.MonsterBase;
import catchGame.monster.MonsterFactory;
import catchGame.monster.MonsterType;

/**
 * 사용자 정보 관리 클래스
 * 
 * <p>
 * 사용자의 이름, 위치, 포켓몬 도감, 맵 탐험 정보, 잡은 몬스터 정보 등을 관리하고,
 * 사용자의 게임 진행 관련 기능을 제공합니다.
 * </p>
 * 
 * @author Woojinjeonkr
 */
public class User {
	/** 사용자 이름 */
	private String userName;
	/** 사용자 위치 */
    private String location;
    /** 사용자의 포켓몬 도감 */
    private PokeDex pokeDex;
    /** 맵 탐험 관련 정보 */
    private MapExploring mapExploring;
    /** 잡은 몬스터 배열 */
    private MonsterBase[] caughtMonsters;
    /** 잡은 몬스터 수 */
    private int caughtMonsterCount;
    /** 게임 시작 시간 */
    private LocalDateTime startTime;
    /** 플레이 시간 (초 단위) */
    private long playTime;
    /** 기본 플레이어 이름 중복 방지를 위한 카운터 */
    private static int defaultNameCounter = 1;
    /** 사용자 입력 스캐너 */
    private Scanner scanner;
    /** 플레이어 ID */
    private String playerId;
    /** 플레이어 레벨 */
    private int level = 1;

    /**
     * User 객체 생성자
     * 
     * <p>사용자 이름을 입력받고, 새로운 포켓몬 도감을 생성하여 초기화합니다.</p>
     */

    public User() {
        scanner = new Scanner(System.in);
        this.playerId = "";
        initializeUser();
    }
    
    /**
     * 사용자 이름 반환 메서드
     *
     * @return 사용자 이름
     */
    public String getUserName() {
    	return this.userName;
    }
    
    /**
     * 사용자 위치 반환 메서드
     *
     * @return 사용자 위치
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * 사용자 위치 설정 메서드
     *
     * @param location 설정할 사용자 위치
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 사용자 이름 설정 메서드
     *
     * @param userName 설정할 사용자 이름
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 잡은 몬스터 배열 반환 메서드
     *
     * @return 잡은 몬스터 배열
     */
    public MonsterBase[] getCaughtMonsters() {
        return this.caughtMonsters;
    }

    /**
     * 잡은 몬스터 수 반환 메서드
     *
     * @return 잡은 몬스터 수
     */
    public int getCaughtMonsterCount() {
        return this.caughtMonsterCount;
    }
    
    /** 잡은 몬스터 수 증가 메서드 */
    public void incrementCaughtMonsterCount() {
        this.caughtMonsterCount++;
    }
    
    /**
     * 플레이어 ID 반환 메서드
     *
     * @return 플레이어 ID
     */
    public String getPlayerId() {
        return this.playerId;
    }
    
    /**
     * 플레이어 ID 설정 메서드
     *
     * @param playerId 설정할 플레이어 ID
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
    
    /**
     * 플레이어 레벨 반환 메서드
     *
     * @return 플레이어 레벨
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * 플레이어 레벨 설정 메서드
     *
     * @param level 설정할 플레이어 레벨 (0보다 커야 함)
     */
    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        }
    }
    
    /** 게임 시작 시간 설정 및 플레이 시간 초기화 메서드 */
    public void startGame() {
        this.startTime = LocalDateTime.now();
        this.playTime = 0;
    }
    
    /**
     * 플레이 시간 반환 메서드
     *
     * @return 플레이 시간 (초)
     */
    public long getPlayTime() {
        return this.playTime;
    }
    
    /**
     * 플레이 시간 설정 메서드
     *
     * @param playTime 설정할 플레이 시간 (초)
     */
    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }
    
    /** 플레이어 레벨 증가 메서드 */
    public void increaseLevel() {
        this.level++;
    }
    
    /**
     * 소지 몬스터 평균 레벨 계산 메서드
     *
     * @return 소지 몬스터의 평균 레벨
     */
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
    
    /**
     * 사용자 초기화 메서드
     * 
     * <p>
     * 사용자 이름 입력, 포켓몬 도감 생성, 맵 탐험 정보 초기화,
     * 시작 시간 설정, 잡은 몬스터 배열 초기화 등을 수행합니다.
     * </p>
     */
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

    /** 사용자의 포켓몬 도감 출력 메서드 */
    public void printMyPokeDex() {
        this.pokeDex.printPokeDex();
    }
    
    /** 전체 포켓몬 도감 검색 메서드 */
    public void searchTotalPokeDex() {
        this.pokeDex.searchPokeDex();
    }

    /**
     * 맵 선택 메서드
     *
     * @throws InterruptedException 맵 선택 중 인터럽트 발생 시 예외 처리
     */
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

    /** 사용자 정보 출력 메서드 */
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

    /**
     * 문자열 앞뒤 공백 제거 메서드
     *
     * @param input 공백을 제거할 문자열
     * @return 앞뒤 공백이 제거된 문자열
     */
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
    
    /**
     * 문자열이 비어있는지 확인하는 메서드
     *
     * @param input 확인할 문자열
     * @return 문자열이 비어있으면 true, 그렇지 않으면 false
     */
    private boolean isEmptyInput(String input) {
        return input == null || input.length() == 0;
    }
    
    /**
     * 플레이 시간 갱신 메서드
     * 
     * <p>현재까지의 플레이 시간을 누적하고, 시작 시간을 갱신합니다.</p>
     */
    public void updatePlayTime() {
        if (startTime != null) {
            Duration sessionDuration = Duration.between(startTime, LocalDateTime.now());
            this.playTime += sessionDuration.getSeconds();
            this.startTime = LocalDateTime.now(); // 다시 측정 시작
        }
    }
    
    /** 일시 정지된 플레이 시간을 재개하는 메서드 */
    public void resumePlayTime() {
        this.startTime = LocalDateTime.now().minusSeconds(this.playTime);
    }
    
    /**
     * 플레이 시간을 사용자 친화적인 형식으로 반환하는 메서드
     *
     * @return "HH시간 MM분 SS초" 형식의 플레이 시간 문자열
     */
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
    
    /** 잡은 몬스터 정보 초기화 메서드 */
    public void resetCaughtMonsters() {
        this.caughtMonsters = new MonsterBase[6]; // 최대 6마리로 변경
        this.caughtMonsterCount = 0;
    }
    
    /**
     * 불러온 몬스터를 잡은 몬스터 목록에 추가하는 메서드
     *
     * @param monsterName 추가할 몬스터 이름
     * @param level       추가할 몬스터 레벨
     */
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
    
    /**
     * 사용자의 포켓몬 도감 반환 메서드
     *
     * @return 사용자의 포켓몬 도감
     */
    public PokeDex getPokeDex() {
        return this.pokeDex;
    }
}