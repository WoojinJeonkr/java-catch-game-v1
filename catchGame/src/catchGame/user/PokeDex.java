package catchGame.user;

import java.util.Scanner;

import catchGame.monster.Monster0;
import catchGame.monster.Monster1;
import catchGame.monster.Monster10;
import catchGame.monster.Monster2;
import catchGame.monster.Monster3;
import catchGame.monster.Monster4;
import catchGame.monster.Monster5;
import catchGame.monster.Monster6;
import catchGame.monster.Monster7;
import catchGame.monster.Monster8;
import catchGame.monster.Monster9;
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
		System.out.println("포켓몬 도감을 출력합니다\n");
		for (int i = 1; i < this.pokeDex.length; i++) {// i = 1 부터 해야 0번(못마주침)출력안함
			System.out.println("---------------------------------\n");
			this.RPad(i);
			if (this.pokeDex[i].ifCatch) {//true = 잡힌거
				
				System.out.println("포켓몬 이름 : " + this.pokeDex[i].name);
				System.out.println("포켓몬 출현장소 : " + this.pokeDex[i].spawnMap);
				System.out.println("포켓몬 설명 : " + this.pokeDex[i].present + "\n");					
			}else {
				System.out.println("아직 못잡은 포켓몬 입니다 화이팅!\n");
			}
			System.out.println("---------------------------------\n");	
		}
	}
	
	public void updatePokeDex(String name) {
		for (int i = 1; i < this.pokeDex.length; i++) {
			if(this.pokeDex[i].name.equals(name)){
				this.pokeDex[i].ifCatch = true;
			}
		}
		
	}
	
	public void findPokeDex() {
		System.out.println("포켓몬 도감 검색하기");
		System.out.println("포켓몬 도감번호와 이름을 출력합니다 원하시는 포켓몬의 도감번호를 입력해 주세요");
		for (int i = 1; i < this.pokeDex.length; i++) {
			this.RPad(i);
			if (this.pokeDex[i].ifCatch) {//true = 잡힌거
				System.out.println("포켓몬 이름 : " + this.pokeDex[i].name);
			}else {
				System.out.println("포켓몬 이름 : ???"); 
			}
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("도감번호 마지막 숫자 입력 : ");
		int userInput = Integer.parseInt(scanner.nextLine());
		System.out.println("---------------------------------\n");
		if(this.pokeDex[userInput].ifCatch = true){
			this.RPad(userInput);
			System.out.println("포켓몬 이름 : " + this.pokeDex[userInput].name);
			System.out.println("포켓몬 출현장소 : " + this.pokeDex[userInput].spawnMap);
			System.out.println("포켓몬 설명 : " + this.pokeDex[userInput].present + "\n");
		}else {
			System.out.println(this.pokeDex[userInput].spawnMap + "에서 나타난다는 소문이 있다. 화이팅!");
		}
		
	}
	
	private void RPad (int i) {
		String RPad = ""; // 도감번호 RPad 매서드
		for (int j = 0; j < 4; j ++) {
			
			if (RPad.length() + String.valueOf(i).length() == 4) {
				break;
			}else {
				RPad = RPad + "0";
			}
		}	
		//출력
		System.out.println("도감 번호 : No." + RPad + i);
	}
}
