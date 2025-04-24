package catchGame.monster;

// 아무것도 만나지 않았을 때
public class Monster0 extends MonsterBase {

	// 아무것도 못 마주쳤을 때
	public Monster0() {
		// 이름은 '기본'으로 되어있음
		this.present = "텅 빈 거리, 텅 빈 내 위장, 텅 빈 내 지갑";
		this.isMet = 0;
	}

	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		System.out.println("=========아무것도 못 마주침=========");
		this.probabilityValue = r.nextInt(3);
		if (this.probabilityValue == 0) {
			System.out.println("주변엔 아무것도 없는 거 같다..");
		} else if (this.probabilityValue == 1) {
			System.out.println("염병, 허탕이다..");
		} else {
			System.out.println("전설의 아르세우스!는 커녕 아무것도 나오지 않았다..");
		}
		System.out.println();
	}

	// 반환 값 => 도망칠 때:false | 안도망칠 때:true
	// Monster0은 무조건 false 반환
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		if (this.probabilityValue == 0) {
			System.out.println("어디선가 배고픈 포켓몬이 있을 것만 같은데, 오늘은 없나 봐. ...이동하자");
		} else if (this.probabilityValue == 1) {
			System.out.println("포켓몬? 아, 그냥 산책하고 있나 봐. 오늘은 너만의 시간을 가져라! ...이동하자");
		} else {
			System.out.println("자, 포켓몬의 흔적도 없고, 내 발자국만 남았다. 어디로 가야 하지? ...이동하자");
		}
		System.out.println();
		return false;
	}

	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	// Monster0은 무조건 true 반환
	@Override
	public boolean catchMonster() throws InterruptedException {
		delayTime();
		this.ifCatch = true;
		return true;
	}

}
