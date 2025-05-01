package catchGame.monster;

import java.util.Scanner;

import catchGame.user.User;

/**
 * 몬스터 관련 기능을 처리하는 클래스
 * 
 * @author Woojinjeonkr
 */
public class MonsterHandler {
	/** 사용자 입력을 처리하는 Scanner 객체 */
	private Scanner scanner;

	/**
     * MonsterHandler 생성자
     *
     * <p>
     * MonsterHandler 객체를 생성합니다.
     * 사용자 입력을 받기 위한 Scanner 객체를 초기화합니다.
     * </p>
     *
     * @param scanner 사용자 입력 Scanner
     */
    public MonsterHandler(Scanner scanner) {
        this.scanner = scanner;
    }
    
    /**
     * 몬스터 포획 로직을 처리하는 메서드
     * 
     * * <p>
     * 현재 위치에 따라 몬스터를 생성하고, 사용자와의 상호작용을 통해 포획을 시도합니다.
     * 이미 6마리의 몬스터를 소지하고 있다면 교체 또는 놓아주는 과정을 처리합니다.
     * </p>
     *
     * @param user 현재 플레이어
     * @throws InterruptedException 스레드 sleep 중 인터럽트 발생 시 예외 처리
     */
    public void catchMonster(User user) throws InterruptedException {
        MonsterArrays monsterArrays = new MonsterArrays();
        MonsterBase monster = this.getMonsterForCurrentLocation(user.getLocation(), monsterArrays);

        if (monster.getIsMet() == 1) {
            System.out.println("\n💥 몬스터를 만났다! 💥\n");
            monster.displayAppearanceMessage();
        } else {
            System.out.println("\n😢 몬스터가 만나지 못했다... 😢\n");
            monster.displayAppearanceMessage();
        }

        Thread.sleep(500);

        if (!monster.getName().equals("기본")) {
            if (this.askUserToFight()) {
                System.out.println("\n>> 싸우는 중");
                Thread.sleep(500);
                System.out.println(">> ...");
                Thread.sleep(500);
                System.out.println(">> ...\n");
                Thread.sleep(500);

                if (monster.attemptEscape()) {
                    boolean caught = monster.attemptCatch();
                    if (caught) {
                        int monsterLevel = new java.util.Random().nextInt(96) + 5;
                        monster.setLevel(monsterLevel);

                        if (user.getCaughtMonsterCount() >= 6) {
                            this.replaceMonsterHandler(user, monster);
                        } else {
                            user.getCaughtMonsters()[user.getCaughtMonsterCount()] = monster;
                            user.incrementCaughtMonsterCount();
                            System.out.println("✨ 띠링! " + monster.getName() + "(Lv." + monster.getLevel() + ")이(가) 포켓몬 도감에 등록되었습니다!");
                            user.getPokeDex().updatePokeDex(monster.getName());
                        }
                    }
                }
            }
        } else {
            monster.attemptEscape();
        }
    }
    
    /**
     * 잡은 몬스터를 교체하는 로직을 처리하는 메서드
     *
     * <p>
     * 사용자가 이미 6마리의 몬스터를 소지하고 있을 경우,
     * 새로 잡은 몬스터로 기존 몬스터를 교체하거나 놓아주는 선택지를 제공합니다.
     * </p>
     *
     * @param user 현재 플레이어
     * @param newMonster 새로 잡은 몬스터
     */
    private void replaceMonsterHandler(User user, MonsterBase newMonster) {
        System.out.println("⚠️ 이미 6마리를 소지 중입니다. 처리 방식을 선택하세요:");
        System.out.println("1. 기존 몬스터 교체하기");
        System.out.println("2. 새 몬스터 놓아주기");
        System.out.print("선택 (1-2): ");

        try {
            int actionChoice = Integer.parseInt(scanner.nextLine());
            if (actionChoice == 1) {
                this.showMonsterListForReplacement(user, newMonster);
            } else if (actionChoice == 2) {
                this.releaseNewMonster(newMonster);
            } else {
                this.releaseNewMonster(newMonster);
            }
        } catch (NumberFormatException e) {
            this.releaseNewMonster(newMonster);
        }
    }
    
