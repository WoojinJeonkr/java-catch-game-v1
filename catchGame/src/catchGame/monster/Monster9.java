package catchGame.monster;

public class Monster9 extends MonsterBase {

	public Monster9() {
		super("펄기아");
		this.spawnMap = "하늘";
		this.present ="";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
			System.out.println("마주쳐도 이 녀석을 마주치다니.. 썩 좋은 인생이었다!");	
	}
	
	
	// 도망칠 확률 "개별사건"
	// 4.7% => 47/1000
	// 랜덤 값 1~47 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(1000) + 1 <= 47) {
			System.out.println("약 5% 확률로 이 녀석이 도망치는 꼴을 보다니 해가 서쪽에서 뜨나보다");
			return false;
		}
		// 안 도망칠 때
		System.out.println("이럴 줄 알았다 준비하자!");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 1.2% => 3/250
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(250) + 1 <= 3) {
			System.out.println(this.name + "");
			System.out.println("1.2% 확률로 잡아냈다!");
			System.out.println("이걸 잡으라고 만든 건 아니었는데.. 아무튼 좋았쓰!");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("98.8% 확률로 놓치고 말았다");
		System.err.println("조상님이 안 도와주시나보다 제사를 잘 지내보도록 하자!");
		return false;
	}
	
}
