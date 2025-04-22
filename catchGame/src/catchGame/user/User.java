package catchGame.user;

import java.util.Scanner;

import catchGame.map.MapExploring;

public class User {
	public String userName; // 사용자 이름
	public String location; // 사용자 위치
	public PokeDex pokeDex; // 사용자 도감

	Scanner scanner = new Scanner(System.in);

	// User 객체 생성 시 이름 입력받고, 새로운 도감 불러옴
	public User() {
		System.out.print("당신의 이름은? ");
		this.userName = scanner.nextLine();
		this.pokeDex = new PokeDex();
		this.pokeDex.insertPokeDex();
	}
	
	// 사용자의 도감 출력
	public void printMyPokeDex() {
        this.pokeDex.printPokeDex();
    }
	
	// 몬스터를 잡았을 때 잡은 몬스터의 이름을 기준으로 도감 정보 최신화
	public void updateMyPokeDex(String name) {
		this.pokeDex.updatePokeDex(name);
	}

	// 맵 선택
	public void selectMap() {
		MapExploring map = new MapExploring();
		map.mapInput();
		this.location = map.answerMap;
		map.mapSelect(map.answerMap);
	}
	
	// 유저 정보 출력
	public void printUserInfo() {
		System.out.println("사용자명: " + this.userName);
		System.out.println("사용자 위치: " + this.location);
		System.out.println("사용자 도감");
		this.pokeDex.printPokeDex();
	}
}