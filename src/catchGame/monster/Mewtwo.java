package catchGame.monster;

/**
 * 뮤츠 몬스터를 나타내는 클래스입니다.
 * 
 * <p>
 * 이 클래스는 뮤츠의 특성과 행동을 정의합니다.
 * 뮤츠의 등장 메시지, 도망 시도, 포획 시도 등의 동작을 처리합니다.
 * </p>
 *
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class Mewtwo extends MonsterBase {

	/**
     * Mewtwo 생성자
     * 
     * <p>Mewtwo 객체를 생성하고, 몬스터 타입을 MEWTWO로 설정합니다.</p>
     */
	public Mewtwo() {
        super(MonsterType.MEWTWO);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 뮤츠가 등장했을 때의 웅장한 상황을 묘사하는 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 출력합니다.
     * </p>
     */
    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"정신이 흐릿해진다… " + this.getName() + "의 의식이 머릿속을 관통한다.\"\n➤ \"…이게 인간이 내린 최선인가?\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"공간이 뒤틀리며 " + this.getName() + "가 나타났다!\"\n➤ \"과학의 산물은 창조자를 넘는다...\"");
        } else {
            System.out.println("\"강력한 존재감에 몸이 굳는다. 눈앞에 " + this.getName() + "가 서 있다.\"\n➤ \"나는 싸움을 위해 태어났다.\"");
        }
        
        System.out.println();
    }

    /**
     * 도망 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 15% 확률로 뮤츠가 도망치고, 85% 확률로 도망치지 않습니다.
     * 각 상황에 맞는 메시지를 출력합니다.
     * </p>
     *
     * @return 15% 확률로 false (도망침), 85% 확률로 true (도망치지 않음)을 반환
     */
    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 15) { // 15% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"" + this.getName() + "는 눈을 감고 사라졌다. 마치 존재조차 허상이었던 것처럼.\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"순간이동… " + this.getName() + "는 말없이 자취를 감췄다.\"");
            } else {
                System.out.println("\"" + this.getName() + "의 목소리가 울려 퍼진다. '넌 아직 준비되지 않았다.'\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"" + this.getName() + "는 당신을 꿰뚫는 듯한 눈빛으로 바라보고 있다.\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"" + this.getName() + "는 미동도 없이 서 있다. 싸움의 의지가 느껴진다.\"");
        } else {
            System.out.println("\"" + this.getName() + "는 침묵 속에서 기운을 끌어모으고 있다.\"");
        }
        
        System.out.println();
        return true;
    }

    /**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 25% 확률로 뮤츠 포획에 성공하고, 75% 확률로 실패합니다.
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
            System.out.println("\"" + this.getName() + "의 의식이 잠시 흔들렸다… 포획에 성공했다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.getName() + "가 강한 염력으로 볼을 튕겨냈다!\"");
        return false;
    }

}
