package catchGame.map;

import java.util.Random;

public enum MapType {
	SKY("하늘", "☁️", false),
    SEA("바다", "🌊", false),
    LAND("땅", "🌴", false),
    UNIVERSE("우주", "🚀", false),
    RANDOM("랜덤", "🎲", true),
    CANCEL("취소", "⚠️", true);

    private final String koreanName;
    private final String symbol;
    private final boolean isSpecial;
    private static final Random random = new Random();

    MapType(String koreanName, String symbol, boolean isSpecial) {
        this.koreanName = koreanName;
        this.symbol = symbol;
        this.isSpecial = isSpecial;
    }

    public static MapType fromKorean(String input) {
        for (MapType type : values()) {
            if (type.koreanName.equals(input)) {
                return type;
            }
        }
        return null;
    }

    public static MapType getRandomActualMap() {
        int index = random.nextInt(15);
        if (index < 4) return SKY;
        if (index < 8) return SEA;
        if (index < 12) return LAND;
        return UNIVERSE;
    }

    public String getDisplayName() {
        return symbol + " " + koreanName;
    }
}
