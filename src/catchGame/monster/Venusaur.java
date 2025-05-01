package catchGame.monster;

/**
 * 이상해꽃 몬스터를 나타내는 클래스
 * 
 * <p>
 * 이 클래스는 이상해꽃의 특성과 행동을 정의합니다.
 * 이상해꽃의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 *
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Venusaur extends MonsterBase {

	/**
     * Venusaur 생성자
     * 
     * <p>Venusaur 객체를 생성하고, 몬스터 타입을 VENUSAUR로 설정합니다.</p>
     */
	public Venusaur() {
        super(MonsterType.VENUSAUR);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 이상해꽃이 등장했을 때의 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\n" + this.getName() + "이(가) 햇살을 받으며 졸고 있다…\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("\n" + this.getName() + "의 덩굴 채찍이 번개처럼 휘둘러진다!\n");
        } else {
            System.out.println("\n" + this.getName() + "이(가) 잎사귀를 흔들며 등장했다! 싱그러운 풀 내음이 가득하다!\n");
        }
        
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 9% 확률로 이상해꽃이 도망치고, 91% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 9% 확률로 false (도망침), 91% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 9) { // 9% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\n 9% 확률로 " + this.getName() + "의 덩굴이 땅속으로 스르륵 사라졌다!\n");
            } else if (this.probabilityValue == 1) {
                System.out.println("\n 9% 확률로 " + this.getName() + "가 꽃잎을 흩날리며 조용히 사라졌다!\n");
            } else {
                System.out.println("\n 9% 확률로 " + this.getName() + "가 덩굴을 뻗어 숲 속으로 사라졌다!\n");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 넓은 잎사귀 위에 편안하게 누워 있다!\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 꽃봉오리를 살짝 닫고 휴식을 취한다!\n");
        } else {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 주변의 햇살을 즐기며 여유로운 시간을 보낸다!\n");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 50% 확률로 이상해꽃 포획에 성공하고, 50% 확률로 실패합니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 50% 확률로 true (포획 성공), 50% 확률로 false (포획 실패)를 반환
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(2) + 1 == 1) { // 50% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"50% 확률로 " + this.getName() + "가 잡혔다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"50% 확률로 " + this.getName() + "가 놓쳤다!\"");
        return false;
    }

}
