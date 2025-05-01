package catchGame.monster;

import java.util.Random;

/**
 * 몬스터의 기본 동작 및 속성을 정의하는 추상 클래스
 * 
 * <p>모든 몬스터는 이 클래스를 상속받아 구현됩니다.</p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public abstract class MonsterBase {
	
	/** 랜덤 값 생성을 위한 Random 객체 */
	protected Random random = new Random();
	/** 확률 계산을 위한 값 */
	protected int probabilityValue;
	/** 몬스터 조우 여부 (0: 못 만남, 1: 만남) */
	protected int isMet = 1;
	/** 몬스터 이름 */
    protected String name;
    /** 몬스터 출현 맵 */
    protected String spawnMap;
    /** 몬스터 설명 */
    protected String description;
    /** 몬스터가 잡혔는지 여부 */
    protected boolean isCaught = false;
    /** 몬스터 레벨 */
    protected int level = 1;

    /**
     * 기본 생성자
     * 
     * <p>몬스터 이름을 "기본"으로 설정합니다.</p>
     */
    public MonsterBase() {
        this.name = "기본";
    }

    /**
     * MonsterType을 인자로 받는 생성자
     * 
     * <p>몬스터의 이름, 출현 맵, 설명을 MonsterType에서 가져와 설정합니다.</p>
     *
     * @param type 몬스터 타입
     */
    public MonsterBase(MonsterType type) {
        this.name = type.getName();
        this.spawnMap = type.getSpawnMap();
        this.description = type.getDescription();
    }
    
    /** 몬스터 등장 메시지를 출력하는 메서드 (추상 메서드) */
    public abstract void displayAppearanceMessage();
    
    /**
     * 몬스터가 도망칠지 결정하는 메서드 (추상 메서드)
     *
     * @return true: 도망치지 않음, false: 도망침
     */
    public abstract boolean attemptEscape();

    /**
     * 몬스터가 잡힐지 결정하는 메서드 (추상 메서드)
     *
     * @return true: 잡힘, false: 잡히지 않음
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    public abstract boolean attemptCatch() throws InterruptedException;
    
    /**
     * 지연 시간을 표시하는 메서드 (몬스터 잡기 시도 시 사용)
     *
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    protected void showDelay() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("\n>> ...");
        Thread.sleep(500);
        System.out.println("\n>> ...");
    }
    
    /**
     * 몬스터 이름을 반환하는 메서드
     *
     * @return 몬스터 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 몬스터 출현 맵을 반환하는 메서드
     *
     * @return 몬스터 출현 맵
     */
    public String getSpawnMap() {
        return spawnMap;
    }

    /**
     * 몬스터 설명을 반환하는 메서드
     *
     * @return 몬스터 설명
     */
    public String getDescription() {
        return description;
    }

    /**
     * 몬스터가 잡혔는지 여부를 반환하는 메서드
     *
     * @return true: 잡힘, false: 잡히지 않음
     */
    public boolean isCaught() {
        return isCaught;
    }

    /**
     * 몬스터의 잡힘 여부를 설정하는 메서드
     *
     * @param caught 몬스터 잡힘 여부
     */
    public void setCaught(boolean caught) {
        this.isCaught = caught;
    }

    /**
     * 몬스터 조우 여부를 반환하는 메서드
     *
     * @return 몬스터 조우 여부 (0 또는 1)
     */
    public int getIsMet() {
        return isMet;
    }
    
    /**
     * 몬스터 레벨을 반환하는 메서드
     *
     * @return 몬스터 레벨
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * 몬스터 레벨을 설정하는 메서드
     * 
     * <p>레벨은 1에서 100 사이의 값으로 설정할 수 있습니다.</p>
     *
     * @param level 몬스터 레벨
     */
    public void setLevel(int level) {
        if (level >= 1 && level <= 100) {
            this.level = level;
        }
    }
}
