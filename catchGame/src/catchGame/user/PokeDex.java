package catchGame.user;

import monster.MonsterBase;

public class PokeDex {
	
	MonsterBase[] pokeDex;
	
	PokeDex(){
		this.pokeDex = new MonsterBase[10];
	}

	public boolean insertPokeDex() {
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
		return true;
	}
	
	public void printPokeDex() {
		System.out.println("잡은 포켓몬 리스트를 출력합니다\n");
		for (int i = 0; i < this.pokeDex.length; i++) {
			System.out.println("---------------------------------\n");
			if (this.pokeDex[i].ifCatch) {//true 잡힌거
				String Rpad = ""; // 도감번호 Rpad
				for (int j = 0; j < 4; j ++) {
					
					if (Rpad.length() + String.valueOf(i).length() == 4) {
						break;
					}else {
						Rpad = Rpad + "0";
					}
				}	
				
				System.out.println("도감 번호 : No." + Rpad + i);
				System.out.println("포켓몬 이름 : " + "잉어킹");
				System.out.println("포켓몬 설명 : " + "쓸모없다\n");					
			}
			System.out.println("---------------------------------\n");	
		}
	}
}
