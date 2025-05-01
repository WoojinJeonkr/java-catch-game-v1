package catchGame.monster;

/**
 * 나인테일 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 나인테일의 특성과 행동을 정의합니다.
 * 나인테일의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 *
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Ninetales extends MonsterBase {

	/**
     * Ninetales 생성자
     * 
     * <p>Ninetales 객체를 생성하고, 몬스터 타입을 NINETALES로 설정합니다.</p>
     */
	public Ninetales() {
        super(MonsterType.NINETALES);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 나인테일이 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"타오르는 금빛 불꽃 속에서 " + this.getName() + "가 나타났다!\"\n➤ \"감히 나의 꼬리를 노렸느냐...\"\n(아홉 개의 꼬리가 신비로운 불꽃을 일으킨다)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"지면이 갈라지며 고대의 분노가 깨어난다... " + this.getName() + "가 솟구쳤다!\"\n➤ \"천 년의 저주를 느껴라!\"");
        } else {
            System.out.println("\"불꽃이 소용돌이치며 " + this.getName() + "가 조용히 모습을 드러낸다.\"\n➤ \"나의 꼬리에는 신의 힘이 깃들어 있다...\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 67% 확률로 나인테일이 도망치고, 33% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 67% 확률로 false (도망침), 33% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 67) { // 67% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"67% 확률로 " + this.getName() + "가 금빛 화염을 남기고 사라졌다...\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"67% 확률로 " + this.getName() + "가 지열을 타고 흔적 없이 사라졌다!\"");
            } else {
                System.out.println("\"67% 확률로 " + this.getName() + "가 불꽃 분신을 남기고 자취를 감췄다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"33% 확률로 " + this.getName() + "가 불꽃 장벽을 펼치며 버틴다!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"33% 확률로 " + this.getName() + "가 꼬리를 세우며 위협한다!\"");
        } else {
            System.out.println("\"33% 확률로 " + this.getName() + "가 마치 성자의 눈빛으로 널 응시한다...\"");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 25% 확률로 나인테일 포획에 성공하고, 75% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 25% 확률로 true (포획 성공), 75% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(4) + 1 == 1) { // 25% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"25% 확률로 " + this.getName() + "가 잡혔다! 아홉 꼬리가 빛을 내며 공처럼 봉인되었다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"75% 확률로 " + this.getName() + "가 불꽃을 내뿜어 볼을 태워버렸다!\"");
        return false;
    }

}
