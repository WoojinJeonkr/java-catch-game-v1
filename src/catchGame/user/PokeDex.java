package catchGame.user;

import java.util.Scanner;

import catchGame.monster.MonsterBase;
import catchGame.monster.MonsterFactory;
import catchGame.monster.MonsterType;

/**
 * 포켓몬 도감 관리 클래스
 */
public class PokeDex {

	private MonsterBase[] pokeDex; // MonsterBase 객체 데이터 배열 생성
	
	private Scanner scanner = new Scanner(System.in);

	public PokeDex() {
		this.pokeDex = new MonsterBase[MonsterType.values().length];
        initializePokeDex();
	}

	// 포켓몬 도감 초기화
    private void initializePokeDex() {
        MonsterType[] types = MonsterType.values();
        for (int i = 0; i < types.length; i++) {
            this.pokeDex[i] = MonsterFactory.createMonster(types[i]);
        }
    }

    // 포켓몬 도감 출력
    public void printPokeDex() {
        System.out.println("포켓몬 도감을 출력합니다.\n");
        
        // 첫 번째 항목(EMPTY)은 건너뜀
        for (int i = 1; i < this.pokeDex.length; i++) {
            System.out.println("---------------------------------\n");
            formatDexNumber(i);
            
            if (this.pokeDex[i].isCaught()) {
                System.out.println("포켓몬 이름: " + this.pokeDex[i].getName());
                System.out.println("포켓몬 출현장소: " + this.pokeDex[i].getSpawnMap());
                System.out.println("포켓몬 설명: " + this.pokeDex[i].getDescription() + "\n");
            } else {
                System.out.println("아직 못잡은 포켓몬 입니다. 화이팅!\n");
            }
        }
        
        System.out.println("---------------------------------\n");
    }
    
    // 몬스터를 잡았을 때 도감 정보 업데이트
    public void updatePokeDex(String name) {
        for (int i = 1; i < this.pokeDex.length; i++) {
            if (this.pokeDex[i].getName().equals(name)) {
                this.pokeDex[i].setCaught(true);
                break;
            }
        }
    }

    // 포켓몬 도감 검색
    public void searchPokeDex() {
        
        System.out.println("---------------------------------\n");
        System.out.println("포켓몬 도감 검색하기");
        System.out.println("포켓몬 도감번호와 이름을 출력합니다. 원하시는 포켓몬의 도감번호를 입력해 주세요\n");
        
        // 포켓몬 목록 출력
        for (int i = 1; i < this.pokeDex.length; i++) {
            System.out.println("---------------------------------\n");
            formatDexNumber(i);
            
            if (this.pokeDex[i].isCaught()) {
                System.out.println("포켓몬 이름: " + this.pokeDex[i].getName() + "\n");
            } else {
                System.out.println("포켓몬 이름: ???\n");
            }
        }
        
        System.out.println("---------------------------------\n");
        
        try {
            System.out.print("원하시는 도감번호 앞 0을 제외한 1~" + (this.pokeDex.length - 1) + "을 입력해 주세요: ");
            int userInput = Integer.parseInt(scanner.nextLine());
            System.out.println("\n---------------------------------\n");
            
            if (userInput > 0 && userInput < this.pokeDex.length) {
                formatDexNumber(userInput);
                
                if (this.pokeDex[userInput].isCaught()) {
                    System.out.println("포켓몬 이름: " + this.pokeDex[userInput].getName());
                    System.out.println("포켓몬 출현장소: " + this.pokeDex[userInput].getSpawnMap());
                    System.out.println("포켓몬 설명: " + this.pokeDex[userInput].getDescription() + "\n");
                } else {
                    System.out.println(this.pokeDex[userInput].getSpawnMap() + "에서 나타난다는 소문이 있다. 화이팅!\n");
                }
                
                System.out.println("---------------------------------\n");
            } else {
                System.out.println("도감번호 앞 0을 제외한 1~" + (this.pokeDex.length - 1) + "을 입력해 주세요\n");
                searchPokeDex();
            }
        } catch (Exception e) {
            System.out.println("숫자만 입력 가능합니다\n");
            searchPokeDex();
        }
    }
	
    // 도감번호 포맷 (항상 4자리로 표시)
    private void formatDexNumber(int number) {
        String formattedNumber = "";
        for (int i = 0; i < 4 - String.valueOf(number).length(); i++) {
            formattedNumber += "0";
        }
        
        System.out.println("도감 번호: No." + formattedNumber + number);
    }
}
