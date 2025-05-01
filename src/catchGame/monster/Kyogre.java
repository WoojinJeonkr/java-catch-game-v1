package catchGame.monster;

/**
 * 가이오가 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 가이오가의 특성과 행동을 정의합니다.
 * 가이오가의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 *
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Kyogre extends MonsterBase {

	/**
     * Kyogre 생성자
     * 
     * <p>Kyogre 객체를 생성하고, 몬스터 타입을 KYOGRE로 설정합니다.</p>
     */
	public Kyogre() {
        super(MonsterType.KYOGRE);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 가이오가가 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"검푸른 해수가 갈라지며 " + this.getName() + "가 모습을 드러냈다!\"\n➤ …고대의 바다를 깨운 전설의 포켓몬이 다시 눈을 떴다.");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"해저 마그마 틈에서 솟아오른 " + this.getName() + "! 잠들어 있던 분노가 깨어난다!\"");
        } else {
            System.out.println("\"그란돈과의 전투를 앞둔 " + this.getName() + "가 나타났다!\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 89% 확률로 가이오가가 도망치고, 11% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 89% 확률로 false (도망침), 11% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 89) { // 89% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"89% 확률로 " + this.getName() + "가 해일을 일으키며 다시 해저동굴로 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"89% 확률로 " + this.getName() + "가 조용히 바닷속으로 모습을 감췄다!\"");
            } else {
                System.out.println("\"89% 확률로 " + this.getName() + "가 레쿠쟈의 기척을 느끼고 사라졌다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"11% 확률로 " + this.getName() + "가 해일 속에서 여전히 위용을 뽐내고 있다!\"");
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 9% 확률로 가이오가 포획에 성공하고, 91% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 9% 확률로 true (포획 성공), 91% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(100) + 1 <= 9) { // 9% 확률
        	System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"9% 확률로 " + this.getName() + "를 홍옥구슬처럼 간신히 제어하여 포획했다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"91% 확률로 " + this.getName() + "가 명령을 거부하고 바다로 되돌아갔다!\"");
        return false;
    }

}
