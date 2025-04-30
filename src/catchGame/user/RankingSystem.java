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
        for (int i = 1; i < playerCount; i++) {
            User key = rankedPlayers[i];
            double keyAvgLevel = key.calculateAverageMonsterLevel();
            int j = i - 1;

            // key보다 평균 레벨이 낮은 요소를 오른쪽으로 이동
            while (j >= 0 && rankedPlayers[j].calculateAverageMonsterLevel() < keyAvgLevel) {
                rankedPlayers[j + 1] = rankedPlayers[j];
                j--;
            }
            rankedPlayers[j + 1] = key;
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
            	System.out.println((i + 1) + "위: " + rankedPlayers[i].getPlayerId() +
            	        " (몬스터 평균 레벨: " + String.format("%.2f", rankedPlayers[i].calculateAverageMonsterLevel()) 
            			+ ")\n"
            	 );
            }
        }
    }
}
