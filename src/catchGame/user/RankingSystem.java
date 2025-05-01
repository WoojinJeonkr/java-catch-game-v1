package catchGame.user;

/**
 * 랭킹 시스템 클래스
 * 
 * <p>
 * 플레이어의 랭킹을 계산하고 출력하는 기능을 제공합니다.
 * 플레이어 레벨 및 몬스터 평균 레벨을 기준으로 랭킹을 계산하고,
 * 계산된 랭킹 정보를 콘솔에 출력합니다.
 * </p>
 * 
 * @author Woojinjeonkr
 */
public class RankingSystem {
	
	/**
     * 플레이어 레벨 기준 랭킹 계산 메서드
     * 
     * <p>
     * 주어진 플레이어 배열을 플레이어 레벨을 기준으로 내림차순 정렬하여 랭킹을 계산합니다.
     * 삽입 정렬 알고리즘을 사용하여 정렬을 수행합니다.
     * </p>
     *
     * @param players   플레이어 정보가 담긴 User 객체 배열
     * @param playerCount 플레이어 수
     * @return 레벨을 기준으로 정렬된 User 객체 배열
     */
    public User[] calculateLevelRanking(User[] players, int playerCount) {
        User[] rankedPlayers = new User[playerCount];
        
        // 플레이어 배열 복사
        for (int i = 0; i < playerCount; i++) {
            rankedPlayers[i] = players[i];
        }
        
        // 삽입 정렬로 레벨 내림차순 정렬
        for (int i = 1; i < playerCount; i++) {
            User key = rankedPlayers[i];
            int j = i - 1;

            // key를 정렬된 부분으로 삽입할 위치를 찾음
            while (j >= 0 && rankedPlayers[j].getLevel() < key.getLevel()) {
                rankedPlayers[j + 1] = rankedPlayers[j]; // 하나씩 뒤로 이동
                j = j - 1;
            }
            
            rankedPlayers[j + 1] = key; // key를 적절한 위치에 삽입
        }
        
        return rankedPlayers;
    }
    
    /**
     * 몬스터 평균 레벨 기준 랭킹 계산 메서드
     * 
     * <p>
     * 주어진 플레이어 배열을 몬스터 평균 레벨을 기준으로 내림차순 정렬하여 랭킹을 계산합니다.
     * 삽입 정렬 알고리즘을 사용하여 정렬을 수행합니다.
     * </p>
     *
     * @param players   플레이어 정보가 담긴 User 객체 배열
     * @param playerCount 플레이어 수
     * @return 몬스터 평균 레벨을 기준으로 정렬된 User 객체 배열
     */
    public User[] calculateMonsterLevelRanking(User[] players, int playerCount) {
        User[] rankedPlayers = new User[playerCount];
        
        // 플레이어 배열 복사
        for (int i = 0; i < playerCount; i++) {
            rankedPlayers[i] = players[i];
        }
        
        // 삽입 정렬로 몬스터 평균 레벨 내림차순 정렬
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
    
    /**
     * 랭킹 정보 출력 메서드
     * 
     * <p>
     * 계산된 랭킹 정보를 콘솔에 출력합니다.
     * 랭킹 타입에 따라 플레이어 레벨 또는 몬스터 평균 레벨을 함께 출력합니다.
     * </p>
     *
     * @param rankedPlayers 정렬된 플레이어 정보 배열
     * @param rankingType   랭킹 타입 ("플레이어 레벨" 또는 "몬스터 평균 레벨")
     */
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
