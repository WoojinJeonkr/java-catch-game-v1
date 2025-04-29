package catchGame.monster;

/**
 * 몬스터 객체 생성을 위한 클래스
 */
public class MonsterFactory {
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
