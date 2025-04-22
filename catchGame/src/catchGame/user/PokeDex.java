package user;

import monster.MonsterBase;

public class PokeDex extends User{
	
	PokeDex(){
		this.pokeDex = new MonsterBase[10];
	}
	
	@Override
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
	
	@Override
	public void printPokeDex() {
		System.out.println("잡은 포켓몬 리스트를 출력합니다\n");
		for (int i = 0; i < this.pokeDex.length; i++) {
			System.out.println("---------------------------------\n");
			if (this.pokeDex[i].ifCatch) {//true 잡힌거
				System.out.println(this.pokeDex[i].name);
				System.out.println(this.pokeDex[i].present);				
			}
			System.out.println("---------------------------------\n");	
		}
	}
}
