package catchGame.manage;

import catchGame.user.User;

/**
 * 플레이어 관리 클래스
 * 
 * <p>플레이어 등록, 로그인, 로그아웃 및 플레이어 정보 관리를 담당합니다.</p>
 * 
 * @author Woojinjeonkr
 */
public class PlayerManager {
	/** 등록된 플레이어 배열 */
	private User[] players;
	/** 등록된 플레이어 수 */
    private int playerCount;
    /** 현재 로그인한 플레이어 */
    private User currentPlayer;
    
    /**
     * PlayerManager 생성자
     *
     * @param maxPlayers 최대 플레이어 수
     */
    public PlayerManager(int maxPlayers) {
        this.players = new User[maxPlayers];
        this.playerCount = 0;
        this.currentPlayer = null;
    }
    
    
    /**
     * 플레이어 등록 메서드
     * 
     * <p>
     * 주어진 플레이어 ID를 사용하여 새 플레이어를 등록합니다.
     * 이미 존재하는 ID인 경우 등록에 실패합니다.
     * </p>
     *
     * @param playerId 등록할 플레이어 ID
     * @return 등록 성공 시 true, 실패 시 false
     */
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
    
    /**
     * 플레이어 로그인 메서드
     * 
     * <p>
     * 주어진 플레이어 ID를 사용하여 플레이어를 로그인합니다.
     * 존재하지 않는 ID인 경우 로그인에 실패합니다.
     * </p>
     *
     * @param playerId 로그인할 플레이어 ID
     * @return 로그인 성공 시 true, 실패 시 false
     */
    public boolean loginPlayer(String playerId) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getPlayerId().equals(playerId)) {
                currentPlayer = players[i];
                return true;
            }
        }
        return false; // 존재하지 않는 ID
    }
    
    /**
     * 플레이어 로그아웃 메서드
     * 
     * <p>현재 로그인한 플레이어를 로그아웃합니다.</p>
     */
    public void logoutPlayer() {
        currentPlayer = null;
    }
    
    /**
     * 현재 로그인한 플레이어 반환 메서드
     *
     * @return 현재 로그인한 플레이어, 로그인되지 않은 경우 null
     */
    public User getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * 모든 등록된 플레이어 반환 메서드
     *
     * @return 모든 등록된 플레이어 배열
     */
    public User[] getAllPlayers() {
        User[] allPlayers = new User[playerCount];
        for (int i = 0; i < playerCount; i++) {
            allPlayers[i] = players[i];
        }
        return allPlayers;
    }
    
    /**
     * 등록된 플레이어 수 반환 메서드
     *
     * @return 등록된 플레이어 수
     */
    public int getPlayerCount() {
        return playerCount;
    }
    
    /**
     * 로그인 상태 확인 메서드
     *
     * @return 로그인 상태 (true: 로그인, false: 로그아웃)
     */
    public boolean isLoggedIn() {
        return currentPlayer != null;
    }
}
