package catchGame.map;

import java.util.Random;

/**
 * 맵 타입을 정의하는 enum 클래스
 * 
 * <p>게임 내 맵의 종류를 나타내며, 각 맵의 이름, 기호, 특수 맵 여부를 관리합니다.</p>
 * 
 * @author Woojinjeonkr
 */
public enum MapType {
	/** 하늘 맵 */
	SKY("하늘", "☁️", false),
	/** 바다 맵 */
    SEA("바다", "🌊", false),
    /** 땅 맵 */
    LAND("땅", "🌴", false),
    /** 우주 맵 */
    UNIVERSE("우주", "🚀", false),
    /** 랜덤 맵 */
    RANDOM("랜덤", "🎲", true),
    /** 집 */
    HOME("집", "🏠", false),
    /** 맵 선택 취소 */
    CANCEL("취소", "⚠️", true);

	/** 맵 이름 */
    private final String areaName;
    /** 맵 심볼 */
    private final String symbol;
    /** 특수 맵 여부 */
    private final boolean isSpecial;
    /** 랜덤 맵 선택을 위한 Random 객체 */
    private static final Random random = new Random();

    /**
     * MapType 생성자
     *
     * @param koreanName 맵 이름 (한글)
     * @param symbol     맵 기호
     * @param isSpecial  특수 맵 여부
     */
    MapType(String koreanName, String symbol, boolean isSpecial) {
        this.areaName = koreanName;
        this.symbol = symbol;
        this.isSpecial = isSpecial;
    }

    /**
     * 한글 이름을 통해 MapType을 찾는 메서드
     *
     * @param input 찾을 맵 이름 (한글)
     * @return 해당하는 MapType, 없으면 null 반환
     */
    public static MapType fromKorean(String input) {
        for (MapType type : values()) {
            if (type.areaName.equals(input)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 랜덤으로 실제 맵을 선택하는 메서드 (RANDOM, CANCEL 제외)
     *
     * @return 랜덤으로 선택된 실제 맵 (SKY, SEA, LAND, UNIVERSE 중 하나)
     */
    public static MapType getRandomActualMap() {
        int index = random.nextInt(15);
        if (index < 4) return SKY;
        if (index < 8) return SEA;
        if (index < 12) return LAND;
        return UNIVERSE;
    }

    /**
     * 맵의 표시 이름을 반환하는 메서드 (기호 + 이름)
     *
     * @return 맵의 표시 이름
     */
    public String getDisplayName() {
        return symbol + " " + areaName;
    }
    
    /**
     * 맵 이름을 반환하는 메서드
     *
     * @return 맵 이름
     */
    public String getAreaName() {
        return areaName;
    }
}
