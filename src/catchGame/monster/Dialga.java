package catchGame.monster;

public class Dialga extends MonsterBase {

	public Dialga() {
        super(MonsterType.DIALGA);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"공간이 일그러지며 " + this.getName() + "가 나타났다!\"\n➤ \"크오오오오옹!!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"" + this.getName() + "가 시계를 거꾸로 돌리며 등장!\"");
        } else {
            System.out.println("\"" + this.getName() + "가 스탑워치를 멈췄다!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(10) + 1 <= 7) { // 70% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"70% 확률로 " + this.getName() + "가 시간을 되감았다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"70% 확률로 " + this.getName() + "가 무한 루프에 빠졌다!\"");
            } else {
                System.out.println("\"70% 확률로 " + this.getName() + "가 느려지며 사라졌다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"30% 확률로 " + this.getName() + "가 시간을 잠갔다!\"");
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(10000) + 1 <= 767) { // 7.67% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"7.67% 확률로 " + this.getName() + "를 잡았다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"92.33% 확률로 " + this.getName() + "가 탈출했다!\"");
        return false;
    }

}
