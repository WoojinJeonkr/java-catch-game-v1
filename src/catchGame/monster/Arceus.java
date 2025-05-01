package catchGame.monster;

/**
 * 아르세우스 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 아르세우스의 특성과 행동을 정의합니다.
 * 아르세우스의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Arceus extends MonsterBase {

	/**
     * Arceus 생성자
     * 
     * <p>Arceus 객체를 생성하고, 몬스터 타입을 ARCEUS로 설정합니다.</p>
     */
	public Arceus() {
        super(MonsterType.ARCEUS);
    }

	/**
    * 등장 메시지를 출력하는 메서드
    * 
    * <p>
    * 아르세우스가 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
    * 랜덤한 메시지를 선택하여 출력합니다.
    * </p>
    */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"시공간이 흔들린다… " + this.getName() + "가 나타났다!\"\n➤ \"플레이트의 기운이 퍼지고 있다…\"\n(온 우주의 기원을 마주한 듯한 공포가 엄습한다.)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"빛과 어둠이 갈라진다… " + this.getName() + "의 그림자가 비친다.\"\n➤ \"그 존재만으로 세계의 균형이 흔들린다.\"\n(신오 신화가 현실이 되는 순간이다!)");
        } else {
            System.out.println("\"" + this.getName() + "가 내려왔다. 만물의 창조자, 그 이름은 아르세우스.\"\n➤ \"플레이트의 기운이 주변을 감싼다.\"\n(그 앞에선 어떤 포켓몬도 의미 없다.)");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 아르세우스는 세계의 질서를 지키는 존재이므로 도망치는 개념이 없습니다.
     * 항상 true를 반환합니다.
     * </p>
     *
     * @return 항상 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
    	System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"" + this.getName() + "는 세계의 질서를 지키는 존재… 도망이란 개념이 없다.\"\n(주위를 감싸는 기운이 점점 강해진다.)");
        return true;
    }
    
    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 0.0023%의 극악한 확률로 포획에 성공하며, 99.9977% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 0.0023% 확률로 true (포획 성공), 99.9977% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(1000000) + 1 <= 23) { // 0.0023% 확률
        	System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"기적이 일어났다! 0.0023% 확률로 " + this.getName() + "를 포획했다!\"\n(이 세계의 창조주가 조용히 몬스터볼 안에 잠들었다.)");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.getName() + "는 인간의 도전을 조용히 거절했다.\"\n➤ \"99.9977% 확률로 포획 실패… 신의 벽은 높았다.\"");
        return false;
    }

}
