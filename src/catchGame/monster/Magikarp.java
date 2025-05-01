package catchGame.monster;

/**
 * 잉어킹 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 잉어킹의 특성과 행동을 정의합니다.
 * 잉어킹의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Magikarp extends MonsterBase {
	
	/**
     * Magikarp 생성자
     * 
     * <p>Magikarp 객체를 생성하고, 몬스터 타입을 MAGIKARP로 설정합니다.</p>
     */
	public Magikarp() {
        super(MonsterType.MAGIKARP);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 잉어킹이 등장했을 때의 다양한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
        	System.out.println("\"물가에서 뭔가가 펄쩍 뛰었다...!\"");
            System.out.println("➤ 잉어킹이 모습을 드러냈다!");
            System.out.println("(빨간 몸에 왕관 같은 지느러미, 전투보단 수면에 어울리는 느낌이다.)");
        } else if (this.probabilityValue == 1) {
        	System.out.println("\"강한 포스는 느껴지지 않는다...\"");
            System.out.println("➤ 하지만 잉어킹은 기세 좋게 점프했다!");
            System.out.println("(피죤이 날아와 데려갈까 걱정되는 점프력이다.)");
        } else {
        	System.out.println("\"잉어킹이 등장했다! 그런데 이건... 생선인가...?\"");
            System.out.println("➤ 트레이너가 당황하고 있다!");
            System.out.println("(어쩌면 산도 넘을 수 있겠지만 지금은 그냥 물가에서 졸고 있었던 듯하다.)");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 10% 확률로 잉어킹이 도망치고, 90% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 10% 확률로 false (도망침), 90% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        // 10% 확률로 도망
        if (random.nextInt(10) + 1 == 1) {
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
            	System.out.println("\"10% 확률로 잉어킹이 허둥지둥 도망쳤다!\"");
                System.out.println("➤ \"잉어~~~! (나도 탈출쯤은 할 수 있지!)\"");
                System.out.println("(그러나 뒷걸음질이 심해서 거의 제자리에서 버둥거린다.)");
            } else if (this.probabilityValue == 1) {
            	System.out.println("\"잉어킹이 바다의 왕이라도 된 듯 전속력으로 달아난다!\"");
                System.out.println("➤ \"잉어잉어잉어킹~~~! (이게 진짜 나의 실력이다!)\"");
                System.out.println("(방향 감각은 없어 보이지만 속도만큼은 그럴싸하다.)");
            } else {
            	System.out.println("\"잉어킹이 갑자기 공포를 느끼고 달아났다!\"");
                System.out.println("(한동안 자랑거리로 삼을 수 있을지도 모른다.)");
            }
            
            System.out.println();
            return false;
        }
        
        // 90% 확률로 도망치지 않음
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
        	System.out.println("\"잉어킹은 도망칠 생각이 없다. 여기가 바로 자신의 왕국이라 생각하는 듯하다!\"");
            System.out.println("➤ \"잉어~! (이곳은 나의 물속 세계!)\"");
            System.out.println("(잔잔한 물결 속에서 유유히 수영 중이다.)");
        } else if (this.probabilityValue == 1) {
        	System.out.println("\"잉어킹은 움직이지 않는다. 오히려 트레이너를 구경하는 중이다.\"");
            System.out.println("➤ \"잉어잉어킹~ (도망? 왜 그래야 하지?)\"");
            System.out.println("(근처를 돌며 느긋하게 지느러미를 흔들고 있다.)");
        } else {
        	System.out.println("\"잉어킹이 도망치지 않고 갑자기 몸을 흔들기 시작했다!\"");
            System.out.println("➤ \"잉어~! (이게 나만의 무브야!)\"");
            System.out.println("(혼자서 리듬을 타며 춤을 추는 듯한 모습이다.)");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 0.1% 확률로 잉어킹 포획에 성공하고, 99.9% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 0.1% 확률로 true (포획 성공), 99.9% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        // 0.1% 확률로 잡힘
        if (random.nextInt(1000) + 1 == 1) {
        	System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"" + this.name + "이(가) 허무하게 잡혀버렸다!\"");
            System.out.println("➤ 0.1%의 기적! 이건 집에 가서 자랑할 일이다.");
            System.out.println("(누구나 잡을 수 있을 것 같지만, 사실 잡기 어려운 녀석이다.)");
            System.out.println();
            this.isCaught = true;
            return true;
        }
        
        // 99.9% 확률로 잡히지 않음
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.name + "의 모습이 다시 물속으로 사라졌다...\"");
        System.out.println("➤ 놓쳐버렸다! 0.1% 확률의 실패.");
        System.out.println("(잉어킹 하나도 못 잡다니... 트레이너의 자존심이 무너진다.)");
        System.out.println();
        return false;
    }

}