    /**
     * 교체를 위해 사용자가 소지한 몬스터 목록을 보여주는 메서드
     *
     * <p>
     * 기존 몬스터를 교체하기 위해 사용자가 소지한 몬스터 목록을 출력하고,
     * 교체할 몬스터를 선택하도록 합니다.
     * </p>
     *
     * @param user 현재 플레이어
     * @param newMonster 새로 잡은 몬스터
     */
    private void showMonsterListForReplacement(User user, MonsterBase newMonster) {
        System.out.println("\n교체할 몬스터 번호 선택:");
        MonsterBase[] caughtMonsters = user.getCaughtMonsters();
        int count = user.getCaughtMonsterCount();

        for (int i = 0; i < count; i++) {
            if (caughtMonsters[i] != null) {
                System.out.println((i + 1) + ". " + caughtMonsters[i].getName() + " (Lv." + caughtMonsters[i].getLevel() + ")");
            } else {
                System.out.println((i + 1) + ". [비어 있음]");
            }
        }
        System.out.println("7. 취소하고 새 몬스터 놓아주기");

        try {
            int slotChoice = Integer.parseInt(scanner.nextLine());
            if (slotChoice >= 1 && slotChoice <= 6) {
                this.replaceMonster(user, slotChoice, newMonster);
            } else {
                this.releaseNewMonster(newMonster);
            }
        } catch (NumberFormatException e) {
            this.releaseNewMonster(newMonster);
        }
    }
    
    /**
     * 몬스터를 교체하는 메서드
     *
     * <p>
     * 선택한 슬롯의 기존 몬스터를 새 몬스터로 교체하고,
     * 교체 결과를 사용자에게 알립니다.
     * </p>
     *
     * @param user 현재 플레이어
     * @param slot 교체할 몬스터의 슬롯 번호
     * @param newMonster 새로 잡은 몬스터
     */
    private void replaceMonster(User user, int slot, MonsterBase newMonster) {
        MonsterBase[] caughtMonsterList = user.getCaughtMonsters();
        MonsterBase oldMonster = caughtMonsterList[slot - 1];
        System.out.println("\n【" + oldMonster.getName() + " (Lv." + oldMonster.getLevel() +
                ")】을(를) 풀어주고 【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
                ")】을(를) 획득했습니다!");
        caughtMonsterList[slot - 1] = newMonster;
        user.getPokeDex().updatePokeDex(newMonster.getName());
    }

    /**
     * 새 몬스터를 놓아주는 메서드
     *
     * <p>새로 잡은 몬스터를 야생으로 돌려보내는 것을 사용자에게 알립니다.</p>
     *
     * @param newMonster 새로 잡은 몬스터
     */
    private void releaseNewMonster(MonsterBase newMonster) {
        System.out.println("\n【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
                ")】을(를) 야생으로 돌려보냈습니다...");
    }
    
    /**
     * 현재 위치에 맞는 몬스터를 생성하는 메서드
     *
     * <p>
     * 사용자의 현재 위치에 따라 다른 종류의 몬스터를 생성합니다.
     * 각 위치에 맞는 몬스터를 반환합니다.
     * </p>
     *
     * @param location 현재 위치
     * @param monsterArrays 몬스터 배열 객체
     * @return 생성된 몬스터 객체
     */
    private MonsterBase getMonsterForCurrentLocation(String location, MonsterArrays monsterArrays) {
        switch (location) {
            case "하늘":
                return monsterArrays.createSkyMonster();
            case "바다":
                return monsterArrays.createSeaMonster();
            case "땅":
                return monsterArrays.createEarthMonster();
            case "우주":
                return monsterArrays.createUniverseMonster();
            default:
                return monsterArrays.createEarthMonster();
        }
    }
    
    /**
     * 사용자에게 싸울 것인지 묻는 메서드
     *
     * <p>
     * 몬스터를 만났을 때 사용자에게 싸울 것인지 묻고,
     * 사용자의 입력을 받아 boolean 값을 반환합니다.
     * </p>
     *
     * @return 사용자가 싸우겠다고 응답하면 true, 아니면 false
     */
    private boolean askUserToFight() {
        System.out.print("\n>> 싸우시겠습니까?(Y/N) ");

        while (true) {
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("Y")) {
                return true;
            } else if (userChoice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("⚠️ 잘못된 입력입니다. 'Y' 또는 'N'을 입력해주세요.");
            }
        }
    }
}
