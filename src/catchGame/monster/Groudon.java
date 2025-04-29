package catchGame.monster;

public class Groudon extends MonsterBase {

	public Groudon() {
        super(MonsterType.GROUDON);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"지면이 흔들린다… " + this.getName() + "다!\"\n➤ \"그라라라라...돈..\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"해저 마그마에서 " + this.getName() + "가 솟구쳤다!\"");
        } else {
            System.out.println("\"뜨거운 수중기와 함께 " + this.getName() + "가 등장!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 3) { // 3% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"3% 확률로 " + this.getName() + "가 뒤돌아 떠났다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"3% 확률로 " + this.getName() + "가 잠수했다!\"");
            } else {
                System.out.println("\"3% 확률로 " + this.getName() + "가 멀어져간다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"97% 확률로 " + this.getName() + "가 굳건히 서 있다!\"");
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(5) + 1 <= 2) { // 40% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"40% 확률로 " + this.getName() + "를 잡았다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"60% 확률로 " + this.getName() + "가 탈출했다!\"");
        return false;
    }
    
}
