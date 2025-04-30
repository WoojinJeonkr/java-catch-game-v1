package catchGame.monster;

import java.util.Random;

public abstract class MonsterBase {
	
	protected Random random = new Random();

	protected int probabilityValue;
	protected int isMet = 1;  // 0: 못 만남, 1: 만남
    protected String name;
    protected String spawnMap;
    protected String description;
    protected boolean isCaught = false;  // 몬스터가 잡혔는지 여부
    protected int level = 1;

    public MonsterBase() {
        this.name = "기본";
    }

    public MonsterBase(MonsterType type) {
        this.name = type.getName();
        this.spawnMap = type.getSpawnMap();
        this.description = type.getDescription();
    }
    
    // 몬스터 등장 멘트
    public abstract void displayAppearanceMessage();
    
    // 몬스터가 도망칠지 결정 (true: 도망치지 않음, false: 도망침)
    public abstract boolean attemptEscape();

    // 몬스터가 잡힐지 결정 (true: 잡힘, false: 잡히지 않음)
    public abstract boolean attemptCatch() throws InterruptedException;
    
    // 지연 시간 표시 (몬스터 잡기 시도 시 사용)
    protected void showDelay() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("\n>> ...");
        Thread.sleep(500);
        System.out.println("\n>> ...");
    }
    
    public String getName() {
        return name;
    }

    public String getSpawnMap() {
        return spawnMap;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        this.isCaught = caught;
    }

    public int getIsMet() {
        return isMet;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        if (level >= 1 && level <= 100) {
            this.level = level;
        }
    }
}
