package catchGame.user;

public class RankingSystem {
	// 플레이어 레벨 기준 랭킹 계산
    public User[] calculateLevelRanking(User[] players, int playerCount) {
        User[] rankedPlayers = new User[playerCount];
        
        // 플레이어 배열 복사
        for (int i = 0; i < playerCount; i++) {
            rankedPlayers[i] = players[i];
        }
        
        // 버블 정렬로 레벨 내림차순 정렬
        for (int i = 0; i < playerCount - 1; i++) {
            for (int j = 0; j < playerCount - i - 1; j++) {
                if (rankedPlayers[j].getLevel() < rankedPlayers[j + 1].getLevel()) {
                    // 플레이어 교환
                    User temp = rankedPlayers[j];
                    rankedPlayers[j] = rankedPlayers[j + 1];
                    rankedPlayers[j + 1] = temp;
                }
            }
        }
        
        return rankedPlayers;
    }
    
    // 몬스터 평균 레벨 기준 랭킹 계산
    public User[] calculateMonsterLevelRanking(User[] players, int playerCount) {
        User[] rankedPlayers = new User[playerCount];
        
        // 플레이어 배열 복사
        for (int i = 0; i < playerCount; i++) {
            rankedPlayers[i] = players[i];
        }
        
        // 버블 정렬로 몬스터 평균 레벨 내림차순 정렬
        for (int i = 0; i < playerCount - 1; i++) {
            for (int j = 0; j < playerCount - i - 1; j++) {
                if (rankedPlayers[j].calculateAverageMonsterLevel() < 
                    rankedPlayers[j + 1].calculateAverageMonsterLevel()) {
                    // 플레이어 교환
                    User temp = rankedPlayers[j];
                    rankedPlayers[j] = rankedPlayers[j + 1];
                    rankedPlayers[j + 1] = temp;
                }
            }
        }
        
        return rankedPlayers;
    }
    
    // 랭킹 정보 출력
    public void displayRanking(User[] rankedPlayers, String rankingType) {
        System.out.println("\n=== " + rankingType + " 랭킹 ===");
        
        for (int i = 0; i < rankedPlayers.length; i++) {
            if (rankingType.equals("플레이어 레벨")) {
                System.out.println((i + 1) + "위: " + rankedPlayers[i].getPlayerId() + 
                                  " (레벨: " + rankedPlayers[i].getLevel() + ")");
            } else if (rankingType.equals("몬스터 평균 레벨")) {
                System.out.printf("%d위: %s (몬스터 평균 레벨: %.2f)\n", 
                                 (i + 1), rankedPlayers[i].getPlayerId(), 
                                 rankedPlayers[i].calculateAverageMonsterLevel());
            }
        }
    }
}
