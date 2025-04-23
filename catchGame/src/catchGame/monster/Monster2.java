package Monster;

public class Monster2 extends MonsterBase {

	public Monster2() {
		super("피카츄");
		this.spawnMap = "땅";
		this.present ="전기 타입 포켓몬";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			
	}
	
	// 도망칠 확률 "개별사건"
	// 32% => 8/25
	// 랜덤 값 1~8 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(25) + 1 <= 8) {
			System.out.println("");
			return false;
		}
		// 안 도망칠 때
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 33% => 33/100
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(100) + 1 <= 33) {
			System.out.println(this.name + "가(이) 꽥 소리를 냈다!");
			System.out.println("33% 확률로 잡아냈다!");
			System.out.println("");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("67% 확률로 아뿔싸 놓치고 말았다");
		System.err.println("");
		return false;
	}
}
