package catchGame.monster;

public class Monster6 extends MonsterBase{

	public Monster6() {
		super("그란돈");
		this.spawnMap = "바다";
		this.present ="불 타입 포켓몬 | 땅을 밟는 그랜드 파파, 사막에서 자고 일어나면 \"아, 너무 덥다!\"고 하는 진짜 땅속에서 자는 덩치 큰 포켓몬, 헌데 왜 이새끼가 바다에..?";
	}
	
	
	// 마주쳤을 때
	// 등장멘트
	@Override
	public void appearanceComment() {
		this.probabilityValue = r.nextInt(3);
		if(this.probabilityValue == 0) {
			System.out.println("\"지면이 흔들린다… 아니, 바다가 흔들린다! 그란돈이 모습을 드러냈다!\"\n" +
					"➤ \"그라라라라...돈..\"\n" +
					"(아니 이새끼가 왜 바다에..?)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"해저 마그마가 솟구치는 틈에서 그란돈이 등장했다! 해일을 뚫고 등장하는 정통파(?) 무대 연출!\"\n" +
					"➤ \"그라라라...돈... \"\n" +
					"(아니 이새끼가 왜 바다에..?)");
		} else {
			System.out.println("\"뜨거운 수중기와 함께 그란돈이 바다를 울리며 나왔다! 관중석이 없다면 만들어서라도 등장하는 타입!\"\n" +
					"➤ \"그라..돈\"\n" +
					"(아니 이새끼가 왜 바다에..?)");
		}
	}
	
	
	// 도망칠 확률 "개별사건"
	// 3% => 3/100
	// 랜덤 값 1~3 나오면 도망, 그외 숫자 안 도망침
	@Override
	public boolean runMonster() {
		this.probabilityValue = r.nextInt(3);

		// 도망칠 때
		if(this.r.nextInt(100) + 1 <= 3) {
			if(this.probabilityValue == 0) {
				System.out.println("\"3% 확률로 그란돈이 뒤돌아 떠나고 있다! 땅 포켓몬 헤엄 수준이 전문가입니다.\"\n" +
						"➤ \"그라라라라\"\n" +
						"(바다가 흔들리며 그란돈이 서서히 도망간다. 굳이로 어디로 가든 망망대해지만 떠나긴 떠났다)");
			}
			else if (this.probabilityValue == 1) {
				System.out.println("\"3% 확률로 주변이 흔들리더니 그란돈이 자취를 감추었다! 이런, 바다로 잠수하다니!\"\n" +
						"➤ \"그라~\"\n" +
						"(...)");
			} else {
				System.out.println("\"3% 확률로 그란돈이 도망쳤다! 바다가 흔들리는 틈을 타서 멀어져간다!\"\n" +
						"➤ \"그라~돈!\"\n" +
						"(엄청난 크기에도 불구하고, 그란돈은 눈에 띄지 않게 사라진다.)");
			}
			return false;
		}
		// 안 도망칠 때
		if(this.probabilityValue == 0) {
			System.out.println("\"97% 확률로 그란돈이 도망가지 않는다! 이 정도로 굳건한 대지..아니 바다라면 도망칠 수 없다!\"\n" +
					"➤ \"...\"\n" +
					"(고요한 바다 위에서, 그란돈은 웅장하게 서 있다. 모든 것들이 이 대지(?)를 두려워한다.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"97% 확률로 그란돈은 단단히 자리를 잡았다! 이곳에서 떠날 생각은 없다고 선언했다!\"\n" +
					"➤ \"그라라라라~ (나야, 나! 난 언제나 이 자리에!)\"\n" +
					"(움직이지 않으려는 그란돈의 의지가 느껴진다. 사실 어느곳이든 바다라 지쳤나보다)");
		} else {
			System.out.println("\"97% 확률로 그란돈은 그냥 서 있다. 도망칠 생각은 아예 없다! 단단한 대지처럼 마음도 단단하다!\"\n" +
					"➤ \"그라..돈!\"\n" +
					"(도망칠 필요가 없는 그란돈, 사방이 바다이다)");
		}
		return true;
	}
	
	// 잡힐 확률 "개별사건"
	// 40% => 2/5
	// 반환 값 => 잡혔을 때:true | 아닐 때:false
	@Override
	public boolean catchMonster() {
		this.probabilityValue = r.nextInt(3);

		// 잡혔을 때 
		if(this.r.nextInt(5) + 1 <= 2) {
			if(this.probabilityValue == 0) {
				System.out.println("\"40% 확률로 그란돈이 포켓볼에 갇혔다! 이게 가능한 일이었나?! 바다여서 가능했나보다!\"\n" +
						"➤ \"그라~돈 (대지의 신, 포켓볼 안에 갇히다니!)\"\n" +
						"(그란돈이 포켓볼 안에서 큰 소리로 불평한다. 대지의 신이 이렇게 작게 갇히다니!)");
			}
			else if (this.probabilityValue == 1) {
				System.out.println("\"40% 확률로 그란돈이 잡혔다! 땅에 있어야 할 놈이 왜 바다에 허우적 거리는지 모르겠다 일단 잡았으니 좋았쓰!\"\n" +
						"➤ \"그라라라라~ (내가 이렇게 약해졌다고?!)\"\n" +
						"(그란돈이 포켓볼에서 구르며 땅을 흔들지만, 끝내 봉인된다.)");
			} else {
				System.out.println("\"40% 확률로 그란돈이 포켓볼에 들어갔다! 지구의 정복자가 포켓볼에 갇히다니!\"\n" +
						"➤ \"그라~돈! (내가, 내가 갇혔다구?! 대체 언제 이런 일이…?)\"\n" +
						"(그란돈이 포켓볼 안에서 커다란 한숨을 내쉰다. 그래도 포켓볼 안에서 굴러다닌다.)");
			}
			this.ifCatch = true;
			return true;
		}
		// 안 잡혔을 때
		if(this.probabilityValue == 0) {
			System.out.println("\"60% 확률로 그란돈이 포켓볼에서 빠져나갔다! 대지의 힘으로 벗어나버렸다!\"\n" +
					"➤ \"그라라라라~ (너희들이 날 막을 수 있다고 생각했어?)\"\n" +
					"(그란돈은 포켓볼에서 힘껏 튕겨나가며 바다를 흔든다. 썩어도 준치라고 만만치 않은 상대이다.)");
		}
		else if (this.probabilityValue == 1) {
			System.out.println("\"60% 확률로 그란돈은 잡히지 않았다! 땅(?)의 힘이 강력해서 포켓볼을 흔들어버렸다!\"\n" +
					"➤ \"그라~돈! (이런 작은 장난감에 내가 갇힐 수 없다!)\"\n" +
					"(그란돈이 포켓볼 안에서 바다를 흔들어버리며 다시 탈출한다. '잡히지 않는 자'의 위엄!)");
		} else {
			System.out.println("\"60% 확률로 그란돈은 여전히 포켓볼을 뚫고 나온다! 대지의 신이 이 작은 장난감에 갇힐 순 없다!\"\n" +
					"➤ \"그라라라~돈! (포켓볼로 날 가둘 수는 없다!)\"\n" +
					"(그란돈은 포켓볼을 불태운 후, 다시 지구의 신처럼 바다 한 가운데에 우뚝 서 있다.)");
		}
		return false;
	}
	
}
