package catchGame.Monster;

public class Monster7 extends MonsterBase {

	public Monster7() {
		super("뮤츠");
		this.spawnMap = "하늘";
		this.present ="";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.out.println("");	
	}
	
	
	// 도망칠 확률 "개별사건"
	// 15% => 3/20
	// 랜덤 값 1~3 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(20) + 1 <= 3) {
			System.out.println("명색이 뮤츠란 녀석이.. 꼬리나 떼라");
			return false;
		}
		// 안 도망칠 때
		System.out.println("");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 25% => 1/4
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(4) + 1 == 1) {
			System.out.println(this.name + "");
			System.out.println("25% 확률로 잡아냈다!");
			System.out.println("");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("75% 확률로 놓치고 말았다");
		System.err.println("");
		return false;
	}
	
}
