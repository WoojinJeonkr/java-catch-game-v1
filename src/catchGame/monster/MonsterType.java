package catchGame.monster;

public enum MonsterType {
	EMPTY("기본", "", "텅 빈 거리, 텅 빈 내 위장, 텅 빈 내 지갑"),
    MAGIKARP("잉어킹", "바다", "물 타입 포켓몬 | 바다에서 자주 보이는, 느긋하게 움직이는 생물. 맛은 있을지도?"),
    PIKACHU("피카츄", "땅", "전기 타입 포켓몬 | 볼이 부족한 트레이너에겐 기쁨을, 볼이 많은 트레이너에겐 특별함을, 뽑기방에겐 행운을 전해주는 온 세계가 사랑하는 마스코트 포켓몬"),
    NINETALES("다꼬리", "땅", "불 타입 포켓몬 | 아홉 개의 꼬리를 가진 여우 포켓몬, 그 꼬리는 천 년의 지혜를 담고 있다고 한다, 화려한 모습에 속지 말라 상당히 강력하다"),
    VENUSAUR("이상해꽃", "땅", "풀/독 타입 포켓몬 | 등의 꽃에서 향을 내뿜어 사람들의 마음을 편안하게 만든다, 포켓몬스터 스타팅 삼대장 중 하나"),
    KYOGRE("가이오가", "바다", "물 타입 포켓몬 | 고대 전설의 포켓몬으로 바다를 창조한 신, 원시회귀하면 원시의 바다로 모든 대지를 집어삼킨다고 한다"),
    GROUDON("그란돈", "바다", "땅 타입 포켓몬 | 고대 전설의 포켓몬으로 대륙을 창조한 신, 원시회귀하면 태양 빛이 강해져 대지가 말라버린다고 한다"),
    MEWTWO("뮤츠", "하늘", "에스퍼 타입 포켓몬 | 유전자 조작으로 태어난 포켓몬으로, 뛰어난 정신 능력을 지니고 있으며 사람에 대해 경계심을 가지고 있다"),
    DIALGA("디아루가", "하늘", "강철/드래곤 타입 포켓몬 | 시간의 흐름을 조종할 수 있는 전설의 포켓몬, 포켓몬의 신 아르세우스가 만든 창조물 중 하나"),
    PALKIA("펄기아", "하늘", "물/드래곤 타입 포켓몬 | 공간을 자유자재로 조종할 수 있는 전설의 포켓몬, 포켓몬의 신 아르세우스가 만든 창조물 중 하나"),
    ARCEUS("아르세우스", "우주", "노말 타입 포켓몬 | 모든 포켓몬을 창조했다고 전해지는 포켓몬의 신, 전설에 따르면 세계 이전부터 존재했다고 한다");
	
	private final String name;
    private final String spawnMap;
    private final String description;
    
    MonsterType(String name, String spawnMap, String description) {
        this.name = name;
        this.spawnMap = spawnMap;
        this.description = description;
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
}
