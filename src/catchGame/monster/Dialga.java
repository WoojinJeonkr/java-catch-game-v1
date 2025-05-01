package catchGame.monster;

/**
 * 디아루가 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 디아루가의 특성과 행동을 정의합니다.
 * 디아루가의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Dialga extends MonsterBase {

	/**
     * Dialga 생성자
     * 
     * <p>Dialga 객체를 생성하고, 몬스터 타입을 DIALGA로 설정합니다.</p>
     */
	public Dialga() {
        super(MonsterType.DIALGA);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 디아루가가 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"공간이 일그러지며 시간의 신 " + this.getName() + "가 모습을 드러냈다!\"\n➤ \"크오오오오옹!!\"\n(주변의 시간이 멈춘 듯 정적이 흐른다...)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"과거로 되돌아간 시계 속에서 " + this.getName() + "가 출현했다!\"\n➤ \"심장이 뛰는 순간, 시간이 다시 흐른다.\"");
        } else {
            System.out.println("\"정지된 시간의 틈에서 " + this.getName() + "가 나타났다!\"\n➤ \"그 존재만으로 세계의 흐름이 흔들린다.\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 70% 확률로 디아루가가 도망치고, 30% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 70% 확률로 false (도망침), 30% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(10) + 1 <= 7) { // 70% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"" + this.getName() + "가 시간을 되감아 사라졌다! (70%)\"\n➤ \"지금 이 순간도 과거가 된다.\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"" + this.getName() + "가 무한 루프 속으로 사라졌다! (70%)\"\n➤ \"끝없는 시간의 굴레 속으로 빠져든다...\"");
            } else {
                System.out.println("\"" + this.getName() + "가 흐릿한 실루엣만 남긴 채 사라졌다! (70%)\"\n➤ \"시간이 멈추고 다시 흘러간다...\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"" + this.getName() + "가 시간을 잠그며 자리를 지켰다! (30%)\"\n➤ \"이 순간은 영원히 지속된다.\"");
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 7.67% 확률로 디아루가 포획에 성공하고, 92.33% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 7.67% 확률로 true (포획 성공), 92.33% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(10000) + 1 <= 767) { // 7.67% 확률
        	System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"기적처럼! 7.67% 확률로 " + this.getName() + "를 포획했다!\"\n(시간의 흐름이 너의 손에 멈춰 섰다.)");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.getName() + "는 92.33% 확률로 시간의 파동을 타고 탈출했다!\"\n➤ \"신화는 쉽게 붙잡히지 않는다.\"");
        return false;
    }

}
