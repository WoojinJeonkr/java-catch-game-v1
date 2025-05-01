package catchGame.monster;

/**
 * 아무것도 없는 상황을 나타내는 몬스터 클래스
 * 
 * <p>
 * 이 클래스는 몬스터를 만날 수 없는 특별한 상황을 처리합니다.
 * 어떠한 몬스터도 존재하지 않는 빈 공간을 표현하며,
 * 플레이어에게 적절한 메시지를 출력하고 특정 동작을 수행합니다.
 * </p>
 * 
 * @author ImaginaryNumberi
 * @author Woojinjeonkr
 */
public class EmptyMonster extends MonsterBase {
	
	/**
     * EmptyMonster 생성자
     * 
     * <p>EmptyMonster 객체를 생성하고, 몬스터 타입을 EMPTY로 설정합니다.</p>
     */
	public EmptyMonster() {
		super(MonsterType.EMPTY);
    }

	/**
     * 등장 메시지를 출력하는 메서드
     * 
     * <p>
     * 아무것도 만날 수 없는 상황에 대한 메시지를 출력합니다.
     * 랜덤한 메시지를 선택하여 다양한 상황을 표현합니다.
     * </p>
     */
	@Override
	public void displayAppearanceMessage() {
		System.out.println("=========아무것도 못 마주침=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("주변엔 아무것도 없는 거 같다..\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("아이고, 허탕이다..\n");
        } else {
            System.out.println("전설의 아르세우스!는 커녕 아무것도 나오지 않았다..\n");
        }
	}

	/**
     * 도망 시도에 대한 메시지를 출력하고 결과를 반환하는 메서드
     * 
     * <p>
     * 몬스터가 없으므로 도망 시도는 항상 실패합니다.
     * 다양한 메시지를 출력하여 상황을 설명합니다.
     * </p>
     *
     * @return 항상 false를 반환하여 도망 시도가 실패했음을 나타냄
     */
	@Override
	public boolean attemptEscape() {
		this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("어디선가 배고픈 포켓몬이 있을 것만 같은데, 오늘은 없나 봐. ...이동하자\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("포켓몬? 아, 그냥 산책하고 있나 봐. 오늘은 너만의 시간을 가져라! ...이동하자\n");
        } else {
            System.out.println("자, 포켓몬의 흔적도 없고, 내 발자국만 남았다. 어디로 가야 하지? ...이동하자\n");
        }
        
        return false;
	}

	/**
     * 포획 시도를 처리하고 결과를 반환하는 메서드
     * 
     * <p>
     * 아무것도 없는 상황이므로 포획 시도는 즉시 성공합니다.
     * 지연 시간을 보여주고, 포획 성공을 반환합니다.
     * </p>
     *
     * @return 항상 true를 반환하여 포획이 성공했음을 나타냄
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
	@Override
	public boolean attemptCatch() throws InterruptedException {
		showDelay();
        this.isCaught = true;
        return true;
	}

}
