package catchGame.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import catchGame.map.MapExploring;
import catchGame.map.MapType;
import catchGame.monster.MonsterArrays;
import catchGame.monster.MonsterBase;

public class User {
	private String userName;                // 사용자 이름
    private String location;                // 사용자 위치
    private PokeDex pokeDex;           // 사용자의 포켓몬 도감
    private MapExploring mapExploring;      // 맵 탐험 관련 정보
    private MonsterBase[] caughtMonsters;   // 잡은 몬스터 배열
    private int caughtMonsterCount;         // 잡은 몬스터 수
    private LocalDateTime startTime;        // 게임 시작 시간
    private Scanner scanner;                // 사용자 입력 스캐너

	// User 객체 생성 시 이름 입력받고, 새로운 도감 불러옴
    public User() {
        scanner = new Scanner(System.in);
        initializeUser();
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
        this.caughtMonsters = new MonsterBase[100];
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
            if (askUserToFight()) {
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
                        this.caughtMonsters[caughtMonsterCount] = monster;
                        caughtMonsterCount++;
                        System.out.println("✨ 띠링! " + monster.getName() + "이(가) 포켓몬 도감에 등록되었습니다!");
                        this.pokeDex.updatePokeDex(monster.getName());
                    }
                }
            }
        } else {
            // 기본 몬스터(아무것도 만나지 않음)의 경우
            monster.attemptEscape();
        }
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
        int lineLimit = 2;
        int countOnLine = 0;
        
        System.out.println("사용자명: " + this.userName);
        System.out.println("사용자 위치: " + (this.location.equals("취소") ? "집" : this.location));
        System.out.println("플레이 시간: " + getFormattedPlayTime());
        System.out.println("잡은 몬스터 수: " + caughtMonsterCount + "마리");
        System.out.println("현재 잡은 몬스터\n");
        
        // 중복 제거하여 몬스터 목록 출력
        for (int i = 0; i < this.caughtMonsterCount; i++) {
            if (this.caughtMonsters[i] == null) continue;
            
            // 이미 출력된 몬스터인지 확인
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (this.caughtMonsters[j] != null && 
                    this.caughtMonsters[i].getName().equals(this.caughtMonsters[j].getName())) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (isDuplicate) continue;
            
            // 몬스터 정보 출력
            if (countOnLine > 0) System.out.print(", ");
            System.out.print("🎯" + this.caughtMonsters[i].getName());
            countOnLine++;
            
            if (countOnLine == lineLimit) {
                System.out.println();
                countOnLine = 0;
            }
        }
        
        if (countOnLine > 0) {
            System.out.println();
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
    private String getFormattedPlayTime() {
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        
        return String.format("%02d시간 %02d분 %02d초", hours, minutes, seconds);
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}