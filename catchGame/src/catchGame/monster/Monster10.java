package catchGame.monster;

public class Monster10 extends MonsterBase{

	public Monster10() {
		super("아르세우스");
		this.spawnMap = "우주";
		this.present ="";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.err.println("");	
	}
	
	
	// 도망칠 확률 "개별사건"
	// 0%
	@Override
	public boolean runMonster() {
		System.err.println("신은 도망치지 않는다");
		return true; // 안 도망침
	}
	
	// 잡힐 확률 "개별사건"
	// 0.0023% => 23/1000000
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(1000000) + 1 <= 23) {
			System.err.println(this.name + "");
			System.err.println("필멸자 주제에 0.0023% 확률로 나를 이기다니..");
			System.err.println("");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("신은 99.9977% 확률로 지지 않는다");
		System.err.println("");
		return false;
	}
	
}
