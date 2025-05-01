package catchGame.monster;

/**
 * 펄기아 몬스터를 나타내는 클래스
 * '
 * <p>
 * 이 클래스는 펄기아의 특성과 행동을 정의합니다.
 * 펄기아의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Palkia extends MonsterBase {

	/**
     * Palkia 생성자
     * 
     * <p>Palkia 객체를 생성하고, 몬스터 타입을 PALKIA로 설정합니다.</p>
     */
	public Palkia() {
        super(MonsterType.PALKIA);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 펄기아가 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
        	System.out.println("\"차원의 균열 속에서 " + this.getName() + "가 강림했다!\"\n➤ \"공간은 나의 무대다!\"");
        } else if (this.probabilityValue == 1) {
        	System.out.println("\"하늘이 갈라지고 " + this.getName() + "가 현실을 가른다!\"\n➤ \"너의 세계는 끝났다!\"");
        } else {
        	System.out.println("\"중력이 뒤틀리며 " + this.getName() + "가 모습을 드러냈다!\"\n➤ \"공간은 곧 나다.\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 4.7% 확률로 펄기아가 도망치고, 95.3% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 4.7% 확률로 false (도망침), 95.3% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(1000) + 1 <= 47) { // 4.7% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
            	System.out.println("\"4.7% 확률로 " + this.getName() + "가 차원의 틈으로 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
            	System.out.println("\"4.7% 확률로 " + this.getName() + "가 공간을 왜곡해 모습을 감췄다!\"");
            } else {
            	System.out.println("\"4.7% 확률로 " + this.getName() + "가 중력을 휘어 탈출했다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
        	System.out.println("\"95.3% 확률로 " + this.getName() + "가 공간을 고정하며 포획을 피했다!\"");
        } else if (this.probabilityValue == 1) {
        	System.out.println("\"95.3% 확률로 " + this.getName() + "가 차원의 결계를 펼쳤다!\"");
        } else {
        	System.out.println("\"95.3% 확률로 " + this.getName() + "가 싸움을 받아들였다!\"");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 1.2% 확률로 펄기아 포획에 성공하고, 98.8% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 1.2% 확률로 true (포획 성공), 98.8% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(250) + 1 <= 3) { // 1.2% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"1.2% 확률로 " + this.getName() + "의 차원 에너지가 약해져 포획에 성공!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"98.8% 확률로 " + this.getName() + "가 공간의 균열 속으로 탈출했다!\"");
        return false;
    }

}
