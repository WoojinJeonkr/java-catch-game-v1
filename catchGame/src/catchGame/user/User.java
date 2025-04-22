package catchGame.user;

import java.util.Scanner;

public class User {
	public String userName;
	public String location;
	// public MonsterBase[] pokeDex;

	Scanner scanner = new Scanner(System.in);

	public User() {
		System.out.print("당신의 이름은? ");
		this.userName = scanner.nextLine();
	}

	public void printPokeDex() {

	}

	public boolean insertPokeDex() {
		return true;
	}
}
