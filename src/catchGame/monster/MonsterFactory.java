package catchGame.monster;

/**
 * 몬스터 객체 생성을 위한 클래스
 * 
 * <p>몬스터 타입에 따라 해당하는 몬스터 객체를 생성합니다.</p>
 * 
 * @author Woojinjeonkr
 */
public class MonsterFactory {
	
	/**
     * 몬스터 타입에 따라 몬스터 객체를 생성하는 팩토리 메서드
     *
     * @param type 생성할 몬스터의 타입
     * @return 해당 타입의 몬스터 객체
     */
    public static MonsterBase createMonster(MonsterType type) {
        switch (type) {
            case EMPTY:
                return new EmptyMonster();
            case MAGIKARP:
                return new Magikarp();
            case PIKACHU:
                return new Pikachu();
            case NINETALES:
                return new Ninetales();
            case VENUSAUR:
                return new Venusaur();
            case KYOGRE:
                return new Kyogre();
            case GROUDON:
                return new Groudon();
            case MEWTWO:
                return new Mewtwo();
            case DIALGA:
                return new Dialga();
            case PALKIA:
                return new Palkia();
            case ARCEUS:
                return new Arceus();
            default:
                return new EmptyMonster();
        }
    }
}
