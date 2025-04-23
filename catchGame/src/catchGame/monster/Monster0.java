package catchGame.monster;


// 아무것도 만나지 않았을 때
public class Monster0 extends MonsterBase {
	
	public int e;
	
	// 아무것도 못 마주쳤을 때
	public Monster0() {
		// 이름은 '기본'으로 되어있음
		this.present ="텅 빈 거리, 텅 빈 내 위장, 텅 빈 내 지갑";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		this.e = r.nextInt(3);
		if(e == 0) {
			System.out.println("주변엔 아무것도 없는 거 같다.. 이동하자");
		}
		else if (e == 1) {
			System.out.println("염병, 허탕이다.. 이동하자");
		} else {
			System.out.println("야생의 아르세우스!는 커녕 아무것도 나오지 않았다.. 이동하자");
		}
	}

	public boolean runMonster() {
		System.out.println("...");
		return false;
	}


	@Override
	public boolean catchMonster() {
		System.out.println("...");
		this.ifCatch = true;
		return true;
	}
	
}
