package catchGame.monster;

public class Monster8 extends MonsterBase {

	public Monster8() {
		super("디아루가");
		this.spawnMap = "하늘";
		this.present = "강철/드래곤 타입 포켓몬 | 시간의 신, 시계를 한 번만 돌리면 딱 맞춰서 일어날 수 있지. 뭐, 실제로는 계속 늦는 일만…";
	}

	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		this.probabilityValue = r.nextInt(3);
		if (this.probabilityValue == 0) {
			System.out.println("\"공간이 일그러지며 뭔가가 나타났다… 디아루가다!\"\n" + "➤ \"크오오오오옹!! (시간 정지 ON)\"\n"
					+ "(너무 빨리 나타나서 BGM도 아직 시작 안 됨.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"디아루가가 시계를 거꾸로 돌리며 등장했다!\"\n" + "➤ \"내가 점심을 두 번 먹은 이유를 알고 싶은가?\"\n"
					+ "(시간을 조작해 무한 점심 루프 돌리는 중.)");
		} else {
			System.out.println(
					"\"디아루가가 나타났다! 스탑워치도 멈췄다!\"\n" + "➤ \"지금부터 너의 인생은 슬로우모션이다.\"\n" + "(멋있는데… 말투 왜 이렇게 익숙하지?)");
		}
	}

	// 도망칠 확률 "개별사건"
	// 70% => 7/10
	// 랜덤 값 1~3 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		// 도망칠 때
		if (this.r.nextInt(10) + 1 <= 7) {
			if (this.probabilityValue == 0) {
				System.out.println("\"70% 확률로 디아루가가 시간을 되감아 아예 ‘처음부터 안 만난’ 척 도망쳤다!\"\n"
						+ "➤ \"아무 일도 없었어. 기억도 지웠고. 이 대화도 없었던 거야.\"\n" + "(너 방금 뭘 찾고 있었더라?)");
			}
			else if (this.probabilityValue == 1) {
				System.out.println("\"70% 확률로 디아루가가 무한 루프 속으로 사라졌다!\"\n" + "➤ \"같은 장면 반복시키면 넌 포기할 줄 알았어.\"\n"
						+ "(몇 번째 똑같은 등장씬 보고 멘탈이 탈탈.)");
			} else {
				System.out.println("\"70% 확률로 디아루가가 갑자기 느려지더니 사라졌다… 시간 정지 후 로그아웃?!\"\n" + "➤ \"슬로우모션 엔딩, 꽤 예쁘지?\"\n"
						+ "(잔상만 남기고 야심차게 도망 완료!)");
			}
			return false;
		}
		// 안 도망칠 때
			if (this.probabilityValue == 0) {
			System.out.println("\"30% 확률로 디아루가가 멈춰 선다. 시간은 정지했고… 싸움은 피할 수 없다.\"\n" + "➤ \"지금 너는 0.0001초의 영원 속에 있어.\"\n"
					+ "(정신 차려보니 싸움은 이미 시작된 상태.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"30% 확률로 디아루가가 도망치지 않는다. 오히려 시간을 잠가버렸다.\"\n" + "➤ \"도망? 너랑 대화 끝날 때까진 시간 못 가.\"\n"
					+ "(진지한 척하면서 토크지옥으로 인도 중.)");
		} else {
			System.out.println("\"30% 확률로 디아루가가 조용히 다가오더니 시계를 멈췄다.\"\n" + "➤ \"나에게 도망이란 선택지는 없어. (그리고 너도 마찬가지야.)\"\n"
					+ "(무서운데 멋있다… 이게 전설의 무게인가?)");
		}
		return true;
	}

	// 잡힐 확률 "개별사건"
	// 7.67% => 767/10000
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		this.probabilityValue = r.nextInt(3);


		// 잡혔을 때
		if (this.r.nextInt(10000) + 1 <= 767) {
			if (this.probabilityValue == 0) {
				System.out.println("\"7.67% 확률로 ……이 시간의 지배자, 내가… 이렇게 작은 구 안에……\"\n"
						+ "➤ \"흥, 뭐… 너한테 잠깐… 맡겨주는 것뿐이야. 오해는 하지 마……\"\n" + "(디아루가는 얼굴 붉히며 조용히 구석에 말없이 앉았다.)");
			}
			else if (this.probabilityValue == 1) {
				System.out.println("\"7.67% 확률로 디아루가가 잡혔다… 시간의 신이 너에게 마음을 열었어…?\"\n"
						+ "➤ \"너의 손길이… 따뜻해서…… 아니, 기분 나쁘단 뜻은 아니야……!\"\n" + "(포켓볼 안에서 혼잣말을 중얼거리고 있다.)");
			} else {
				System.out.println("\"7.67% 확률로 디아루가가 포켓볼 안에서 조용히 눈을 감는다.\"\n"
						+ "➤ \"…이 세계의 끝에서 널 다시 만날 줄은 몰랐어… 네가 부른 거지?\"\n" + "(시간의 파동이 조용히 맴돌며 반짝인다.)");
			}
			this.ifCatch = true;
			return true;
		}
		// 안 잡혔을 때
		if (this.probabilityValue == 0) {
			System.out.println("\"92.33% 확률로  디아루가가 고요히 미소 지으며 포켓볼을 바라본다.\"\n" + "➤ \"…아직 너에겐… 날 받아들일 준비가 안 된 것 같아…\"\n"
					+ "(포켓볼은 부드럽게 바닥에 떨어지고, 그녀는 사라졌다.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"92.33% 확률로 디아루가는 당신을 한참 바라보다 고개를 돌렸다.\"\n"
					+ "➤ \"…흥. 이 정도 감정으론 나를 가둘 수 없어. 다음엔… 더 진심을 보여줘.\"\n" + "(그 말과 함께 시간이 찢기듯 열리고, 그녀는 사라졌다.)");
		} else {
			System.out.println("\"92.33% 확률로 포켓볼이 디아루가의 공간에 닿는 순간, 시간조차 얼어붙었다.\"\n"
					+ "➤ \"……이 시간은 나의 것… 아직, 너에겐 허락할 수 없어.\"\n" + "(그녀는 당신의 머리 위에 조용히 속삭인다. 그리고 사라진다.)");
		}
		return false;
	}

}
