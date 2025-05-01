package catchGame.monster;

import java.util.Scanner;

import catchGame.user.User;

public class MonsterHandler {
	private Scanner scanner;

    public MonsterHandler(Scanner scanner) {
        this.scanner = scanner;
    }
    
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
    
    private void replaceMonster(User user, int slot, MonsterBase newMonster) {
        MonsterBase[] caughtMonsterList = user.getCaughtMonsters();
        MonsterBase oldMonster = caughtMonsterList[slot - 1];
        System.out.println("\n【" + oldMonster.getName() + " (Lv." + oldMonster.getLevel() +
                ")】을(를) 풀어주고 【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
                ")】을(를) 획득했습니다!");
        caughtMonsterList[slot - 1] = newMonster;
        user.getPokeDex().updatePokeDex(newMonster.getName());
    }

    private void releaseNewMonster(MonsterBase newMonster) {
        System.out.println("\n【" + newMonster.getName() + " (Lv." + newMonster.getLevel() +
                ")】을(를) 야생으로 돌려보냈습니다...");
    }
    
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
