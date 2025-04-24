package catchGame.monster;

public class Monster5 extends MonsterBase {

	public Monster5() {
		super("가이오가");
		this.spawnMap = "바다";
		this.present = "물 타입 포켓몬 | 바다의 왕자, 물 속에서 왕처럼 유유히 떠다니며, \"내가 물의 제왕이다!\"라고 외치고는 돌아서서 잡혀가는 물 포켓몬";
	}

	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		System.out.println("=========포켓몬 조우=========");
		this.probabilityValue = r.nextInt(3);
		if (this.probabilityValue == 0) {
			System.out.println("\"바다 그 자체이자 바다의 행운 가이오가 등장! 봤으니 기도하자!\"\n" + "➤ ....." + "(내가 뒤지질 않기를)");
		} else if (this.probabilityValue == 1) {
			System.out.println("\"하늘이 어두워지더니, 빗방울과 함께… 가이오가 떠올랐다!\"\n" + "➤ \"가아아~오가… (우비 안 챙겼냐?)\"\n"
					+ "(등장과 동시에 비가 오는 기적! 지역 기상청도 패닉!)");
		} else {
			System.out.println("\"바닷속에서 거대한 그림자가 올라온다… 눈을 뜬 순간, 가이오가다!\"\n" + "➤ \"가오가오가오!! (자, 누구부터 젖어볼래?)\"\n"
					+ "(물이 넘쳐흐르고, 심장은 쿵쿵! 분위기는 재난영화급.)");
		}
		System.out.println();
	}

	// 도망칠 확률 "개별사건"
	// 89% => 89/100
	// 랜덤 값 1~89 나오면 도망, 그외 숫자 안 도망침
	// 반환 값 => 도망칠 때:false | 안도망칠 때:true
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		// 도망칠 때 false
		if (this.r.nextInt(100) + 1 <= 89) {
			System.out.println("=========포켓몬이 도망쳤다!=========");
			if (this.probabilityValue == 0) {
				System.out.println("\"89% 확률로 가이오가가 도망쳤다! 갑자기 물보라를 일으키며 바다로 풍덩!\"\n"
						+ "➤ \"가오가오~ (비 오니까 더 젖기 전에 튄다!)\"\n" + "(그 자리에 남은 건 물웅덩이와 트레이너의 젖은 양말.)");
			} else if (this.probabilityValue == 1) {
				System.out.println("\"89% 확률로 가이오가가 조용히 바다로 빠져나갔다… 고요 속의 퇴장.\"\n" + "➤ \"가아…오… (여긴 내 무대가 아닌 듯)\"\n"
						+ "(배경 음악이 사라지고, 어색한 정적만 남았다.)");
			} else {
				System.out.println("\"89% 확률로 가이오가가 도망쳤다! 하늘은 여전히 흐리고, 기분만 축축하다.\"\n" + "➤ \"가오가~ (다음엔 우산 쓰고 와라~)\"\n"
						+ "(트레이너는 젖은 채 멍하니 서 있다.)");
			}
			System.out.println();
		}
		// 안 도망칠 때 true
		System.out.println("=========포켓몬이 도망치지 않았다!=========");
		if (this.probabilityValue == 0) {
			System.out.println("\"11% 확률로 가이오가는 도망가지 않았다! 대신 구름이 더 몰려오고, 비가 쏟아지기 시작했다!\"\n"
					+ "➤ \"가오가오오~ (이제 시작이다, 우산 챙겼니?)\"\n" + "(우비 안 챙긴 트레이너는 공포에 떨고 있다!)");
		} else if (this.probabilityValue == 1) {
			System.out.println("\"11% 확률로 가이오가가 그 자리에 버티고 있다… 도망? 비 오는 날 집 나간 적 없다!\"\n"
					+ "➤ \"가아오~ (물은 내 친구야. 여기서 싸워야지!)\"\n" + "(물 위에 떠 있으면서도 존재감은 대륙급!)");
		} else {
			System.out.println("\"11% 확률로 가이오가는 도망치지 않았다! 하지만 뭔가… 우울한 눈빛이다.\"\n" + "➤ \"가오… (내가 여길 왜 나왔더라?)\"\n"
					+ "(전설도 가끔 멘붕이 온다.)");
		}
		System.out.println();
		return true;
	}

	// 잡힐 확률 "개별사건"
	// 9% => 9/100
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() throws InterruptedException {
		delayTime();
		// 잡혔을 때 true
		if (this.r.nextInt(100) + 1 <= 9) {
			System.out.println("=========포켓몬 포획 성공!=========");
			System.out.println("\"9% 확률로 믿기 힘들겠지만… 전설의 포켓몬 가이오가가 포켓볼에 들어갔다!\"\n"
					+ "➤ \"가아오오오… (내 체급에 맞는 방이 아닌데… 뭐, 살다 보면 이런 날도 있지)\"\n" + "(가이오가는 포켓볼 안에서 몸을 접는 요가를 시작했다.)");
			System.out.println();
			this.ifCatch = true;
			return true;
		}
		// 안 잡혔을 때 false
		System.out.println("=========포켓몬 포획 실패!=========");
		System.out.println("\"91% 확률로 가이오가는 잡히지 않았다! 포켓볼이 던져진 순간, 바닷물로 위장하고 사라졌다!\"\n"
				+ "➤ \"가오가오~ (전설은 쉽게 포켓볼에 담기지 않아!)\"\n" + "(목숨 부지한걸로 만족하자)");
		System.out.println();
		return false;
	}

}
