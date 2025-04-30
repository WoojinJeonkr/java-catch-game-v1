package catchGame.manage;

import java.util.Scanner;

import catchGame.user.User;

public class PlayerManager {
	private User[] players; // 등록된 플레이어 배열
    private int playerCount; // 등록된 플레이어 수
    private User currentPlayer; // 현재 로그인한 플레이어
    private Scanner scanner;
    
    public PlayerManager(int maxPlayers) {
        this.players = new User[maxPlayers];
        this.playerCount = 0;
        this.currentPlayer = null;
        this.scanner = new Scanner(System.in);
    }
    
    // 플레이어 등록 메서드
    public boolean registerPlayer(String playerId) {
        // 이미 존재하는 ID인지 확인
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerId().equals(playerId)) {
                return false; // 이미 존재하는 ID
            }
        }
        
        // 배열 공간 확인 및 확장
        if (playerCount >= players.length) {
            // 배열 크기 확장 (System.arrayCopy 사용 불가로 직접 복사)
            User[] newPlayers = new User[players.length * 2];
            for (int i = 0; i < playerCount; i++) {
                newPlayers[i] = players[i];
            }
            players = newPlayers;
        }
        
        // 새 플레이어 생성 및 등록
        User newPlayer = new User();
        newPlayer.setPlayerId(playerId);
        players[playerCount] = newPlayer;
        playerCount++;
        currentPlayer = newPlayer; // 등록 후 자동 로그인
        
        return true;
    }
    
    // 플레이어 로그인
    public boolean loginPlayer(String playerId) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerId().equals(playerId)) {
                currentPlayer = players[i];
                return true;
            }
        }
        return false; // 존재하지 않는 ID
    }
    
    // 플레이어 로그아웃
    public void logoutPlayer() {
        currentPlayer = null;
    }
    
    // 현재 로그인한 플레이어 가져오기
    public User getCurrentPlayer() {
        return currentPlayer;
    }
    
    // 모든 등록된 플레이어 가져오기
    public User[] getAllPlayers() {
        User[] allPlayers = new User[playerCount];
        for (int i = 0; i < playerCount; i++) {
            allPlayers[i] = players[i];
        }
        return allPlayers;
    }
    
    // 플레이어 수 가져오기
    public int getPlayerCount() {
        return playerCount;
    }
    
    // 로그인 상태 확인
    public boolean isLoggedIn() {
        return currentPlayer != null;
    }
}
}
