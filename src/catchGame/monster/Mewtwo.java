package catchGame.monster;

public class Mewtwo extends MonsterBase {

	public Mewtwo() {
        super(MonsterType.MEWTWO);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"머릿속에 직접 들려오는 목소리… " + this.getName() + "가 나타났다!\"\n➤ \"…이게 너의 최선인가?\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"하늘이 찢기듯 갈라지며 " + this.getName() + " 등장!\"\n➤ \"나는 왜 여기에 있는가...\"");
        } else {
            System.out.println("\"정신을 차리고 보니 " + this.getName() + "가 앞에 서 있다!\"\n➤ \"나는 싸움을 원치 않는다.\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 15) { // 15% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"15% 확률로 " + this.getName() + "가 눈을 감더니 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"15% 확률로 " + this.getName() + "가 순간이동했다!\"");
            } else {
                System.out.println("\"15% 확률로 " + this.getName() + "의 목소리가 울린다. '나 피곤하다.'\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"85% 확률로 " + this.getName() + "가 당신을 응시하고 있다!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"85% 확률로 " + this.getName() + "가 미동도 하지 않는다!\"");
        } else {
            System.out.println("\"85% 확률로 " + this.getName() + "가 눈썹 하나 까딱하지 않는다!\"");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(4) + 1 == 1) { // 25% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"25% 확률로 " + this.getName() + "가 잡혔다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"75% 확률로 " + this.getName() + "가 탈출했다!\"");
        return false;
    }

}
