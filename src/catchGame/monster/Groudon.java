package catchGame.monster;

/**
 * 그란돈 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 그란돈의 특성과 행동을 정의합니다.
 * 그란돈의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 *
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Groudon extends MonsterBase {

	/**
     * Groudon 생성자
     * 
     * <p>Groudon 객체를 생성하고, 몬스터 타입을 GROUDON으로 설정합니다.</p>
     */
	public Groudon() {
        super(MonsterType.GROUDON);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 그란돈이 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"지면이 울린다... 대지의 화신 " + this.getName() + " 등장!\"\n➤ \"그라라라라...돈..!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"해저 마그마 속에서 " + this.getName() + "가 깨어났다!\"");
        } else {
            System.out.println("\"화산재와 수증기가 치솟는 가운데 " + this.getName() + "가 나타났다!\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 3% 확률로 그란돈이 도망치고, 97% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 3% 확률로 false (도망침), 97% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 3) { // 3% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"" + this.getName() + "이 대지를 가르고 지하로 사라졌다...\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"용암의 틈 속으로 " + this.getName() + "가 모습을 감췄다!\"");
            } else {
                System.out.println("\"" + this.getName() + "는 강렬한 열기와 함께 사라졌다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"97% 확률로 " + this.getName() + "가 굳건히 서 있다. 그 대지는 쉽게 무너지지 않는다!\"");
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 40% 확률로 그란돈 포획에 성공하고, 60% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 40% 확률로 true (포획 성공), 60% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(5) + 1 <= 2) { // 40% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"대지의 정령 " + this.getName() + "를 포획했다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.getName() + "의 뜨거운 분노가 포획을 거부했다!\"");
        return false;
    }
    
}
