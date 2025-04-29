package catchGame.monster;

public class Magikarp extends MonsterBase {
	
	public Magikarp() {
        super(MonsterType.MAGIKARP);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"물에서 무언가 펄떡인다...!\"");
            System.out.println("➤ 잉어킹이 튀어나왔다!");
            System.out.println("(전혀 위협적이지 않다.)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"적이 강해 보이지 않는다...\"");
            System.out.println("➤ 그러나 잉어킹은 용감하게 튀어올랐다!");
            System.out.println("(... 아무 일도 일어나지 않았다.)");
        } else {
            System.out.println("\"잉어킹이 등장했다! 그런데 이건... 그냥 생선이다?\"");
            System.out.println("➤ 트레이너가 당황하고 있다!");
            System.out.println("(어떻게 해야 할지 모르는 눈치다.)");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        // 10% 확률로 도망
        if (random.nextInt(10) + 1 == 1) {
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"10% 확률로 주인 없는 잉어킹이 도망쳤다! 그냥 헤엄치는 게 아니라, 탈출하기 위해 열심히 '짠짠짠'하며 도망쳤다!\"\n"
                    + "➤ \"잉어~~~! (내가 뭐 좀 할 수 있을 줄 알았냐?)\"\n"
                    + "(잉어킹이 뭔가 중요한 일을 하려다가 도망가면서도 자세히 보면 한 번도 제대로 헤엄치지 못함. 그냥 뒷걸음질 치는 중.)");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"10% 확률로 주인 없는 잉어킹이 도망쳤다! 바다의 왕이라 믿고 도망가는 길에 무릎이 부서질 듯한 속도로 수영하고 있다!\"\n"
                    + "➤ \"잉어잉어잉어킹~~~! (이게 진짜 탈출이다!)\"\n"
                    + "(잉어킹이 전속력으로 도망가지만, 도망치는 방향이 어디인지 몰라 옆으로 방향을 틀며 엉뚱한 곳으로 헤엄친다.)");
            } else {
                System.out.println("\"그 잉어킹이 10% 확률로 두려움을 느꼈다!\"\n" + "(집에 가서 자랑해보자!)");
            }
            
            System.out.println();
            return false;
        }
        
        // 90% 확률로 도망치지 않음
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"90% 확률로 주인 없는 잉어킹이 도망치지 않는다! 그냥 고요하게 수영하며 '도망칠 필요 없잖아, 다 나의 바다야!'라고 생각하고 있다!\"\n"
                + "➤ \"잉어~! (나, 뭐든지 할 수 있을 것 같거든!)\"\n" + "(잉어킹이 여유롭게 수영하며 누구도 상관하지 않고 그저 물속을 느긋하게 헤엄친다.)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"90% 확률로 주인 없는 잉어킹이 도망치지 않는다! '아니, 내가 뭐야? 나의 물속 왕국에서 도망칠 필요가 있나?!'라고 말하며 수영하고 있다!\"\n"
                + "➤ \"잉어잉어킹~~~! (난 여기에 있어도 돼, 내 바다니까!)\"\n" + "(잉어킹이 느긋하게 물속을 헤엄치면서 사실 도망칠 필요가 없다는 듯 여유를 부린다.)");
        } else {
            System.out.println("\"90% 확률로 주인 없는 잉어킹이 도망치지 않는다! 그냥 물속에서 이런저런 동작을 시도하며 자신만의 춤을 춘다!\"\n"
                + "➤ \"잉어~! (이게 바로 나의 독특한 물속 춤이다!)\"\n" + "(잉어킹이 도망치지 않고, 춤을 추듯이 물속에서 뱅글뱅글 돌며 리듬을 타는 모습.)");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        // 0.1% 확률로 잡힘
        if (random.nextInt(1000) + 1 == 1) {
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"" + this.name + "의 머리에서 둔탁한 소리가 났다!\"\n" + "➤ 99.9% 확률로 잡아냈다!\n"
                + "(지나가던 꼬마도 잡을 수 있는 흔한 녀석이다 가문의 영광이므로 집에 가서 자랑해보자.)");
            System.out.println();
            this.isCaught = true;
            return true;
        }
        
        // 99.9% 확률로 잡히지 않음
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"" + this.name + "의 모습이 보이지 않는다.\"\n" + "➤ 아뿔싸! 0.1% 확률로 놓치고 말았다.\n" + "(이것도 못잡다니...)");
        System.out.println();
        return false;
    }

}
