package catchGame.monster;

public class EmptyMonster extends MonsterBase {
	
	public EmptyMonster() {
		super(MonsterType.EMPTY);
    }

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

	@Override
	public boolean attemptCatch() throws InterruptedException {
		showDelay();
        this.isCaught = true;
        return true;
	}

}
