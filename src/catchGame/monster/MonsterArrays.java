package catchGame.monster;

import java.util.Random;

/**
 * 몬스터 등장 확률을 관리하는 클래스
 */
public class MonsterArrays {
	private Random random = new Random();

	// 등장 횟수 카운트 (통계용)
    public int emptyEncounterCount = 0;
    public int firstMonsterCount = 0;
    public int secondMonsterCount = 0;
    public int thirdMonsterCount = 0;

    // 땅맵에서 몬스터 생성
    public MonsterBase createEarthMonster() {
        int randomValue = random.nextInt(20);
        
        if (randomValue <= 3) {  // 20% 확률
            this.emptyEncounterCount++;
            return MonsterFactory.createMonster(MonsterType.EMPTY);
        } else if (randomValue <= 8) {  // 25% 확률
        	this.firstMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.PIKACHU);
        } else if (randomValue <= 13) {  // 25% 확률
        	this.secondMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.NINETALES);
        } else {  // 30% 확률
        	this.thirdMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.VENUSAUR);
        }
    }

    // 바다맵에서 몬스터 생성
    public MonsterBase createSeaMonster() {
        int randomValue = random.nextInt(20);
        
        if (randomValue <= 7) {  // 40% 확률
        	this.emptyEncounterCount++;
            return MonsterFactory.createMonster(MonsterType.EMPTY);
        } else if (randomValue <= 15) {  // 40% 확률
        	this.firstMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.MAGIKARP);
        } else if (randomValue == 16) {  // 5% 확률
        	this.secondMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.KYOGRE);
        } else {  // 15% 확률
        	this.thirdMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.GROUDON);
        }
    }

    // 하늘맵에서 몬스터 생성
    public MonsterBase createSkyMonster() {
        int randomValue = random.nextInt(20);
        
        if (randomValue <= 1) {  // 10% 확률
        	this.emptyEncounterCount++;
            return MonsterFactory.createMonster(MonsterType.EMPTY);
        } else if (randomValue <= 9) {  // 40% 확률
        	this.firstMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.MEWTWO);
        } else if (randomValue <= 14) {  // 25% 확률
        	this.secondMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.DIALGA);
        } else {  // 25% 확률
        	this.thirdMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.PALKIA);
        }
    }

    // 우주맵에서 몬스터 생성
    public MonsterBase createUniverseMonster() {
        int randomValue = random.nextInt(200);
        
        if (randomValue <= 179) {  // 90% 확률
        	this.emptyEncounterCount++;
            return MonsterFactory.createMonster(MonsterType.EMPTY);
        } else if (randomValue <= 187) {  // 4% 확률
        	this.firstMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.DIALGA);
        } else if (randomValue <= 195) {  // 4% 확률
        	this.secondMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.PALKIA);
        } else {  // 2% 확률
        	this.thirdMonsterCount++;
            return MonsterFactory.createMonster(MonsterType.ARCEUS);
        }
    }
}
