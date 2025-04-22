package catchGame.user;

import catchGame.monster.MonsterBase;

public class PokeDex {
	
	MonsterBase[] pokeDex; // MonsterBase 객체 데이터 배열 생성
	
	PokeDex(){
		this.pokeDex = new MonsterBase[11]; //MonsterBase 객체 데이터 11개 배열 생성자에서 초기화
	}

	public void insertPokeDex() { // 11개 배열에 Monster 객체 하나식 입력
		this.pokeDex[0] = new Monster0();
		this.pokeDex[1] = new Monster1();
		this.pokeDex[2] = new Monster2();
		this.pokeDex[3] = new Monster3();
		this.pokeDex[4] = new Monster4();
		this.pokeDex[5] = new Monster5();
		this.pokeDex[6] = new Monster6();
		this.pokeDex[7] = new Monster7();
		this.pokeDex[8] = new Monster8();
		this.pokeDex[9] = new Monster9();
		this.pokeDex[10] = new Monster10();
	}
	
	public void printPokeDex() {
		System.out.println("잡은 포켓몬 리스트를 출력합니다\n");
		for (int i = 0; i < this.pokeDex.length; i++) {
			System.out.println("---------------------------------\n");
			if (this.pokeDex[i].ifCatch) {//true = 잡힌거
				
				String Rpad = ""; // 도감번호 Rpad 함수
				for (int j = 0; j < 4; j ++) {
					
					if (Rpad.length() + String.valueOf(i).length() == 4) {
						break;
					}else {
						Rpad = Rpad + "0";
					}
				}	
				//출력
				System.out.println("도감 번호 : No." + Rpad + i);
				System.out.println("포켓몬 이름 : " + "잉어킹");
				System.out.println("포켓몬 설명 : " + "쓸모없다\n");					
			}
			System.out.println("---------------------------------\n");	
		}
	}
	
	public void updatePokeDex(String name) {
		for (int i = 0; i < this.pokeDex.length; i++) {
			if(this.pokeDex[i].name.equals(name)){
				this.pokeDex[i].ifCatch = true;
			}
		}
		
	}
}
