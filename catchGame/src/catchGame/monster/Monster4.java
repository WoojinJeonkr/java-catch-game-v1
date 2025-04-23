package Monster;

public class Monster4 extends MonsterBase {

	public Monster4() {
		super("마자용");
		this.spawnMap = "땅";
		this.present ="뭐가 맞다는지 모르겠다, 쳐맞고싶다는건가?";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
				
	}
	
	
	// 도망칠 확률 "개별사건"
	// 9% => 9/100
	// 랜덤 값 1~9 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(100) + 1 <= 9) {
			System.out.println("도망치지마 맞서 싸워!");
			return false;
		}
		// 안 도망칠 때
		System.out.println("이름값대로 맞는 걸 좋아하는거 같다, 살짝 소름이 돋는다");
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 50% => 1/2
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 
		if(this.r.nextInt(2) + 1 == 1) {
			System.out.println(this.name + "의 눈이 제정신이 아닌거 같다");
			System.out.println("50% 확률로 잡아냈다!");
			System.out.println("이런 녀석은 좀 아닌거 같은데.. 도감에 넣어야 되나?");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("50% 확률로 놓치고 말았다");
		System.err.println("오히려 다행인거 같다");
		return false;
	}
	
}
