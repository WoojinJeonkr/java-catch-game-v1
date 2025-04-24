package catchGame.monster;

public class Monster2 extends MonsterBase {

	public Monster2() {
		super("피카츄");
		this.spawnMap = "땅";
		this.present ="전기 타입 포켓몬 | 전기가 찌릿찌릿, 가끔은 너무 많은 전기 때문에 착각하는 전격 고양이, 요리로는 볶음밥이 최고일지도?";
	}
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		System.out.println("=========포켓몬 조우=========");
		this.probabilityValue = r.nextInt(3);
		if(this.probabilityValue == 0) {
			System.out.println("\"전기가 튀는 소리와 함께… 피카츄가 튀어나왔다!\"\n" +
					"➤ \"피카~츄!!\"\n" +
					"(꼬리를 세우며 전기를 모으고 있다!)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"귀여운 생쥐처럼 보이지만… 눈빛이 매섭다!\"\n" +
					"➤ 피카츄의 전기가 벌써 충전됐다! ⚡\n" +
					"(상대 트레이너가 긴장하기 시작했다.)");
		} else {
			System.out.println("\"피카츄가 등장했다! 주머니 속에서 점프하듯 튀어나왔다!\"\n" +
					"➤ \"피카피카~!\"\n" +
					"(초반에는 귀여움, 다음은 백만 볼트의 공포.)");
		}
		System.out.println();
	}
	
	// 도망칠 확률 "개별사건"
	// 32% => 8/25
	// 랜덤 값 1~8 나오면 도망, 그외 숫자 안 도망침
	// 반환 값 => 도망칠 때:false | 안도망칠 때:true
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		// 도망칠 때 false
		if(this.r.nextInt(25) + 1 <= 8) {
			System.out.println("=========포켓몬이 도망쳤다!=========");
			if(this.probabilityValue == 0) {
				System.out.println("\"32% 확률로 주인 없는 피카츄가 도망쳤다! 전기를 충전하고 바람처럼 사라졌다!\"\n" +
						"➤ \"피카~!! (도망가는 건 나야 나!)\"\n" +
						"(피카츄가 전기를 모으며 훌쩍 도망간다. 자유롭게 도망가는 모습이 너무 자연스러워.)");
			}
			else if (this.probabilityValue == 1) {
				System.out.println("\"32% 확률로 주인 없는 피카츄가 도망칠 때, 왜 이렇게 두려워하는지 모르겠지만... 그만큼 뛰어! 전기가 풀로 터질 것 같아!\"\n" +
						"➤ \"피카! 피카!! (어디가서 전기를 좀 쓰고 올게!)\"\n" +
						"(도망가면서 전기 충격을 너무 많이 일으키는 피카츄. 누구도 못 잡을 것 같은 자신감.)");

			} else {
				System.out.println("\"32% 확률로 주인 없는 피카츄가 도망쳤다! 자신이 이길 수 없을 거라 생각한 걸까? 전기를 풀로 내뿜고 도망쳤다!\"\n" +
						"➤ \"피카~~! (난 그냥 자유롭게 살아가겠다!)\"\n" +
						"(피카츄가 전기를 내뿜으며 자유롭게 도망간다. '누구든 나를 잡을 수 없다!'는 느낌.)");
			}
			System.out.println();
			return false;
		}
		// 안 도망칠 때 true
		System.out.println("=========포켓몬이 도망치지 않았다!=========");
		if(this.probabilityValue == 0) {
			System.out.println("\"68% 확률로 피카츄가 도망치지 않고 그냥 당당히 서 있다. '어차피 나 피할 필요 없지!'라고 생각한 걸까?\"\n" +
					"➤ \"피카! 피카츄!!\"\n" +
					"(피카츄, 평온한 표정으로 그냥 당당히 버티고 있다. 도망치지 않겠다고 굳은 결심.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"68% 확률로 피카츄가 도망칠 기세였지만, '나 피할 필요 없지?'라며 한 걸음도 움직이지 않는다.\"\n" +
					"➤ \"피카! 피카!\"\n" +
					"(고양이처럼 묵묵히 서 있는 피카츄. '너는 못 이겨!' 라고 외치는 듯.)");
		} else {
			System.out.println("\"68% 확률로 피카츄는 도망치지 않는다! '이렇게 저항하는 거야!'라며 전기를 풀로 방출 중!\"\n" +
					"➤ \"피카! 피카~츄!\"\n" +
					"(피카츄가 도망치지 않고 전기를 모은다! 전기를 꽉 차게 방출하려는 듯한 태세.)");
		}
		System.out.println();
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 33% => 33/100
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		// 잡혔을 때 true
		if(this.r.nextInt(100) + 1 <= 33) {
			System.out.println("=========포켓몬 포획 성공!=========");
			System.out.println("\"33% 확률로 주인 없는 피카츄가 잡혔다! '도망가면 또 잡힐 거라서 그냥 멈추기로 했다!' 하지만 포켓볼 안에서 어떻게 나갈지 몰라서 어리둥절해한다.\"\n" +
					"➤ \"피카피카~! (이게 뭐야? 왜 이렇게 안 나가져?)\"\n" +
					"(피카츄가 포켓몬볼에 들어가며, 당황한 나머지 볼 안에서 뒹굴고 있다.)");
			System.out.println();
			this.ifCatch = true;
			return true;
		}
		// 안 잡혔을 때 false
		System.out.println("=========포켓몬 포획 실패!=========");
		System.out.println("\"아뿔싸! 67% 확률로 피카츄가 잡히지 않았다! '대체 왜 이렇게 빨리 도망칠 수 있는 거지?'라는 표정으로 한 걸음 한 걸음 나가며 여유를 부린다!\"\n" +
				"➤ \"피카~! (이게 바로 피카츄의 '도망의 기술'이지!)\"\n" +
				"(피카츄가 느긋하게 도망치며 상대는 놓치고 당황한다.)");
		System.out.println();
		return false;
	}
}
