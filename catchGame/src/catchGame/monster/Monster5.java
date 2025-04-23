package catchGame.monster;

public class Monster5 extends MonsterBase {

	public Monster5() {
		super("가이오가");
		this.spawnMap = "바다";
		this.present ="";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.out.println("바다 그 자체이자 바다의 행운! 봤으니 기도하자! ...내가 뒤지질 않기를");	
	}
	
	
	// 도망칠 확률 "개별사건"
	// 89% => 89/100
	// 랜덤 값 1~89 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(100) + 1 <= 89) {
			System.out.println("싸울 가치를 못느끼나 보다, 분발하자!");
			return false;
		}
		// 안 도망칠 때
		System.out.println("넌 뒤졌다");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 9% => 9/100
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(100) + 1 <= 9) {
			System.out.println(this.name + "");
			System.out.println("9% 확률로 잡아냈다!");
			System.out.println("");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("91% 확률로 놓치고 말았다");
		System.err.println("목숨 부지한걸로 만족하자");
		return false;
	}
	
}
