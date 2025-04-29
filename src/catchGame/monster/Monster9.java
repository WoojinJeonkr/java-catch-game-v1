package catchGame.monster;

public class Monster9 extends MonsterBase {

	public Monster9() {
		super("펄기아");
		this.spawnMap = "하늘";
		this.present = "물/드래곤 타입 포켓몬 | 시공간의 요리사, 시공을 넘나들며 \"여기 시공 맞게 해서 내일은 저기 가봐야지!\"라며, 어디로 튈지 모르는 포켓몬";
	}

	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		System.out.println("=========포켓몬 조우=========");
		this.probabilityValue = r.nextInt(3);
		if (this.probabilityValue == 0) {
			System.out.println("\"공간이 일그러지며 차원이 열렸다… 펄기아가 나타났다!\"\n" + "➤ \"이 세계… 너무 시끄러워. 네가 부른 거야? 귀찮게 굴지 마.\"\n"
					+ "(그녀는 공간을 찢고 내려오며, 은근슬쩍 너를 바라본다.)");
		} else if (this.probabilityValue == 1) {
			System.out.println("\"시간이 멈춘 듯한 정적… 그 속에서 펄기아가 모습을 드러냈다.\"\n"
					+ "➤ \"……나를 찾았다고? 대체 무슨 이유로… 뭐, 일단 들어는 보지.\"\n" + "(펄기아는 팔짱을 끼고 조용히 고개를 돌린다.)");
		} else {
			System.out.println("\"하늘에 금이 가며 차원의 문이 열린다… 펄기아가 너를 내려다본다.\"\n" + "➤ \"지금 널 시험할게… 내가 너에게 머물 가치가 있는지.\"\n"
					+ "(그녀의 목소리는 차분하지만, 그 안엔 묘한 떨림이 섞여 있다.)");
		}
		System.out.println();
	}

	// 도망칠 확률 "개별사건"
	// 4.7% => 47/1000
	// 랜덤 값 1~47 나오면 도망, 그외 숫자 안 도망침
	// 반환 값 => 도망칠 때:false | 안도망칠 때:true
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		// 도망칠 때 false
		if (this.r.nextInt(1000) + 1 <= 47) {
			System.out.println("=========포켓몬이 도망쳤다!=========");
			if (this.probabilityValue == 0) {
				System.out.println("\"너는 망설임 끝에 등을 돌려 도망쳤다…\"\n" + "➤ \"…흥. 결국 그런 선택이군.\"\n"
						+ "(펄기아는 조용히 한숨을 쉬며, 다시 공간 속으로 스며든다. 그녀의 실루엣은 곧 사라졌다.)");
			} else if (this.probabilityValue == 1) {
				System.out.println("\"너는 공포에 휩싸인 채 한 걸음… 두 걸음… 뒤로 물러섰다.\"\n" + "➤ \"그래… 네가 감당할 수 있는 존재는 아니겠지.\"\n"
						+ "(펄기아는 흥미를 잃은 듯 시선을 거두며, 차원의 틈을 닫는다.)");
			} else {
				System.out.println("\"너는 싸움을 피했다. 심장은 빠르게 뛰고, 손끝은 떨린다.\"\n" + "➤ \"다음에 만났을 땐, 그렇게 쉽게 도망칠 수 없을 거야.\"\n"
						+ "(펄기아의 마지막 말이 귓가를 스친다. 하지만 그녀는 이미 사라지고 없다.)");
			}
			System.out.println();
			return false;
		}
		// 안 도망칠 때 true
		System.out.println("=========포켓몬이 도망치지 않았다!=========");
		if (this.probabilityValue == 0) {
			System.out.println("\"너는 눈을 똑바로 뜨고 그녀를 바라보았다. 두려움은 있었지만, 물러서지 않았다.\"\n"
					+ "➤ \"…좋아. 그 눈빛, 가볍게 본 내가 실수였나 봐.\"\n" + "(펄기아는 미소를 머금으며, 천천히 너에게 다가온다.)");
		} else if (this.probabilityValue == 1) {
			System.out.println("\"너는 조용히 숨을 고르며, 한 발 앞으로 나섰다.\"\n" + "➤ \"호오… 도망치지 않네. 나름 용감한데? 재밌어졌어.\"\n"
					+ "(펄기아의 눈동자에 빛이 돈다. 마치 새로운 흥미를 찾은 아이처럼.)");
		} else {
			System.out.println("\"너는 마음을 다잡고 그 자리에 선 채, 결연한 눈빛으로 그녀를 마주했다.\"\n" + "➤ \"흐응… 그런 각오라면, 조금 진심을 내볼까.\"\n"
					+ "(펄기아는 손끝을 들어올리며, 주위를 감싸던 에너지를 집중시키기 시작한다.)");
		}
		System.out.println();
		return true;
	}

	// 잡힐 확률 "개별사건"
	// 1.2% => 3/250
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() throws InterruptedException {
		delayTime();
		this.probabilityValue = r.nextInt(3);

		// 잡혔을 때 true
		if (this.r.nextInt(250) + 1 <= 3) {
			System.out.println("=========포켓몬 포획 성공!=========");
			if (this.probabilityValue == 0) {
				System.out.println("\"1.2% 확률로  ……공간의 신인 내가, 이렇게까지 허락해주는 건…… 특.별.한. 거야.\"\n"
						+ "➤ \"이 포켓볼 안… 네 기척이 느껴져서, 이상하게… 안심돼…\"\n" + "(펄기아가 부끄러운 듯 고개를 숙인다.)");
			} else if (this.probabilityValue == 1) {
				System.out.println("\"1.2% 확률로 펄기아는 천천히 포켓볼 안에 들어가더니… 입꼬리를 살짝 올렸다.\"\n"
						+ "➤ \"…그냥… 거절하기엔… 네가 너무 진지했잖아. 어쩔 수 없이 인정한 거야… 바보…\"\n" + "(볼 안이 순간 반짝이며, 조용한 온기로 가득 찬다.)");
			} else {
				System.out.println("\"1.2% 확률로 당신이 던진 포켓볼을 잠시 바라보던 펄기아… 스스로 들어갔다.\"\n"
						+ "➤ \"…내 공간의 일부로 너를 받아들이겠어. 책임져야 해… 그 마음까지.\"\n" + "(신의 포켓몬은 조용히 눈을 감으며, 네 손안에 안긴다.)");
			}
			System.out.println();
			this.ifCatch = true;
			return true;
		}
		// 안 잡혔을 때 false
		System.out.println("=========포켓몬 포획 실패!=========");
		if (this.probabilityValue == 0) {
			System.out.println("\"98.8% 확률로 펄기아는 포켓볼을 가볍게 피하며 속삭인다.\"\n" + "➤ \"조상님이 안 도와주시나보다 제사를 잘 지내보도록 하자!\"\n"
					+ "(그녀의 몸은 공간의 균열 속으로 사라졌다. 잔향만이 남았다.)");
		} else if (this.probabilityValue == 1) {
			System.out.println("\"98.8% 확률로 포켓볼이 공중에서 멈췄다… 펄기아가 시간을 굽히고 있다.\"\n"
					+ "➤ \"…잡히는 게 무서운 게 아니라… 네가 날 진심으로 부르지 않아서야.\"\n" + "(볼은 조용히 떨어지고, 그녀의 눈빛은 아련하다.)");
		} else {
			System.out.println("\"98.8% 확률로 펄기아는 포켓볼을 바라보며 슬쩍 미소 지었다.\"\n" + "➤ \"조금만 더… 네가 나를 원한다고 믿게 된다면, 그땐…\"\n"
					+ "(공간이 일그러지며 그녀는 떠났고, 너의 손은 허공을 움켜쥐었다.)");
		}
		System.out.println();
		return false;
	}

}
