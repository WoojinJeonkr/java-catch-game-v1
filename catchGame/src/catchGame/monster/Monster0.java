package catchGame.monster;


// 아무것도 만나지 않았을 때
public class Monster0 extends MonsterBase {
	
	public int e;
	
	// 아무것도 못 마주쳤을 때
	public Monster0() {
		// 이름은 '기본'으로 되어있음
		this.present ="텅 빈 거리, 텅 빈 내 위장, 텅 빈 내 지갑";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		this.e = r.nextInt(3);
		if(e == 0) {
			System.out.println("주변엔 아무것도 없는 거 같다.. 이동하자");
		}
		else if (e == 1) {
			System.out.println("염병, 허탕이다.. 이동하자");
		} else {
			System.out.println("야생의 아르세우스!는 커녕 아무것도 나오지 않았다.. 이동하자");
		}
		// 잡혔을 때
		this.ifCatch = true;
	}
	
//	// 도망칠 확률 "개별사건"
//	// 10% => 1/10
//	// 랜덤 값 1 나오면 도망 그외 숫자 안 도망침
//	public boolean runMonster() {
//		if(this.r.nextInt(10) + 1 == 1) {
//			System.out.println("그 잉어킹이 10% 확률로 두려움을 느꼈다!");
//			System.out.println("집에 가서 자랑해보자!");
//			return false;
//		}
//			
//		return true;
//	}
//		
//	// 잡힐 확률 "개별사건"
//	// 97% => 97/100
//	// 반환 값 => 잡혔을 때:true | 아닐 때:false
//	@Override
//	public boolean catchMonster() {
//	// 잡혔을 때 
//		if(this.r.nextInt(100) + 1 > 3) {
//			System.out.println(this.name + "가(이) 꽥 소리를 냈다!");
//			System.out.println("97% 확률로 잡아냈다!");
//			System.out.println("지나가던 꼬마도 잡을 수 있는 흔한 녀석이다 집에 가서 자랑해보자!");
//			return true;
//	}
//			System.err.println(this.name + "의 모습이 보이지 않는다");
//			System.err.println("3% 확률로 아뿔싸 놓치고 말았다");
//			System.err.println("이것도 못잡는 거 보니 해당 유저는 사람새x끼가 아닌거 같다!");
//			return false;
//	}
	
}
