package catchGame.user;

import java.util.Scanner;

import catchGame.monster.MonsterBase;
import catchGame.monster.MonsterFactory;
import catchGame.monster.MonsterType;

/**
 * 포켓몬 도감 관리 클래스
 * 
 * <p>
 * 포켓몬 도감을 생성, 관리, 출력 및 검색하는 기능을 제공합니다.
 * 포켓몬스터의 정보를 저장하고, 사용자가 잡은 포켓몬스터의 정보를 갱신하며,
 * 도감 검색을 통해 원하는 포켓몬스터의 상세 정보를 확인할 수 있도록 지원합니다.
 * </p>
 * 
 * @author banghyunmin1999
 * @author Woojinjeonkr
 */
public class PokeDex {

	/**
     * MonsterBase 객체 배열
     * 
     * <p>
     * 포켓몬 도감에 저장될 MonsterBase 객체들을 담는 배열입니다.
     * 각 인덱스는 MonsterType에 대응됩니다.
     * </p>
     */
	private MonsterBase[] pokeDex;
	
	/**
     * 사용자 입력을 처리하는 Scanner 객체
     * 
     * <p>
     * 사용자의 콘솔 입력을 읽어 들이는 데 사용됩니다.
     * 도감 검색 시 사용자의 입력을 받기 위해 활용됩니다.
     * </p>
     */
	private Scanner scanner = new Scanner(System.in);

	/**
     * PokeDex 생성자
     * 
     * <p>
     * MonsterType의 모든 타입을 순회하며 각 타입에 해당하는 MonsterBase 객체를 생성하여
     * pokeDex 배열을 초기화합니다.
     * </p>
     */
	public PokeDex() {
		this.pokeDex = new MonsterBase[MonsterType.values().length];
        initializePokeDex();
	}

	/**
     * 포켓몬 도감 초기화 메서드
     * 
     * <p>
     * MonsterType 배열을 순회하면서 MonsterFactory를 통해 각 타입에 맞는 몬스터를 생성하고
     * pokeDex 배열에 저장합니다.
     * </p>
     */
    private void initializePokeDex() {
        MonsterType[] types = MonsterType.values();
        for (int i = 0; i < types.length; i++) {
            this.pokeDex[i] = MonsterFactory.createMonster(types[i]);
        }
    }

    /**
     * 포켓몬 도감 출력 메서드
     * 
     * <p>
     * pokeDex에 저장된 모든 포켓몬스터의 정보를 출력합니다.
     * 잡은 포켓몬스터의 경우 이름, 출현장소, 설명을 출력하고,
     * 잡지 못한 경우 "아직 못잡은 포켓몬 입니다. 화이팅!" 메시지를 출력합니다.
     * </p>
     */
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
    
    /**
     * 몬스터를 잡았을 때 도감 정보 업데이트 메서드
     * 
     * <p>
     * 주어진 이름에 해당하는 포켓몬스터를 찾아 잡은 상태로 업데이트합니다.
     * </p>
     *
     * @param name 잡은 포켓몬스터의 이름
     */
    public void updatePokeDex(String name) {
        for (int i = 1; i < this.pokeDex.length; i++) {
            if (this.pokeDex[i].getName().equals(name)) {
                this.pokeDex[i].setCaught(true);
                break;
            }
        }
    }

    /**
     * 포켓몬 도감 검색 메서드
     * 
     * <p>
     * 사용자로부터 도감 번호를 입력받아 해당 포켓몬스터의 정보를 검색하고 출력합니다.
     * 잡은 포켓몬스터의 경우 이름, 출현 장소, 설명을 출력하고,
     * 잡지 못한 경우 출현장소에 대한 소문을 출력합니다.
     * 잘못된 입력이 들어올 경우 재입력을 요청합니다.
     * </p>
     */
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
	
    /**
     * 도감 번호 포맷 메서드
     * 
     * <p>
     * 도감 번호를 항상 4자리로 표시하기 위해 앞에 0을 채워 넣는 기능을 제공합니다.
     * </p>
     *
     * @param number 포맷할 도감 번호
     */
    private void formatDexNumber(int number) {
        String formattedNumber = "";
        for (int i = 0; i < 4 - String.valueOf(number).length(); i++) {
            formattedNumber += "0";
        }
        
        System.out.println("도감 번호: No." + formattedNumber + number);
    }
}
