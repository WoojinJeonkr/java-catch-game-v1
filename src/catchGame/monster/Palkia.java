package catchGame.monster;

public class Palkia extends MonsterBase {

	public Palkia() {
        super(MonsterType.PALKIA);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"차원의 문이 열리며 " + this.getName() + "가 강림!\"\n➤ \"공간은 내 손안에 있다!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"하늘을 가르는 " + this.getName() + "의 포효!\"\n➤ \"이 공간은 내가 지배한다!\"");
        } else {
            System.out.println("\"중력이 왜곡되며 " + this.getName() + "가 모습을 드러냈다!\"\n➤ \"네 모든 공격은 헛될 것이다!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(1000) + 1 <= 47) { // 4.7% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"4.7% 확률로 " + this.getName() + "가 차원 이동으로 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"4.7% 확률로 " + this.getName() + "가 공간 왜곡으로 도주!\"");
            } else {
                System.out.println("\"4.7% 확률로 " + this.getName() + "가 중력 제어로 탈출!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"95.3% 확률로 " + this.getName() + "가 공간을 잠금 상태로 변경!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"95.3% 확률로 " + this.getName() + "가 도전을 수락!\"");
        } else {
            System.out.println("\"95.3% 확률로 " + this.getName() + "가 차원의 장벽을 전개!\"");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(250) + 1 <= 3) { // 1.2% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"1.2% 확률로 " + this.getName() + "가 차원의 힘을 잃고 잡혔다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"98.8% 확률로 " + this.getName() + "가 공간 균열을 통해 탈출!\"");
        return false;
    }

}
