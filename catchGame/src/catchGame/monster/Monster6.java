package catchGame.Monster;

public class Monster6 extends MonsterBase{

	public Monster6() {
		super("그란돈");
		this.spawnMap = "바다(사실 땅)";
		this.present ="";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.out.println("아니 이새끼가 왜 바다에..?");	
	}
	
	
	// 도망칠 확률 "개별사건"
	// 3% => 3/100
	// 랜덤 값 1~3 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(100) + 1 <= 3) {
			System.out.println("땅 포켓몬 헤엄 수준이 전문가입니다");
			return false;
		}
		// 안 도망칠 때
		System.out.println("");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 40% => 2/5
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(5) + 1 <= 2) {
			System.out.println(this.name + "");
			System.out.println("40% 확률로 잡아냈다!");
			System.out.println("땅에 있어야 할 놈이 왜 바다에 허우적 거리는지 모르겠다 일단 잡았으니 좋았쓰!");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("60% 확률로 놓치고 말았다");
		System.err.println("썩어도 준치라고 만만치 않은 상대였다");
		return false;
	}
	
}
