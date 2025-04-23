package Monster;

public class Monster8 extends MonsterBase{

	public Monster8() {
		super("디아루가");
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
	// 70% => 7/10
	// 랜덤 값 1~3 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(10) + 1 <= 7) {
			System.out.println("생각보다 자비롭다");
			return false;
		}
		// 안 도망칠 때
		System.out.println("어지간히 네가 마음에 안 들었나 보다 준비하자!");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 7.67% => 767/10000
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(10000) + 1 <= 767) {
			System.out.println(this.name + "");
			System.out.println("7.67% 확률로 잡아냈다!");
			System.out.println("이새끼.. 좀 하는데?");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("92.33% 확률로 놓치고 말았다");
		System.err.println("");
		return false;
	}
	
}
