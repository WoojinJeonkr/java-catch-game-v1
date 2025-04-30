package catchGame.manage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import catchGame.monster.MonsterBase;
import catchGame.user.User;

/**
 * 파일 저장 및 불러오기 클래스
 */
public class GameSaveManager {
	private static final int MAX_SAVES = 5;
    private String[] savedFiles = new String[MAX_SAVES];
    private int saveCount = 0;
    
    Scanner scanner = new Scanner(System.in);
    
    public GameSaveManager() {
        loadSaveFilesList();
    }
    
    // 저장된 파일 목록 로드
    private void loadSaveFilesList() {
        File directory = new File("saves");
        if (!directory.exists()) {
            directory.mkdir();
        }
        
        File[] files = directory.listFiles();
        if (files != null) {
            saveCount = 0;
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    if (saveCount < MAX_SAVES) {
                        savedFiles[saveCount] = file.getName();
                        saveCount++;
                    }
                }
            }
        }
    }
    
    // 파일 저장
    public void saveGame(User user) {
        if (saveCount >= MAX_SAVES) {
            System.out.print("삭제할 세이브 번호 선택:");
            for (int i = 0; i < saveCount; i++) {
                System.out.println((i + 1) + ". " + savedFiles[i]);
            }
            
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0 && choice <= saveCount) {
                    // 선택한 파일 삭제
                    File fileToDelete = new File("saves/" + savedFiles[choice - 1]);
                    if (fileToDelete.exists()) {
                        fileToDelete.delete();
                    }
                    
                    // 배열 정리 (선택한 파일 이후의 항목들을 한 칸씩 앞으로 이동)
                    for (int i = choice - 1; i < saveCount - 1; i++) {
                        savedFiles[i] = savedFiles[i + 1];
                    }
                    
                    savedFiles[saveCount - 1] = null;
                    saveCount--;
                } else {
                    System.out.println("잘못된 선택입니다.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                return;
            }
        }
        
        // 파일명에 플레이어 ID 포함
        String fileName = getCurrentDateTime() + "-" + user.getPlayerId() + "-" + user.getUserName() + ".txt";
        
        // saves 디렉토리 확인 및 생성
        File directory = new File("saves");
        if (!directory.exists()) {
            directory.mkdir();
        }
        
        // 파일 저장
        try (PrintWriter writer = new PrintWriter("saves/" + fileName)) {
            // 플레이어 ID 저장
            writer.println("PLAYER_ID=" + user.getPlayerId());
            // 플레이어 레벨 저장
            writer.println("PLAYER_LEVEL=" + user.getLevel());
            
            // 기존 정보 저장
            writer.println("USER_NAME=" + user.getUserName());
            writer.println("LOCATION=" + user.getLocation());
            writer.println("CAUGHT_COUNT=" + user.getCaughtMonsterCount());
            
            // 잡은 몬스터 정보 저장
            MonsterBase[] monsters = user.getCaughtMonsters();
            for (int i = 0; i < user.getCaughtMonsterCount(); i++) {
                if (monsters[i] != null) {
                    writer.println("MONSTER=" + monsters[i].getName() + "," + monsters[i].getLevel());
                }
            }
            
            System.out.println("✅ 성공적으로 저장되었습니다 ("+fileName+")");
            // 저장된 파일 목록 업데이트
            savedFiles[saveCount] = fileName;
            saveCount++;
        } catch (FileNotFoundException e) {
            System.out.println("저장 실패: " + e.getMessage());
        }
    }
    
    // 현재 날짜-시간 문자열 반환
    private String getCurrentDateTime() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss");
        return formatter.format(new java.util.Date());
    }
    
    // 저장된 게임 목록 표시 및 선택
    public boolean loadGame(User user) {
        // 저장된 파일 목록 새로고침
        loadSaveFilesList();
        
        if (saveCount == 0) {
            System.out.println("저장된 게임이 없습니다.");
            return false;
        }
        
        // 저장된 파일 목록 표시
        System.out.println("불러올 세이브 선택:");
        for (int i = 0; i < saveCount; i++) {
            System.out.println((i + 1) + ". " + savedFiles[i]);
        }
        System.out.println((saveCount + 1) + ". 취소");
        
        // 사용자 선택 받기
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= saveCount) {
                return loadGameFile(user, savedFiles[choice - 1]);
            } else if (choice == saveCount + 1) {
                System.out.println("로드 취소");
                return false;
            } else {
                System.out.println("잘못된 선택입니다.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return false;
        }
    }
    
    // 선택한 파일 로드
    private boolean loadGameFile(User user, String fileName) {
        File file = new File("saves/" + fileName);
        if (!file.exists()) {
            System.out.println("파일을 찾을 수 없습니다: " + fileName);
            return false;
        }
        
        try (Scanner scanner = new Scanner(file)) {
            // 몬스터 배열 초기화
            user.resetCaughtMonsters();
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    
                    switch (key) {
                        case "PLAYER_ID":
                            user.setPlayerId(value);
                            break;
                        case "PLAYER_LEVEL":
                            user.setLevel(Integer.parseInt(value));
                            break;
                        case "USER_NAME":
                            user.setUserName(value);
                            break;
                        case "LOCATION":
                            user.setLocation(value);
                            break;
                        case "MONSTER":
                            String[] monsterData = value.split(",");
                            if (monsterData.length == 2) {
                                String monsterName = monsterData[0];
                                int monsterLevel = Integer.parseInt(monsterData[1]);
                                user.addLoadedMonster(monsterName, monsterLevel);
                            }
                            break;
                    }
                }
            }
            
            System.out.println("✅ "+fileName+"에서 성공적으로 복원되었습니다");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("파일을 읽을 수 없습니다: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("파일 로드 중 오류 발생: " + e.getMessage());
            return false;
        }
    }
}
