package catchGame.monster;



public class Monster3 extends MonsterBase {

	public Monster3() {
		super("다꼬리");
		this.spawnMap = "땅";
		this.present ="매우 커여운 포켓몬, 조심성이 거의 없다";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.out.println("");
	}
	
	
	// 도망칠 확률 "개별사건"
	// 67% => 67/100
	// 랜덤 값 1~67 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(100) + 1 <= 67) {
			System.out.println("그 사교성 좋은 다꼬리가 당신을 피한다, 당신의 사상이 의심스럽다!");
			return false;
		}
		// 안 도망칠 때
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 75% => 3/4
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(4) + 1 <= 3) {
			System.out.println(this.name + "가(이) 순순히 곁에 왔다!");
			System.out.println("75% 확률로 잡아냈다!");
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
