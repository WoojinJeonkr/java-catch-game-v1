package catchGame.Monster;


public class Monster1 extends MonsterBase{
	
	
	public Monster1() {
		super("잉어킹");
		this.spawnMap = "바다";
		this.present = "바다에서 흔하게 볼 수 있는 개쓸모없는녀석, 생각이 없는지 겁이 없는지 유유자적하다, 맛은 있을지도?";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		System.out.println("전설의 \"그 녀석\"이 나타났다! 식은 죽 먹기일 듯 하다");
	}
	
	// 도망칠 확률 "개별사건"
	// 10% => 1/10
	// 랜덤 값 1 나오면 도망 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		// 도망칠 때
		if(this.r.nextInt(10) + 1 == 1) {
			System.out.println("그 잉어킹이 10% 확률로 두려움을 느꼈다!");
			System.out.println("집에 가서 자랑해보자!");
			return false;
		}
		// 안 도망칠때	
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 99.9% => 99.9/100 => 0.1% => 1/1000
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 반대로 해놓음(0.1% 확률로 잡게함)
		// 잡혔을 때 
		if(this.r.nextInt(1000) + 1 == 1) {
			System.out.println(this.name + "가(이) 꽥 소리를 냈다!");
			System.out.println("99.9% 확률로 잡아냈다!");
			System.out.println("지나가던 꼬마도 잡을 수 있는 흔한 녀석이다 가문의 영광이므로 집에 가서 자랑해보자!");
			// 잡혔을 때
			this.ifCatch = true;
			return true;
		}
		// 못잡을 때
		System.err.println(this.name + "의 모습이 보이지 않는다");
		System.err.println("0.1% 확률로 아뿔싸 놓치고 말았다");
		System.err.println("이것도 못잡는 거 보니 해당 유저는 사람새x끼가 아닌거 같다!");
		return false;
	}
	
}
