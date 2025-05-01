package catchGame.monster;

/**
 * 피카츄 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 피카츄의 특성과 행동을 정의합니다.
 * 피카츄의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Pikachu extends MonsterBase {

	/**
     * Pikachu 생성자
     * 
     * <p>Pikachu 객체를 생성하고, 몬스터 타입을 PIKACHU로 설정합니다.</p>
     */
	public Pikachu() {
        super(MonsterType.PIKACHU);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 피카츄가 등장했을 때의 다양한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"노란 몸에 번개 모양 꼬리… " + this.getName() + "가 모습을 드러냈다!\"\n➤ \"피카~츄!!\"\n(꼬리를 세우며 전기 주머니에 전기를 모으고 있다!)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"빨간 뺨에서 전기가 튀는 " + this.getName() + "가 등장했다!\"\n➤ 전기 주머니가 부드럽고 잘 늘어나 보인다... 강력한 전기가 예고된다! ⚡");
        } else {
            System.out.println("\"" + this.getName() + "가 주머니 속에서 튀어나오듯 등장했다!\"\n➤ \"피카피카~!\"\n(여러 마리 피카츄가 모여 있는 숲에서는 벼락이 끊이지 않는다는데...)");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 32% 확률로 피카츄가 도망치고, 68% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 32% 확률로 false (도망침), 68% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(25) + 1 <= 8) { // 32% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"" + this.getName() + "가 전기를 방출하며 재빠르게 숲속으로 사라졌다!\"\n➤ \"피카~!! (도망가는 것도 전광석화처럼!)\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"꼬리를 세운 " + this.getName() + "가 순간 번쩍이더니 시야에서 사라졌다!\"\n➤ \"피카! 피카!! (전기 충전 완료! 탈출 개시!)\"");
            } else {
                System.out.println("\"" + this.getName() + "는 전자파를 휘감고 주위 나뭇잎을 흔들며 사라졌다. 잡을 수 없을 것만 같다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"" + this.getName() + "는 전기를 더 축적하기 위해 움직이지 않는다. 지금이 기회인가?\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"" + this.getName() + "는 뺨을 부풀리며 전자파로 주변을 방어하고 있다! 도망칠 생각은 없어 보인다.\"");
        } else {
            System.out.println("\"" + this.getName() + "는 꼬리를 살짝 맞대며 어딘가와 교신 중이다...? 도망칠 생각은 없는 듯하다.\"");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 33% 확률로 피카츄 포획에 성공하고, 67% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 33% 확률로 true (포획 성공), 67% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(100) + 1 <= 33) { // 33% 확률
        	System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"" + this.getName() + "가 볼 안에서 살짝 전기를 흘리며 안정되었다. 잡았다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.getName() + "가 볼을 튕겨내고 전기를 퍼뜨리며 도망쳤다!\"");
        return false;
    }

}
